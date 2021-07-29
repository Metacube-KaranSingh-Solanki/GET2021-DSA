package collegecounseling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue.Queue;

public class CollegeCouselingTest {
    public static CollegeCounseling collegeCounseling;
    public static Student[] studentArray = new Student[10];

    @BeforeEach
    public void init() {
        List<Program> listOfPrograms = new LinkedList<>();
		Queue<Student> studentQueue = new Queue<Student>(10);

		listOfPrograms.add(new Program("C1", 2));
		listOfPrograms.add(new Program("C2", 2));
		listOfPrograms.add(new Program("C3", 1));
		listOfPrograms.add(new Program("C4", 1));
		listOfPrograms.add(new Program("C5", 1));

        studentArray[0] = new Student("A", new Program[] { new Program("C1"), new Program("C2"), new Program("C3"), new Program("C4"), new Program("C5") });
        studentArray[1] = new Student("B", new Program[] { new Program("C1"), new Program("C2"), new Program("C3"), new Program("C4"), new Program("C5") });
 		studentArray[2] = new Student("C", new Program[] { new Program("C2"), new Program("C3"), new Program("C5"), new Program("C1"), new Program("C4") });
 		studentArray[3] = new Student("D", new Program[] { new Program("C1"), new Program("C2"), new Program("C3"), new Program("C4"), new Program("C5") });
 		studentArray[4] = new Student("E", new Program[] { new Program("C4"), new Program("C2"), new Program("C3"), new Program("C1"), new Program("C5") });
 		studentArray[5] = new Student("F", new Program[] { new Program("C5"), new Program("C2"), new Program("C3"), new Program("C4"), new Program("C1") });
 		studentArray[6] = new Student("G", new Program[] { new Program("C1"), new Program("C2"), new Program("C3"), new Program("C4"), new Program("C5") });
 		studentArray[7] = new Student("H", new Program[] { new Program("C2"), new Program("C1"), new Program("C3"), new Program("C4"), new Program("C5") });
 		studentArray[8] = new Student("I", new Program[] { new Program("C2"), new Program("C5"), new Program("C1"), new Program("C3"), new Program("C4") });
 		studentArray[9] = new Student("J", new Program[] { new Program("C3"), new Program("C2"), new Program("C1"), new Program("C4"), new Program("C5") });
		
		for (Student s: studentArray) {
			studentQueue.enqueue(s);
		}

        collegeCounseling = new CollegeCounseling(listOfPrograms, studentQueue, 10);
        collegeCounseling.allocateCourses();
        collegeCounseling.print();
    }

    /**
     * Course Allocated
     */
    @Test
    public void Test_AllocationSuccessfull() {
        assertEquals("C1", studentArray[0].getProgramAllocated());
    }

    /**
     * Course Allocated
     */
    @Test
    public void Test_CourseCapacityFull_AllocatedNextChoice() {
        assertEquals("C3", studentArray[6].getProgramAllocated());
    }

    /**
     * Course not allocated
     */
    @Test
    public void Test_NotAllocated() {
        assertEquals("N/A", studentArray[9].getProgramAllocated());
    }
}
