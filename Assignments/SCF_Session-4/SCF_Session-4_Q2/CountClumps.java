/*
 * class contains method to return number of clumps
 * clumps are same digits adjacent or more time to one other
 */
public class CountClumps {

    /*
     * method to find number of clumps in array
     * @param integer array containing elements
     * @return clump count
     */
    public int getNumberOfClumps(int arr[]) {
        int clumpsCount = 0;
        int i = 0;
        boolean flag = false;
        if(isArrayEmpty(arr))
        {
        	throw new AssertionError("Empty array found");
        }
        else
        {
	        int temp = 1; //A temporary variable 
	        while (i != arr.length - 1) {
	            while (arr[temp] == arr[i]) {
	                flag = true;
	                if (temp == arr.length - 1) {
	                    break;
	                } else {
	                    temp++;
	                }
	            }
	            if (flag) {
	                clumpsCount++;
	            }
	            i = temp;
	            temp++;
	            flag = false;
	        }
	        return clumpsCount;
        }
    }
    
    /*
     * method is used to validate the array
     * @param arr array
     * @return true if array is empty
     * @return false if array is not empty
     */
    public boolean isArrayEmpty(int arr[])
    {
    	if(arr.length==0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}