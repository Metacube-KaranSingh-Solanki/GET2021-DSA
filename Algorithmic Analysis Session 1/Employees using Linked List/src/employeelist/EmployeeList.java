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
	 * Insertion sort is performed using customized Linked List, get method return
	 * the element at i-th position starting from 0 if two salaries are equal,
	 * employee with lesser age will appear first in the list.
	 */
	public void sort() {
		if (employees.getHead() == null)
			throw new AssertionError("Head is null");
		int i = 1;
		while (i < employees.size()) {
			Node<Employee> currNode = employees.get(i);
			int j = i - 1;
			while (j >= 0) {
				Node<Employee> prevEmployee = employees.get(j);
				if (currNode != null && currNode.getData().compareSalary(prevEmployee.getData())) {
					prevEmployee.setNext(currNode.getNext());
					currNode.setNext(prevEmployee);
					if (prevEmployee == employees.getHead())
						employees.setHead(currNode);
					else {
						employees.get(j - 1).setNext(currNode);
					}
				}
				j--;
			}
			i++;
		}

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
