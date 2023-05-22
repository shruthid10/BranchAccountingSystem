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
	private AccountantDao accountantDao;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistrationForm(@ModelAttribute("user") User user, Model model) {
		

		if (!accountantDao.existsByEmail(user.getEmail())) {
			model.addAttribute("error", "This email is not registered as an accountant.");
			return "register";
		}
		if (userDao.existsByEmail(user.getEmail())) {
			model.addAttribute("error", "This email is already registered.");
			return "register";
		}

		if (userDao.existsByUsername(user.getUsername())) {
			model.addAttribute("error1", "This username is already taken.");
			return "register";
		}

		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		newUser.setRole("accountant");
		userDao.save(newUser);

		return "redirect:/login";

	}
}
