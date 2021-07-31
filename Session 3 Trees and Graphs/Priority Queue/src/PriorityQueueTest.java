import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {
	PriorityQueue<Character> priorityQueue;

	@BeforeEach
	void AppTestInit() {
		priorityQueue = new PriorityQueue<Character>(5);
		assertTrue(priorityQueue.enqueue('A', 1));
		assertTrue(priorityQueue.enqueue('B', 2));
		assertTrue(priorityQueue.enqueue('C', 1));
		assertTrue(priorityQueue.enqueue('D', 4));
	}

	/** Adding first Element to Priority Queue - Priority Queue is empty */
	@Test
	public void testFirstElementEnqueue() {
		priorityQueue = new PriorityQueue<Character>(5);
		assertTrue(priorityQueue.isEmpty());
		assertTrue(priorityQueue.enqueue('E', 1));
	}

	/** Adding the Last element to the Priority Queue */
	@Test
	public void testLastElementEnqueue() {
		assertTrue(priorityQueue.enqueue('F', 2));
	}

	/** Test Priority Queue is full - throws error */
	@Test
	public void testQueueIsFullEnqueue() {
		assertTrue(priorityQueue.enqueue('G', 1));
		assertTrue(priorityQueue.isFull());
		assertThrows(AssertionError.class, () -> {
			priorityQueue.enqueue('H', 2); 
		});
	}

	/** Test PriorityQueue is empty, throws error */
	@Test
	public void testEmptyDequeue() {
		priorityQueue = new PriorityQueue<Character>(5);
		assertThrows(AssertionError.class, () -> {
			priorityQueue.dequeue();
		});
	}

	/** Test Dequeue removing highest priority object */
	@Test
	public void testDequeue() {
		assertEquals('D', priorityQueue.dequeue());
	}
	
	
	/** Test Dequeue removing highest priority object */
	@Test
	public void testRemoveElementDequeue() {
		assertEquals('D', priorityQueue.dequeue());
		assertEquals('B', priorityQueue.dequeue());
	}
	
	/**Front == rear Dequeue */
	@Test
	public void TestFrontRearEqualDequeue() {
		assertTrue(priorityQueue.enqueue('E',3));
		assertEquals('D', priorityQueue.dequeue());
		assertEquals('E', priorityQueue.dequeue());
		assertEquals('B', priorityQueue.dequeue());
		assertEquals('A', priorityQueue.dequeue());	
		assertEquals('C', priorityQueue.dequeue());
		assertTrue(priorityQueue.isEmpty());
	}
	
}
