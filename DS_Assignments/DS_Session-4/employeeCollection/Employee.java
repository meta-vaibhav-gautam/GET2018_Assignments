package employeeCollection;

/**
 * class containing attributes of the employee
 * created on August August 08, 2018
 */
public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeeAddress;
	
	public Employee (int employeeId, String employeeName, String employeeAddress) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	/**
	 * @return employeeId*/
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @return employeeAddress
	 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	
	
}
