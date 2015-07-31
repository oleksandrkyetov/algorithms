package algorithms.graph;

import algorithms.utils.Pair;

import java.util.List;
import java.util.Map;

/**
 * TODO Use custom data structures instead of Java internal ones
 * TODO Optimize algorithms search and size usage
 */
public interface MinimumCut {

	/**
	 * Initialize using adjacency list
	 * @param adjacencyList
	 * @return
	 */
	MinimumCut init(final List<Pair<String, List<String>>> adjacencyList);

	/**
	 * Initialize using edge list
	 * @param edgeList
	 * @return
	 */
	/*
	MinimumCut init(final List<Pair<String, String>> edgeList);
	*/

	/**
	 * Find minimum cuts for the provided graph
	 * @return
	 */
	int find();

}
