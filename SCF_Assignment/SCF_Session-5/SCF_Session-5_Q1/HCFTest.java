import static org.junit.Assert.*;

import org.junit.Test;

/*
 * class containing test cases and 
 * methods to test the program
 */
public class HCFTest {

	@Test
	public void testPass() {
		int x=2;
		int y=6;
		HCF obj=new HCF();
		int result=obj.findHCF(x, y);
		
		assertEquals(2, result);
	}
	
	@Test
	public void testFail() {
		int x=2;
		int y=6;
		HCF obj=new HCF();
		int result=obj.findHCF(x, y);
		
		assertNotEquals(10, result);
	}
}
