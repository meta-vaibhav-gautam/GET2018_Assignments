package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Employee;
import com.DAO.EmployeeOperation;

/**
 * Servlet implementation class UpdateEmployeeDetails
 * created on August 30, 2018
 */
public class UpdateEmployeeDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String name =fname+" "+lname;
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		EmployeeOperation employeeOperation=new EmployeeOperation();
		boolean result=employeeOperation.updateEmployeeDetails(new Employee(email, name, age));
		if(result) {
			 out.println("<html>");
			 out.println("<h2 style=\"color:green;text-align:center;\">Information Updated !</h2>");
			 out.println("</html>");
			 
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("ShowAllEmployees");
			 requestDispatcher.include(request, response);
		} else {
			 out.println("<html>");
			 out.println("<h2 style=\"color:red;text-align:center;\">Information not updated !</h2>");
			 out.println("</html>");
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("ShowAllEmployees");
			 requestDispatcher.include(request, response);
		}
		
	}
}
