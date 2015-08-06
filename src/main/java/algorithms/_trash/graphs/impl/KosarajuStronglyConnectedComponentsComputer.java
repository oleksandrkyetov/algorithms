package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.StronglyConnectedComponentsComputer;
import algorithms._trash.graphs.domain.Vertex;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class KosarajuStronglyConnectedComponentsComputer implements StronglyConnectedComponentsComputer {

	private List<Pair<Integer, Integer>> originalEdges;
	private List<Pair<Integer, Integer>> reversedEdges;
	private List<Vertex> vertices;

	@Override
	public StronglyConnectedComponentsComputer init(int verticesCount, final List<Pair<Integer, Integer>> edges) {
		originalEdges = new ArrayList<>(edges.size());
		for (Pair<Integer, Integer> edge : edges) {
			originalEdges.add(Pair.from(edge.getLeft() - 1, edge.getRight() - 1));
		}
		Collections.sort(originalEdges,
				(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p1.getLeft().compareTo(p2.getLeft()));

		reversedEdges = new ArrayList<>(edges.size());
		for (Pair<Integer, Integer> edge : edges) {
			reversedEdges.add(Pair.from(edge.getRight() - 1, edge.getLeft() - 1));
		}
		Collections.sort(reversedEdges,
				(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p1.getLeft().compareTo(p2.getLeft()));

		vertices = new ArrayList<>(verticesCount);
		for (int i = 0; i < verticesCount; i++) {
			vertices.add(Vertex.builder().build());
		}

		return this;
	}

	@Override
	public List<Integer> compute() {
		/*
		int time = 0;

		for (int i = 0; vertices.) {

		}
		*/

		return null;
	}

	public List<Pair<Integer, Integer>> getOriginalEdges() {
		return originalEdges;
	}

	public List<Pair<Integer, Integer>> getReversedEdges() {
		return reversedEdges;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

}
