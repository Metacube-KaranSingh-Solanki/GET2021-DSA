import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharCounter {
	private Map<String,Integer> cacheMemory;
	
	/**
	 * Constructor to initialize the cacheMemory
	 */
	public CharCounter() {
		cacheMemory = new HashMap<>();
	}
	
	/**
	 * Get unique character count
	 * @param string 
	 * @return unique count
	 */
	public int getUniqueCount(String string) {
		if (string == null)
			throw new AssertionError("String is null");
		int count=0;
		if(cacheMemory.containsKey(string)) {
			count = cacheMemory.get(string);				
		}else {
			count = getCount(string);
			cacheMemory.put(string, count);
		}
		return count;
	}
	
	/**
	 * Helper method to count number of unique characters in string
	 * @param string
	 * @return unique char count 
	 */
	private int getCount(String string) {
		Set<Character> tempSet = new HashSet<>();	
		for(char ch: string.toCharArray()) {
			tempSet.add(ch);
		}
		return tempSet.size();
	}
}
