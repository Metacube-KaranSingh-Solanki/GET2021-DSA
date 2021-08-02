import java.util.ArrayList;
import java.util.List;

public class Heap {

	private List<Bowler> heap;

	/**
	 * Constructor to initialize the data members
	 */
	public Heap() {
		heap = new ArrayList<Bowler>();
	}
	
	/**
	 * To insert a bowler to the heap
	 * @param bowler to insert
	 */
	public void insert(Bowler bowler) {
		heap.add(bowler);
		if (heap.size() > 1) {
			for (int k = heap.size() / 2 - 1; k >= 0; k--) {
				heapify(k);
			}
		}
	}

	/**
	 * To keep the max heap property and heapify the heap
	 * @param k the current index
	 */
	private void heapify(int k) {
		int n = heap.size();
		int largest = k;
		int left = 2 * k + 1;
		int right = 2 * k + 2;
		
		if (left < n && heap.get(left).compareTo(heap.get(largest)) == 1)
			largest = left;
		if (right < n && heap.get(right).compareTo(heap.get(largest)) == 1)
			largest = right;

		if (largest != k) {
			// Swapping
			Bowler bowler = heap.get(largest);
			heap.set(largest, heap.get(k));
			heap.set(k, bowler);

			heapify(largest);
		}
	}

	/**
	 * Removes and returns the bowler with maximum balls left
	 * @return bowler object with maximum balls left
	 */
	public Bowler extractMax() {
		if (isEmpty())
			throw new AssertionError("Heap is empty");

		Bowler bowler = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1)); // Swap element to remove with last element
		heap.remove(heap.size() - 1);

		for (int k = heap.size() / 2 - 1; k >= 0; k--) {
			heapify(k);
		}

		return bowler;
	}

	/**
	 * Checks if the heap is empty or not
	 * @return true if it is empty, false if it is not
	 */
	public boolean isEmpty() {
		return (heap.size() == 0);
	}
}
