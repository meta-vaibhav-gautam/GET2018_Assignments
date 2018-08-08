package uniqueCharacters;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class containing main method
 * created on August 08, 2018
 */
public class UniqueCharacterMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		UniqueCharacter object = new UniqueCharacter();
		String inputString = "";
		try {
			while(! inputString.equals("exit")) {
				System.out.print("\nEnter the string (Enter exit to exit from program): ");
				inputString = scanner.nextLine();
				System.out.println("\nTotal Unique Characters in the \""+inputString+"\" :"+object.countUniqueCharacter(inputString));
			}
		} catch (InputMismatchException e) {
			System.out.println("Some Invalid Input !");
		}
	}
}
