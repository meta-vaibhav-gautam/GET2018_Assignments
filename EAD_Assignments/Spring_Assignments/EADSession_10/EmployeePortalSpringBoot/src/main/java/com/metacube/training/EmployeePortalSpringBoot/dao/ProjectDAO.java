package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Project;

public interface ProjectDAO {
	
	
	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);
}
