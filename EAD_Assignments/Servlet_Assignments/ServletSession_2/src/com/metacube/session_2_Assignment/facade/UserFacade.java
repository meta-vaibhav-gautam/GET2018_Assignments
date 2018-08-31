package com.metacube.session_2_Assignment.facade;

import com.metacube.session_2_Assignment.DAO.MySQLUserDao;
import com.metacube.session_2_Assignment.enums.status;
import com.metacube.session_2_Assignment.model.User;

/**
 * User facade acting as inter mediate layer
 * created on August 31, 2018
 */
public class UserFacade {
	
	private static UserFacade userFacade= new UserFacade();
	private MySQLUserDao mySqlUserDao = new MySQLUserDao();
	
	public static UserFacade getInstance() {
		return userFacade;
	}
	
	public status registerUser(User user) {
		return mySqlUserDao.registerUser(user);
	}
	
	public String getUserPassword(String email) {
		return mySqlUserDao.getPasswordOfUser(email);
	}
	
	public User getUserDetailsByEmail(String email) {
		return mySqlUserDao.getUserDetailsByEmail(email);
	}
}
