package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
	Queue<Integer> queue;

	@BeforeEach
	void AppTestInit() {
		queue = new Queue<Integer>(5);
		assertTrue(queue.enqueue(1));
		assertTrue(queue.enqueue(2));
		assertTrue(queue.enqueue(3));
		assertTrue(queue.enqueue(4));
	}

	/** Adding first Element to queue - queue is empty */
	@Test
	public void TestFirstElementEnqueue() {
		queue = new Queue<Integer>(5);
		assertTrue(queue.isEmpty());
		assertTrue(queue.enqueue(6));
	}

	/** Adding the Last element to the queue */
	@Test
	public void TestLastElementEnqueue() {
		assertTrue(queue.enqueue(5));
	}

	/** Test Queue is full */
	@Test
	public void TestQueueIsFullEnqueue() {
		assertTrue(queue.enqueue(5));
		assertTrue(queue.isFull());
		assertFalse(queue.enqueue(6));
	}

	/** Front > 0 rear == MAX_LENGTH - 1 */
	@Test
	public void TestCircularQueue() {
		assertTrue(queue.enqueue(5)); // rear = 4
		assertEquals(1, queue.dequeue()); // Front = 1
		assertTrue(queue.enqueue(6)); // rear = 0
	}

	/**
	 * Test Queue is empty, throws error
	 */
	@Test
	public void TestEmptyDequeu() {
		queue = new Queue<Integer>(5);
		assertThrows(AssertionError.class, () -> {
			queue.dequeue();
		});
	}

	/**
	 * Test Dequeue
	 */
	@Test
	public void TestDequeue() {
		assertEquals(1, queue.dequeue());
	}

	/** Front == rear Dequeue */
	@Test
	public void TestFrontRearEqualDequeue() {
		assertTrue(queue.enqueue(5));
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());
		assertEquals(5, queue.dequeue());
		assertTrue(queue.isEmpty());
	}

	/** Front>Queue and set front to 0 */
	@Test
	public void TestResetFrontToZero() {
		assertTrue(queue.enqueue(5));
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());
		assertTrue(queue.enqueue(7));
		assertTrue(queue.enqueue(8));
		assertEquals(5, queue.dequeue());
	}

}
