package postfixEvaluation;

import java.util.StringTokenizer;

/*
 * class containing method to evaluate postfix expression
 * created on August 2, 2018
 */
public class Postfix {

	private double stackForOperands[]; //stack to store operands value
	private int top = -1;
	private double result = 0;

	/*
	 * method evaluates the postfix expression
	 * @param postFixExpression as string
	 * @return result as double value
	 */
	public double getExpressionEvaluated(String postFixExpression) {

		stackForOperands = new double[postFixExpression.length()];
		if(!(isOperator(postFixExpression.charAt(postFixExpression.length()-1)))) {
			System.out.println("Invalid input postfix expression !");
			return result;
		}
		StringTokenizer tokens = new StringTokenizer(postFixExpression);
		while(tokens.hasMoreTokens()) {
			try {
			String elementTraversed=tokens.nextToken();
			if(isValidToken(elementTraversed)) {
				
				if (isOperator(elementTraversed.charAt(0))) {
						operate(elementTraversed.charAt(0));
							
					} else {

						push(Double.parseDouble(elementTraversed));

					}
				}
			  }
				catch (Exception e) {
					System.out.println("Invalid Input postfix expression !");
					break;
			} 
		}
		
		
		return result;
	}

	/*
	 * method to push element to stack
	 * @param operand as double value
	 */
	private void push(double operand) {
		stackForOperands[++top] = operand;
	}

	/*
	 * method to pop element from stack
	 * @return operand as double
	 */
	private double pop() {
		double operand = stackForOperands[top];
		top--;
		return operand;
	}

	/*
	 * operator method for operating according to operator obtained
	 * @param operator
	 */
	private void operate(char operator) {
		double firstNumber = 0, secondNumber = 0;
		firstNumber = pop();
		secondNumber = pop();
		solve(firstNumber, secondNumber, operator);
	}

	/*
	 * method to solve the expression
	 */
	private void solve(double firstNumber, double secondNumber, char operator) {

		double a = firstNumber;
		double b = secondNumber;

		if (operator == '+') {
			result = (a + b);
			push(result);
		}
		if (operator == '-') {
			result = b - a;

			push(result);
		}
		if (operator == '*') {
			result = a * b;
			push(result);
		}
		if (operator == '/') {
			result = b / a;
			push(result);
		}
	}

	/*
	 * method to check whether the element is operator or not
	 * @param elementTraversed from postfix string
	 * @return true if element is operator otherwise return false
	 */
	private boolean isOperator(char elementTraversed) {
		if (elementTraversed == '+' || elementTraversed == '-' || elementTraversed == '*' || elementTraversed == '/') {
			return true;
		}
		return false;
	}
	
	/*
	 * method checks for number input
	 * if input is not valid it throws exception
	 */
	private boolean isValidToken(String token) throws Exception {
		if(!(isOperator(token.charAt(0)))) {
			Double.parseDouble(token);
		}
		return true;
	}
}
