package com.metacube.session_2_Assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.session_2_Assignment.enums.status;
import com.metacube.session_2_Assignment.facade.UserFacade;
import com.metacube.session_2_Assignment.model.User;
import com.metacube.session_2_Assignment.validator.UserDetailsValidation;

/**
 * Servlet implementation class RegisterUser
 * created on August 31, 2018
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");   
		String lastName = request.getParameter("lastName");    
		String age = request.getParameter("age");            
		String birthday = request.getParameter("birthday");      
		String contact = request.getParameter("contact");     
		String email = request.getParameter("email");       
		String password = request.getParameter("password");  
		String confirmPassword = request.getParameter("confirmPassword");
		String organization = request.getParameter("organization");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = birthday;
		Date date=null;
		try {
			date = new java.sql.Date(sdf.parse(parameter).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		UserDetailsValidation userDetailsValidation = new UserDetailsValidation();
		if(userDetailsValidation.validateUserDetails(firstName, lastName, age, contact, email, password, confirmPassword,organization)) {
			User user = new User(firstName, lastName, Integer.parseInt(age), date, contact, email, confirmPassword, organization,"");
			
			status status = UserFacade.getInstance().registerUser(user); //interacting to facade
			
			if("OK".equals((status.toString()))) {
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">Account created Successfully !</h2>");
				out.println("</html>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
				requestDispatcher.include(request, response);
			} else {
				out.println("<html>");
				out.println("<h2 style=\"color:red;text-align:center;\">Sign Up Failed !</h2>");
				out.println("</html>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.html");
				requestDispatcher.include(request, response);
			}
		} else {
			 out.println("<html>");
			 out.println("<h2 style=\"color:red;text-align:center;\">Sign Up Failed !</h2>");
			 out.println("</html>");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.html");
			 requestDispatcher.include(request, response);
		}
	}


}
