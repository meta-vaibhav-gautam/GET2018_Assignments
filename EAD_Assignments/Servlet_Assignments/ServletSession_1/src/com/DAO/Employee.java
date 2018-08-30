package com.DAO;

/**
 * Class containing attributes of employee
 * created on August 30, 2018
 */
public class Employee {
	private String Employee_Email;
	private String Employee_Name;
	private int Employee_age;
	
	public Employee(String Employee_Email, String Employee_Name, int Employee_age) {
		this.Employee_Email = Employee_Email;
		this.Employee_Name = Employee_Name;
		this.Employee_age = Employee_age;
	}

	/**
	 * method to get email of employee
	 * @return email string
	 */
	public String getEmployee_Email() {
		return Employee_Email;
	}

	/**
	 * method to get name of employee
	 * @return name string
	 */
	public String getEmployee_Name() {
		return Employee_Name;
	}

	/**
	 * method to get age of employee
	 * @return age
	 */
	public int getEmployee_age() {
		return Employee_age;
	}
	
	
}