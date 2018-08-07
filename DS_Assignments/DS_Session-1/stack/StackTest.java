package stack;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * junit test class containing test methods
 * created on August 2, 2018
 */
public class StackTest {
	
	Stack stackUsingArray=new StackUsingArray(5);
	Stack stackUsingLinkedList=new StackUsingLinkedList();

	/*
	 * method to test pushElement method success scenario
	 */
	@Test
	public void testPushElement_Success() {
		
		int element=2;
		int result1=stackUsingArray.pushElement(element);
		int result2=stackUsingLinkedList.pushElement(element);
		
		boolean flag=(result1==1 && result2==1);
		
		assertEquals(true,flag);
		
	}
	
	/*
	 * method to test pushElement method failure scenario
	 */
	@Test
	public void testPushElement_Failure() {
		
		int element=3;
		int result1=stackUsingArray.pushElement(element);
		int result2=stackUsingLinkedList.pushElement(element);
		
		boolean flag=(result1==1 && result2==1);
		
		assertNotEquals(false,flag);
		
	}
	
	/*
	 * method to test popElement method success scenario
	 */
	@Test
	public void testPopElement_Success() {
		stackUsingArray.pushElement(2);
		stackUsingArray.pushElement(3);
		stackUsingLinkedList.pushElement(4);
		stackUsingLinkedList.pushElement(5);

		int result1=stackUsingArray.popElement();
		int result2=stackUsingLinkedList.popElement();
		
		boolean flag=(result1==1 && result2==1);
		
		assertEquals(true,flag);
		
	}
	
	/*
	 * method to test popElement method Failure scenario
	 */
	@Test
	public void testPopElement_Failure() {
		stackUsingArray.pushElement(2);
		stackUsingArray.pushElement(3);
		stackUsingLinkedList.pushElement(4);
		stackUsingLinkedList.pushElement(5);

		int result1=stackUsingArray.popElement();
		int result2=stackUsingLinkedList.popElement();
		
		boolean flag=(result1==1 && result2==1);
		
		assertNotEquals(false,flag);
		
	}
	
	/*
	 * method to test topElement method success scenario
	 */
	@Test
	public void testTopElement_Success() {
		stackUsingArray.pushElement(2);
		stackUsingArray.pushElement(3);
		stackUsingLinkedList.pushElement(4);
		stackUsingLinkedList.pushElement(5);

		int result1=stackUsingArray.topElement();
		int result2=stackUsingLinkedList.topElement();
		
		boolean flag=(result1==3 && result2==5);
		
		assertEquals(true,flag);
		
	}
	
	/*
	 * method to test topElement method Failure scenario
	 */
	@Test
	public void testTopElement_Failure() {
		stackUsingArray.pushElement(2);
		stackUsingArray.pushElement(3);
		stackUsingLinkedList.pushElement(4);
		stackUsingLinkedList.pushElement(5);

		int result1=stackUsingArray.topElement();
		int result2=stackUsingLinkedList.topElement();
		
		boolean flag=(result1==3 && result2==5);
		
		assertNotEquals(false,flag);
		
	}

}
