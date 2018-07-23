/*
 *class contains methods to fix the posistion of x and y elements
 *x and y are the digits entered by user
 */
public class FixXY {

	/*
	 * method fixes the position of y adjacent to x
	 * @param arr an integer array containing elements
	 * @param x integer whose position is to be kept fixed
	 * @param y integer whose position is to be changed adjacent to x
	 * @return an integer array with desired position
	 * of X and Y*/
	public int[] fixXYPosition(int arr[],int x,int y)
	{
		int i;
		int testPrev=0;
		int returnArray[]=arr; //5 4 9 4 9 5
		for(i=0;i<returnArray.length;i++)
		{
			if(returnArray[i]==x)
			{
				if(returnArray[i+1]==y)
				{
					continue;
				}
				else
				{
					int index=i+1;
					for(int j=0;j<returnArray.length;j++)
					{
						if(j>0)
						{
							testPrev=j-1;
						}
						
						if(returnArray[j]==y && (returnArray[testPrev]!=x))
						{
							int temp=returnArray[index]; //temporary variable to store value to be swapped
							returnArray[index]=returnArray[j];
							returnArray[j]=temp;
						}
						else
						{
							continue;
						}
					}
				}
			}
			else
			{
				continue;
			}
		}
		return returnArray;
	}
	
}
