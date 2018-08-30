package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

/**
 * class containing method to perform operation on database
 * Created on August 30, 2018
 */
public class EmployeeOperation {
	 
	/**
	 * method to add Employee details in database
	 * @param employee object
	 * @return true if employee added successfully
	 */
	public boolean addEmployeeDetails(Employee employee) {
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		boolean flag=false;
		if(connection!=null) {
			String queryToAddEmployee = QueryDatabase.addEmployeeDetails();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToAddEmployee);
				preparedStatement.setString(1, employee.getEmployee_Email());
				preparedStatement.setString(2, (employee.getEmployee_Name()));
				preparedStatement.setInt(3, employee.getEmployee_age());
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					connection.close();
					flag = true;
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * method to get all Employee details from database
	 * @return list of employees
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		if(connection!=null) {
			String queryToGetAllEmployees = QueryDatabase.getAllEmployees();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToGetAllEmployees);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					employeeList.add(new Employee(resultSet.getString("Employee_Email"), resultSet.getString("Employee_Name"), 
							Integer.parseInt(resultSet.getString("Employee_age"))));
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}
	
	/**
	 * method to get Employee details using name
	 * @param name string
	 * @return list of employees
	 */
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		if(connection!=null) {
			String queryToGetEmployeesByName = QueryDatabase.getEmployeeDetailsByName();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryToGetEmployeesByName);
				preparedStatement.setString(1, name);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					employeeList.add(new Employee(resultSet.getString("Employee_Email"), resultSet.getString("Employee_Name"), 
							Integer.parseInt(resultSet.getString("Employee_age"))));
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}
	
	/**
	 * method to update Employee details in database
	 * @param employee object
	 * @return true if employee updated successfully
	 */
	public boolean updateEmployeeDetails (Employee employee) {
		String queryToUpdateEmployeeDetails=QueryDatabase.updateEmployeeDetails();
		int result=0;
		boolean flag=false;
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(queryToUpdateEmployeeDetails);
			preparedStatement.setString(1,employee.getEmployee_Name());
			preparedStatement.setInt(2, employee.getEmployee_age());
			preparedStatement.setString(3, employee.getEmployee_Email());
			result=preparedStatement.executeUpdate();
			if(result>0) {
				flag=true;
			} 
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * method to get Employee details from database
	 * @param email string
	 * @return employee object
	 */
	public Employee getEmployeeDetails(String email) {
		String queryToGetEmployeeDetails=QueryDatabase.getEmployeeDetails();
		Connection connection=JDBCConnection.getDatabaseConnection("MetacubeDB", "root", "root");
		Employee employee=null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(queryToGetEmployeeDetails);
			preparedStatement.setString(1, email);
			ResultSet resultset=preparedStatement.executeQuery();
			resultset.next();
			employee=new Employee(resultset.getString("Employee_Email"), resultset.getString("Employee_Name"),
					Integer.parseInt(resultset.getString("Employee_age")));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

}