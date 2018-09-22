
/*
 * class containing methods to find largest
 * mirror sequence in a given array
 */
public class LargestMirrorSection {

    /*
     * method finding largest mirror sequence
     * @param an array sequence containing integer element
     * @return size of the sequence found
     */
    public int findLargestMirrorSection(int arrSequence[]) {
        int size = 0;
        if(isArrayEmpty(arrSequence))
        {
        	throw new AssertionError("Empty Array Found !");
        }
        else
        {
        	int length = arrSequence.length;
        	int reverseArray[] = new int[length]; //reverse array of the input array
	        int arr[][] = new int[length + 1][length + 1]; //2-D array used for comparing arrays
	        int index = 0;
	        for (int i = length - 1; i >= 0; i--) {
	            reverseArray[index] = arrSequence[i];
	            index++;
	        }
	        for (int i = 0; i <length; i++) {
	            for (int j = 0; j < reverseArray.length; j++) {
	                if (arrSequence[i] == reverseArray[j]) {
	                    arr[i + 1][j + 1] = arr[i][j] + 1;
	                } else {
	                    arr[i + 1][j + 1] = 0;
	                }
	            }
	        }
	
	        for (int i = 0; i < length; i++) {
	            for (int j = 0; j < length; j++) {
	                if (size < arr[i][j]) {
	                    size = arr[i][j];
	                }
	            }
	        }
        }
        return size;
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