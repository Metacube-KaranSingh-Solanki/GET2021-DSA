
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {

	/**
	 * Is Connected Test Case
	 */
	@Test
	public void isConnectedTest() {

		List<Edge> edges = Arrays.asList(new Edge[] { new Edge(0, 1, 45), new Edge(1, 2, 35), new Edge(3, 2, 30) });
		UndirectedWeightedGraph graph = new WeightedGraph(edges, 4);
		assertTrue(graph.isConnected());

		edges = Arrays.asList(new Edge[] { new Edge(0, 1, 45), new Edge(3, 1, 35), new Edge(1, 2, 30) });
		graph = new WeightedGraph(edges, 4);
		assertTrue(graph.isConnected());

		edges = Arrays.asList(new Edge[] { new Edge(0, 1, 45) });
		graph = new WeightedGraph(edges, 4);
		assertFalse(graph.isConnected());
	}

	/**
	 * Reachable Test Case
	 */
	@Test
	public void reachableTest() {
		List<Edge> edges = Arrays.asList(new Edge[] { new Edge(0, 1, 45), new Edge(1, 2, 35), new Edge(3, 2, 30) });
		UndirectedWeightedGraph graph = new WeightedGraph(edges, 5);
		assertArrayEquals(new Object[] { 0, 1, 2, 3 }, graph.reachable(0).toArray());
	}

	/**
	 * Minimum Spanning Tree Test Case
	 */
	@Test
	public void mstTest() {
		List<Edge> edges = Arrays.asList(new Edge[] { new Edge(0, 1, 1), new Edge(1, 2, 3), new Edge(2, 3, 6),
				new Edge(3, 4, 5), new Edge(4, 5, 5), new Edge(0, 5, 4), new Edge(1, 5, 2), new Edge(2, 5, 2),
				new Edge(2, 4, 7) });
		WeightedGraph graph = new WeightedGraph(edges, 6);
		List<Edge> mstOfGraph = graph.MST();

		int[] v1 = { 0, 5, 4, 5, 1 };
		int[] v2 = { 1, 2, 3, 4, 5 };
		int[] w = { 1, 2, 5, 5, 2 };

		int i = 0;
		for (Edge edge : mstOfGraph) {
			Edge temp = new Edge(v1[i], v2[i], w[i]);
			assertTrue(mstOfGraph.contains(temp));
			i++;
		}
	}

	@Test
	public void shortestPathTest() {
		List<Edge> edges = Arrays.asList(new Edge[] { new Edge(0, 1, 4), new Edge(1, 2, 8), new Edge(0, 7, 8),
				new Edge(1, 7, 11), new Edge(7, 8, 7), new Edge(6, 7, 1), new Edge(2, 8, 2), new Edge(6, 8, 6),
				new Edge(6, 5, 2), new Edge(2, 5, 2), new Edge(2, 3, 7), new Edge(3, 5, 14), new Edge(3, 4, 9),
				new Edge(4, 5, 10) });
		WeightedGraph graph = new WeightedGraph(edges, 9);

		assertEquals(21, graph.shortestPath(0, 4));
		assertEquals(14, graph.shortestPath(0, 8));
	}

}