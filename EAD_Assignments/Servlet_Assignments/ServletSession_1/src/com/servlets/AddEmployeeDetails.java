package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Employee;
import com.DAO.EmployeeOperation;

/**
 * Servlet implementation class AddEmployeeDetails
 */
public class AddEmployeeDetails extends HttpServlet {
	
	/**
	 * method to add employee details to database
	 * @throws IOException 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		Employee employee = new Employee(email, (firstName+" "+lastName),age);
		PrintWriter out = response.getWriter();
		EmployeeOperation employeeOperation=new EmployeeOperation();
		if(employeeOperation.addEmployeeDetails(employee)) {
			 out.println("<html>");
			 out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
			 out.println("</html>");
			 
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Register.html");
			 requestDispatcher.include(request, response);
		} else {
			 out.println("<html>");
			 out.println("<h2 style=\"color:red;text-align:center;\">Employee already present !</h2>");
			 out.println("</html>");
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Register.html");
			 requestDispatcher.include(request, response);
		}
	}
}
