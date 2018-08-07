package circularQueue;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * class containing main method
 * created on August 3, 2018
 */
public class circularQueueMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		CircularQueue queue = null;
		System.out.println("Enter size of Queue: ");
		int maxSize=takeInput();
		queue=new CircularQueue(maxSize);
		int choice=0;
		while (choice <= 4) {
			System.out.println("\nenter your choice:\n1. Add Element \n2. Delete Element\n3. Exit");
			choice = takeInput();

			switch (choice) {
			
				case 1:
					System.out.println("Enter element: ");
					int element=takeInput();
					queue.addElementToQueue(element);
					queue.displayQueueElements();
					break;
					
				case 2:
					queue.deleteElementFromQueue();
					queue.displayQueueElements();
					break;
					
				case 3:
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
