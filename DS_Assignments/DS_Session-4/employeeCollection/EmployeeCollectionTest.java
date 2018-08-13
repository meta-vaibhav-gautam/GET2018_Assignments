package employeeCollection;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * junit test class containing test methods
 * created on August 08, 2018
 */
public class EmployeeCollectionTest {

	EmployeeCollection object = new EmployeeCollection();
	
	/**
	 * test method to test addEmployeeToCollection success scenario
	 */
	@Test
	public void testAddEmployeeToCollection_Success() {
		Employee employee = new Employee(5,"vaibhav","abc");
		boolean result = object.addEmployeeToCollection(employee);
		
		assertEquals(true,result);
	}
	
	/**
	 * test method to test addEmployeeToCollection failure scenario
	 */
	@Test
	public void testAddEmployeeToCollection_Failure() {
		Employee employee = new Employee(5,"vaibhav","abc");
		Employee employee1 = new Employee(5,"jitu","abc");
		object.addEmployeeToCollection(employee);
		boolean result = object.addEmployeeToCollection(employee1);
		
		assertNotEquals(true,result);
	}


}
