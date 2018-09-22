package com.metacube.session_2_Assignment.DAO.queries;

/**
 * class containing all the queries to interact with user
 * created on August 31, 2018
 */
public class MySQLUserDaoQueries {
	public static final String queryToAddUser = "INSERT INTO user(email,firstname,lastname,age,birthday,"
			+ "contact,password,organization) VALUES (?,?,?,?,?,?,?,?)";
	
	public static final String queryToGetUserPassword = "SELECT password FROM user WHERE email = ?";
	
	public static final String queryToGetUserDetailsByEmail = "SELECT email,firstname,lastname,age,birthday,"
			+ "contact,password,organization,image FROM user WHERE email = ?";
	
	public static final String queryToUpdateProfilePicture = "UPDATE user SET image=? WHERE email=?";
	
	public static final String queryToGetFriendList = "SELECT email,firstname,lastname,age,birthday,"
			+ "contact,password,organization,image FROM user WHERE organization = ? AND email <> ?";
	
	public static final String queryToUpdateUserDetails = "UPDATE user SET firstname=?,lastname=?,age=?,birthday=?,"
			+ "contact=?,organization=? WHERE email=?";
}
