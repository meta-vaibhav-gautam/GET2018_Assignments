package DictionaryImplementation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * class containing main method
 * created on August 09, 2018
 */
public class DictionaryMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		DictionaryImplementation object = new DictionaryImplementation("D:\\eclipse\\Metacube\\DS_Session-5\\src\\DictionaryImplementation\\inputData.json");
		try {
			int choice = 0;
			while (choice <= 6) {
				System.out.println("\nEnter your choice :\n1. Add Key Value Pair to Dictionary\n2. Delete a key value pair"
						+ "\n3. Get Value Of Specified Key\n4. Get Sorted List Of Key Value Pair\n5. Get Sorted List In Specified Range"
						+ "\n6. Exit");
				choice = scanner.nextInt();
				switch (choice) {
					case 1:
						System.out.print("\nKey : ");
						String keyToBeAdded = scanner.next();
						System.out.print("\nValue : ");
						scanner.nextLine();
						String valueToBeAdded = scanner.nextLine();
						System.out.println();
						object.addKeyValuePairToDictionary(keyToBeAdded, valueToBeAdded);
						object.printTree(object.getRoot());
						break;
						
					case 2:
						System.out.println("Enter key to be Deleted: ");
						String keyToBeDeleted = scanner.next();
						object.deleteKeyValuePairFromDictionary(keyToBeDeleted,object.getRoot());
						object.printTree(object.getRoot());
						break;
						
					case 3:
						System.out.println("Enter key : ");
						String key = scanner.next();
						String value = object.getValue(key,object.getRoot());
						if(value==null) {
							System.out.println("No such word present ! You can add this by pressing 1.");
						} else {
							System.out.println("Value---> "+value);
						}
						break;
						
					case 4:
						List<Pair> listOfKeys = object.getSortedListOfKeys();
						for(Pair val : listOfKeys) {
							object.printListOfValuesInBST(val);
						}
						break;
						
					case 5:
						System.out.println("Enter K1: ");
						String k1 = scanner.next();
						System.out.println("Enter K2: ");
						String k2 = scanner.next();
						List<Pair> list = object.getSortedListOfKeysInRange(k1, k2);
						for(Pair val : list) {
							object.printListOfValuesInBST(val);
						}
						break;
					case 6:
						System.out.println("\nExiting system.....");
						System.exit(0);
						break;
						
					default:
						System.out.println("Invalid choice !");
						break;
				}
				
			} 
		}catch (InputMismatchException e) {
			System.out.println("Invalid input given !");
		} catch (Exception e) {
			System.out.println("Some error occured !");
		}	
	}
	
}
