package com.metacube.advertisementAssignment.facade;

import java.util.List;

import com.metacube.advertisementAssignment.DAO.MySQLCategoryDao;
import com.metacube.advertisementAssignment.model.Category;

/**
 * Category facade acting as inter mediate layer
 * created on September 03, 2018
 */
public class CategoryFacade {
	
	private static CategoryFacade categoryFacade= new CategoryFacade();
	MySQLCategoryDao mySqlCategoryDao = new MySQLCategoryDao();
	
	public static CategoryFacade getInstance() {
		return categoryFacade;
	}
	
	public boolean addCatgeory(String categoryName) {
		return mySqlCategoryDao.addCategory(categoryName);
	}
	
	public boolean updateCategory(String name, int id) {
		return mySqlCategoryDao.updateCategory(name,id);
	}
	
	public List<Category> getAllCategories() {
		return mySqlCategoryDao.getAllCategories();
	}
}
