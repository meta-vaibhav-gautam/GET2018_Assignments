package com.metacube.advertisementAssignment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertisementAssignment.model.Advertisement;
import com.metacube.advertisementAssignment.queries.MySQLAdvertisementDaoQueries;

/**
 * class containing methods to operate on Advertisements
 * Created on September 03, 2018
 */
public class MySQLAdvertisementDao {
	
	/**
	 * method to add a new advertisement
	 * @param advertisement object
	 * @return true if advertisement is added successfully
	 */
	public boolean addAdvertisement(String advertisementTitle, String advertisementDescription, int categoryId) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToaddAdvertisement = MySQLAdvertisementDaoQueries.queryToAddAdvertisement;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToaddAdvertisement);
			preparedStatement.setString(1,advertisementTitle);
			preparedStatement.setString(2, advertisementDescription);
			preparedStatement.setInt(3, categoryId);
			
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
	 * method to update Advertisement
	 * @param advertisement object
	 * @return true if updated successfully
	 */
	public boolean updateAdvertisement(Advertisement advertisement) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToUpdateAdvertisement = MySQLAdvertisementDaoQueries.queryToUpdateAdvertisement;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToUpdateAdvertisement);
			preparedStatement.setString(1,advertisement.getAdvertisementTitle());
			preparedStatement.setString(2, advertisement.getAdvertisementDescription());
			preparedStatement.setInt(3, advertisement.getCategoryId());
			preparedStatement.setInt(4, advertisement.getId());
			
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
	 * method to get list of all advertisements
	 * @return list of all advertisements
	 */
	public List<Advertisement> getAllAdvertisements() {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToGetAllAdvertisements = MySQLAdvertisementDaoQueries.queryToGetAllAdvertisements;
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(queryToGetAllAdvertisements);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				do {
					advertisementList.add(new Advertisement(
							resultSet.getInt("id"), 
							resultSet.getString("advertisement_title"), 
							resultSet.getString("advertisement_description"), 
							resultSet.getInt("category_id")
						)
					);
				} while (resultSet.next());
				return advertisementList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return advertisementList;
	}
	
	/**
	 * method to delete an advertisement
	 * @param id of advertisement to be deleted
	 * @return true if advertisement is deleted successfully
	 */
	public boolean deleteAdvertisement(int id) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToDeleteAdvertisement = MySQLAdvertisementDaoQueries.queryToDeleteAdvertisement;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToDeleteAdvertisement);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
