package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
public class ShowUpdateForm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		PrintWriter out = response.getWriter();
		EmployeeOperation employeeOperation=new EmployeeOperation();
		Employee employee=employeeOperation.getEmployeeDetails(email);
		String name=employee.getEmployee_Name();
		int indexOfSpace=name.indexOf(" ");
		String fname=name.substring(0,indexOfSpace);
		String lname=name.substring(indexOfSpace,name.length());
		
		out.println("<html>");
		out.println("<title>Employee Details</title>");
		out.println("<body align=\"center\">");
		out.println("<table align=\"center\" width=50%>");
		
		out.println("<form action=\"UpdateEmployeeDetails\">");
		out.println("<tr>");
		out.println("<td>Email</td><td><input type=\"text\" value="+employee.getEmployee_Email()+" name=\"email\" readonly></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>First Name</td><td><input type=\"text\" value="+fname+" name=\"fname\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Last Name</td><td><input type=\"text\" value="+lname+" name=\"lname\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Age</td><td><input type=\"text\" value="+employee.getEmployee_age()+" name=\"age\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align=\"center\"><input type=\"submit\" value=\"Update Details\"></td>");
		out.println("</form></tr>");	
		out.println("</table>");
		out.println("<hr/><h2><a href=\"index.html\">Home</a></h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
