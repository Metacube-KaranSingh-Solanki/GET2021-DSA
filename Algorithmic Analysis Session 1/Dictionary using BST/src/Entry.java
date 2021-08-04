/**
 * Generic Entry class to define the key-value pair of the of the dictionary
 * @param <T> type key
 * @param <E> type value
 */
public class Entry<T extends Comparable<T>,E extends Comparable<E>> implements Comparable<Entry<T,E>>{
	private T key;
	private E value;
	
	public Entry(T key, E object) {
		this.key = key;
		this.value = object;
	}
	
	public T getKey() {
		return key;
	}
	
	public E getValue() {
		return value;
	}
	
	@Override
	public int compareTo(Entry<T,E> other) {
		if(other == null || getClass() != other.getClass())
			throw new NullPointerException("Object is null or Clas MisMatch");
		if (key == null)
			throw new NullPointerException("Key is null");
		Entry<T,E> oth = (Entry<T,E>) other;
		return key.compareTo(oth.key);
	}

	@Override
	public String toString() {
		return key + ": " + value;
	}
}