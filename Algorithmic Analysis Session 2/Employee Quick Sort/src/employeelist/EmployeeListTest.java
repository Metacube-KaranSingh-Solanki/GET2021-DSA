package employeelist;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeListTest {

	EmployeeList employeeList;
	Employee e1, e2, e3, e4, e5;

	@BeforeEach
	public void init() {
		employeeList = new EmployeeList();
		e1 = new Employee("E1", 19, 400);
		e2 = new Employee("E2", 20, 500);
		e3 = new Employee("E3", 21, 600);
		e4 = new Employee("E4", 22, 1000);
		e5 = new Employee("E5", 23, 1200);

		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
	}

	@Test
	public void TestInvalidInput_EmployeeDetailsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			employeeList.add(new Employee(null, 21, 50000));
		});
	}

	@Test
	public void TestEmployeeNull() {
		assertThrows(AssertionError.class, () -> {
			employeeList.add(null);
		});
	}

	@Test
	public void TestInputListInAscendingOrder() {
		employeeList.sort();
		EmployeeList expectedList = new EmployeeList();
		expectedList.add(e5);
		expectedList.add(e4);
		expectedList.add(e3);
		expectedList.add(e2);
		expectedList.add(e1);

		assertTrue(employeeList.compareTo(expectedList));
	}

	@Test
	public void TestSimilarSalaryEmployeesShouldSortOnAge() {
		Employee e6 = new Employee("E6", 21, 1200);
		Employee e7 = new Employee("E7", 18, 600);
		employeeList.add(e6);
		employeeList.add(e7);
		employeeList.sort();

		EmployeeList expectedList = new EmployeeList();
		expectedList.add(e6);
		expectedList.add(e5);
		expectedList.add(e4);
		expectedList.add(e7); // E7 & E3 has same
		expectedList.add(e3);
		expectedList.add(e2);
		expectedList.add(e1);

		assertTrue(employeeList.compareTo(expectedList));
	}

	@Test
	public void TestSortedList() {
		employeeList = new EmployeeList();
		employeeList.add(e5);
		employeeList.add(e4);
		employeeList.add(e3);
		employeeList.add(e2);
		employeeList.add(e1);

		employeeList.sort();

		EmployeeList expectedList = new EmployeeList();
		expectedList.add(e5);
		expectedList.add(e4);
		expectedList.add(e3);
		expectedList.add(e2);
		expectedList.add(e1);

		assertTrue(employeeList.compareTo(expectedList));
	}

	@Test
	public void TestSalarySameForAllEmployee() {
		employeeList = new EmployeeList();
		e1 = new Employee("E1", 24, 400);
		e2 = new Employee("E2", 21, 400);
		e3 = new Employee("E3", 22, 400);
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.sort();

		EmployeeList expectedList = new EmployeeList();
		expectedList.add(e2);
		expectedList.add(e3);
		expectedList.add(e1);

		assertTrue(employeeList.compareTo(expectedList));
	}
}
