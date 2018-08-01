package com;


/*
 * class containing attributes of rectangle and methods for operations of rectangle
 * created on July 31, 2018
 */
public class Rectangle implements Shape {

	private int xCoordinate;
	private int yCoordinate;
	private int length;
	private int width;
	
	public Rectangle (int xCoordinate, int yCoordinate, int length, int width) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.length=length;
		this.width=width;
	}
	
	//method returns the area calculated
	@Override
	public double getArea() {
		
		return (length*width);
	}

	//method returns the perimeter calculated
	@Override
	public double getPerimeter() {
		
		return (2*(length+width));
	}

	//method returns the origin points
	@Override
	public String getOrigin() {
		String originCoordinates="";
		originCoordinates+=String.valueOf(xCoordinate)+",";
		originCoordinates+=String.valueOf(yCoordinate);
		
		return originCoordinates;
	}

	//method checks for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point) {
		 int x=point.getXCoordinate();
		 int y=point.getYCoordinate();
		
		 if(x<(xCoordinate+width) && y<(yCoordinate+length)) {
			 return true;
		 }
		return false;
	}

	//method returns the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.RECTANGLE;
	}

}
