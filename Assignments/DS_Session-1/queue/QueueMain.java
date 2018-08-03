package queue;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * main class containing main method
 * created on August 2, 2018
 */
public class QueueMain {

	public static void main(String args[]) {

		Queue queue = null;
		
		System.out.println("Enter choice:\n1. Queue using array\n2. Queue using linked list");
		int choice = takeInput();
		
		switch(choice) {
		
			case 1:
				System.out.println("Enter size of Queue: ");
				int maxSize=takeInput();
				queue=new QueueUsingArray(maxSize);
				break;
			
			case 2:
				queue=new QueueUsingLinkedList();
				break;
				
			default:
				System.out.println("Program terminated !");
				System.exit(0);
				
		}
		
		while (choice <= 4) {
			System.out.println("\nenter your choice: 1.add element  2.delete element  3.is queue full  4.is queue empty  5.exit");
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
					System.out.println("is Queue Full: "+queue.isQueueFull());
					break;
					
				case 4:
					System.out.println("is Queue empty: "+queue.isQueueEmpty());
					break;
					
				case 5:
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
