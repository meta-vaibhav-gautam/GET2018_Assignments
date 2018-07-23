import static org.junit.Assert.*;

import org.junit.Test;

/*
 * class containing test cases and 
 * methods to test the program
 */
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
        
        assertNotEquals(false, result);
	}

}
