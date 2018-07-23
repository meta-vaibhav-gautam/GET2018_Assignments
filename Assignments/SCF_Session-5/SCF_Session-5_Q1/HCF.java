/*
 * HSF class consist of method to find LCM of two positive integer
 */
public class HCF {

	/*
	 * findLCM method finds the HCF of two integers using recursion
	 * @param x as first integer
	 * @param y as second integer
	 * @return HCF computed
	 */
	public int findHCF(int x, int y)
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
				return findHCF(x-y, y);
			}
			else
			{
				return findHCF(x, y-x);
			}
		}
	}
}
