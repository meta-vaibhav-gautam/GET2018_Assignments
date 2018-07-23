import static org.junit.Assert.*;

import org.junit.Test;


public class LCMTest {

	@Test
	public void testPass() {
		int x=2;
		int y=6;
		LCM obj=new LCM();
		int result=obj.findLCM(x, y);
		
		assertEquals(6, result);
	}
	
	@Test
	public void testFail() {
		int x=2;
		int y=6;
		LCM obj=new LCM();
		int result=obj.findLCM(x, y);
		
		assertEquals(10, result);
	}

}
