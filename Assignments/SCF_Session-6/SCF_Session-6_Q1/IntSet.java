import java.util.Arrays;
import java.util.Scanner;

/*
 * class containing methods for set operations
 * created on july 24,2018
 */
public final class IntSet implements IntSetInterface {
    private int set[]; // set array representing a set

    /*
     * method initializes the set
     * @param set[] as input set
     */
    public void initialiseSet(int set[]) {
        this.set = set;
    }

    /*
     * method returns the set initialzed
     */
    public int[] getSet() {
        return set;
    }

    /*
     * method is used to find if the element is present in set or not
     * @param x as integer value representing value to be found out
     * @return true if value found otherwise false
     */
    @Override
    public boolean isMember(int x) {
        for (int setValues: set) {
            if (setValues == x) {
                return true;
            }
        }
        return false;
    }

    /*
     * method is used to find size of the set
     * @return length of the set
     */
    @Override
    public int size() {
        return set.length;
    }

    /*
     * method is used to find if the set given is subset or not
     * @param IntSet object having set as its member
     * @return true if it is subset otherwise false
     */
    @Override
    public boolean isSubset(IntSet obj) {
        int subset[] = obj.set;
        int superSet[] = this.set;
        int subsetLength = subset.length;
        for (int i = 0; i < superSet.length; i++) {
            int tempSet[] = Arrays.copyOfRange(superSet, i, i + subsetLength);
            if (Arrays.equals(subset, tempSet)) {
                return true;
            }
        }
        return false;
    }

    /*
     * method is used to calculate compliment set of the universal and set provided
     * @param IntSet object as set contained in it
     * @return compliment array
     */
    @Override
    public int[] getCompliment(IntSet set) {
        int complimentArray[] = new int[1000 - (set.set.length)];
        int index = 0;
        for (int i = 0; i < 1000; i++) {
            if (!(set.isMember(i))) {
                complimentArray[index++] = i;
            }
        }
        return complimentArray;
    }

    /*
     * method is used to get union of two sets
     * @param IntSet Object s1
     * @param IntSet Object s2
     * @return union set array
     */
    @Override
    public int[] union(IntSet s1, IntSet s2) {
        s1.takeInput();
        s2.takeInput();
        int set1[] = s1.set;
        int set2[] = s2.set;
        int commonElementsCount = 0;
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if (set1[i] == set2[j]) {
                    commonElementsCount++;
                }
            }
        }
        int lengthOfUnion = (set1.length + set2.length) - commonElementsCount;
        int unionSet[] = new int[lengthOfUnion];
        int index = 0;
        for (int i = 0; i < 1000; i++) {
            if (s1.isMember(i) || s2.isMember(i)) {
                unionSet[index++] = i;
            }
        }

        return unionSet;
    }

    /*
     * method is used to take inputs by validating set properties
     */
    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        int element = 0;
        System.out.println("Enter no. of elements: ");
        int n = sc.nextInt();
        set = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            element = sc.nextInt();
            if (i > 0) {
                while (isMember(element)) {
                    System.out.println("element is alreay present, enter different element: ");
                    element = sc.nextInt();
                }
            }
            this.set[i] = element;
        }
    }
}