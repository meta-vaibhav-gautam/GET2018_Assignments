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
		if(! isArraySafe(arr,x,y))
		{
			throw new AssertionError("some error present");
		}
		else
		{
			int returnArray[]=arr; 
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
	
	/*
     * method is used to validate the array
     * @param arr as input array
     * @param x as integer
     * @param y as integer
     * @return true if array is valid
     * @return false if array is not valid
     */
	public boolean isArraySafe(int arr[],int x,int y)
	{
		int xCount=0;
		int yCount=0;
		if(arr.length==0)
		{
			return false;
		}
		
		if(arr[arr.length-1]==x)
		{
			return false;
		}
		else
		{
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]==x && arr[i+1]==x)
					return false;
				
				if(arr[i]==x)
					xCount++;
				if(arr[i]==y)
					yCount++;
			}
			if(xCount!=yCount)
			{
				return false;
			}
		}
		return true;
	}
}
