package employeeCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * class containing collection implementation for employee
 * created on August 08, 2018
 */
public class EmployeeCollection {
	List<Employee> employeeList = new ArrayList<Employee>(); //list to hold employee objects
	
	/**
	 * method adds unique values of employee into collection
	 * @param employee as Employee object
	 * @return true if added successfully otherwise return false
	 */
	public boolean addEmployeeToCollection(Employee employee) {
		try {
			if(employee!=null && (!(isDuplicateEmployee(employee)))) {
				employeeList.add(employee);
				System.out.println("Employee "+employee.getEmployeeName()+" Added !");
				return true;
			} else {
				System.out.println("Employee already present with same credential !");
			}
		} catch (Exception e) {
			System.out.println("Some exception occurred while adding this employee !");
		}
		return false;
	}
	
	/**
	 * method sort the employee list in natural order
	 */
	public void sortEmployeeListNaturalOrder() {
		if(employeeList.size()==0) {
			System.out.println("No emplyee to sort !\n");
			return;
		}
		
		for(int i=0;i<employeeList.size();i++) {
			for(int j=0; j<(employeeList.size()-1)-i;j++) {
				if(employeeList.get(j).compareTo(employeeList.get(j+1)) > 0) {
					Employee tempObject1 = employeeList.get(j);
					Employee tempObject2 = employeeList.get(j+1);
					employeeList.remove(j);
					employeeList.add(j, tempObject2);
					employeeList.remove(j+1);
					employeeList.add((j+1),tempObject1);
				}
			}
		}
	}
	
	/**
	 * method sort the employee list on the basis of employee name
	 */
	public void sortEmployeeListBasedOnName() {
		if(employeeList.size()==0) {
			System.out.println("No emplyee to sort !\n");
			return;
		}
		for(int i=0;i<employeeList.size();i++) {
			for(int j=0; j<(employeeList.size()-1)-i;j++) {
				if(employeeList.get(j).getEmployeeName().compareTo(employeeList.get(j+1).getEmployeeName()) > 0) {
					Employee tempObject1 = employeeList.get(j);
					Employee tempObject2 = employeeList.get(j+1);
					employeeList.remove(j);
					employeeList.add(j, tempObject2);
					employeeList.remove(j+1);
					employeeList.add((j+1),tempObject1);
				}
			}
		}
	}
	
	public void printEmployeeDetails(Employee employee) {
		if(employee!=null) {
			System.out.println("Employee Id: "+employee.getEmployeeId());
			System.out.println("Employee Name: "+employee.getEmployeeName());
			System.out.println("Employee Address: "+employee.getEmployeeAddress());
			System.out.println("---------------------------------------------------");
		} else {
			return;
		}
	}
	/**
	 * method checks for duplicacy of the employee object in collection
	 * @param employee object
	 * @return true if duplicate otherwise return false
	 */
	private boolean isDuplicateEmployee(Employee employee) {
		for(Employee value : employeeList) {
			if(value.getEmployeeId() == employee.getEmployeeId())
				return true;
		}
		return false;
	}

	//method return employeeList
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	
}
