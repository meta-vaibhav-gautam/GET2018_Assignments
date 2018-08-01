package com;

/*
 * class containing attributes of a coordinate
 * created on July 31, 2018
 */
public class Point {

	private final int MAX_X_COORDINATE=500;
	private final int MAX_y_COORDINATE=500;
	
	private int xCoordinate;
	private int yCoordinate;
	
	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
	}

	//method returns the value of X coordinate
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	//method returns the value of y coordinate
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	//method returns maximum value of x coordinate
	public int getMAX_X_COORDINATE() {
		return MAX_X_COORDINATE;
	}

	//method returns maximum value of y coordinate
	public int getMAX_y_COORDINATE() {
		return MAX_y_COORDINATE;
	}

	
}
