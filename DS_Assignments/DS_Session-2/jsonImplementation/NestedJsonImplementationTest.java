package jsonImplementation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * junit test classes containing test methods
 */
public class NestedJsonImplementationTest {

	/**
	 * method to test getSumOfAllIntegers success scenario
	 */
	@Test
	public void testGetSumOfAllIntegers_Success() {
		NestedListJsonImplementation object = new NestedListJsonImplementation("C:\\Users\\User24\\workspace\\DS_Session-2#Part-2\\src\\jsonImplementation\\InputFile.json");
		long sum = object.getSumOfAllIntegers(object.getNestedList());
		long expected = 26;
		
		assertEquals(expected, sum);
	}
	
	/**
	 * method to test getSumOfAllIntegers failure scenario
	 */
	@Test
	public void testGetSumOfAllIntegers_Failure() {
		NestedListJsonImplementation object = new NestedListJsonImplementation("C:\\Users\\User24\\workspace\\DS_Session-2#Part-2\\src\\jsonImplementation\\InputFile.json");
		long sum = object.getSumOfAllIntegers(object.getNestedList());
		long expected = 30;
		
		assertNotEquals(expected, sum);
	}
	
	/**
	 * method to test getLargestValue success scenario
	 */
	@Test
	public void testGetLargestValue_Success() {
		NestedListJsonImplementation object = new NestedListJsonImplementation("C:\\Users\\User24\\workspace\\DS_Session-2#Part-2\\src\\jsonImplementation\\InputFile.json");
		long value = object.getLargestValueFromNestedList(object.getNestedList());
		long expected = 9;
		
		assertEquals(expected, value);
	}

	
	/**
	 * method to test getLargestValue failure scenario
	 */
	@Test
	public void testGetLargestValue_Failure() {
		NestedListJsonImplementation object = new NestedListJsonImplementation("C:\\Users\\User24\\workspace\\DS_Session-2#Part-2\\src\\jsonImplementation\\InputFile.json");
		long value = object.getLargestValueFromNestedList(object.getNestedList());
		long expected = 8;
		
		assertNotEquals(expected, value);
	}
	
	/**
	 * method to test searchValue success scenario
	 */
	@Test
	public void testSearchValue_Success() {
		NestedListJsonImplementation object = new NestedListJsonImplementation("C:\\Users\\User24\\workspace\\DS_Session-2#Part-2\\src\\jsonImplementation\\InputFile.json");
		boolean result = object.searchValue(3, object.getNestedList());
		boolean expected = true;
		
		assertEquals(expected, result);
	}

}
