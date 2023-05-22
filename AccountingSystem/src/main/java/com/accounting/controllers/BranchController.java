package com.accounting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accounting.beans.Branch;
import com.accounting.dao.BranchDao;



@Controller
public class BranchController {
	
	@Autowired
	BranchDao dao;
	
	@RequestMapping("/branchform")  
    public String showBranchForm(Model m){  
    	m.addAttribute("command", new Branch());
    	return "branchform"; 
    }  
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("branch") Branch branch, Model model) {
	    int result = dao.save(branch);
	    if (result == -1) {
	        model.addAttribute("error", "Branch name already exists");
	        return "branchform";
	    } else {
	        return "redirect:/viewbranch";
	    }
	}

	
	
	@RequestMapping("/viewbranch")  
    public String viewBranch(Model m){  
        List<Branch> list=dao.getBranches();  
        m.addAttribute("list",list);
        return "viewbranch";  
    }  

	@RequestMapping(value="/editbranch/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Branch branch=dao.getBranchById(id);  
        m.addAttribute("command",branch);
        return "branchupdateform";  
    }
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editSave(@ModelAttribute("branch") Branch branch){  
        dao.update(branch);  
        return "redirect:/viewbranch";  
    }  
	
}

