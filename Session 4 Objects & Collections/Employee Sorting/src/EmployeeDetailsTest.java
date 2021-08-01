import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeDetailsTest {
	EmployeeDetails empDetails;

	/**
	 * Compare two list of employee based on id
	 * @param list1
	 * @param list2
	 * @return true if equal
	 */
	public boolean compare(List<Employee> list1, List<Employee> list2) {
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getEmpId() != list2.get(i).getEmpId())
				return false;
		}
		return true;
	}

	@BeforeEach
	public void initTest() {
		empDetails = new EmployeeDetails();
		assertTrue(empDetails.addEmployee(2, "Sofia", "New York"));
		assertTrue(empDetails.addEmployee(3, "Mathew", "New York"));
		assertTrue(empDetails.addEmployee(4, "Michaell", "California"));
		assertTrue(empDetails.addEmployee(1, "Alice", "Columbia"));
		assertTrue(empDetails.addEmployee(5, "John", "Florida"));
	
	}
	
	@Test
	public void TestNullInputs() {
		assertThrows(IllegalArgumentException.class,()->{empDetails.addEmployee(5, "John", null);});
		assertThrows(IllegalArgumentException.class,()->{empDetails.addEmployee(5, null, "Florida");});
	}

	@Test
	public void TestNaturalOrderSort() {
		empDetails.sortEmployees();
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Alice", "Columbia"));
		list.add(new Employee(2, "Sofia", "New York"));
		list.add(new Employee(3, "Mathew", "New York"));
		list.add(new Employee(4, "Michaell", "California"));
		list.add(new Employee(5, "John", "Florida"));
		assertTrue(compare(list, empDetails.getEmployees()));
	}

	@Test
	public void TestSortByName() {
		empDetails.sortEmployeesByName();
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Alice", "Columbia"));
		list.add(new Employee(5, "John", "Florida"));
		list.add(new Employee(3, "Mathew", "New York"));
		list.add(new Employee(4, "Michaell", "California"));
		list.add(new Employee(2, "Sofia", "New York"));
		assertTrue(compare(list, empDetails.getEmployees()));
	}
	
	@Test
	public void TestSortByNameWithTwoEqualName() {
		assertTrue(empDetails.addEmployee(6, "Alice", "London"));
		empDetails.sortEmployeesByName();
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Alice", "Columbia"));
		list.add(new Employee(6, "Alice", "Florida"));
		list.add(new Employee(5, "John", "Florida"));
		list.add(new Employee(3, "Mathew", "New York"));
		list.add(new Employee(4, "Michaell", "California"));
		list.add(new Employee(2, "Sofia", "New York"));
		assertTrue(compare(list, empDetails.getEmployees()));
	}
	
	@Test
	public void TestUnique() {
		assertFalse(empDetails.addEmployee(1, "Alice", "Columbia"));
		
	}

}
