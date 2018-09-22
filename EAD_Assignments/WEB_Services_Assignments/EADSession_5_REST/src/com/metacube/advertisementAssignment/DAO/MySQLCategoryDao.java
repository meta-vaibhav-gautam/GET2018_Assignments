package com.metacube.advertisementAssignment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertisementAssignment.model.Category;
import com.metacube.advertisementAssignment.queries.MySQLCategoryDaoQueries;

/**
 * class containing methods to operate on category
 * Created on September 3, 2018
 */
public class MySQLCategoryDao {
	
	/**
	 * method to get category name
	 * @param id of category
	 * @return name of category
	 */
	public String getCategoryName(int id) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToGetCategoryName = MySQLCategoryDaoQueries.queryToGetCategory;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetCategoryName);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("Category_name");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * method to add a new category
	 * @param name of the category
	 * @return true if category is added successfully
	 */
	public boolean addCategory(String categoryName) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToaddCategory = MySQLCategoryDaoQueries.queryToAddCategory;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToaddCategory);
			preparedStatement.setString(1,categoryName);
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
	 * method to update category name
	 * @param name of category and id of category
	 * @return true if updated successfully
	 */
	public boolean updateCategory(String name, int id) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToUpdateCategory = MySQLCategoryDaoQueries.queryToUpdateCategory;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToUpdateCategory);
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2, id);
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * method to get all categories
	 * @return list of category
	 */
	public List<Category> getAllCategories() {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		List<Category> categoryList = new ArrayList<Category>();
		String queryToGetAllCategories = MySQLCategoryDaoQueries.queryToGetAllCategories;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetAllCategories);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				do {
					categoryList.add(new Category(resultSet.getInt("id"), resultSet.getString("Category_Name")));
				} while(resultSet.next());
				return categoryList;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
}
