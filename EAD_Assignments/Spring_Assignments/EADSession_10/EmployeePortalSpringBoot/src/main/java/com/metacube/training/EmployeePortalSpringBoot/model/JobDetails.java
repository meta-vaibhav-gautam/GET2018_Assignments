package com.metacube.training.EmployeePortalSpringBoot.model;

/**
 * class for job details
 * created on September 10, 2018
 */
public class JobDetails {
	private int jobDetailId;
	private String employeeCode;
	private int jobCode;
	private String reportingManager;
	private String teamLead;
	private int currentProjectId;
	
	public int getJobDetailId() {
		return jobDetailId;
	}
	
	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public int getJobCode() {
		return jobCode;
	}
	
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	
	public String getReportingManager() {
		return reportingManager;
	}
	
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	
	public String getTeamLead() {
		return teamLead;
	}
	
	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
	
	public int getCurrentProjectId() {
		return currentProjectId;
	}
	
	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}
	
	
}
