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