package com.accounting.controllers;
  

import java.util.List;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.accounting.beans.Payment;
import com.accounting.dao.PaymentDao;


  
	@Controller
	public class PaymentController {

		@Autowired
		PaymentDao paymentdao;

		@RequestMapping("/paymentform")
		public String showPaymentForm(Model m) {
			m.addAttribute("command", new Payment());
			return "paymentform";
		}

		@RequestMapping(value = "/savepayment", method = RequestMethod.POST)
		public String save(@ModelAttribute("payment") Payment payment, Model model) {
			int result = paymentdao.save(payment);

			if (result == -1) {
				model.addAttribute("error", "Error: Student ID already exists in the payment table");
				return "paymentform";
			} else if (result == -2) {
				model.addAttribute("error", "Error: Student ID not found in the student table");
				return "paymentform";
			} else if (result == -3) {
				model.addAttribute("error", "Error occurred during database access");
				return "paymentform";
			}

			return "redirect:/viewpaymentdetails";
		}

		@RequestMapping("/viewpaymentdetails")
		public String viewPaymentdetails(Model m) {
			List<Payment> list = paymentdao.getPayments();
			m.addAttribute("list", list);
			return "viewpaymentdetails";
		}

		@RequestMapping(value = "/editpayment/{id}")
		public String edit(@PathVariable int id, Model m) {
			Payment payment = paymentdao.getPaymentId(id);
			m.addAttribute("command", payment);
			return "paymentupdateform";
		}

		@RequestMapping(value = "/editsavepayment", method = RequestMethod.POST)
		public String editSave(@ModelAttribute("payment") Payment payment) {
			paymentdao.update(payment);
			return "redirect:/viewpaymentdetails";
		}

	}
