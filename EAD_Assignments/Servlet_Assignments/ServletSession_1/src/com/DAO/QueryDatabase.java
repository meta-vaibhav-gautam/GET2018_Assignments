package com.DAO;

/**
 * class containing query strings to query database
 * created on August 30, 2018
 */
public class QueryDatabase {
	
	/**
	 * method to get query to get employee details
	 * @return query string
	 */
	public static String addEmployeeDetails() {
		return "INSERT INTO EMPLOYEE values (?,?,?)";
	}
	
	/**
	 * method to get query to update employee details
	 * @return query string
	 */
	public static String updateEmployeeDetails() {
		return "UPDATE employee SET Employee_Name=?, Employee_age=? WHERE Employee_Email=?";
	}
	
	/**
	 * method to get query to get employee details by name
	 * @return query string
	 */
	public static String getEmployeeDetailsByName() {
		return "SELECT employee_Email,employee_Name,employee_age FROM employee where Employee_Name=?";
	}
	
	/**
	 * method to get query to get all employee details
	 * @return query string
	 */
	public static String getAllEmployees() {
		return "SELECT employee_Email,employee_Name,employee_age FROM employee";
	}
	
	/**
	 * method to get query to get employee details
	 * @return query string
	 */
	public static String getEmployeeDetails() {
		return "SELECT employee_Email,employee_Name,employee_age FROM employee WHERE Employee_Email=?";
	}
	
}