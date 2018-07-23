import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Junit test class
 */
public class SplitArrayTest {

	@Test
	public void testPass() {
		int elementsArray[]={1,1,1,2,1};
		SplitArray obj=new SplitArray();
		int result=obj.getIndexOfSplitArray(elementsArray);
		
		assertEquals(3,result);
	}
	
	@Test
	public void testFail() {
		int elementsArray[]={1,1,1,2,1};
		SplitArray obj=new SplitArray();
		int result=obj.getIndexOfSplitArray(elementsArray);
		
		assertEquals(2,result);
	}

}
