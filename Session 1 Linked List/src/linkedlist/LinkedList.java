package linkedlist;

public class LinkedList<T> {
	private Node<T> head;
	private int length = 0;
	
	/**
	 * To get head of the linked list
	 * @return head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * Appends a specified node at the end of the list 
	 * @param node
	 */
	public void append(Node<T> node) {
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
	 * Appends a node with specified data at the end of the list
	 * @param data of the new node
	 */
	public void append(T data) {
		Node<T> newNode = new Node<T>(data);
		append(newNode);
	}

	/**
	 * To get the length of the linked list
	 * @return length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Rotates sublist of LinkedList between L and R, both inclusive, clockwise N times.
	 * 
	 * @param L starting index of sublist (inclusive)
	 * @param R ending index of sublist (inclusive)
	 * @param N number of times rotation should happen 
	 * requires L <= R, however when
	 *          L == R there will be no effect on the list requires N > 0, L > 0, R
	 *          <= length
	 */
	public void rotate(int L, int R, int N) {
		if (head == null)
			throw new AssertionError("Linked list is empty.");

		if (N <= 0 || L > R || L <= 0 || R > length)
			throw new IllegalArgumentException();
		
		Node<T> traverser;
		Node<T> previousNodeOfL = null;
		Node<T> previousNodeOfR = null;
		Node<T> LNode = null;
		int nodeCounter;

		while (N != 0) {
			nodeCounter = 0;
			traverser = head;
			while (nodeCounter != R - 1) {
				nodeCounter++;
				if (L == 1 && nodeCounter == 1)
					LNode = traverser;
				else if (nodeCounter == L - 1)
					previousNodeOfL = traverser;
				else if (nodeCounter == R - 1) {
					previousNodeOfR = traverser;
				}
				traverser = traverser.getNext();
			}
			
			previousNodeOfR.setNext(traverser.getNext());
			if (previousNodeOfL == null) {
				 traverser.setNext(LNode);
				 head = traverser;
			} else {			
				traverser.setNext(previousNodeOfL.getNext());
				previousNodeOfL.setNext(traverser);
			}
			N--;
		}
	}

	/**
	 * To get the list as a array of nodes.
	 * @return list as an array of nodes.
	 */
	public Node<T>[] getListAsNodeArray() {
		Node<T>[] arrayOfNodes = new Node[length];
		Node<T> traverser = head;
		if (detectLoop()) {
			for (int i = 0; i < length; i++) {
				arrayOfNodes[i] = traverser;
				traverser = traverser.getNext();
			}
		}
		else {
			int i=0;
			while (traverser != null) {
				arrayOfNodes[i++] = traverser;
				traverser = traverser.getNext();
			}
		}
		return arrayOfNodes;
	}
	
	/**
	 * To print the linked list
	 */
	public void print() {
		Node<T> traverser = head;
		if (detectLoop()) {
			for (int i = 0; i < length; i++) {
				System.out.print(traverser.getData() + " -> ");
				traverser = traverser.getNext();
			}
			System.out.println("Cycle begines here");
		}
		else {
			while (traverser != null) {
				System.out.print(traverser.getData() + " -> ");
				traverser = traverser.getNext();
			}
			System.out.println("null");
		}
	}
	
	/**
	 * Finds if there is a cycle in the linked list
	 * @return true if cycle is present, false if not.
	 */
	public boolean detectLoop() {
		boolean isCyclePresent = false;
		
		if (head == null)
			throw new AssertionError("Linked list is empty.");
		
		if (head.getNext() == null)
			return isCyclePresent;
		
		Node<T> slowPointer = head;
		Node<T> fastPointer = head.getNext();
		
		while(fastPointer != null && fastPointer.next != null) {
			if (slowPointer == fastPointer) {
				isCyclePresent = true;
				break;
			}
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		
		return isCyclePresent;
	}
}
