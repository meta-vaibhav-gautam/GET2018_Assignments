package com.metacube.training.EmployeePortalHibernate.dao;

import java.util.List;

import com.metacube.training.EmployeePortalHibernate.model.Project;

public interface ProjectDAO {
	
	
	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	void createProject(Project project);
}
