
public interface PriorityQueueInterface<T> {

	/**
	 * Add Element in the queue of type T with given priority.
	 * 
	 * @param data element to be added
	 * @return true if element is added
	 */
	boolean enqueue(T item, int priority);

	/**
	 * Remove the Element in the queue of type T
	 * 
	 * @return Removes the highest priority item and returns the item
	 */
	T dequeue();

	/**
	 * Method to check if Queue is Empty
	 * 
	 * @return true if capacity is Empty
	 */
	boolean isEmpty();

	/**
	 * Method to check if Queue is Full
	 * 
	 * @return true if capacity is full
	 */
	boolean isFull();
}
