package queue;

/**
 * Generic Interface to implement Queue - FIFO
 * 
 * @param <T>
 */
public interface InterfaceQueue<T> {
	/**
	 * Add Element in the queue of type T
	 * 
	 * @param data element to be added
	 * @return true if element is added
	 */
	boolean enqueue(T data);

	/**
	 * Remove Element in the queue of type T
	 * 
	 * @return element that removed
	 */
	T dequeue();

	/**
	 * To check if the queue is empty
	 * 
	 * @return true if it is empty, false if it is not
	 */
	boolean isEmpty();

	/**
	 * To check if the queue is full
	 * 
	 * @return true if it is full, false if is not
	 */
	boolean isFull();
}
