package infixToPostfix;

import java.util.Scanner;

public class InfixToPostFixMain {
	
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Enter the infix expression: ");
		String infixExpression = scanner.nextLine();
		
		System.out.println("postfix expression : "+new InfixToPostfixConversion().convertInfixToPostfix(infixExpression));
	}
	
}
