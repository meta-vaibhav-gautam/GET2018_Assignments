package employeeCollection;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class containing main method
 * created on August 08, 2018
 */
public class EmployeeCollectionMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeCollection object = new EmployeeCollection();
		int choice = 0;
		try {
			while (choice <= 4) {
				System.out.println("Enter your choice :\n1. Add Employee\n2. Sort Employee In Natural Order"
						+ "\n3. Sort Employee On Basis Of Names(Ascending Order)\n4. Exit");
				choice = scanner.nextInt();
				switch (choice) {
					case 1:
						System.out.println("Enter employee details: ");
						System.out.print("\nEmployee ID (in integers): ");
						int employeeId = scanner.nextInt();
						System.out.print("\nName: ");
						scanner.nextLine();
						String employeeName = scanner.nextLine();
						System.out.print("\nAddress: ");
						String employeeAddress = scanner.nextLine();
						System.out.println();
						Employee employee = new Employee(employeeId, employeeName, employeeAddress);
						object.addEmployeeToCollection(employee);
						break;
						
					case 2:
						object.sortEmployeeListNaturalOrder();
						for(Employee value : object.getEmployeeList()) {
							object.printEmployeeDetails(value);
						}
						break;
						
					case 3:
						object.sortEmployeeListBasedOnName();
						for(Employee value : object.getEmployeeList()) {
							object.printEmployeeDetails(value);
						}
						break;
						
					case 4:
						System.out.println("\nExiting system.....");
						System.exit(0);
						break;
						
					default:
						System.out.println("Invalid choice !");
						break;
				}
				
			} 
		}catch (InputMismatchException e) {
			choice=0;
			System.out.println("Invalid input given !");
		} catch (Exception e) {
			choice=0;
			System.out.println("Some error occured !");
		}
		
	}

}
