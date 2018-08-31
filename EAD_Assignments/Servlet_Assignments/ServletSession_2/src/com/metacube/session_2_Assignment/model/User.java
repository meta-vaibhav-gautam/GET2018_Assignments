package com.metacube.session_2_Assignment.model;

import java.sql.Date;

public class User {
	
	 private String email;
	 private String firstName;
	 private String lastName;
	 private int age;
	 private Date birthday;
	 private String contact;
	 private String password;
	 private String organization;
	 private String image;
	
	 public User (String firstName,String lastName,int age,Date birthday,String contact,
			 String email,String password,String organization,String image) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthday = birthday;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.organization = organization;
		this.image = image;
	 }

	/**
	 * method to get first name of user
	 * @return first name of user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * method to get last name of user
	 * @return last name of user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * method to get age of user
	 * @return age of user
	 */
	public int getAge() {
		return age;
	}

	/**
	 * method to get birthday of user
	 * @return birthday of user
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * method to get contact of user
	 * @return contact of user
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * method to get email of user
	 * @return email of user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * method to get password of user
	 * @return password of user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * method to get organization of user
	 * @return organization of user
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * method to get image of user
	 * @return image of user
	 */
	public String getImage() {
		return image;
	}
	 
	 
}
