package com.metacube.training.EmployeePortalSpringBoot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.Project;

/**
 * mapper class containing method to map the resultset values in project entity
 * created on September 06, 2018
 */
public class ProjectMapper implements RowMapper<Project> {
	
	public Project mapRow(ResultSet resultSet, int i) throws SQLException {

		Project project = new Project();
		project.setProjectId(resultSet.getInt("project_id"));
		project.setDescription(resultSet.getString("description"));
		project.setStartDate(resultSet.getDate("start_date"));
		project.setEndDate(resultSet.getDate("end_date"));
		project.setProjectLogo(resultSet.getString("project_logo"));
		return project;
	}
	
}
