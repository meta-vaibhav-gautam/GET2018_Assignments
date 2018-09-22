package com.metacube.session_2_Assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.session_2_Assignment.facade.UserFacade;
import com.metacube.session_2_Assignment.validator.LoginValidation;

/**
 * Servlet implementation class ValidateUser
 */
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		UserFacade userFacade = UserFacade.getInstance();
		String userPassword = userFacade.getUserPassword(email);
		
		if(new LoginValidation().validateLoginPassword(password, userPassword)) {
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			
			response.sendRedirect("Profile.jsp");
		} else {
			out.println("<html>");
			out.println("<h2 style=\"color:red;text-align:center;\">Login Failed !</h2>");
			out.println("</html>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
			requestDispatcher.include(request, response);
		}
	}

}
