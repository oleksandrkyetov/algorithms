package algorithms._trash.graphs;

import algorithms.utils.Pair;

import java.util.List;

/**
 * TODO Use custom data structures instead of Java internal ones
 * TODO Optimize algorithms search and size usage
 */
public interface MinimumCutFinder {

	/**
	 * Initialize using adjacency list
	 * @param adjacencyList
	 * @return
	 */
	MinimumCutFinder init(final List<Pair<String, List<String>>> adjacencyList);

	/**
	 * Find minimum cuts for the provided graph
	 * @return
	 */
	int find();

}
