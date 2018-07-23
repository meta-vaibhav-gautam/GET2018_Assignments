import static org.junit.Assert.*;

import org.junit.Test;


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
		
		assertEquals(10, result);
	}
}
