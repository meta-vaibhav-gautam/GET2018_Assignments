package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;

/**
 * Servlet implementation class GetEmployeeDetails
 */
public class GetEmployeeDetails extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String name = (firstName+" "+lastName);
		PrintWriter out = response.getWriter();
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		if(connection!=null) {
			String queryToGetEmployeeDetails = "SELECT employee_Email,employee_Name,employee_age FROM employee where Employee_Name=?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToGetEmployeeDetails);
				preparedStatement.setString(1, name);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				out.println("<html>");
				out.println("<title>Employee Details</title>");
				out.println("<body align=\"center\">");
				out.println("<table align=\"center\" width=50%>");
				out.println("<tr>");
				out.println("<th><h1>Email</h1></th>");
				out.println("<th><h1>Name</h1></th>");
				out.println("<th><h1>Age</h1></th>");
				out.println("</tr>");
				if(resultSet .next()) {
					do {
						out.println("<tr>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Email")+"</strong></td>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_Name")+"</strong></td>");
						out.println("<td align=\"center\"><strong>"+resultSet.getString("employee_age")+"</strong></td>");
						out.println("<td align=\"center\"><a href=\"\">Update</a></td>");
						out.println("</tr>");
					} while (resultSet.next());
				} else {
					out.println("<h2 style=\"color:black;text-align:center;\">No Employee with the name entered !</h2>");
				}
				out.println("</table>");
				out.println("<hr/><h2><a href=\"index.html\">Home</a></h2>");
				out.println("</body>");
				out.println("</html>");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Error.html");
		}
	}
}
