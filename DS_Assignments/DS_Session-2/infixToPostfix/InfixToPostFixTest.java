package infixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * class containing junit test methods
 * created on August 3, 2018
 */
public class InfixToPostFixTest {

	/*
	 * method to test convert Infix to postfix expression success scenario
	 */
	@Test
	public void testConvertInfixToPostfix_Success() {
		InfixToPostfixConversion obj=new InfixToPostfixConversion();
		String infixExpression = "a + b * ( c ^ d - e ) ^ ( f + g * h ) - i" ;
		String postfixExpression = "a b c d ^ e - f g h * + ^ * + i - " ;
		String result = obj.convertInfixToPostfix(infixExpression);
		
		assertEquals(postfixExpression,result);
		
	}
	
	/*
	 * method to test convert Infix to postfix expression failure scenario
	 */
	@Test
	public void testConvertInfixToPostfix_Failure() {
		InfixToPostfixConversion obj=new InfixToPostfixConversion();
		String infixExpression = "a + b * ( c ^ d - e ) ^ ( f + g * h ) - i" ;
		String postfixExpression = "a b c d e ^ - f g h * + ^ * + i -" ;
		String result = obj.convertInfixToPostfix(infixExpression);
		
		assertNotEquals(postfixExpression,result);
		
	}

}
