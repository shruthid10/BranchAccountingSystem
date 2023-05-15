package com.accounting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.accounting.beans.Course;

import com.accounting.dao.CourseDao;

@Controller
public class CourseController {
	
	@Autowired
	CourseDao coursedao;
	
	@RequestMapping("/courseform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Course());
    	return "courseform"; 
    }  
	
	@RequestMapping(value="/savecourse",method = RequestMethod.POST)  
    public String save(@ModelAttribute("course") Course course){  
        coursedao.save(course);  
        return "redirect:/viewcourse";//will redirect to viewemp request mapping  
    } 
	
	@RequestMapping("/viewcourse")  
    public String viewcourse(Model m){  
        List<Course> list=coursedao.getCourses();  
        m.addAttribute("list",list);
        return "viewcourse";  
    }  

	@RequestMapping(value="/editcourse/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Course course=coursedao.getCourseById(id);  
        m.addAttribute("command",course);
        return "courseupdateform";  
    }
	
	@RequestMapping(value="/editsavecourse",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("course") Course course){  
        coursedao.update(course);  
        return "redirect:/viewcourse";  
    }  
	/*
	 * @RequestMapping(value="/deletecourse/{id}",method = RequestMethod.GET) public
	 * String delete(@PathVariable int id){ coursedao.delete(id); return
	 * "redirect:/viewcourse"; }
	 */

}
