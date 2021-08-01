import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Employee Details and different sorting operation methods
 * Each employee has unique employeeId
 */
public class EmployeeDetails {
	private List<Employee> employees;

	public EmployeeDetails() {
		this.employees = new ArrayList<>();
	}
	
	/**
	 * Add employee to employee details, handles the duplicate entry (No employee should have same employeeId)
	 * @param empId 
	 * @param name	
	 * @param address 
	 * @return true if employee added to the list, false if already exists
	 */
	public boolean addEmployee(int empId, String name, String address) {
		boolean result = false;
		Employee employee = new Employee(empId, name, address);
		if (!isEmployeeExists(employee)) {
			employees.add(employee);
			result = true;
		}
		return result;
	}
	
 	/**
 	 * Sort Employee list by employeeId
 	 */
 	public void sortEmployees() {
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int empId1 = o1.getEmpId();
				int empId2 = o2.getEmpId();
				
				return Integer.compare(empId1, empId2);		
			}
		} );
	}
 	
	/**
 	 * Sort Employee list by employeeName, if two names are equal sort by Id	
 	 */
	public void sortEmployeesByName() {
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				String empName1 = o1.getName();
				String empName2 = o2.getName();		
				if(empName1.equals(empName2)) { //If two names are equal sort by Id
					return Integer.compare(o1.getEmpId(), o2.getEmpId());
				}
				return 	empName1.compareTo(empName2);
			}
		} );
	}
	
	/**
	 * Print the Employee Details
	 */
	public void printEmployeeList() {
		System.out.println("Id\tName\tAddress");
		employees.stream()
		.map(emp -> emp.getEmpId() +"\t"+emp.getName() + "\t" + emp.getAddress())
		.forEach(System.out::println);
	}
	
	/**
	 * get number of employees
	 * @return number of employees
	 */
	public int getSize() {
		return employees.size();
	}

	/**
	 * get list of employees
	 * @return list of employees
	 */
	protected List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Check if employee already exits
	 * @param employee 
	 * @return true if exists else false
	 */
	private boolean isEmployeeExists(Employee employee) {
		return employees.stream().anyMatch(emp -> emp.equals(employee));
	}
}
