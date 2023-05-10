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
		public String showform(Model m) {
			m.addAttribute("command", new Payment());
			return "paymentform";
		}

		@RequestMapping(value = "/savepayment", method = RequestMethod.POST)
		public String save( Payment payment) {
			
			
		
		     paymentdao.save(payment);
			return "redirect:/viewpaymentdetails";
		}

		@RequestMapping("/viewpaymentdetails")
		public String viewpaymentdetails(Model m) {
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
		public String editsave(@ModelAttribute("payment") Payment payment) {
			paymentdao.update(payment);
			return "redirect:/viewpaymentdetails";
		}

		@RequestMapping(value = "/deletepayment/{id}", method = RequestMethod.GET)
		public String delete(@PathVariable int id) {
			paymentdao.delete(id);
			return "redirect:/viewpaymentdetails";
		}
	}
