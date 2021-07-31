import java.util.ArrayList;
import java.util.List;
public class BowlerScheduler {
	
	Heap heap;
	
	/**
	 * Constructor to initialize the heap
	 * @param bowlers
	 */
	public BowlerScheduler(Bowler[] bowlers) {
		 heap = new Heap();
		 if (bowlers.length == 0)
			 throw new AssertionError("Bowlers are missing.");
		 for (Bowler bowler: bowlers) {
			 heap.insert(bowler);
		 }
	}
	
	/**
	 * Returns the bowling order as an array of bowler names
	 * @return array of bowler names with correct order
	 */
	public String[] getBowlingOrder() {
		List<String> order = new ArrayList<>();
		while (!heap.isEmpty()) {
			Bowler bowler = heap.extractMax();
			order.add(bowler.getName());
			bowler.setBallsLeft(bowler.getBallsLeft() - 1);
			if (bowler.getBallsLeft() != 0)
				heap.insert(bowler);
		}
		Object[] str = order.toArray();
		String[] orderArray = new String[str.length];

		for (int i=0;i<str.length;i++){
			orderArray[i] = (String) str[i];
		}

		return orderArray;
	}
}
