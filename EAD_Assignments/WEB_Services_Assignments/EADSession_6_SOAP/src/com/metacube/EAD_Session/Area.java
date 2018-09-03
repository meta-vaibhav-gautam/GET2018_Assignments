package com.metacube.EAD_Session;

/**
 * class containing method to get triagle area
 * created on August 2, 2018
 */
public class Area {
	
	/**
	 * method to get area of triangle
	 * @param three sides of triangle
	 * @return area of triangle calculated
	 */
	public double getTriangleArea(int side1, int side2, int side3) {
		double area=0;
		try {
			double s=(side1+side2+side3)/2;
			area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		}
		return area;
	}

}
