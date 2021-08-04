
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DictionaryTest {
	DictionaryImplementation<Integer, String> dictionary;
	String jsonString;

	private void addToDictionary(String jsonString) {
		JSONObject jsonObj = new JSONObject(jsonString);
		for (Object obj : JSONObject.getNames(jsonObj)) {
			dictionary.add(Integer.parseInt((String) obj), jsonObj.get(obj.toString()).toString());
		}
	}

	@BeforeEach
	public void init() {
		jsonString = "{105:\"Alice\",104:\"Mathew\",103:\"John\",102:\"May\",101:\"Karan\"}";
		dictionary = new DictionaryImplementation<>();
		addToDictionary(jsonString);
	}

	@Test
	public void TestGetValueWhenKeyIsPresent() {
		assertEquals("Alice", dictionary.getValue(105));
	}

	@Test
	public void TestGetValueWhenKeyIsNull() {
		assertThrows(NullPointerException.class, () -> {
			dictionary.getValue(null);
		});
	}

	@Test
	public void TestGetValueWhenKeyIsNotPresent() {
		assertEquals(null, dictionary.getValue(999));
	}

	@Test
	public void TestAddToDictionaryNullInputs() {
		assertThrows(NullPointerException.class, () -> {
			dictionary.add(107, null);
		});
		assertThrows(NullPointerException.class, () -> {
			dictionary.add(null, "xyz");
		});
		assertThrows(NullPointerException.class, () -> {
			dictionary.add(null, null);
		});
	}

	@Test
	public void TestAddToDictionaryValidInputs() {
		assertTrue(dictionary.add(110, "PQR"));
	}

	@Test
	public void TestDeleteNull() {
		assertThrows(NullPointerException.class, () -> {
			dictionary.delete(null);
		});
	}

	@Test
	public void TestDeleteEntry() {
		assertEquals("John", dictionary.getValue(103));
		dictionary.delete(103);
		assertEquals(null, dictionary.getValue(103));
	}

	@Test
	public void TestDeleteExtreamCases() {
		assertEquals("Alice", dictionary.getValue(105));
		assertEquals("Karan", dictionary.getValue(101));
		dictionary.delete(105);
		dictionary.delete(101);
		assertEquals(null, dictionary.getValue(105));
		assertEquals(null, dictionary.getValue(101));
	}

	@Test
	public void TestSort() {
		List<String> expectedList = Arrays.asList(new String[] { "Karan", "May", "John", "Mathew", "Alice" });
		List<Entry<Integer, String>> actualList = dictionary.getSorted();

		boolean result = true;
		int i = 0;
		for (Entry<Integer, String> entry : actualList) {
			if (!entry.getValue().equals(expectedList.get(i))) {
				result = false;
				break;
			}
			i++;
		}
		assertTrue(result);
	}

	@Test
	public void TestSortRange() {
		List<String> expectedList = Arrays.asList(new String[] { "May", "John", "Mathew" });
		List<Entry<Integer, String>> actualList = dictionary.getSortedRange(102, 104);

		boolean result = true;
		int i = 0;
		for (Entry<Integer, String> entry : actualList) {
			if (!entry.getValue().equals(expectedList.get(i))) {
				result = false;
				break;
			}
			i++;
		}
		assertTrue(result);
	}

	@Test
	public void TestSortRangeNullKeys() {
		assertThrows(NullPointerException.class, () -> {
			dictionary.getSortedRange(103, null);
		});
		assertThrows(NullPointerException.class, () -> {
			dictionary.getSortedRange(null, 105);
		});
		assertThrows(NullPointerException.class, () -> {
			dictionary.getSortedRange(107, null);
		});
	}
}
