
/**
 * Generic Stack class Implements the StackInterface
 * 
 * @param <T>
 */
public class Stack<T> implements StackInterface<T> {
	private T[] stackArray;
	private int top = -1;

	public Stack(int stackSize) {
		this.stackArray = (T[]) new Object[stackSize];
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new AssertionError("Stack is empty!");
		T element = stackArray[top--];
		return element;
	}

	@Override
	public boolean push(T element) {
		if (isFull())
			throw new AssertionError("Stack is full!");
		stackArray[++top] = element;
		return true;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new AssertionError("Stack is empty!");
		return stackArray[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1 ? true : false;
	}

	@Override
	public boolean isFull() {
		return top == stackArray.length - 1 ? true : false;
	}

	public int getStackSize() {
		return top + 1;
	}
}