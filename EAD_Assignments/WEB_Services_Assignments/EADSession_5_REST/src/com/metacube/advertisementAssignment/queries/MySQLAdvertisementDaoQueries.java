package com.metacube.advertisementAssignment.queries;

/**
 * class containing all the queries to interact with Advertisement
 * created on August 31, 2018
 */
public class MySQLAdvertisementDaoQueries {
	public static final String queryToAddAdvertisement = "INSERT INTO advertisement (advertisement_title,advertisement_description,category_id) VALUES (?,?,?)";
	
	public static final String queryToGetAdvertisementByCategoryId = "SELECT advertisement_title,advertisement_description FROM advertisement WHERE Category_Id = ?";
	
	public static final String queryToGetAllAdvertisements = "SELECT advertisement_title,advertisement_description,Category_Id FROM advertisement";
	
	public static final String queryToUpdateAdvertisement = "UPDATE advertisement SET advertisement_title = ?,advertisement_description = ?,category_id = ? WHERE id = ?";
	
	public static final String queryToDeleteAdvertisement = "DELETE advertisement where id = ?";
}
