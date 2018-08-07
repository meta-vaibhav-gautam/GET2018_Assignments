package jsonImplementation;

import java.util.List;
import java.util.Scanner;

import linkedList.LinkedList;

/*
 * class containing main method
 */
public class NestedListJsonMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		String filePath = "C:\\Users\\User24\\workspace\\DS_Session-2#Part-2\\src\\jsonImplementation\\InputFile.json";
		int choice = 0;
		NestedListJsonImplementation nestedList = new NestedListJsonImplementation(filePath);
		
		while(choice != 4) {
			System.out.println("\nEnter your choice:\n1. Get Sum Of All Integers\n2. Get Largest Value From The List\n3. Search For An Element\n4. Exit");
			choice = scanner.nextInt();
			 switch (choice) {
				 case 1:
					 System.out.println("total = "+nestedList.getSumOfAllIntegers(nestedList.getNestedList()));
					 break;
				
				 case 2:
					 System.out.println("Largest value: "+nestedList.getLargestValueFromNestedList(nestedList.getNestedList()));
					 break;
					
				 case 3:
					 System.out.println("Enter the element to be searched :");
					 long element = scanner.nextInt();
					 System.out.println("Element present in the list: "+nestedList.searchValue(element ,nestedList.getNestedList()));
					 
				 case 4:
					 System.exit(0);
					 
				default:
					System.out.println("Invalid Choice !");
					break;
			 }
		}
	
	}
}
