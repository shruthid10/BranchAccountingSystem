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
	CourseDao courseDao;
	
	@RequestMapping("/courseform")  
    public String showCourseForm(Model m){  
    	m.addAttribute("command", new Course());
    	return "courseform"; 
    }  
	
	@RequestMapping(value = "/savecourse", method = RequestMethod.POST)
	public String save(@ModelAttribute("course") Course course, Model model) {
	    int result = courseDao.save(course);
	    
	    if (result == -1) {
	        model.addAttribute("error", "Course name already exists");
	        return "courseform";
	    } else if (result == -2) {
	        model.addAttribute("error", "Fees value is too large");
	        return "courseform";
	    } else if (result == -3) {
	        model.addAttribute("error", "Duration is too long");
	        return "courseform";
	    } else {
	        return "redirect:/viewcourse";
	    }
	}

	
	@RequestMapping("/viewcourse")  
    public String viewCourse(Model m){  
        List<Course> list=courseDao.getCourses();  
        m.addAttribute("list",list);
        return "viewcourse";  
    }  

	@RequestMapping(value="/editcourse/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Course course=courseDao.getCourseById(id);  
        m.addAttribute("command",course);
        return "courseupdateform";  
    }
	
	@RequestMapping(value="/editsavecourse",method = RequestMethod.POST)  
    public String editSave(@ModelAttribute("course") Course course){  
        courseDao.update(course);  
        return "redirect:/viewcourse";  
    }  
	

}
