package com.metacube.advertisementAssignment.facade;

import java.util.List;

import com.metacube.advertisementAssignment.DAO.MySQLAdvertisementDao;
import com.metacube.advertisementAssignment.model.Advertisement;

/**
 * Advertisement facade acting as inter mediate layer
 * created on September 03, 2018
 */
public class AdvertisementFacade {
	
	private static AdvertisementFacade advertisementFacade= new AdvertisementFacade();
	MySQLAdvertisementDao mySqlAdvertisementyDao = new MySQLAdvertisementDao();
	
	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}
	
	public boolean addAdvertisement(String advertisementTitle, String advertisementDescription, int categoryId) {
		return mySqlAdvertisementyDao.addAdvertisement(advertisementTitle, advertisementDescription, categoryId);
	}
	
	public List<Advertisement> getAdvertisements() {
		return mySqlAdvertisementyDao.getAllAdvertisements();
	}
	
	public boolean updateAdvertisement(int id, String advertisementTitle, String advertisementDescription, int categoryId) {
		return mySqlAdvertisementyDao.updateAdvertisement(new Advertisement(id, advertisementTitle, advertisementDescription, categoryId));
	}
	
	public boolean deleteAdvertisement(int id) {
		return mySqlAdvertisementyDao.deleteAdvertisement(id);
	}
}
