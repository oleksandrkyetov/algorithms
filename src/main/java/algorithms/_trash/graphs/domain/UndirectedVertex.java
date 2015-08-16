package algorithms._trash.graphs.domain;

import java.util.ArrayList;
import java.util.List;

public class UndirectedVertex {

	private final int index;

	public UndirectedVertex(int index) {
		this.index = index;
	}

	private List<Integer> outbounds = new ArrayList<>();

}
