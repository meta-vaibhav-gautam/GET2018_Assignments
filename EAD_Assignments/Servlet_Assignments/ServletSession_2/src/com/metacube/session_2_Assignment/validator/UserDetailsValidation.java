package com.metacube.session_2_Assignment.validator;

import java.util.regex.Pattern;

/**
 * class containing methods to validate user details entered in form
 * Created on August 31, 2018
 */
public class UserDetailsValidation {
	
	/**
	 * method to validate user details
	 * @param user details from a user form
	 * @return true if all values are correct
	 */
	public boolean validateUserDetails(String firstName,String lastName,String age, String contact,String email,String password,String confirmPassword,String organization) {
		boolean flag=false;
		if(validateName(firstName) && validateName(lastName) && validateAge(age) && validateContact(contact) && validateEmail(email) && validatePassword(password,confirmPassword) && validateOrganization(organization)) {
			flag = true;
		} else {
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * method to validate name
	 * @param name of user
	 * @return true if name is correct '
	 */
	private boolean validateName(String name) {
		return Pattern.compile("^[A-Z,a-z]+$").matcher(name).matches()
				&& name.length() > 2 ? true : false;
	}
	
	/**
	 * method to validate age of user
	 * @param age of user
	 * @return true if age entered is in correct format 
	 */
	private boolean validateAge(String age) {
		int ageOfUser = Integer.parseInt(age);
		return ageOfUser > -1 && ageOfUser < 100 ? true : false;
	}
	
	/**
	 * method to validate contact
	 * @param contact of user
	 * @return true if contact is correct
	 */
	private boolean validateContact(String contact) {
		return (contact.length() > 8)? true : false;
	}
	
	/**
	 * method to validate user email
	 * @param email user user
	 * @return true if email is correct
	 */
	private boolean validateEmail(String email) {
		return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE).matcher(email).matches() ? true
				: false;
	}
	
	/**
	 * method to validate password entered by user
	 * @param password
	 * @return true if password is correct
	 */
	private boolean validatePassword(String password,String ConfirmPassword) {
		if (password.equals(ConfirmPassword)) {
			return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,20}$")
		.matcher(password).matches() ? true : false;
		} else {
		System.out.println("Password is incorrect");
		return false;
		}
	}
	
	/**
	 * method to validate organization
	 */
	private boolean validateOrganization(String organization) {
		if("select".equals(organization)) {
			return false;
		}
		return true;
	}
}
