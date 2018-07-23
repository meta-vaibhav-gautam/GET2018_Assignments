import static org.junit.Assert.*;

import org.junit.Test;

/*
 * jUnit test class
 */
public class CountClumpsTest {

	@Test
	public void testPass() {
		int elementsArray[]={1,1,2,1,1};
		CountClumps obj=new CountClumps();
		int result=obj.getNumberOfClumps(elementsArray);
		
		assertEquals(2,result);
	}
	
	@Test
	public void testFail() {
		int elementsArray[]={1,1,2,1,1};
		CountClumps obj=new CountClumps();
		int result=obj.getNumberOfClumps(elementsArray);
		
		assertEquals(3,result);
	}
	
	@Test
	public void testFail1() {
		int elementsArray[]={1,1,2,1,1};
		CountClumps obj=new CountClumps();
		int result=obj.getNumberOfClumps(elementsArray);
		
		assertNotEquals(3,result);
	}
	
	@Test
	public void emptyArrayTest() {
		int elementsArray[]={};
		CountClumps obj=new CountClumps();
		int result=obj.getNumberOfClumps(elementsArray);
		
		assertEquals(3,result);
	}

}
