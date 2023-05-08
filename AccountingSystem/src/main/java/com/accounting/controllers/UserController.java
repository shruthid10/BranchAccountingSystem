package com.accounting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accounting.beans.User;
import com.accounting.dao.AccountantDao;
import com.accounting.dao.UserDao;

@Controller
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AccountantDao accountantdao;
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(@ModelAttribute("user") User user, Model model) {
    	System.out.println("User object from form: " + user.toString());
    	
        // check if email exists in accountant table
        if (!accountantdao.existsByEmail(user.getEmail())) {
        	String email = user.getEmail();
            System.out.println("Email to check: " + email);
            model.addAttribute("error", "This email is not registered as an accountant.");
            return "register";
        }
        if (userDao.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "This email is already registered.");
            return "register";
        }
		
		 // check if username already exists in user table 
        if (userDao.existsByUsername(user.getUsername())) {
			 model.addAttribute("error1", "This username is already taken."); 
			 return "register"; 
			 }
		 
        
      
//        user.setRole("accountant");
//        userDao.save(user);
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole("accountant");
        userDao.save(newUser);
        
        return "redirect:/login";
        

    }
}

