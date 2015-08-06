package algorithms._trash.graphs;

import algorithms._trash.graphs.domain.Vertex;
import algorithms._trash.graphs.impl.KosarajuStronglyConnectedComponentsComputer;
import algorithms.utils.Pair;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class KosarajuStronglyConnectedComponentsComputerTest {

	@InjectMocks
	private KosarajuStronglyConnectedComponentsComputer kosarajuStronglyConnectedComponentsComputer;

	@Test
	public void getEdges() {
		final List<Pair<Integer, Integer>> initialEdges = ImmutableList.<Pair<Integer, Integer>>builder()
				.add(Pair.of(3, 4)).add(Pair.of(4, 5))
				.add(Pair.of(1, 2)).add(Pair.of(1, 3))
				.add(Pair.of(2, 4)).add(Pair.of(5, 3))
				.build();
		final List<Pair<Integer, Integer>> zeroBasedInitialEdges = Lists
				.transform(initialEdges, (Pair<Integer, Integer> p) -> Pair.of(p.getLeft() - 1, p.getRight() - 1));
		final List<Pair<Integer, Integer>> leftSortedInitialEdges = Ordering
				.from((Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p1.getLeft().compareTo(p2.getLeft()))
				.immutableSortedCopy(zeroBasedInitialEdges);
		final List<Pair<Integer, Integer>> rightSortedInitialEdges = Ordering
				.from((Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p1.getRight().compareTo(p2.getRight()))
				.immutableSortedCopy(zeroBasedInitialEdges);
		int verticesCount = 5;

		kosarajuStronglyConnectedComponentsComputer.init(5, initialEdges);
		final List<Vertex> vertices = kosarajuStronglyConnectedComponentsComputer.getVertices();
		final List<Pair<Integer, Integer>> originalEdges = kosarajuStronglyConnectedComponentsComputer.getOriginalEdges();
		final List<Pair<Integer, Integer>> reversedEdges = kosarajuStronglyConnectedComponentsComputer.getReversedEdges();

		assertEquals(verticesCount, vertices.size());
		for (int i = 0; i < leftSortedInitialEdges.size(); i++) {
			assertEquals(leftSortedInitialEdges.get(i), originalEdges.get(i));
		}
		for (int i = 0; i < rightSortedInitialEdges.size(); i++) {
			assertEquals(rightSortedInitialEdges.get(i), reversedEdges.get(i));
		}
	}

}
