package com.metacube.training.EmployeePortal.service;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Employee;

/**
 * service interface for employee
 * created on September 08, 2018
 */
public interface EmployeeService {
	Employee getEmployeeById(String employeeCode);

	List<Employee> getAllEmployee();

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
	
	Employee getLatestEmployeeCode();
}
