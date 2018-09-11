package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalSpringBoot.mapper.EmployeeMapper;
import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

/**
 * class containing implementation of interface method
 * cretaed on September 08, 2018
 */
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAOImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_EMPLOYEE = "SELECT * FROM employee where emp_code=?";
	
	private final String SQL_GET_ALL = "SELECT * FROM EMPLOYEE";
	
	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee "
			+ "(emp_Code, first_Name, last_Name, dob, gender, primary_Contact_Number,"
			+ "secondary_Contact_Number, email_Id, skype_Id, profile_Picture, password,"
			+ "enabled) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET "
			+ "first_Name=?, last_Name=?, dob=?, gender=?, primary_Contact_Number=?,"
			+ "secondary_Contact_Number=?, email_Id=?, skype_Id=?, profile_Picture=?, password=?,"
			+ "enabled=? WHERE emp_code=?";
	
	private final String SQL_LATEST_EMPLOYEE_CODE = "SELECT * FROM employee ORDER BY emp_code DESC LIMIT 1";
	
	@Override
	public Employee getEmployeeById(String employeeCode) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] {employeeCode},new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployee() {
		return jdbcTemplate.query(SQL_GET_ALL,new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, 
				employee.getFirstName(),
				employee.getLastName(),
				employee.getDob(),
				employee.getGender(),
				employee.getPrimaryContactNumber(),
				employee.getSecondaryContactNumber(),
				employee.getEmailId(),
				employee.getSkypeId(),
				employee.getProfilePicture(),
				employee.getPassword(),
				employee.isEnabled(),
				employee.getEmployeeCode()
		)>0;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
				employee.getEmployeeCode(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getDob(),
				employee.getGender(),
				employee.getPrimaryContactNumber(),
				employee.getSecondaryContactNumber(),
				employee.getEmailId(),
				employee.getSkypeId(),
				employee.getProfilePicture(),
				employee.getPassword(),
				employee.isEnabled()
		)>0;
	}

	@Override
	public Employee getLatestEmployeeCode() {
		return jdbcTemplate.queryForObject(SQL_LATEST_EMPLOYEE_CODE,new Object[]{},new EmployeeMapper());
	}
	
}
