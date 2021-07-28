import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
	Stack<Integer> stack;

    @BeforeEach
    public void init() {
        stack = new Stack<>(5);
    }

    @Test
    public void TestIsEmpty_True() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void TestIsEmpty_False() {
        assertTrue(stack.push(10));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void TestIsFull_True() {
        assertTrue(stack.push(10));
        assertTrue(stack.push(20));
        assertTrue(stack.push(30));
        assertTrue(stack.push(40));
        assertTrue(stack.push(50));
        assertTrue(stack.isFull());
    }

    @Test
    public void TestIsFull_False() {
        assertTrue(stack.push(10));
        assertFalse(stack.isFull());
    }
	
    @Test
    public void TestStackSizeWhenStackIsEmpty() {
        assertEquals(0, stack.getStackSize());
    }

    @Test
    public void TestStackSizeWhenStackIsPartiallyFilled() {
        assertTrue(stack.push(10));
        assertTrue(stack.push(20));
        assertEquals(2, stack.getStackSize());
    }

    @Test
    public void TestStackSizeWhenStackIsFull() {
        assertTrue(stack.push(10));
        assertTrue(stack.push(20));
        assertTrue(stack.push(30));
        assertTrue(stack.push(40));
        assertTrue(stack.push(50));
        assertEquals(5, stack.getStackSize());
    }

    @Test
	public void TestGetStackSizeWhenStackIsEmpty() {
		assertEquals(0, stack.getStackSize());
	}

	@Test
	public void TestGetStackSizeWhenStackIsNotEmpty() {
		assertTrue(stack.push(10));
		assertTrue(stack.push(20));
		assertEquals(2, stack.getStackSize());
	}

	@Test
	public void TestPushWhenStackIsNotFull() {
		assertTrue(stack.push(10));
		assertTrue(stack.push(20));
		assertEquals(2, stack.getStackSize());
	}

    @Test
    public void TestPushWhenStackIsFull() {
        assertTrue(stack.push(10));
        assertTrue(stack.push(20));
        assertTrue(stack.push(30));
        assertTrue(stack.push(40));
        assertTrue(stack.push(50));
        assertThrows(AssertionError.class, () -> {stack.push(60);});
    }

	@Test
	public void TestPeekWhenStackContainElements() {
        assertTrue(stack.push(100));
		assertEquals(100, stack.peek());
	}

    @Test
	public void TestPeekWhenStackIsEmpty() {
    	 assertThrows(AssertionError.class, () -> {stack.peek();});
	}

    @Test
    public void TestPopWhenStackIsEmpty() {
        assertThrows(AssertionError.class, () -> {stack.pop();});
    }

    @Test
    public void TestPopWhenStackIsNotEmpty() {
        assertTrue(stack.push(10));
        assertTrue(stack.push(20));
        assertTrue(stack.push(30));
        assertEquals(30, stack.pop());
    }

}
