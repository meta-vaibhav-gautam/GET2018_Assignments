package com;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/*
 * junit test class containing test methods to test screen class methods
 */
public class ScreenTest {

	ShapeType shapeType=ShapeType.RECTANGLE;
	Point point=new Point(2, 3);
	List<Integer> parametersList1=new ArrayList<Integer>();
	List<Integer> parametersList2=new ArrayList<Integer>();
	List<Integer> parametersList3=new ArrayList<Integer>();
	Shape shape;
	Screen screen=new Screen();
	
	/*
	 * method to test addShapeToScreen method success scenario
	 */
	@Test
	public void testAddShapeToScreen_Success() {
		parametersList1.add(4);
		parametersList1.add(5);
		shape=ShapeObjectFactory.createShape(ShapeType.RECTANGLE, point, parametersList1);
		
		parametersList2.add(3);
		Shape shape1=ShapeObjectFactory.createShape(ShapeType.SQUARE, point, parametersList2);
		
		parametersList3.add(2);
		Shape shape2=ShapeObjectFactory.createShape(ShapeType.CIRCLE, point, parametersList3);
		
		int result=screen.addShapeToScreen(shape);
		screen.addShapeToScreen(shape1);
		screen.addShapeToScreen(shape2);
		
		assertEquals(1, result);
	}
	
	/*
	 * method to test addShapeToScreen method failure scenario
	 */
	@Test
	public void testAddShapeToScreen_Failure() {
		int result=screen.addShapeToScreen(shape);
		
		assertEquals(0, result);
	}
	
	/*
	 * method to test deleteShapeFromScreen method success scenario
	 */
	@Test
	public void testDeleteShapeFromScreen_Success() {
		int result=screen.deleteShapeFromScreen(screen.getUniqueId());
		
		assertEquals(1, result);
	}
	
	/*
	 * method to test deleteShapeFromScreen method Failure scenario
	 */
	@Test
	public void testDeleteShapeFromScreen_Failure() {
		int result=screen.deleteShapeFromScreen(screen.getUniqueId());
		
		assertNotEquals(0, result);
	}

	/*
	 * method to test isEnclosed method success scenario
	 */
	@Test
	public void testIsEnclosed_Success() {
		parametersList1.add(4);
		parametersList1.add(5);
		shape=ShapeObjectFactory.createShape(ShapeType.RECTANGLE, point, parametersList1);
		Point point1=new Point(3,4);
		boolean result=shape.isPointEnclosed(point1);
		
		assertEquals(true, result);
	}
	
	/*
	 * method to test isEnclosed method Failure scenario
	 */
	@Test
	public void testIsEnclosed_Failure() {
		Point point1=new Point(3,15);
		boolean result=shape.isPointEnclosed(point1);
		
		assertNotEquals(true, result);
	}

	/*
	 * method to test deleteAllShapeOfSpecificType method success scenario
	 */
	@Test
	public void testDeleteAllShapeOfSpecificType_Success() {
		int result=screen.deleteAllShapeOfSpecificType("rectangle");
		
		assertEquals(1, result);
	}
	
	/*
	 * method to test deleteAllShapeOfSpecificType method failure scenario
	 */
	@Test
	public void testDeleteAllShapeOfSpecificType_Failure() {
		int result=screen.deleteAllShapeOfSpecificType("rectangle");
		
		assertNotEquals(0, result);
	}
}
