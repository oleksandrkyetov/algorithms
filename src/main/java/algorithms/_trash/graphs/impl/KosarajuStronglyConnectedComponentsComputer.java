package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.StronglyConnectedComponentsComputer;
import algorithms._trash.graphs.domain.Vertex;
import algorithms.utils.Pair;
import com.google.common.collect.Ordering;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class KosarajuStronglyConnectedComponentsComputer implements StronglyConnectedComponentsComputer {

	private List<Vertex> vertices;

	private List<Vertex> finishers;
	private List<Vertex> leaders;
	private Deque<Vertex> deque;

	@Override
	public StronglyConnectedComponentsComputer init(int verticesCount, final List<Pair<Integer, Integer>> edges) {
		vertices = new ArrayList<>();

		for (int i = 0; i < verticesCount; i++) {
			vertices.add(new Vertex(i));
		}

		for (Pair<Integer, Integer> edge : edges) {
			vertices.get(edge.getLeft() - 1).addOutbound(edge.getRight() - 1);
			vertices.get(edge.getRight() - 1).addInbound(edge.getLeft() - 1);
		}

		return this;
	}

	@Override
	public List<Integer> compute() {
		finishers = new ArrayList<>();
		deque = new ArrayDeque<>();
		System.out.println("Reverse graph processing ...");
		for (int i = vertices.size() - 1; i >= 0; i--) {
			if (!vertices.get(i).isReverseExplored()) {
				depthFirstSearchReverse(vertices.get(i));
			}
		}

		System.out.println("Forward graph processing ...");
		leaders = new ArrayList<>();
		deque = new ArrayDeque<>();
		for (int i = finishers.size() - 1; i >= 0; i--) {
			if (!finishers.get(i).isForwardExplored()) {
				depthFirstSearchForward(finishers.get(i), finishers.get(i));
			}
		}

		System.out.println("Sorting ...");
		final List<Integer> result = new ArrayList<>();
		Ordering.from((Vertex v1, Vertex v2) -> {
			if (v1.getSize() > v2.getSize()) {
				return -1;
			}
			if (v1.getSize() < v2.getSize()) {
				return 1;
			}
			return 0;
		}).immutableSortedCopy(leaders)
				.forEach((Vertex vertex) -> result.add(vertex.getSize()));

		return result;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void depthFirstSearchReverse(final Vertex inVertex) {
		inVertex.setReverseExplored(true);
		deque.add(inVertex);

		// Find first not explored inbound(reverse pass) end explore it
		for (int j = 0; j < inVertex.getInbounds().size(); j++) {
			if (!vertices.get(inVertex.getInbounds().get(j)).isReverseExplored()) {
				depthFirstSearchReverse(vertices.get(inVertex.getInbounds().get(j)));
			}
		}

		final Vertex outVertex = deque.pollLast();
		finishers.add(outVertex);
	}

	public void depthFirstSearchForward(final Vertex inVertex, final Vertex leader) {
		inVertex.setForwardExplored(true);
		deque.add(inVertex);

		// Find first not explored inbound(reverse pass) end explore it
		for (int j = 0; j < inVertex.getOutbounds().size(); j++) {
			if (!vertices.get(inVertex.getOutbounds().get(j)).isForwardExplored()) {
				depthFirstSearchForward(vertices.get(inVertex.getOutbounds().get(j)), leader);
			}
		}

		final Vertex outVertex = deque.pollLast();
		leader.incrementSize();
		if (deque.isEmpty()) {
			leaders.add(outVertex);
		}
	}

}
