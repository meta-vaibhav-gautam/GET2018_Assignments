package postfixEvaluation;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * class containing junit test methods
 * created on August 3, 2018
 */
public class PostFixEvaluationTest {

	Postfix postfix=new Postfix();
	/*
	 * method to test getExpression Evaluated success scenario
	 */
	@Test
	public void testGetExpressionEvaluated_Success() {
		String expression= "23 5 * 1 +";
		double expected= 116.0;
		
		double result= postfix.getExpressionEvaluated(expression);
		
		assertEquals(expected , result, 0);
	}
	
	/*
	 * method to test getExpression Evaluated failure scenario
	 */
	@Test
	public void testGetExpressionEvaluated_failure() {
		String expression= "2 + 3 5 * 1 ";
		double expected= 116.0;
		
		double result= postfix.getExpressionEvaluated(expression);
		
		assertNotEquals(expected , result, 0);
	}

}
