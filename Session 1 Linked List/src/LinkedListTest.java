import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import linkedlist.LinkedList;
import linkedlist.Node;

public class LinkedListTest {

	public static LinkedList<Integer> linkedList;

	@BeforeEach
	public void init() {
		linkedList = new LinkedList<Integer>();
	}

	@Test
	public void TestGetLengthWhenListIsEmpty() {
		assertEquals(0, linkedList.getLength());
	}

	@Test
	public void TestGetLengthWhenListIsNotEmpty() {
		linkedList.append(10);
		linkedList.append(20);
		assertEquals(2, linkedList.getLength());
	}

	@Test
	public void TesAppendingNodes() {
		linkedList.append(10);
		linkedList.append(new Node<Integer>(20));
		assertEquals(2, linkedList.getLength());
	}

	@Test
	public void TestGetHead() {
		Node<Integer> headNode = new Node<>(100);
		linkedList.append(headNode);
		assertEquals(headNode, linkedList.getHead());
	}

	@Test
	public void TestGetListAsNodeArray() {
		Node[] expectedNodeArray = new Node[5];

		for (int i = 0; i < 5; i++) {
			Node<Integer> node = new Node<>(i * 10);
			expectedNodeArray[i] = node;
			linkedList.append(node);
		}
		assertArrayEquals(expectedNodeArray, linkedList.getListAsNodeArray());
	}

	@Test
	public void TestRotateList() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);
		Node<Integer> node7 = new Node<>(7);
		
		linkedList.append(node1);
		linkedList.append(node2);
		linkedList.append(node3);
		linkedList.append(node4);
		linkedList.append(node5);
		linkedList.append(node6);
		linkedList.append(node7);

		linkedList.rotate(2, 5, 2);

		Node[] expectedNodeArray = { node1, node4, node5, node2, node3, node6, node7 };
		assertArrayEquals(expectedNodeArray, linkedList.getListAsNodeArray());
	}

	@Test
	public void TestRotateList_ExtreamLeftCase() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);
		Node<Integer> node7 = new Node<>(7);
		
		linkedList.append(node1);
		linkedList.append(node2);
		linkedList.append(node3);
		linkedList.append(node4);
		linkedList.append(node5);
		linkedList.append(node6);
		linkedList.append(node7);
		
		linkedList.rotate(1, 5, 2);

		Node[] expectedNodeArray = { node4, node5, node1, node2, node3, node6, node7 };
		assertArrayEquals(expectedNodeArray, linkedList.getListAsNodeArray());
	}
	
	@Test
	public void TestRotateList_ExtreamRightCase() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);
		Node<Integer> node7 = new Node<>(7);
		
		linkedList.append(node1);
		linkedList.append(node2);
		linkedList.append(node3);
		linkedList.append(node4);
		linkedList.append(node5);
		linkedList.append(node6);
		linkedList.append(node7);
		
		linkedList.rotate(3, 7, 2);

		Node[] expectedNodeArray = { node1, node2, node6, node7, node3, node4, node5 };
		assertArrayEquals(expectedNodeArray, linkedList.getListAsNodeArray());
	}

	@Test
	public void TestRotateList_RotateWholeList_ExtreamLeftAndRight() {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);
		Node<Integer> node7 = new Node<>(7);
		
		linkedList.append(node1);
		linkedList.append(node2);
		linkedList.append(node3);
		linkedList.append(node4);
		linkedList.append(node5);
		linkedList.append(node6);
		linkedList.append(node7);
		
		linkedList.rotate(1, 7, 2);

		Node[] expectedNodeArray = { node6, node7, node1, node2, node3, node4, node5 };
		assertArrayEquals(expectedNodeArray, linkedList.getListAsNodeArray());
	}

	@Test
	public void TestRotateArrayInvalidInput1() {
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);

		Assert.assertThrows(IllegalArgumentException.class, () -> {
			linkedList.rotate(4, 2, 2);
		});
	}

	
	@Test
	public void TestRotateArrayInvalidInput2() {
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);

		Assert.assertThrows(IllegalArgumentException.class, () -> {
			linkedList.rotate(2, 5, 2);
		});
	}

	
	@Test
	public void TestRotateArrayHeadIsNullAssertionError() {
		Assert.assertThrows(AssertionError.class, () -> {
			linkedList.rotate(1, 2, 2);
		});
	}

	
	@Test
	public void TestDetectLoopTrue() {
		Node<Integer> node2 = new Node<Integer>(2);

		linkedList.append(1);
		linkedList.append(node2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);
		linkedList.append(node2);

		assertTrue(linkedList.detectLoop());
	}

	@Test
	public void TestDetectLoopFalse() {
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);

		assertFalse(linkedList.detectLoop());
	}

	@Test
	public void TestDetectLoopHeadIsNullAssertionError() {
		Assert.assertThrows(AssertionError.class, () -> {
			linkedList.detectLoop();
		});
	}

	@Test
	public void TestDetectLoopSingleElement() {
		linkedList.append(10);
		assertFalse(linkedList.detectLoop());
	}
}
