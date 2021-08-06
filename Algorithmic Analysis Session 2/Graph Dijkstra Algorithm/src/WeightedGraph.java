import java.util.ArrayList;
import java.util.List;

/**
 * Link class to store weight and vertex
 */
class Link {
	int vertex;
	int weight;

	public Link(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class WeightedGraph implements UndirectedWeightedGraph {
	private List<List<Link>> edgeList;
	private final int noOfVertex;

	public WeightedGraph(List<Edge> edges, int noOfVertex) {

		this.noOfVertex = noOfVertex;
		edgeList = new ArrayList<>();

		for (int i = 0; i < noOfVertex; i++) {
			edgeList.add(i, new ArrayList<>());
		}

		for (Edge edge : edges) {
			edgeList.get(edge.source).add(new Link(edge.destination, edge.weight));
			edgeList.get(edge.destination).add(new Link(edge.source, edge.weight));
		}
	}

	@Override
	public boolean isConnected() {
		List<Integer> visited = new ArrayList<>();
		visited = dfs(0, visited);
		return visited.size() == noOfVertex;
	}

	@Override
	public List<Integer> reachable(int vertex) {
		List<Integer> visited = new ArrayList<>();
		visited = dfs(vertex, visited);
		return visited;
	}

	private List<Integer> dfs(int vertex, List<Integer> visited) {
		if (!visited.contains(vertex)) {
			visited.add(vertex);
		}
		for (Link tempVertex : edgeList.get(vertex)) {
			if (!visited.contains(tempVertex.vertex)) {
				visited = dfs(tempVertex.vertex, visited);
			}
		}
		return visited;
	}

	@Override
	public List<Edge> MST() {
		List<Edge> list = getEdgeList();
		List<Edge> visited = new ArrayList<>();

		int count = 0;
		WeightedGraph graph;

		for (int i = 0; i < list.size(); i++) {
			if (count == noOfVertex - 1)
				break;

			Edge currentEdge = list.get(i);

			visited.add(currentEdge);
			count++;

			graph = new WeightedGraph(visited, noOfVertex);
			if (graph.isCycleFound(currentEdge.source, currentEdge.destination, new ArrayList<>())) {
				visited.remove(currentEdge);
				count--;
				graph = new WeightedGraph(visited, noOfVertex);
			}
		}
		return visited;
	}

	/**
	 * Helper method get list of edges sorted in non-decreasing weight
	 * 
	 * @return edge list
	 */
	private List<Edge> getEdgeList() {
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < noOfVertex; i++) {
			for (Link link : edgeList.get(i)) {
				Edge edge = new Edge(i, link.vertex, link.weight);
				if (!edges.contains(edge)) {
					edges.add(edge);
				}
			}
		}
		edges.sort(null);
		return edges;
	}

	/**
	 * Helper method - To traverse the graph in depth first search manner
	 * 
	 * @param Link
	 * @param visited
	 * @return true if cycle found, else false
	 */
	public boolean isCycleFound(int vertex, int parent, List<Integer> visited) {
		boolean result = false;
		if (!visited.contains(vertex)) {
			visited.add(vertex);
		}
		for (Link temp : this.edgeList.get(vertex)) {
			if (visited.contains(temp.vertex)) {
				if (parent != temp.vertex)
					result = true;
			} else {
				result = isCycleFound(temp.vertex, vertex, visited);
			}
			if (result)
				return result;
		}
		return result;
	}

	@Override
	public int shortestPath(int source, int destination) {
		int[] distances = new int[noOfVertex];
		for (int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		List<Integer> visited = new ArrayList<>();
		distances[source] = 0;

		return path(source, destination, visited, distances);
	}

	/**
	 * Helper method to find the shortest path distance
	 * 
	 * @param vertex
	 * @param destination
	 * @param visited
	 * @param distances
	 * @return shortest path
	 */
	private int path(int vertex, int destination, List<Integer> visited, int[] distances) {
		if (vertex == destination) {
			return distances[destination];
		}
		if (!visited.contains(vertex)) {
			visited.add(vertex);
		}

		int currDistance = distances[vertex];
		for (Link tempLink : edgeList.get(vertex)) {
			int currVertex = tempLink.vertex;
			if (!visited.contains(currVertex)) {
				if ((tempLink.weight + currDistance) < distances[currVertex]) {
					distances[currVertex] = tempLink.weight + currDistance;
				}
			}
		}
		int minimumDistance = Integer.MAX_VALUE;
		int index = -1;

		for (int v = 0; v < distances.length; v++) {
			if (!visited.contains(v) && distances[v] != 0 && distances[v] < minimumDistance) {
				minimumDistance = distances[v];
				index = v;
			}
		}
		return path(index, destination, visited, distances);
	}
}
