package employeelist;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Employee List class to add and sort the employee list
 */
public class EmployeeList {
	private LinkedList<Employee> employees;

	public EmployeeList() {
		employees = new LinkedList<Employee>();
	}

	/**
	 * add employee to the list
	 * 
	 * @param employee
	 */
	public void add(Employee employee) {
		if (employee == null) {
			throw new AssertionError("Employee cannot be null!");
		}
		employees.append(employee);
	}

	/**
	 * Quick sort is performed using customized Linked List, get method return the
	 * element at i-th position starting from 0 Always pick the last element as
	 * pivot if two salaries are equal, employee with lesser age will appear first
	 * in the list.
	 */
	public void sort() {
		if (employees.getHead() == null)
			throw new AssertionError("Head is null");

		quicksort(0, employees.size() - 1);
	}

	/**
	 * Private helper method to perform quick sort algorithm
	 * 
	 * @param start index
	 * @param end   index
	 */
	private void quicksort(int start, int end) {
		if (start < end) {
			int pIndex = partition(start, end);
			quicksort(start, pIndex - 1);
			quicksort(pIndex + 1, end);
		}
	}

	/**
	 * Private helper method to partition the array such that the pivot will be at
	 * its final position in the sorted array.
	 * 
	 * @param start index
	 * @param end   index
	 * @return final index of pivot
	 */
	private int partition(int start, int end) {
		Node<Employee> pivot = employees.get(end);
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (employees.get(i).getData().compareSalary(pivot.getData())) {
				swap(pIndex, i);
				pIndex++;
			}
		}
		swap(pIndex, end);
		return pIndex;
	}

	/**
	 * Private helper method to swap two nodes in the linked list
	 * 
	 * @param i1 first index
	 * @param i2 second index
	 */
	private void swap(int i1, int i2) {
		if (i1 == i2)
			return;

		Node<Employee> node1 = employees.get(i1);
		Node<Employee> node2 = employees.get(i2);

		Node<Employee> temp = node2.getNext();
		node2.setNext(node1.getNext());
		node1.setNext(temp);

		if (employees.get(i1 - 1) != null)
			employees.get(i1 - 1).setNext(node2);
		else
			employees.setHead(node2);

		employees.get(i2 - 1).setNext(node1);
	}

	/**
	 * print the elements of the list
	 */
	public void print() {
		Node<Employee> traverser = employees.getHead();
		while (traverser != null) {
			System.out.println(traverser.getData());
			traverser = traverser.getNext();
		}
	}

	/**
	 * To compare two employee list, helper method for test cases
	 * 
	 * @param other list to be compared with
	 * @return true if equal
	 */
	public boolean compareTo(EmployeeList other) {
		if (employees.size() != other.employees.size())
			return false;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getData() != other.employees.get(i).getData())
				return false;
		}
		return true;
	}
}
