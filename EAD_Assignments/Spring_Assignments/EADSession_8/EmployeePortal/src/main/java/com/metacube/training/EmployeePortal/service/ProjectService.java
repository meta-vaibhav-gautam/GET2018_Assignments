package com.metacube.training.EmployeePortal.service;

import java.util.List;

import com.metacube.training.EmployeePortal.model.Project;


public interface ProjectService {

	
	Project getProjectById(Long id);

	List<Project> getAllProjects();

	boolean deleteProject(Long id);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
