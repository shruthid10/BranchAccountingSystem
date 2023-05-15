package com.accounting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accounting.beans.Branch;
import com.accounting.beans.Course;

import com.accounting.beans.Student;
import com.accounting.dao.BranchDao;
import com.accounting.dao.CourseDao;
import com.accounting.dao.PaymentDao;
import com.accounting.dao.StudentDao;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentdao;
	@Autowired
	BranchDao dao;
	@Autowired
	CourseDao coursedao;
	@Autowired
	PaymentDao paymentdao;
	
	@RequestMapping("/studentform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Student());
    	List<Branch> branches = dao.getAllBranches();
        m.addAttribute("branches", branches);
        List<Course> courses = coursedao.getAllCourses();
        m.addAttribute("courses", courses);
        m.addAttribute("student", new Student());
    	return "studentform"; 
    }  
	
	@RequestMapping(value="/savestudent",method = RequestMethod.POST)  
    public String save(@ModelAttribute("student") Student student){  
		System.out.println("???????????????"+student);
		studentdao.save(student);  
        return "redirect:/viewstudentlist";//will redirect to viewemp request mapping  
    } 
	
	@RequestMapping("/viewstudentlist")  
    public String viewstudent(Model m){  
        List<Student> list=studentdao.getStudents();  
        m.addAttribute("list",list);
        return "viewstudentlist";  
    } 

	@RequestMapping(value="/editstudent/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Student student=studentdao.getStudentById(id);  
        m.addAttribute("command",student);
        return "studentupdateform";  
    }
	

	@RequestMapping(value="/editsavestudent",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("student") Student student){  
        studentdao.update(student);  
        return "redirect:/viewstudentlist";  
    }  
	@RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){
		studentdao.delete(id);  
        return "redirect:/viewstudentlist";  
    }
	
	@RequestMapping(value="/searchstudent",method = RequestMethod.GET)  
	    public String showSearchForm() {
        return "searchstudent";
    }
	/*
	 * @RequestMapping(value="/student",method = RequestMethod.GET) public String
	 * searchStudentById(@RequestParam("student_id") int student_id, Model model) {
	 * Student student = studentdao.fetchStudentById(student_id);
	 * 
	 * if (student != null) { model.addAttribute("student", student); } else {
	 * model.addAttribute("errorMessage", "No student found with ID: " +
	 * student_id); }
	 * 
	 * return "studentdetails"; }
	 */
	
	
	
	@RequestMapping(value="/student",method = RequestMethod.GET)
    public String searchStudentById(@RequestParam("student_id") int student_id, Model model) {
        try {
            Student student = studentdao.fetchStudentById(student_id);

            if (student != null) {
                model.addAttribute("student", student);
            } else {
                model.addAttribute("errorMessage", "No student found with ID: " + student_id);
            }
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("errorMessage", "No student found with ID: " + student_id);
        }

        return "studentdetails";
    }
	

}
