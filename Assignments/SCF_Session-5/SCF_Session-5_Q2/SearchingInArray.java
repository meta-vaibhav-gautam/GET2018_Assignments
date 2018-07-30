/*
 * class contains methods to search a particular input in an array
 */
public class SearchingInArray {

	/*
	 * method linearly finds the element in array
	 * @param arr[] array from which elements is to be found out
	 * @param searchElement, an element that is to be find
	 * @return index of the elements found
	 */
	public int linearSearch(int arr[],int searchElement)
	{
		int element=searchElement;
		int index=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==element)
			{
				index=i;
				break;
			}
			else
			{
				continue;
			}
		}
		return index;
	}
	
	/*
	 * method binary finds the element in array where array is already sorted
	 * @param arr[] array from which elements is to be found out
	 * @param start is start index of the array
	 * @param end is ending index of array;
	 * @return index of the elements found
	 */
	public int binarySearch(int arr[],int start,int end,int searchElement)
	{
		int element=searchElement;
		int startIndex=start;
		int endIndex=end;
		int midIndex=(startIndex+endIndex)/2;
		if(arr[midIndex]==element)
		{
			return midIndex;
		}
		else
		{
			if(arr[midIndex]>searchElement)
			{
				return binarySearch(arr, startIndex,midIndex-1, searchElement);
			}
			else
			{
				return binarySearch(arr, midIndex+1, endIndex, searchElement);
			}
		}
	}
}
