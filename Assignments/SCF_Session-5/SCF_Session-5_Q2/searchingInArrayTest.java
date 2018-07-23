import static org.junit.Assert.*;

import org.junit.Test;


public class searchingInArrayTest {

	@Test
	public void testPass() {
		int arr[]={2,5,7,8,10,12};
		SearchingInArray obj=new SearchingInArray();
		int resultLinearSearch=obj.linearSearch(arr,8);
		int resultBinarySearch=obj.binarySearch(arr, 0, arr.length, 8);
		
		assertEquals(3, resultLinearSearch);
	}

	@Test
	public void testFail() {
		int arr[]={2,5,7,8,10,12};
		SearchingInArray obj=new SearchingInArray();
		int resultLinearSearch=obj.linearSearch(arr,8);
		int resultBinarySearch=obj.binarySearch(arr, 0, arr.length, 8);
		
		assertEquals(4, resultLinearSearch);
	}

}
