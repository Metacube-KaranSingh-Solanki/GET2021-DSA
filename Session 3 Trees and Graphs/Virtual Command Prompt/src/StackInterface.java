
/**
 * Generic Interface to implement Stack - LIFO
 * 
 * @param <T>
 */
public interface StackInterface<T> {

	/**
	 * remove the element from the stack
	 * 
	 * @return the element from the top the stack
	 */
	T pop();

	/**
	 * push the element top of the stack
	 * 
	 * @param data element that need to be push
	 * @return true if element is pushed into the stack
	 */
	boolean push(T data);

	/**
	 * Get the first element from the top of the stack
	 * 
	 * @return Top element from the stack
	 */
	T peek();

	/**
	 * Method to check if Queue is Empty
	 * 
	 * @return true if capacity is Empty
	 */
	public boolean isEmpty();

	/**
	 * Method to check if Queue is Full
	 * 
	 * @return true if capacity is full
	 */
	public boolean isFull();
}
