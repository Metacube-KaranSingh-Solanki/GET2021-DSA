package employeelist;

/**
 * Employee class store the details of the employee
 */
public class Employee {
	private String name;
	private int salary;
	private int age;

	/**
	 * Constructor
	 * 
	 * @param empId
	 * @param name
	 * @param address
	 */
	public Employee(String name, int age, int salary) {
		if (name == null)
			throw new IllegalArgumentException("Name cannot be null.");
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

	/**
	 * Compare employees on basis of their salary, if salary is equal compare age
	 * 
	 * @param other employee object
	 * @return true if this employee is greater than other using both criterion,
	 *         false otherwise
	 */
	public boolean compareSalary(Employee other) {
		if (salary > other.salary)
			return true;
		else if (salary < other.salary)
			return false;
		else if (age > other.age)
			return false;

		return true;
	}
}
