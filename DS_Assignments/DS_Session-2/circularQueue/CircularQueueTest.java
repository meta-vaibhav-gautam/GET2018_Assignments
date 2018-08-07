package circularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * junit test class containing test methods
 * created on August 07, 2018
 */
public class CircularQueueTest {

	CircularQueue queue= new CircularQueue(5);
	
	/**
	 * method to test addElement method success scenario
	 * created on August 07, 2018
	 */
	@Test
	public void testAddElementToQueue_Success() {
		boolean result = queue.addElementToQueue(2);
		boolean expected = true;
		
		assertEquals(expected, result);
	}
	
	/**
	 * method to test addElement method failure scenario
	 * created on August 07, 2018
	 */
	@Test
	public void testAddElementToQueue_Failure() {
		boolean result = queue.addElementToQueue(2);
		boolean expected = false;
		
		assertNotEquals(expected, result);
	}

	/**
	 * method to test deleteElement method success scenario
	 * created on August 07, 2018
	 */
	@Test
	public void testdeleteElement_Success() {
		boolean result = queue.addElementToQueue(2);
		int value = queue.deleteElementFromQueue();
		int expected = 2;
		assertEquals(expected,value);
	}
}
