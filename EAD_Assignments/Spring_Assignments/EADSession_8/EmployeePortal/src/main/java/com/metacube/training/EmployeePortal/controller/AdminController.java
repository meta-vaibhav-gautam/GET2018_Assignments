package com.metacube.training.EmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortal.service.ProjectService;
import com.metacube.training.EmployeePortal.service.ProjectServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProjectService projectService = new ProjectServiceImpl();
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("username")String username, @RequestParam(name = "password") String password) {
		return new ModelAndView("admin/dashboard","username",username);
	}
	
	
}
