package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.StronglyConnectedComponentsComputer;
import algorithms._trash.graphs.domain.Vertex;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Component
public class KosarajuStronglyConnectedComponentsComputer implements StronglyConnectedComponentsComputer {

	private List<Vertex> vertices = new ArrayList<>();

	private List<Vertex> leaders;
	private Deque<Vertex> deque;
	private int time = 0;

	@Override
	public StronglyConnectedComponentsComputer init(int verticesCount, final List<Pair<Integer, Integer>> edges) {
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
		time = 0;
		leaders = new LinkedList<>();
		deque = new ArrayDeque<>();

		for (int i = vertices.size() - 1; i >= 0; i--) {
			if (!vertices.get(i).isReverseExplored()) {
				depthFirstSearchReverse(vertices.get(i));
			}
		}

		return null;
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
		outVertex.setFinishingTime(++time);
	}

}
