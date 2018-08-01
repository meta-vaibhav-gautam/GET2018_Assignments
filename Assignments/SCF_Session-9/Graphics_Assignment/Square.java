package com;

/*
 * class containing attributes of Square
 * created on July 31, 2018
 */
public class Square implements Shape {

	private int xCoordinate;
	private int yCoordinate;
	private int width;
	
	public Square (int xCoordinate, int yCoordinate,int width) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.width=width;
	}
	
	//method returns the area calculated
	@Override
	public double getArea() {
		
		return (width*width);
	}

	//method returns the perimeter calculated
	@Override
	public double getPerimeter() {
		
		return (4*width);
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
		
		 if(x<(xCoordinate+width) && y<(yCoordinate+width)) {
			 return true;
		 }
		return false;
	}

	//method returns the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.SQUARE;
	}

}
