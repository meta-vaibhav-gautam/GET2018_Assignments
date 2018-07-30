import static org.junit.Assert.*;

import org.junit.Test;


public class searchingInArrayTest {

	@Test
	public void testPassLinearSearch() {
		int arr[]={2,5,7,8,10,12};
		SearchingInArray obj=new SearchingInArray();
		int resultLinearSearch=obj.linearSearch(arr,8);
		
		assertEquals(3, resultLinearSearch);
	}

	@Test
	public void testFailLinearSearch() {
		int arr[]={2,5,7,8,10,12};
		SearchingInArray obj=new SearchingInArray();
		int resultLinearSearch=obj.linearSearch(arr,8);
		
		assertNotEquals(4, resultLinearSearch);
	}
	
	@Test
	public void testPassBinarySearch() {
		int arr[]={2,5,7,8,10,12};
		SearchingInArray obj=new SearchingInArray();
		int resultBinarySearch=obj.binarySearch(arr, 0, arr.length, 8);
		
		assertEquals(3, resultBinarySearch);
	}

	@Test
	public void testFailBinarySearch() {
		int arr[]={2,5,7,8,10,12};
		SearchingInArray obj=new SearchingInArray();
		int resultBinarySearch=obj.binarySearch(arr, 0, arr.length, 8);
		
		assertNotEquals(4, resultBinarySearch);
	}

}
