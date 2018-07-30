/*
 * class contains methods to split array
 * such that both have same sum of elements
 */
public class SplitArray {

    /*
     * method finds the index where array arr is to be splitted
     * such that both array elements sum is same
     * @param an integer array arr
     * @return index from where array is to be split
     * @return -1 if not possible to split the array
     */
    public int getIndexOfSplitArray(int arr[]) {
    	if(isArrayEmpty(arr))
    	{
    		throw new AssertionError("Empty array found");
    	}
    	else
    	{
	        int halfSum1 = 0; //sum of element of one half
	        int halfSum2 = 0; //sum of elements of other half
	        int index = -1; //index variable to store the index where the array is to be splitted
	        for (int i = 0; i < arr.length; i++) {
	            halfSum1 += arr[i];
	            for (int j = i + 1; j < arr.length; j++) {
	                halfSum2 += arr[j];
	            }
	
	            if (halfSum1 == halfSum2) {
	                index = i + 1;
	                break;
	            } else {
	                halfSum2 = 0;
	                continue;
	            }
	        }
	        return index;
    	}
    }
    
    /*
     * method is used to validate the array
     * @param arrSequence array
     * @return true if array is empty
     * @return false if array is not empty
     */
    public boolean isArrayEmpty(int arrSequence[])
    {
    	if(arrSequence.length==0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}