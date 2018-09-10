package com.metacube.training.EmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortal.dao.EmployeeDAO;
import com.metacube.training.EmployeePortal.model.Employee;

/**
 * class containing implementation of service interface method
 * created on September 08, 2018
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		String employeeCode = (employeeDAO.getLatestEmployeeCode()).getEmployeeCode();
		String [] employeeCodePartArray = employeeCode.split("/");
		int seriesNumber = Integer.parseInt(employeeCodePartArray[1]);
		seriesNumber = seriesNumber+1;
		employeeCode = employeeCodePartArray[0]+"/"+seriesNumber;
		employee.setEmployeeCode(employeeCode);
		
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public Employee getLatestEmployeeCode() {
		return employeeDAO.getLatestEmployeeCode();
	}
	
	
}
