package com.metacube.training.EmployeePortalSpringBoot.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * class containing Employee attributes
 * created on September 08, 2018
 */
public class Employee {
	private String employeeCode;
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String primaryContactNumber;
	private String secondaryContactNumber; 
	private String emailId;
	private String skypeId;
	private String profilePicture;
	private String password;
	private boolean enabled=true;
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}
	
	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}
	
	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}
	
	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getSkypeId() {
		return skypeId;
	}
	
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}
	
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
