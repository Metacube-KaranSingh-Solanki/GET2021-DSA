/**
 * Node with highest priority removed from the queue, for e.g. (1, "A"), (2,
 * "B"), node with priority 2 will dequeue first
 */

public class PriorityQueue<T> implements PriorityQueueInterface<T> {
	private Node<T> arr[];
	private final int MAX_LENGTH;
	private int front = -1, rear = -1;

	/**
	 * Represents a single node
	 * 
	 * @param <T> Data type this node will hold
	 */
	class Node<T> {
		private int priority;
		private T data;

		public Node(int priority, T data) {
			this.priority = priority;
			this.data = data;
		}

		protected int getPriority() {
			return priority;
		}

		protected T getData() {
			return data;
		}

	}

	/**
	 * Constructor to initialize the Queue array
	 * 
	 * @param N maximum size of array
	 */
	public PriorityQueue(int N) {
		this.arr = new Node[N];
		this.MAX_LENGTH = N;
	}

	/**
	 * Add Element in the queue of type T with given priority.
	 * 
	 * @param data element to be added
	 * @return true if element is added
	 */
	@Override
	public boolean enqueue(T data, int priority) {
		Node<T> newNode = new Node<>(priority, data);
		boolean isAdded = true;
		if (isFull()) {
			throw new AssertionError("");
		} else if (isEmpty()) {
			front = rear = 0;
			arr[rear] = newNode;
		} else if (rear < MAX_LENGTH - 1) {
			for (int i = front; i <= rear; i++) {
				if (priority >= arr[i].getPriority()) {
					if (priority == arr[i].getPriority())
						i++;
					for (int j = rear; j >= i; j--) {
						arr[j + 1] = arr[j];
					}
					arr[i] = newNode;
					rear++;
					break;
				}
			}
		}
		return isAdded;
	}

	/**
	 * Remove the Element in the queue of type T
	 * 
	 * @return Removes the highest priority item and returns the item
	 */
	@Override
	public T dequeue() {
		T element;
		if (isEmpty())
			throw new AssertionError("Queue is empty.");
		element = arr[front].getData();
		if (front == rear) {
			front = rear = -1;
		} else {
			front++;
		}
		return element;
	}

	/**
	 * Method to check if Queue is Empty
	 * 
	 * @return true if capacity is Empty
	 */
	@Override
	public boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	/**
	 * Method to check if Queue is Full
	 * 
	 * @return true if capacity is full
	 */
	@Override
	public boolean isFull() {
		return ((front == 0 && rear == MAX_LENGTH - 1) || rear == front - 1);
	}

	/**
	 * Print the Elements of the queue
	 */
	public void print() {
		for (int i = front; i <= rear; i++) {
			System.out.print(arr[i].getData() + "\t");
		}
	}

}
