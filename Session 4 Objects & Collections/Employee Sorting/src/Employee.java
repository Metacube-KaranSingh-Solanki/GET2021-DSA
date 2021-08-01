
/**Employee class store the details of the employee */
public class Employee {
	private int empId;
	private String name;
	private String address;
	
	/**
	 * Constructor
	 * @param empId
	 * @param name
	 * @param address
	 */
	public Employee(int empId, String name, String address) {
		if(name==null || address==null)
			throw new IllegalArgumentException("Fields cannot be null.");
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	protected int getEmpId() {
		return empId;
	}

	protected String getName() {
		return name;
	}

	protected String getAddress() {
		return address;
	}

	public boolean equals(Employee other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (empId != other.empId)
			return false;
		return true;
	}
}
