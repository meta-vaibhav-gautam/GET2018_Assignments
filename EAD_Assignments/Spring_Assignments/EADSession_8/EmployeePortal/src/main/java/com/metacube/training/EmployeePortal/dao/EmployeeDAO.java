package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Employee;

/**
 * interface for operation on employee
 * created on September 08, 2018
 */
public interface EmployeeDAO {
	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
	
	Employee getLatestEmployeeCode();
}
