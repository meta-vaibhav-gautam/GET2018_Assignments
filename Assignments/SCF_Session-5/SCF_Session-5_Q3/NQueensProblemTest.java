import static org.junit.Assert.*;

import org.junit.Test;


public class NQueensProblemTest {

	@Test
	public void testPass() {
		int n =  4;
        NQueensProblem obj=new NQueensProblem();
        boolean result=obj.solveNQ(n);
        
        assertEquals(true, result);
	}
	
	@Test
	public void testFail() {
		int n =  4;
        NQueensProblem obj=new NQueensProblem();
        boolean result=obj.solveNQ(n);
        
        assertEquals(false, result);
	}

}
