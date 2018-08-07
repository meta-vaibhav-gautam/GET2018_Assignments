package Q_7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NestedList {
	
	List<Object> nestedList = null;
	
	public NestedList (List<Object> nestedList) {
		this.nestedList = nestedList;
	}
	
	public String getValue(String positionSpecifier, List<Object> nestedList) {
		positionSpecifier = positionSpecifier.toUpperCase();
		Object listElement = null;
		
		try {
			if(isValid(positionSpecifier)) {
				int specifierLength = positionSpecifier.length();
				for(int i=0 ; i<specifierLength ; i++) {
					char character = positionSpecifier.charAt(i);
					switch(character) {
						case 'T':
							listElement = nestedList.get(nestedList.size()-1);
							break;
						
						case 'H':
							listElement =nestedList.get(0);
							break;
						
						default:
							break;
					}
					if(!(listElement instanceof Integer))
						nestedList = (List)listElement;
				}
				if(listElement instanceof Integer) {
					return "Integer element Obtained !";
				} else {
					return "Error occured !";
				}
			} else {
				return "Invalid Specifier entered !";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception  occurred !";
		}
		
	}
	
	public static List<Object> takeInput(List<Object> inputList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter type of element you want to add: \n1. List Of Integers\n2. Integer Value\n(Press 3 to exit !)");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Enter the number of elements in this list:");
				int numberOfElements = scanner.nextInt();
				for(int j=0; j< numberOfElements ;j++){
					System.out.println("Enter the elements:");
					List<Object> innerList = new LinkedList<Object>();
					for(int i=0;i<numberOfElements;i++) {
						inputList.add(innerList);
					}
					inputList = takeInput(inputList);
				}
				break;
				
			case 2:
				for(int j=0; j<inputList.size() ;j++) {
					System.out.println("Enter the number of elements:");
					numberOfElements = scanner.nextInt();
					System.out.println("Enter the elements:");
					for(int i=0;i<numberOfElements;i++) {
						inputList.add(scanner.nextInt());
					}
				}
				
				break;
				
			default:
				break;
		}
		return inputList;
	}

	private boolean isValid(String positionSpecifier) {
		int length = positionSpecifier.length();
		for(int i=0 ; i<length ; i++) {
			if(!(positionSpecifier.charAt(i)=='T' || positionSpecifier.charAt(i)=='H')) {
				return false;
			}
		}
		return true;
	}
	
}
