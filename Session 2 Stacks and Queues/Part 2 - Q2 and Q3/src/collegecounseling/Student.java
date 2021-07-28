package collegecounseling;

/**
 * Class Student structure 
 */
public class Student {
	private String name;
	private Program[] preferences = new Program[5];
	String programAllocated = "N/A";

	public Student(String name, Program[] preferences) {
		this.name = name;
		this.preferences = preferences;
	}
	
	protected String getName() {
		return name;
	}

	protected Program[] getPreferences() {
		return preferences;
	}

	protected String getProgramAllocated() {
		return programAllocated;
	}
	
	protected void setProgramAllocated(String programAllocated) {
		this.programAllocated = programAllocated;
	}
}
