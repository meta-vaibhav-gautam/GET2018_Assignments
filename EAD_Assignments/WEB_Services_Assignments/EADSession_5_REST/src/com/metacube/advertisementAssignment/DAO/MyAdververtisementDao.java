package com.metacube.advertisementAssignment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.advertisementAssignment.model.Advertisement;
import com.metacube.advertisementAssignment.queries.MySQLAdvertisementDaoQueries;
import com.metacube.advertisementAssignment.queries.MySQLCategoryDaoQueries;

/**
 * class containing methods to operate on Advertisements
 * Created on September 03, 2018
 */
public class MyAdververtisementDao {
	
	/**
	 * method to add a new advertisement
	 * @param advertisement object
	 * @return true if advertisement is added successfully
	 */
	public boolean addAdvertisement(Advertisement advertisement) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToaddAdvertisement = MySQLAdvertisementDaoQueries.queryToAddAdvertisement;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToaddAdvertisement);
			preparedStatement.setString(1,advertisement.getAdvertisementTitle());
			preparedStatement.setString(2, advertisement.getAdvertisementDescription());
			preparedStatement.setInt(3, advertisement.getId());
			
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
	public boolean updateCategory(Advertisement advertisement) {
		Connection connection = MySQLConnection.getDatabaseConnection("metaRestfulSessionDB");
		String queryToUpdateAdvertisement = MySQLAdvertisementDaoQueries.queryToUpdateAdvertisement;
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
}
