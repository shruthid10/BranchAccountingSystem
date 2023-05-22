package com.accounting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accounting.beans.Accountant;
import com.accounting.beans.Branch;
import com.accounting.beans.Student;
import com.accounting.dao.AccountantDao;
import com.accounting.dao.BranchDao;
import com.accounting.dao.CourseDao;
import com.accounting.dao.StudentDao;

@Controller
public class AccountantController {
	
	@Autowired
	AccountantDao accountantDao;
	
	@Autowired
	BranchDao dao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CourseDao courseDao;
	
	
	@RequestMapping("/accountantform")
	public String showAccountantForm(Model m) {
		m.addAttribute("accountant", new Accountant());
		List<Branch> branches = dao.getAllBranches();
		m.addAttribute("branches", branches);
		return "accountantform";

	}

	
	@RequestMapping(value = "/saveaccountant", method = RequestMethod.POST)
	public String saveAccountant(@ModelAttribute("accountant") Accountant accountant, Model model) {
	    float salary = accountant.getSalary();
	    
	    if (salary <= 0) {
	        model.addAttribute("error", "Invalid salary value. Please enter a positive value.");
	        List<Branch> branches = dao.getAllBranches();
	        model.addAttribute("branches", branches);
	        return "accountantform";
	    }

	    float MAX_ALLOWED_SALARY=100000000;
		if (salary > MAX_ALLOWED_SALARY) {
	        model.addAttribute("error", "Invalid salary value. The salary is too large.");
	        List<Branch> branches = dao.getAllBranches();
	        model.addAttribute("branches", branches);
	        return "accountantform";
	    }

	    if (accountantDao.existsByEmail(accountant.getEmail())) {
	        List<Branch> branches = dao.getAllBranches();
	        model.addAttribute("error", "Email already exists");
	        model.addAttribute("branches", branches);
	        return "accountantform";
	    }

	    try {
	        accountantDao.saveAccountant(accountant);
	        return "redirect:/viewaccountant";
	    } catch (DataAccessException e) {
	        model.addAttribute("error", "Failed to save the accountant. Please try again.");
	        List<Branch> branches = dao.getAllBranches();
	        model.addAttribute("branches", branches);
	        return "accountantform";
	    }
	}

	@RequestMapping("/viewaccountant")
	public String viewAccountant(Model m) {
		List<Accountant> list = accountantDao.getAccountantsWithBranchNames();
		m.addAttribute("list", list);
		return "viewaccountant";
	}

	@RequestMapping(value = "/editaccountant/{id}")
	public String edit(@PathVariable int id, Model m) {
		Accountant accountant = accountantDao.getAccountantById(id);
		m.addAttribute("command", accountant);
		return "accountanteditform";
	}

	@RequestMapping(value = "/editsaveaccountant", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("accountant") Accountant accountant, Model model) {
	    float incrementPercentage = accountant.getIncrementPercentage();
	    if (incrementPercentage < 0) {
	       
	    	model.addAttribute("command", accountant);
	        model.addAttribute("error", "Increment percentage must be a positive value");
	        return "accountanteditform";
	    }

	    try {
	        accountantDao.update(accountant);
	    } catch (Exception e) {
	       
	        model.addAttribute("error", "Failed to update the accountant. Please try again.");
	        return "accountanteditform";
	    }

	    return "redirect:/viewaccountant";
	}

	@RequestMapping(value = "/deleteaccountant/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		accountantDao.delete(id);
		return "redirect:/viewaccountant";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("searchOption") String searchOption,
			@RequestParam("searchCriteria") String searchCriteria, Model model) {
		
		if ("accountant".equals(searchOption)) {
			
			if (dao.getBranchByBranchName(searchCriteria)) {

				List<Accountant> accountants = accountantDao.searchAccountantsByBranchName(searchCriteria);
				if (accountants.isEmpty()) {
					model.addAttribute("error", "No accountant found");
					return "adminsearch";
				}
				model.addAttribute("accountants", accountants);
				return "accountantSearchResults";
			} else {
				model.addAttribute("error", "Incorrect Branch Name");
				return "adminsearch";

			}
		} else if ("student".equals(searchOption)) {
			if (courseDao.getCourseByCourseName(searchCriteria)) {
				List<Student> students = studentDao.searchStudentsByCourseName(searchCriteria);
				if (students.isEmpty()) {
					model.addAttribute("error", "No student found");
					return "adminsearch";
				}
				model.addAttribute("students", students);
				return "studentSearchResults";
			} else {
				model.addAttribute("error", "Course does not exist");
				return "adminsearch";
			}
		} else {
			model.addAttribute("error", "Invalid search option");
			return "error";
		}
	}
	  

}


