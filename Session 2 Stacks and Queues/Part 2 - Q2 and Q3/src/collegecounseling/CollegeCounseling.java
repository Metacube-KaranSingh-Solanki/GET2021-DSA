package collegecounseling;

import java.util.List;
import queue.Queue;

class Program{
	private String name;
	private int availableSeats;
	
	public Program(String name, int availableSeats) {
		this.name = name;
		this.availableSeats = availableSeats;
	}

	protected Program(String name) {
		this.name = name;
	}

	protected String getName() {
		return name;
	}

	protected int getAvailableSeats() {
		return availableSeats;
	}

	protected void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}
public class CollegeCounseling {
	private List<Program> listOfPrograms;
	private Queue<Student> studentQueue;
	private final int noOfStudents;
	Student[] studentArray;
	

	/** Constructor of College Counseling
	 * @param listOfPrograms list of programs offered and it's availability
	 * @param studentQueue list of students of type queue
	 * @param noOfStudents no of students
	 */
	public CollegeCounseling(List<Program> listOfPrograms, Queue<Student> studentQueue, int noOfStudents) {
		this.listOfPrograms = listOfPrograms;
		this.studentQueue = studentQueue;
		this.noOfStudents = noOfStudents;
		studentArray = new Student[noOfStudents];
	}
	
	protected List<Program> getListOfPrograms() {
		return listOfPrograms;
	}

	protected Queue<Student> getStudentQueue() {
		return studentQueue;
	}

	protected int getNoOfStudents() {
		return noOfStudents;
	}
	
	private Program getProgramData(String programName) {
		for (Program program: listOfPrograms) {
			if (program.getName() == programName)
				return program;
		}
		return null;
	}

	/**
	 * Allocate the courses to the students bases on preference list
	 * @return list of students
	 */
	public void allocateCourses() {
		int i=0;
		while (!studentQueue.isEmpty()) {
			Student student = studentQueue.dequeue();
			for (Program preference: student.getPreferences()) {
				Program program = getProgramData(preference.getName());
				if(program==null) 
					throw new AssertionError("Program not available in this college.");
				if (program.getAvailableSeats() > 0) {
					student.setProgramAllocated(program.getName());
					program.setAvailableSeats(program.getAvailableSeats() - 1);
					break;
				}
			}
			studentArray[i++] = student;
		}
	}
	
	/**
	 * Prints students with course allocated, print N/A if course not alloted
	 * @param studentWithPrograms
	 */
	public void print() {
		for (Student student: studentArray) {
		    System.out.println(student.getName() + ": " + student.getProgramAllocated());
		}
	}
}
