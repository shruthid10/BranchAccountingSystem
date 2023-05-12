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
import com.accounting.dao.StudentDao;

@Controller
public class AccontantController {
	
	@Autowired
	AccountantDao accountantdao;
	
	@Autowired
	BranchDao dao;
	
	@Autowired
	StudentDao studentdao;
	
	@RequestMapping("/accountantform")  
    public String showaccountantform(Model m){  
		List<Branch> branches = dao.getAllBranches();
        m.addAttribute("branches", branches);
        m.addAttribute("command", new Accountant());
        return "accountantform";
    	
    	
    } 
	
	

	  @RequestMapping(value="/saveaccountant",method = RequestMethod.POST) 
	  public String saveaccountant(@ModelAttribute("accountant") Accountant accountant){
	  accountantdao.saveaccountant(accountant); 
	  
	  return "redirect:/viewaccountant"; 
	  }
	  

	  @RequestMapping("/viewaccountant")  
	    public String viewaccountant(Model m){  
	        List<Accountant> list=accountantdao.getAccountantsWithBranchNames(); 

	        m.addAttribute("list",list);
	        return "viewaccountant";  
	    } 
	  
	  @RequestMapping(value="/editaccountant/{id}")  
	    public String edit(@PathVariable int id, Model m){  
	        Accountant accountant=accountantdao.getAccountantById(id);  
	        m.addAttribute("command",accountant);
	        return "accountanteditform";  
	    }
	
	  @RequestMapping(value="/editsaveaccountant",method = RequestMethod.POST)  
	    public String editsave(@ModelAttribute("accountant") Accountant accountant){  
	        accountantdao.update(accountant);  
	        return "redirect:/viewaccountant";  
	    }  
	  
	  @RequestMapping(value="/deleteaccountant/{id}",method = RequestMethod.GET)  
	    public String delete(@PathVariable int id){
			accountantdao.delete(id);  
	        return "redirect:/viewaccountant";  
	    }  
	  
		
		/*
		 * @RequestMapping(value="/search",method = RequestMethod.GET) public String
		 * searchAccountants(@RequestParam("branch_name") String branch_name, Model
		 * model) { List<Accountant> accountants =
		 * accountantdao.getAccountantsByBranchName(branch_name);
		 * model.addAttribute("accountants", accountants); return "accountants"; }
		 */
	  @RequestMapping(value = "/search", method = RequestMethod.GET)
	  public String search(@RequestParam("searchOption") String searchOption,
	                       @RequestParam("searchCriteria") String searchCriteria,
	                       Model model) {
	      if ("accountant".equals(searchOption)) {
	          // Implement the logic to search accountants based on branch name
	          List<Accountant> accountants = accountantdao.searchAccountantsByBranchName(searchCriteria);
	          model.addAttribute("accountants", accountants);
	          return "accountantSearchResults";
	      } else if ("student".equals(searchOption)) {
	          // Implement the logic to search students based on course name
	          List<Student> students = studentdao.searchStudentsByCourseName(searchCriteria);
	          model.addAttribute("students", students);
	          return "studentSearchResults";
	      }
	      // Handle invalid search option
	      return "error";
	  }

	 

	 
}
	 
	

