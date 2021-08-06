import java.util.List;

public interface UndirectedWeightedGraph {
	
	/** Check if graph is connected using depth first search
	 * @return it will return true if the graph is a connected graph.
	 */
	public boolean isConnected();
	
	/**
	 * Finds all the nodes reachable from node
	 * @param node
	 * @return all the nodes that are reachable from node a - it will return the minimum
	 */
	public List<Integer> reachable(int node);
	
	
	/**
	 * Finds the minimum cost spanning tree using Kruskal's greedy algorithm
	 * @return spanning tree for the graph using the greedy approach - it will return the MST
	 */
	public List<Edge> MST();
	
	
	/**
	 * Finds the shortest path distance between two nodes using Dijkstra’s algorithm.
	 * @param a
	 * @param b
	 * @return shortest path distance from source to destination
	 */
	public int shortestPath(int source, int destination);
}
