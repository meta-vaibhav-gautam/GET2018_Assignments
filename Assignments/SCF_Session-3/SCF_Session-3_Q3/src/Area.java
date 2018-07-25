
public class Area {
	
	/*
	 *finds the area of triangle
	 *@param width of base
	 *@param height of triangle
	 *@return area computed
	 */
	public double triangleArea(double width, double height)
	{
		return (width*height)/2;
	}
	
	/*
	 *finds the area of rectangle
	 *@param width of rectangle
	 *@param height of rectangle
	 *@return area computed
	 */
	public double rectangleArea(double width, double height)
	{
		return (width*height);
	}
	
	/*
	 *finds the area of square
	 *@param width of square
	 *@return area computed
	 */
	public double squareArea(double width)
	{
		return (width*width);
	}
	
	/*
	 *finds the area of circle
	 *@param radius of circle
	 *@return area computed
	 */
	public double cicleArea(double radius)
	{
			return (3.14*radius*radius);
	}
}
