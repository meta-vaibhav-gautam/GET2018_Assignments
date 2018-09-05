package com.metacube.advertisementAssignment.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static Connection connection;
	private static String userName = "root";
	private static String password = "rat";

	/**
	 * method to load drivers and return the connection object
	 * @return Connection class object
	 */
	public static Connection getDatabaseConnection(String databaseName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName,password);
		} catch (ClassNotFoundException cne) {System.out.println("Class not found ! Exception in generating Connection.");
		} catch (SQLException se) {
			System.out.println("SQL Exception ! Exception in generating Connection.");
		}
		return connection;
	}
}
