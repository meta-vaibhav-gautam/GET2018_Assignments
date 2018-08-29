package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;

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
		
		PrintWriter out = response.getWriter();
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		if(connection!=null) {
			String queryToAddEmployee = "INSERT INTO EMPLOYEE values (?,?,?)";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToAddEmployee);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, (firstName+" "+lastName));
				preparedStatement.setInt(3, age);
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					 out.println("<html>");
					 out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
					 out.println("</html>");
					 
					 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Register.html");
					 requestDispatcher.include(request, response);
				} else {
					response.sendRedirect("Error.html");
				}
				connection.close();
			} catch (SQLException e) {
				 out.println("<html>");
				 out.println("<h2 style=\"color:red;text-align:center;\">Employee Already Present !</h2>");
				 out.println("</html>");
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Register.html");
				 requestDispatcher.include(request, response);
				 
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Error.html");
		}
	}

}
