package stack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StackMain {

	public static void main(String args[]) {

		Stack stack = null;
		
		System.out.println("Enter choice:\n1. Stack using array\n2. Stack using linked list");
		int choice = takeInput();
		
		switch(choice) {
		
			case 1:
				System.out.println("Enter size of stack: ");
				int maxSize=takeInput();
				stack=new StackUsingArray(maxSize);
				
				break;
			
			case 2:
				stack=new StackUsingLinkedList();
				break;
				
			default:
				System.out.println("Program terminated !");
				System.exit(0);
		}
		
		while (choice < 4) {
			System.out.println("enter your choice: 1.Push  2.Pop  3.top  4.exit");
			choice = takeInput();

			switch (choice) {
			
				case 1:
					System.out.println("Enter element: ");
					int element=takeInput();
					stack.pushElement(element);
					stack.printStack();
					break;
					
				case 2:
					stack.popElement();
					stack.printStack();
					break;
					
				case 3:
					System.out.println(stack.topElement());
					break;
					
				case 4:
					System.exit(0);
					
				default:
					System.out.println("Program terminated !");
					System.exit(0);
				}
		}
	}
	
	//method to validate user input
		private static int takeInput() {
			
			Scanner sc = new Scanner(System.in);
			int input=0;
			try {
				input=sc.nextInt();
			} catch(InputMismatchException e) {
				input=0;
				System.out.println("Invalid Input !");
			}
			return input;
			
		}

}
