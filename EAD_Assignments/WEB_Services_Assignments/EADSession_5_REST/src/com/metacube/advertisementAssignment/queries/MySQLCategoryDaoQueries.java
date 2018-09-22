package com.metacube.advertisementAssignment.queries;


/**
 * class containing all the queries to interact with category
 * created on August 31, 2018
 */
public class MySQLCategoryDaoQueries {
	public static final String queryToAddCategory = "INSERT INTO Category (category_name) VALUES (?)";
	
	public static final String queryToGetCategory = "SELECT Category_name FROM category WHERE id = ?";
	
	public static final String queryToGetAllCategories = "SELECT id, Category_Name FROM Category";
	
	public static final String queryToUpdateCategory = "UPDATE category SET Category_Name=? WHERE id = ?";

	
}
