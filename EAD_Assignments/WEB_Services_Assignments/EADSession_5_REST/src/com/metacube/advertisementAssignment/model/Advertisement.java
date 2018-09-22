package com.metacube.advertisementAssignment.model;

public class Advertisement {
	private int id;
	private String advertisementTitle;
	private String advertisementDescription;
	private int categoryId;
	
	public Advertisement (int id, String advertisementTitle, String advertisementDescription, int categoryId) {
		this.id = id;
		this.advertisementTitle = advertisementTitle;
		this.advertisementDescription = advertisementDescription;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public String getAdvertisementTitle() {
		return advertisementTitle;
	}

	public String getAdvertisementDescription() {
		return advertisementDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}
	
}
