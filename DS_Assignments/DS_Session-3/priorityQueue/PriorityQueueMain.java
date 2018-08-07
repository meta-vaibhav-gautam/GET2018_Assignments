package priorityQueue;

import java.util.Scanner;

/*
 * class containing main method
 * created on August 07, 2018
 */
public class PriorityQueueMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size for the queue:");
		int queueSize = scanner.nextInt();
		PriorityQueueImplementation<Integer> priorityQueue = new PriorityQueueImplementation<Integer>(queueSize);
		int choice = 0;
		while (choice <= 3) {
			System.out.println("\nenter your choice: 1.Add Element  2.Delete Element  3.Get Highest Priority Of the Queue  4.Exit");
			choice = scanner.nextInt();

			switch (choice) {
			
				case 1:
					System.out.println("Enter attribute of element:\nEnter the value: ");
					int value=scanner.nextInt();
					System.out.println("Enter the priority of the element:");
					int priority = scanner.nextInt();
					priorityQueue.addElement(new Queue(value,priority));
					break;
					
				case 2:
					priorityQueue.deleteElement();
					break;
					
				case 3:
					System.out.println("Highest Priority in queue: "+priorityQueue.getHighestPriority());
					break;
					
				case 4:
					System.exit(0);
					
				default:
					System.out.println("Invalid choice !");
					break;
				}
		}
	}
}
