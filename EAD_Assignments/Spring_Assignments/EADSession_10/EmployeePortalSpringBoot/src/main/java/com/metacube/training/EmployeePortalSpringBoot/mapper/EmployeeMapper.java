package com.metacube.training.EmployeePortalSpringBoot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

/**
 * class containing method to map resultset data to employee object
 * created on September 08, 2018
 */
public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeCode(rs.getString("emp_code"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setDob(rs.getDate("dob"));
		employee.setGender(rs.getString("gender"));
		employee.setPrimaryContactNumber(rs.getString("primary_contact_number"));
		employee.setSecondaryContactNumber(rs.getString("secondary_contact_number"));
		employee.setEmailId(rs.getString("email_id"));
		employee.setSkypeId(rs.getString("skype_id"));
		employee.setProfilePicture(rs.getString("profile_picture"));
		employee.setPassword(rs.getString("password"));
		employee.setEnabled(rs.getBoolean("enabled"));
		return employee;
	}
	
}
