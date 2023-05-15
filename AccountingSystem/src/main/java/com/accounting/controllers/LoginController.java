package com.accounting.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accounting.beans.User;
import com.accounting.dao.UserDao;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;
    
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String home()
	 * { return "home"; }
	 */


    
       @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String showLoginForm(Model model) {
            model.addAttribute("user", new User());
            return "login";
        }

       @RequestMapping(value = "/login", method = RequestMethod.POST)
       public String processLoginForm(@RequestParam String username, @RequestParam String password, Model model) {
           User user = userDao.findByUsernameAndPassword(username, password);
           if (user != null) {
               String role = user.getRole();
               if ("admin".equals(role)) {
                   return "redirect:/admin";
               } else if ("accountant".equals(role)) {
                   return "redirect:/accountant";
               }
           }
           
           model.addAttribute("error", "Invalid username or password");
           return "login";
       }


    
       @RequestMapping(value = "/admin", method = RequestMethod.GET)
       public String showAdminPage() {
           return "admin";
       }

       @RequestMapping(value = "/accountant", method = RequestMethod.GET)
       public String showAccountantPage() {
           return "accountant";
       }
 
    }

    



