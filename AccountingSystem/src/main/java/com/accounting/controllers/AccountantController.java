package com.accounting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	AccountantDao accountantdao;
	
	@Autowired
	BranchDao dao;
	
	@Autowired
	StudentDao studentdao;
	
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
		if (accountantdao.existsByEmail(accountant.getEmail())) {
			List<Branch> branches = dao.getAllBranches();
			model.addAttribute("error2", "Email already exists");
			model.addAttribute("branches", branches);
			return "accountantform";
		} else {
			accountantdao.saveAccountant(accountant);
			return "redirect:/viewaccountant";
		}

	}

	@RequestMapping("/viewaccountant")
	public String viewAccountant(Model m) {
		List<Accountant> list = accountantdao.getAccountantsWithBranchNames();

		m.addAttribute("list", list);
		return "viewaccountant";
	}

	@RequestMapping(value = "/editaccountant/{id}")
	public String edit(@PathVariable int id, Model m) {
		Accountant accountant = accountantdao.getAccountantById(id);
		m.addAttribute("command", accountant);
		return "accountanteditform";
	}

	@RequestMapping(value = "/editsaveaccountant", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("accountant") Accountant accountant) {
		accountantdao.update(accountant);
		return "redirect:/viewaccountant";
	}

	@RequestMapping(value = "/deleteaccountant/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		accountantdao.delete(id);
		return "redirect:/viewaccountant";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("searchOption") String searchOption,
			@RequestParam("searchCriteria") String searchCriteria, Model model) {

		if ("accountant".equals(searchOption)) {
			// Implement the logic to search accountants based on branch name
			if (dao.getBranchByBranchName(searchCriteria)) {

				List<Accountant> accountants = accountantdao.searchAccountantsByBranchName(searchCriteria);
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
				List<Student> students = studentdao.searchStudentsByCourseName(searchCriteria);
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


