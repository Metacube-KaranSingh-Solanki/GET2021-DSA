import java.util.List;

/**
 * Dictionary interface with key-value pairs as an entry
 */
public interface Dictionary<T extends Comparable<T>, E extends Comparable<E>> {

	/**
	 * add a key-value pair to dictionary
	 * 
	 * @param key<T>
	 * @param value<E>
	 * @return true if key-value pair added, else false
	 */
	public boolean add(T key, E value);

	/**
	 * delete a key value pair from the dictionary
	 * 
	 * @param key
	 * @return true if deleted
	 */
	public boolean delete(T key);

	/**
	 * Get value of specific key
	 * 
	 * @param key
	 * @return value for the corresponding key
	 */
	public Object getValue(T key);

	/**
	 * Sorted list of (Key,Value)
	 * 
	 * @return sorted list of key-value pairs by keys
	 */
	public List<?> getSorted();

	/**
	 * Sorted Sublist of Key-value within range of two keys
	 * 
	 * @param key1
	 * @param key2
	 * @return the sorted list of key-value pairs for all the keys >=K1 and <=K2
	 */
	public List<?> getSortedRange(T key1, T key2);

}