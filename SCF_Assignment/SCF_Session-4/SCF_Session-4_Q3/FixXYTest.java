import static org.junit.Assert.*;

import org.junit.Test;

/*
 * jUnit test class
 */
public class FixXYTest {

	@Test
	public void testPass() {
		int elementsArray[]={5,4,9,4,9,5};
		FixXY obj=new FixXY();
		int result[]=obj.fixXYPosition(elementsArray,4,5);
		int expectedOutput[]={9,4,5,4,5,9};
		
		assertArrayEquals(result,expectedOutput);
		
	}
	
	@Test
	public void testFail() {
		int elementsArray[]={5,4,9,4,9,5};
		FixXY obj=new FixXY();
		int result[]=obj.fixXYPosition(elementsArray,4,5);
		int expectedOutput[]={9,4,5,4,9,5};
		
		assertArrayEquals(result,expectedOutput);
		
	}

}
