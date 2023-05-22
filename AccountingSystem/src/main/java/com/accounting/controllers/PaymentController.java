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

import com.accounting.beans.Payment;
import com.accounting.beans.Student;
import com.accounting.dao.PaymentDao;
import com.accounting.dao.StudentDao;


  
	@Controller
	public class PaymentController {

		@Autowired
		PaymentDao paymentDao;

		@Autowired
		StudentDao studentDao;
		
		
		@RequestMapping(value="/paymentform",method = RequestMethod.GET)
		public String showPaymentForm(@RequestParam("student_id") int student_id, Model model) {
		  
		    model.addAttribute("student_id", student_id);
		    model.addAttribute("command", new Payment());
		    
		    return "paymentform";
		}
		
		
		@RequestMapping(value = "/savepayment", method = RequestMethod.POST)
		public String savePayment(@ModelAttribute("payment") Payment payment, Model model) {
		    int result = paymentDao.save(payment);

		    if (result == -1) {
		        model.addAttribute("error", "Error: Student ID already exists in the payment table");
		        return "paymentform";
		    } else if (result == -2) {
		        model.addAttribute("error", "Error: Amount paid cannot be greater than the course fee");
		        return "paymentform";
		    } else if (result == -3) {
		        model.addAttribute("error", "Error occurred during database access");
		        return "paymentform";
		    }

		    return "redirect:/viewpaymentdetails";
		}


		@RequestMapping("/viewpaymentdetails")
		public String viewPaymentdetails(Model m) {
			List<Payment> list = paymentDao.getPayments();
			m.addAttribute("list", list);
			return "viewpaymentdetails";
		}

		@RequestMapping(value = "/editpayment/{id}")
		public String edit(@PathVariable int id, Model m) {
			Payment payment = paymentDao.getPaymentId(id);
			m.addAttribute("command", payment);
			return "paymentupdateform";
		}

		@RequestMapping(value = "/editsavepayment", method = RequestMethod.POST)
		public String editSave(@ModelAttribute("payment") Payment payment) {
			paymentDao.update(payment);
			return "redirect:/viewpaymentdetails";
		}
		@RequestMapping(value = "/generateInvoice", method = RequestMethod.POST)
		public String generateInvoice(@RequestParam("payment_id") int payment_id, Model model) {
		    
		    Payment payment = paymentDao.getPaymentById(payment_id);
		    model.addAttribute("payment", payment);
		    Student student = studentDao.getStudentInfoById(payment.getStudent_id());
		    model.addAttribute("student", student);
		    model.addAttribute("success", "Invoice generated successfully!");
		    return "invoicepage";
		}

	}
