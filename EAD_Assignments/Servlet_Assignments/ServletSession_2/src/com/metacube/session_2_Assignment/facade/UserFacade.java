package com.metacube.session_2_Assignment.facade;

import com.metacube.session_2_Assignment.DAO.MySqlUserDao;
import com.metacube.session_2_Assignment.enums.status;
import com.metacube.session_2_Assignment.model.User;

/**
 * User facade acting as inter mediate layer
 * created on August 31, 2018
 */
public class UserFacade {
	
	private static UserFacade userFacade= new UserFacade();
	
	public static UserFacade getInstance() {
		return userFacade;
	}
	
	public status registerUser(User user) {
		return new MySqlUserDao().registerUser(user);
	}
	
	public String getUserPassword(String email) {
		return new MySqlUserDao().getPasswordOfUser(email);
	}
}
