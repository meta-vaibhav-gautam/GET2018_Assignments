package com.metacube.session_2_Assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.session_2_Assignment.facade.UserFacade;
import com.metacube.session_2_Assignment.model.User;

/**
 * Servlet implementation class UpdateUserDetails
 */
public class UpdateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String ageString = request.getParameter("age");
		String birthday = request.getParameter("birthday");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String organization = request.getParameter("organization");
		int age = Integer.parseInt(ageString);
		PrintWriter out = response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = new java.sql.Date(sdf.parse(birthday).getTime());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		User user = new User (firstName,lastName,age,date,contact,email,"",organization,"");
		UserFacade userFacade = UserFacade.getInstance();
		if(userFacade.updateUserDetails(user)) {
			out.println("<html>");
			out.println("<h2 style=\"color:green;text-align:center;\">Profile Updated Successfully !</h2>");
			out.println("</html>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Profile.jsp");
			requestDispatcher.include(request, response);
		} else {
			out.println("<html>");
			out.println("<h2 style=\"color:red;text-align:center;\">Some error occurred !</h2>");
			out.println("</html>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Profile.jsp");
			requestDispatcher.include(request, response);
		}
	}
}
