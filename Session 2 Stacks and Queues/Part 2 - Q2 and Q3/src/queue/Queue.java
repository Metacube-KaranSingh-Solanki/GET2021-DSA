package queue;
public class Queue<T> implements InterfaceQueue<T> {
	private final int MAX_LENGTH;
	private T[] arr;
	private int front = -1, rear = -1;
	
	public Queue(int N) {
		MAX_LENGTH = N;
		this.arr = (T[])new Object[MAX_LENGTH];
	}

	@Override
	public boolean enqueue(T data) {
		boolean isAdded = true;
		if (isFull()) {
			isAdded = false;
		} else if (isEmpty()) {
			front = rear = 0;
			arr[rear] = data;
		} else if (front <= rear && rear < MAX_LENGTH - 1) {
			rear++;
			arr[rear] = data;
		} else if (front > 0 && rear == MAX_LENGTH - 1) {
			rear = 0;
			arr[rear] = data;
		}
		return isAdded;
	}

	@Override
	public T dequeue() {
		T element;
		if (isEmpty())
			throw new AssertionError("Queue is empty.");
		
		element = arr[front];
		if (front == MAX_LENGTH - 1 && front != rear){
			front = 0;
		} else if (front == rear) { 
			front = rear = -1;
		} else {
			front++;
		}
		return element;
	}
	
	/**
	 *  Method to check if Queue is Empty
	 * @return  true if capacity is Empty
	 */
	public boolean isEmpty() {
		return (front == -1 && rear == -1) ? true : false;
	}
	
	/** Method to check if Queue is Full
	 * @return true if capacity is full
	 */
	public boolean isFull() {
		return ((front == 0 && rear == MAX_LENGTH-1) || rear==front-1) ? true : false;
	}

	/**
	 * Print the Elements of the queue
	 */
	public void print() {
		System.out.println();
		if (front <= rear) {
			for (int i=front; i<=rear; i++) {
				System.out.print(arr[i] + "\t");
			}
		}else {
			for (int i=front; i<MAX_LENGTH; i++) {
				System.out.print(arr[i] + "\t");
			}
			for (int i=0; i<=rear; i++) {
				System.out.print(arr[i] + "\t");
			}
		}
	}

	 
}
