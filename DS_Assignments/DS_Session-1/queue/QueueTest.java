package queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/*
 * junit test classes to test methods of Queue
 * created on August 2, 2018
 */
public class QueueTest {
	
	Queue queueUsingArray = new QueueUsingArray(5);
	Queue queueUsingLinkedList = new QueueUsingLinkedList();
	
	/*
	 * method to test addElement method success scenario
	 */
	@Test
	public void testAddElement_Success() {
		
		int element=2;
		int result1=queueUsingArray.addElementToQueue(element);
		int result2=queueUsingLinkedList.addElementToQueue(element);
		
		boolean flag=(result1==1 && result2==1);
		
		assertEquals(true,flag);
		
	}
	
	/*
	 * method to test addElement method Failure scenario
	 */
	@Test
	public void testAddElement_Failure() {
		
		int element=2;
		int result1=queueUsingArray.addElementToQueue(element);
		int result2=queueUsingLinkedList.addElementToQueue(element);
		
		boolean flag=(result1==1 && result2==1);
		
		assertNotEquals(false,flag);		
	}
	
	/*
	 * method to test deletElementFromQueue method Success scenario
	 */
	@Test
	public void testDeleteElementFromQueue_Success() {
		queueUsingArray.addElementToQueue(1);
		queueUsingArray.addElementToQueue(2);
		
		queueUsingLinkedList.addElementToQueue(6);
		queueUsingLinkedList.addElementToQueue(5);
		
		int result1=queueUsingArray.deleteElementFromQueue();
		int result2=queueUsingLinkedList.deleteElementFromQueue();
		
		boolean flag=(result1==1 && result2==1);
		
		assertEquals(true,flag);		
	}
	
	/*
	 * method to test deletElementFromQueue method Failure scenario
	 */
	@Test
	public void testDeleteElementFromQueue_Failure() {
		queueUsingArray.addElementToQueue(1);
		queueUsingArray.addElementToQueue(2);
		
		queueUsingLinkedList.addElementToQueue(6);
		queueUsingLinkedList.addElementToQueue(5);
		
		int result1=queueUsingArray.deleteElementFromQueue();
		int result2=queueUsingLinkedList.deleteElementFromQueue();
		
		boolean flag=(result1==1 && result2==1);
		
		assertNotEquals(false,flag);		
	}
	
	/*
	 * method to test isQueueFull method Success scenario
	 */
	@Test
	public void testIsQueueFull_Success() {
		queueUsingArray.addElementToQueue(1);
		queueUsingArray.addElementToQueue(2);
		
		queueUsingLinkedList.addElementToQueue(6);
		queueUsingLinkedList.addElementToQueue(5);
		
		boolean flag1=queueUsingArray.isQueueFull();
		boolean flag2=queueUsingLinkedList.isQueueFull();
		
		assertEquals(false,(flag1 && flag2));		
	}
	
	/*
	 * method to test isQueueFull method Failure scenario
	 */
	@Test
	public void testIsQueueFull_Failure() {
		queueUsingArray.addElementToQueue(1);
		queueUsingArray.addElementToQueue(2);
		
		queueUsingLinkedList.addElementToQueue(6);
		queueUsingLinkedList.addElementToQueue(5);
		
		boolean flag1=queueUsingArray.isQueueFull();
		boolean flag2=queueUsingLinkedList.isQueueFull();
		
		assertNotEquals(true,(flag1 && flag2));		
	}
	
}
