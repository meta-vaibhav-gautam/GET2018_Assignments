package com;

public class Triangle implements Shape {

	private int xCoordinate;
	private int yCoordinate;
	private int side1;
	private int side2;
	private int side3;
	
	public Triangle (int xCoordinate, int yCoordinate,int side1,int side2,int side3) {
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	
	//method returns the area calculated
	@Override
	public double getArea() {
		double area;
		double s=(side1+side2+side3)/2;
		area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}

	//method returns the perimeter calculated
	@Override
	public double getPerimeter() {
		
		return (side1+side2+side3);
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
		
		 int x2=xCoordinate+side1;
		 int y2=yCoordinate+side1;

		 int x3=x2+side2;
		 int y3=y2+side2;
		 if(x>=xCoordinate && x<=x3 && y<=y2) {
			 return true;
		 }
		return false;
	}

	//method returns the shape type
	@Override
	public ShapeType getType() {
		return ShapeType.TRIANGLE;
	}

}
