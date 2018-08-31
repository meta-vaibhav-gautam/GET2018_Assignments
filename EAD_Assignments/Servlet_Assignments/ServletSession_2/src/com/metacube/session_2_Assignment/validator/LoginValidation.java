package com.metacube.session_2_Assignment.validator;

/**
 * class containing method to validate login credentials
 * created on August 31, 2018
 */
public class LoginValidation {
	public boolean validateLoginPassword(String enteredPassword, String userPassword) {
		if(enteredPassword.equals(userPassword)) {
			return true;
		}
		return false;
	}
}
