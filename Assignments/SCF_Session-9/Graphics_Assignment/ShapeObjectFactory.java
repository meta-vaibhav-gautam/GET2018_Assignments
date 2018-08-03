package com;

import java.util.List;

/*
 * class containing method which returns the object of shape type
 * created on July 31, 2018
 */
public class ShapeObjectFactory {
	
	public static Shape createShape(ShapeType shapeType,Point point, List<Integer> parametersList) {
		Shape shape=null;
		
		if(point.getXCoordinate()>point.getMAX_X_COORDINATE() || point.getYCoordinate()>point.getMAX_y_COORDINATE()) {
			System.out.println("Screen limit exceed !");
			return null;
		}
		
		switch (shapeType) {
		case RECTANGLE:
			shape = new Rectangle(point.getXCoordinate(), point.getYCoordinate(), parametersList.get(0),parametersList.get(1));
			break;
			
		case CIRCLE:
			shape = new Circle(point.getXCoordinate(), point.getYCoordinate(), parametersList.get(0));
			break;
			
		case SQUARE:
			shape = new Square(point.getXCoordinate(), point.getYCoordinate(), parametersList.get(0));
			break;
			
		case TRIANGLE:
			shape = new Triangle(point.getXCoordinate(), point.getYCoordinate(), parametersList.get(0),parametersList.get(1),parametersList.get(2));
			break;

		default:
			break;
		}
		return shape;
	}
}
