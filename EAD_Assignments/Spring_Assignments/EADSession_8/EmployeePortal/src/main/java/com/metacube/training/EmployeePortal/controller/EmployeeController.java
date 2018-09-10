package com.metacube.training.EmployeePortal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.EmployeePortal.model.Employee;
import com.metacube.training.EmployeePortal.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "employee/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,HttpServletRequest request) {
		Employee employee = employeeService.getEmployeeById(username);
		HttpSession session = request.getSession();
		String passwordFromDataBase = employee.getPassword();
		if(password.equals(passwordFromDataBase)) {
			session.setAttribute("employeeCode",username);
			return "redirect:/employee/search";
		} else {
			return "employee/login";
		}	
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String search(Model model, HttpServletRequest request) {
	model.addAttribute("employee",employeeService.getEmployeeById(request.getSession().getAttribute("employeeCode").toString()));
	return "employee/dashboard";
	}
	
	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "employee/login";
	}
}
