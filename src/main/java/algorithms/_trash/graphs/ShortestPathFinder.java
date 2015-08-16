package algorithms._trash.graphs;

import algorithms.utils.Pair;

import java.util.List;
import java.util.Set;

public interface ShortestPathFinder {

	/**
	 * Initialize using adjacency list
	 * Index of the list - current vertex, Pair - outgoing vertex and its weight
	 * @param data
	 * @return
	 */
	ShortestPathFinder init(final List<Set<Pair<Integer, Integer>>> data);

	/**
	 * Find shortest path to the vertex
	 * @param start starting vertex
	 * @param end ending vertex
	 * @return
	 */
	Integer find(final int start, final int end);

}
