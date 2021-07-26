import linkedlist.LinkedList;
import linkedlist.Node;

public class App {
	public static void main(String[] args) {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		
		Node<Integer> node2 = new Node<>(2);
		
		myLinkedList.append(1);
		myLinkedList.append(node2);
		myLinkedList.append(3);
		myLinkedList.append(4);
		myLinkedList.append(5);
		myLinkedList.append(6);
		myLinkedList.append(node2);

		System.out.println(myLinkedList.detectLoop());
		
		myLinkedList.print();
	}
}
