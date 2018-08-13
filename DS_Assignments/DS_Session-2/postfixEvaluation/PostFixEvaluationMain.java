package postfixEvaluation;

import java.util.Scanner;

public class PostFixEvaluationMain {
	
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Enter the postfix expression: ");
		String postFixExpression = scanner.nextLine();
		
		System.out.println("Result : "+new Postfix().getExpressionEvaluated(postFixExpression));
	}
	
}
