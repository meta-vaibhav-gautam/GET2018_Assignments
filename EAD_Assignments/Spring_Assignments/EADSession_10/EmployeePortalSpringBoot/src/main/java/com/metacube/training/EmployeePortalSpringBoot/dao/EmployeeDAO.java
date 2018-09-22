package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

/**
 * interface for operation on employee
 * created on September 08, 2018
 */
public interface EmployeeDAO {
	public Employee getEmployeeById(String employeeCode);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
	
	Employee getLatestEmployeeCode();
}
