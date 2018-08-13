package Q_7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * class containing main method
 */
public class NestedListMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		List<Object> nestedList = new LinkedList<Object>();
		List<Object> innerList = null;
		int choice = 0;
		while (choice<=2) {
			System.out.println("Enter type of element you want to add: \n1. List Of Integers\n2. Integer Value\n(Press 3 to exit !)");
			choice = scanner.nextInt();
			switch (choice) {
				case 1:
					innerList = new LinkedList<Object>();
					System.out.println("Enter the number of elements in this list:");
					int numberOfElements = scanner.nextInt();
					System.out.println("Enter the elements:");
					for(int i=0;i<numberOfElements;i++) {
						innerList.add(scanner.nextInt());
					}
					nestedList.add(innerList);
					break;
					
				case 2:
					System.out.println("Enter the number of elements:");
					numberOfElements = scanner.nextInt();
					System.out.println("Enter the elements:");
					for(int i=0;i<numberOfElements;i++) {
						nestedList.add(scanner.nextInt());
					}
					break;
					
				default:
					break;
			}
		}
		NestedList obj = new NestedList(nestedList);
		System.out.println(obj.getValue("TH"));
	}
}
