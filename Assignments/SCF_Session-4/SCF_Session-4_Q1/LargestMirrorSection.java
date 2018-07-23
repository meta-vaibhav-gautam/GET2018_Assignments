
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
        int reverseArray[] = new int[arrSequence.length]; //reverse array of the input array
        int length = arrSequence.length;
        int arr[][] = new int[length + 1][length + 1]; //2-D array used for comparing arrays
        int index = 0;
        for (int i = arrSequence.length - 1; i >= 0; i--) {
            reverseArray[index] = arrSequence[i];
            index++;
        }
        for (int i = 0; i < arrSequence.length; i++) {
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
        return size;
    }
}