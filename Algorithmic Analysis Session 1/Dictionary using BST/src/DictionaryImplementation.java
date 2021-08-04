import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dictionary with Key value pairs As it is a generic class, we
 * can't directly fetch JSON String, so it has to be handled outside the class.
 * 
 * @param <T> Type of Key
 * @param <E> Type of Value
 */
public class DictionaryImplementation<T extends Comparable<T>, E extends Comparable<E>> implements Dictionary<T, E> {

	BinarySearchTree<Entry<T, E>> bst;

	public DictionaryImplementation() {
		bst = new BinarySearchTree<Entry<T, E>>();
	}

	@Override
	public boolean add(T key, E value) {
		if (key == null || value == null)
			throw new NullPointerException("Key or Value null, unable to insert");
		Entry<T, E> entry = new Entry<>(key, value);
		bst.addNode(entry);
		return true;
	}

	@Override
	public boolean delete(T key) {
		bst.delete(new Entry<>(key, null));
		return true;
	}

	@Override
	public Object getValue(T key) {
		if (key == null)
			throw new NullPointerException("Key is null");
		Entry<T, E> entry = new Entry<>(key, null);
		entry = bst.search(entry);
		if (entry == null)
			return null;
		return entry.getValue();
	}

	@Override
	public List<Entry<T, E>> getSorted() {
		return bst.sort();
	}

	@Override
	public List<Entry<T, E>> getSortedRange(T key1, T key2) {
		if (key1 == null || key2 == null)
			throw new NullPointerException("Keys cannot be null.");
		List<Entry<T, E>> list = new ArrayList<>();
		for (Entry<T, E> entry : getSorted()) {
			if (entry.getKey().compareTo(key1) >= 0 && entry.getKey().compareTo(key2) <= 0) {
				list.add(entry);
			}
		}
		if (list == null)
			throw new NullPointerException("Keys not found.");
		return list;
	}

	public void print() {
		List<Entry<T, E>> list = getSorted();
		list.stream().map(x -> x.toString()).forEach(System.out::println);
	}
}