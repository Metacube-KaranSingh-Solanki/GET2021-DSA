package linkedlist;

/**
 * Represents a single node
 * @param <T> Data Type
 */
public class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
