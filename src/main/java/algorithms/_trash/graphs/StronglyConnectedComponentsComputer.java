package algorithms._trash.graphs;

import algorithms.utils.Pair;

import java.util.List;

public interface StronglyConnectedComponentsComputer {

	StronglyConnectedComponentsComputer init(int verticesCount, final List<Pair<String, String>> edges);

	/**
	 * Leader vertices of the strongly connected components
	 * @return list of leaders of strongly connected components
	 */
	public List<String> compute();

}
