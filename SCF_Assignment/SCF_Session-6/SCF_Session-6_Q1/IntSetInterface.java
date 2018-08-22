/*
 * interface containing all the methods of set operations
 */
public interface IntSetInterface {

	boolean isMember(int x);
	int size();
	boolean isSubset(IntSet obj);
	int[] getCompliment(IntSet s);
	int[] union(IntSet s1,IntSet s2);
}
