package com;

public class Circle implements Shape {

	private final double PI=3.14;
	
	private int xCoordinate;
	private int yCoordinate;
	private int radius;
	
	public Circle(int xCoordinate, int yCoordinate,int radius) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.radius=radius;
	}
	
	// method returns the area calculated
	@Override
	public double getArea() {

		return (PI*radius*radius);
	}

	// method returns the perimeter calculated
	@Override
	public double getPerimeter() {

		return (2*PI*radius);
	}

	// method returns the origin points
	@Override
	public String getOrigin() {
		String originCoordinates = "";
		originCoordinates += String.valueOf(xCoordinate) + ",";
		originCoordinates += String.valueOf(yCoordinate);

		return originCoordinates;
	}

	// method checks for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point) {
		int x = point.getXCoordinate();
		int y = point.getYCoordinate();

		double centreX=0,centreY=0;
		double m=0;
		double n=radius;
		
		//calculating coordinates of centre
		m=Math.sqrt((xCoordinate*xCoordinate)+(yCoordinate*yCoordinate))+radius;
		centreX=(m*xCoordinate)/(m-n);
		centreY=(m*yCoordinate)/(m-n);
		
		//calculate distance of centre from the point given
		double distanceToPoint=(double)Math.sqrt(((x-centreX) * (x-centreX))+((y-centreY) * (y-centreY)));
		
		if (distanceToPoint < radius) {
			return true;
		}
		return false;
	}

	// method returns the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.CIRCLE;
	}

}