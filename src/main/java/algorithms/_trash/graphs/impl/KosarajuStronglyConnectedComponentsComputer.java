package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.StronglyConnectedComponentsComputer;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KosarajuStronglyConnectedComponentsComputer implements StronglyConnectedComponentsComputer {

	private List<Pair<String, String>> edges;

	private List<Vertex> vertices;
	private List<Pair<Vertex, Vertex>> graph;

	@Override
	public StronglyConnectedComponentsComputer init(int verticesCount, final List<Pair<String, String>> edges) {
		this.edges = new ArrayList<>(edges.size());
		for (Pair<String, String> edge : edges) {
			this.edges.add(Pair.from(edge));
		}

		vertices = new ArrayList<>(verticesCount);
		for (int i = 0; i < vertices.size(); i++) {
			vertices.add(new Vertex());
		}

		return this;
	}

	@Override
	public List<String> compute() {
		return null;
	}

	/**
	 * Vertex representation
	 */
	private static class Vertex {
		private boolean explored = false;
		private long finishingTime = -1;
		/**
		 * Where current points to
		 * In another words tail of the current vertex
		 */
		private long pointsTo = -1;

		public boolean isExplored() {
			return explored;
		}

		public void setExplored(boolean explored) {
			this.explored = explored;
		}

		public long getFinishingTime() {
			return finishingTime;
		}

		public void setFinishingTime(long finishingTime) {
			this.finishingTime = finishingTime;
		}

		public long getPointsTo() {
			return pointsTo;
		}

		public void setPointsTo(long pointsTo) {
			this.pointsTo = pointsTo;
		}
	}

}
