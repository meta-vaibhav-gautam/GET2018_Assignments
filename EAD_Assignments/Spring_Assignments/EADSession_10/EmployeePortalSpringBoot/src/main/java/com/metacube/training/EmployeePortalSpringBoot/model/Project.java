package com.metacube.training.EmployeePortalSpringBoot.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * model class for project entity
 * created on September 06, 2018
 */
public class Project {
	
	private int projectId;
	private String description;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private String projectLogo;
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getProjectLogo() {
		return projectLogo;
	}
	
	public void setProjectLogo(String projectLogo) {
		this.projectLogo = projectLogo;
	}
	
}
