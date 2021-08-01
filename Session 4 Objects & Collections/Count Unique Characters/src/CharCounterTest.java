import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharCounterTest {
	CharCounter charCounter;

	@BeforeEach
	public void initTest() {
		charCounter = new CharCounter();
	}

	@Test
	public void testCharCountOnZeroLengthString() {
		assertEquals(0, charCounter.getUniqueCount(""));
	}
	
	@Test
	public void testCharCountOnNullString() {
		assertThrows(AssertionError.class, () -> {charCounter.getUniqueCount(null);});
	}

	@Test
	public void testCharCount() {
		assertEquals(7, charCounter.getUniqueCount("edrdefredwsasawsd"));
	}

	@Test
	public void testCacheMemory() {
		assertEquals(7, charCounter.getUniqueCount("edrdefredwsasawsd"));
		assertEquals(3, charCounter.getUniqueCount("abc"));
		assertEquals(12, charCounter.getUniqueCount("hello Programming"));
		assertEquals(7, charCounter.getUniqueCount("edrdefredwsasawsd"));
	}
}
