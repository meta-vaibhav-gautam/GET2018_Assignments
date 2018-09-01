package com.metacube.session_2_Assignment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.session_2_Assignment.DAO.queries.MySQLUserDaoQueries;
import com.metacube.session_2_Assignment.enums.status;
import com.metacube.session_2_Assignment.model.User;

/**
 * Class containing methods for operations on user in database
 * created on August 31, 2018
 */
public class MySQLUserDao {
	
	/**
	 * method to add user details to database
	 * @param user model object
	 * @return status enum
	 */
	public status registerUser(User user) {
		String queryToRegisterUser = MySQLUserDaoQueries.queryToAddUser;
		Connection connection = MySQLConnection.getDatabaseConnection("metaServletSession2");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToRegisterUser);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setDate(5, user.getBirthday());
			preparedStatement.setString(6, user.getContact());
			preparedStatement.setString(7, user.getPassword());
			preparedStatement.setString(8, user.getOrganization());
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				connection.close();
				return status.OK;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return status.ERROR;
		}
		return status.ERROR;
	}
	
	/**
	 * method to get password of user
	 * @param email of user
	 * @return password of user
	 */
	public String getPasswordOfUser(String email) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaServletSession2");
		String queryToGetUserPassword = MySQLUserDaoQueries.queryToGetUserPassword;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetUserPassword);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("password");
			}
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *method to get user information using email
	 *@param email of the user
	 *@return user object containing information
	 */
	public User getUserDetailsByEmail(String email) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaServletSession2");
		String queryToGetUserDetailsByEmail = MySQLUserDaoQueries.queryToGetUserDetailsByEmail;
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetUserDetailsByEmail);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new User(
							resultSet.getString("firstname"),
							resultSet.getString("lastname"),
							resultSet.getInt("age"),
							resultSet.getDate("birthday"),
							resultSet.getString("contact"),
							resultSet.getString("email"),
							resultSet.getString("password"),
							resultSet.getString("organization"),
							resultSet.getString("image")
						);
			}
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * method to update profile picture
	 * @param email and image uploaded by user
	 * @return true if image is updated successfully
	 */
	public boolean updateProfilePicture(String email,String image) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaServletSession2");
		String queryToUpdateProfilePicture = MySQLUserDaoQueries.queryToUpdateProfilePicture;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToUpdateProfilePicture);
			preparedStatement.setString(1,image);
			preparedStatement.setString(2, email);
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				return true;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *method to get userList of particular organization
	 *@param email and organization of the user 
	 *@return user list containing information
	 */
	public List<User> getFriendListOfUser(String email, String organization) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaServletSession2");
		String queryToGetUserDetailsByEmail = MySQLUserDaoQueries.queryToGetFriendList;
		List<User> friendList = new ArrayList<User>();
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetUserDetailsByEmail);
			preparedStatement.setString(1, organization);
			preparedStatement.setString(2, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				do {
					user = new User(
							resultSet.getString("firstname"),
							resultSet.getString("lastname"),
							resultSet.getInt("age"),
							resultSet.getDate("birthday"),
							resultSet.getString("contact"),
							resultSet.getString("email"),
							resultSet.getString("password"),
							resultSet.getString("organization"),
							resultSet.getString("image")
					);
					friendList.add(user);
				} while (resultSet.next());
				return friendList;
			}
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return friendList;
	}
	
	/**
	 * method to update user profile data
	 * @param user object 
	 * @return true if profile data is updated successfully
	 */
	public boolean updateUserDetails(User user) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaServletSession2");
		String queryToUpdateUserDetails = MySQLUserDaoQueries.queryToUpdateUserDetails;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToUpdateUserDetails);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setDate(4, user.getBirthday());
			preparedStatement.setString(5, user.getContact());
			preparedStatement.setString(6, user.getOrganization());
			preparedStatement.setString(7, user.getEmail());
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				return true;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
