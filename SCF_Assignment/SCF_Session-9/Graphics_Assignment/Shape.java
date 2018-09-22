package com;

/*
 * interface containing attributes of shape
 * created on July 31, 2018
 */
public interface Shape {

	public double getArea();
	public double getPerimeter();
	public String getOrigin();
	public ShapeType getType();
	public boolean isPointEnclosed(Point point);
	
}
