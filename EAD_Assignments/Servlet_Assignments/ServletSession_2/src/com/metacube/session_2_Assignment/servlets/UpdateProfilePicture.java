package com.metacube.session_2_Assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.session_2_Assignment.facade.UserFacade;

/**
 * Servlet implementation class updateProfilePicture
 */
public class UpdateProfilePicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String image = "images/"+request.getParameter("profilePicture");
		String email = request.getSession().getAttribute("email").toString();
		PrintWriter out = response.getWriter();
		UserFacade userFacade = UserFacade.getInstance();
		if(userFacade.updateProfilePicture(email, image)) {
			response.sendRedirect("Profile.jsp");
		} else {
			out.println("<html>");
			out.println("<h2 style=\"color:red;text-align:center;\">Sign Up Failed !</h2>");
			out.println("</html>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Profile.jsp");
			requestDispatcher.include(request, response);
		}
	}
}
