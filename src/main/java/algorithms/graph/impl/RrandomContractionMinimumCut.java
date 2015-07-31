package algorithms.graph.impl;

import algorithms.graph.MinimumCut;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * TODO Use custom data structures instead of Java internal ones
 * TODO Optimize algorithms search and size usage
 */
@Component
public class RrandomContractionMinimumCut implements MinimumCut {

	private List<Pair<String, List<String>>> adjacencyList;
//	private List<Pair<String, String>> edgeList;

	@Override
	public MinimumCut init(final List<Pair<String, List<String>>> adjacencyList) {
		this.adjacencyList = new LinkedList<>();
		for (Pair<String, List<String>> pair : adjacencyList) {
			final String left = pair.getLeft();
			final List<String> right = new LinkedList<>();
			for (String string : pair.getRight()) {
				right.add(string);
			}

			this.adjacencyList.add(Pair.of(left, right));
		}

		return this;
	}

	@Override
	public int find() {
		final Random random = new Random();

		// Repeat contraction while there is at least two vertices in the graph
		while(adjacencyList.size() > 2) {
			int indexToSuccess = random.nextInt(adjacencyList.size());
			final String elementToSuccess = adjacencyList.get(indexToSuccess).getLeft();
			final List<String> elementToSuccessVertices = adjacencyList.get(indexToSuccess).getRight();

			int indexToRemove = random.nextInt(elementToSuccessVertices.size());
			final String elementToRemove = elementToSuccessVertices.get(indexToRemove);
			final List<String> elementToRemoveVertices = adjacencyList.get(indexToSuccess).getRight();

			for (Pair<String, List<String>> pair : adjacencyList) {
				if (elementToRemoveVertices.contains(pair.getLeft())) {
					pair.getRight().remove(elementToRemove);

					// If successor copy vertices to update into it otherwise replace remove with successor
					if (pair.getLeft().equals(elementToSuccess)) {
						pair.getRight().addAll(elementToRemoveVertices);
						// Remove loop edges
						pair.getRight().remove(elementToSuccess);
					} else {
						pair.getRight().add(elementToSuccess);
					}
				}
			}

			// Remove element
			adjacencyList.remove(indexToRemove);
		}

		// Number of the edges from first vertex to second vertex (two last remaining vertex)
		return adjacencyList.get(0).getRight().size();
	}

	/*
	@Override
	public MinimumCut init(final List<Pair<String, String>> edgeList) {
		this.edgeList = new LinkedList<>();
		for (Pair<String, String> pair : edgeList) {
			this.edgeList.add(Pair.from(pair));
		}

		return this;
	}
	*/

	/*
	private int findEdgeList() {
		final Random random = new Random();

		// Repeat contraction while there is at least two vertices in the graph
		while(proceedFindEdgeList()) {
			final Pair<String, String> edgeToRemove = edgeList.get(random.nextInt(edgeList.size()));
			for () {

			}
		}

		return -1;
	}

	private boolean proceedFindEdgeList() {
		final Set<String> vertices = new HashSet<>();
		for (Pair<String, String> pair : edgeList) {
			vertices.add(pair.getLeft());
			vertices.add(pair.getRight());

			if (vertices.size() > 2) {
				return true;
			}
		}

		return vertices.size() > 2;
	}
	*/

}
