package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.ShortestPathFinder;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DijkstraShortestPathFinder implements ShortestPathFinder {

	private final Set<Integer> visited = new HashSet<>();

	private List<Set<Pair<Integer, Integer>>> data = new ArrayList<>();

	@Override
	public ShortestPathFinder init(final List<Set<Pair<Integer, Integer>>> adjacencyList) {
		data.clear();

		for (Set<Pair<Integer, Integer>> adjacencyItems : adjacencyList) {
			final Set<Pair<Integer, Integer>> list = new HashSet<>();
			for (Pair<Integer, Integer> adjacencyItem : adjacencyItems) {
				list.add(Pair.from(adjacencyItem));
			}
			data.add(list);
		}

		return this;
	}

	@Override
	public Integer find(int start, int end) {
		visited.clear();
		visited.add(start);

		// List of path
		final List<LinkedList<Pair<Integer, Integer>>> paths = new LinkedList<>();
		for (int i = 0; i < data.size(); i++) {
			paths.add(new LinkedList<>());
		}
		paths.get(0).add(Pair.of(0, 0));

		// List of scores
		final List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			scores.add(0);
		}

		// Repeat while end node is not visited
		while (!visited.contains(end)) {
			// Vertex
			Integer head = Integer.MAX_VALUE;
			Integer tail = Integer.MAX_VALUE;

			// Min length of vertex weight
			Integer minLength = Integer.MAX_VALUE;

			// Each visited as a tail
			for (Integer integer : visited) {
				// TODO In general we can just find here vertex with minimum weight instead of length comparisons
				// For each visited neighbour find minimum length + weight
				for (Pair<Integer, Integer> pair : data.get(integer)) {
					if (!visited.contains(pair.getLeft()) && (scores.get(integer) + pair.getRight()) < minLength) {
						minLength = scores.get(integer) + pair.getRight();
						head = pair.getLeft();
						tail = integer;
					}
				}
			}

			// Add found vertex to the path and update scores
			paths.get(head).addAll(paths.get(tail));
			paths.get(head).add(Pair.of(head, minLength));
			scores.set(head, minLength);

			visited.add(head);
		}

		//System.out.println(paths.get(end));

		return scores.get(end);
	}

}
