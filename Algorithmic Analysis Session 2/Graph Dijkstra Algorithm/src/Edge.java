
/**
 * Represent a single edge
 */
public class Edge implements Comparable<Edge> {

	int source;
	int destination;
	int weight;

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "WeightedEdge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return source + destination;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		return ((source == other.source && destination == other.destination)
				|| (source == other.destination && destination == other.source));
	}

	@Override
	public int compareTo(Edge o) {
		if (weight > o.weight)
			return 1;
		else if (weight == o.weight) {
			return 0;
		}
		return -1;
	}

}
