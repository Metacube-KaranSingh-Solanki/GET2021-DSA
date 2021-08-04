package linkedlist;

public class LinkedList<T> {

	private int length = 0;
	Node<T> head;

	public LinkedList() {
		head = null;
	}

	/**
	 * To get head of the linked list
	 * 
	 * @return head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * To set head of the linked list
	 */
	public void setHead(Node<T> node) {
		this.head = node;
	}

	/**
	 * Appends a node with specified data at the end of the list
	 * 
	 * @param data of the new node
	 */
	public void append(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			length++;
			return;
		}
		Node<T> traverser = head;
		while (traverser.getNext() != null) {
			traverser = traverser.getNext();
		}
		traverser.setNext(node);
		length++;
	}

	/**
	 * Calculate size of the linkedList
	 * 
	 * @return size of list
	 */
	public int size() {
		return length;
	}

	/**
	 * Print the list
	 */
	public void printList() {
		Node<T> node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	/**
	 * delete node comparing object
	 * 
	 * @param key object of type T
	 */
	public boolean delete(T element) {
		Node<T> tempNode = head, prevNode = null;
		boolean result = true;
		if (tempNode != null && tempNode.data == element) {
			head = tempNode.next;
		} else {
			while (tempNode != null && tempNode.data != element) {
				prevNode = tempNode;
				tempNode = tempNode.next;
			}

			if (tempNode == null) {
				result = false;
			} else {
				prevNode.next = tempNode.next;
			}
		}
		return result;
	}

	/**
	 * Gets the Node at position i
	 * 
	 * @param position
	 * @return Node Object, null if head is null
	 */
	public Node<T> get(int position) {
		int count = -1;
		Node<T> tempNode = head;
		while (tempNode != null) {
			count++;
			if (count == position)
				return tempNode;
			tempNode = tempNode.next;
		}
		return null;
	}
}
