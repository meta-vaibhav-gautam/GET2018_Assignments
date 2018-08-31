package com.metacube.session_2_Assignment.DAO.queries;

/**
 * class containing all the queries to interact with user
 * created on August 31, 2018
 */
public class MySQLUserDaoQueries {
	public static final String queryToAddUser = "INSERT INTO user(email,firstname,lastname,age,birthday,contact,password,organization) VALUES (?,?,?,?,?,?,?,?)";
	public static final String queryToGetUserPassword = "SELECT password FROM user WHERE email = ?";
}
