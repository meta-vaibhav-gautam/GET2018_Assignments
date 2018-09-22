/*
 * LCM class consist of method to find LCM of two positive integer
 */
public class LCM {

	/*
	 * findLCM method finds the LCM of two integers using recursion
	 * @param x as first integer
	 * @param y as second integer
	 * @return lcm computed
	 */
	public int findLCM(int x, int y)
	{
		int lcm=(x*y)/findGCD(x, y);
		return lcm;
	}
	
	/*
	 * findGCD method finds Greatest Common Divisor (GCD) of two numbers
	 * @param x as first integer
	 * @param y as second integer
	 * @return gcd calculated
	 */
	private int findGCD(int x,int y)
	{
		if(x==0 || y==0)
		{
			return 0;
		}
		else if(x==y)
		{
			return x;
		}
		else
		{
			if(x>y)
			{
				return findGCD(x-y, y);
			}
			else
			{
				return findGCD(x, y-x);
			}
		}
	}
}
