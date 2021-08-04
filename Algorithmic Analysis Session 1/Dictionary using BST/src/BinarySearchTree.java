import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single node of Binary Search Tree
 * 
 * @param <T> type
 */
class Node<T> {
	T data;
	Node<T> left, right;

	public Node(T data) {
		this.data = data;
	}
}

/**
 * Represents a Binary Search Tree of Nodes
 * 
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
	private Node<T> root;
	private int size;
	private List<T> sortedNodes;

	/**
	 * Constructor to initialize data members
	 */
	public BinarySearchTree() {
		root = null;
		sortedNodes = new ArrayList<>();
	}

	/**
	 * Adds a node whose data is specified by data
	 * 
	 * @param data
	 */
	public void addNode(T data) {
		if (data == null)
			throw new AssertionError("Data is null");
		root = add(root, data);
		size++;
	}

	/**
	 * Private helper function of add, Inserts a node in the tree
	 * 
	 * @param currRoot The current node, used in recursion
	 * @param data
	 * @return
	 */
	private Node<T> add(Node<T> currRoot, T data) {
		if (currRoot == null) {
			return new Node<>(data);
		} else if (data.compareTo(currRoot.data) > 0) {
			currRoot.right = add(currRoot.right, data);
		} else if (data.compareTo(currRoot.data) < 0) {
			currRoot.left = add(currRoot.left, data);
		}
		return currRoot;
	}

	/**
	 * To search for a node
	 * 
	 * @param node
	 * @return the node
	 */
	public T search(T node) {
		return search(root, node);
	}

	/**
	 * Private helper method of search
	 * 
	 * @param currRoot current root, used in recursion
	 * @param node     to be found
	 * @return the node, null if not found
	 */
	private T search(Node<T> currRoot, T node) {
		if (currRoot == null) {
			return null;
		} else if (currRoot.data.compareTo(node) == 0)
			return currRoot.data;
		else if (currRoot.data.compareTo(node) > 0) {
			return search(currRoot.left, node);
		} else
			return search(currRoot.right, node);
	}

	/**
	 * Deletes a node with data specified
	 * 
	 * @param data
	 */
	public void delete(T node) {
		if (node == null)
			throw new NullPointerException("Data is null");
		root = delete(root, node);
		size--;
	}

	/**
	 * Private helper method of delete
	 * 
	 * @param currRoot current root used in recursion
	 * @param node     to delete
	 * @return node which is deleted, null if not found
	 */
	private Node<T> delete(Node<T> currRoot, T node) {
		if (currRoot == null)
			return currRoot;

		// Finding the node to be deleted.
		if (node.compareTo(currRoot.data) < 0)
			currRoot.left = delete(currRoot.left, node);
		else if (node.compareTo(currRoot.data) > 0)
			currRoot.right = delete(currRoot.right, node);
		else {
			// If node have only one child
			if (currRoot.left == null)
				return currRoot.right;
			else if (currRoot.right == null)
				return currRoot.left;

			// If node have two children, replace with inorder successor
			currRoot.data = findInorderSuccessor(currRoot.right);
			currRoot.right = delete(currRoot.right, currRoot.data);
		}

		return currRoot;
	}

	/**
	 * Private helper method of delete to find inorder successor of node
	 * 
	 * @param node
	 * @return inorder successor of node
	 */
	private T findInorderSuccessor(Node<T> node) {
		T min = node.data;
		while (node.left != null) {
			min = node.left.data;
			root = node.left;
		}
		return min;
	}

	/**
	 * To sort the dictionary
	 * 
	 * @return sorted dictionary in the form of list
	 */
	public List<T> sort() {
		sortedNodes.clear();
		return inorder(root);
	}

	/**
	 * Private helper method to inorder traverse the tree
	 * 
	 * @param root
	 * @return list of nodes inorder
	 */
	private List<T> inorder(Node<T> root) {
		if (root == null)
			return null;
		inorder(root.left);
		sortedNodes.add(root.data);
		inorder(root.right);

		if (sortedNodes == null)
			throw new NullPointerException("No nodes present");
		return sortedNodes;
	}
}