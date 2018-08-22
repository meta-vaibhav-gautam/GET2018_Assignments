import java.util.Scanner;

/*
 * class containing main method
 */
public class SplitArrayMain {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements: ");
        int elements = sc.nextInt();
        int elementsArray[] = new int[elements];
        System.out.println("Enter elements: ");
        for (int i = 0; i < elements; i++) {
            elementsArray[i] = sc.nextInt();
        }
        SplitArray obj = new SplitArray();
        System.out.println("split index: " + obj.getIndexOfSplitArray(elementsArray));
        sc.close();
    }
}