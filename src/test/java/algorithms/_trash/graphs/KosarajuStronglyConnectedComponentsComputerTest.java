package algorithms._trash.graphs;

import algorithms._trash.graphs.impl.KosarajuStronglyConnectedComponentsComputer;
import algorithms.utils.Pair;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class KosarajuStronglyConnectedComponentsComputerTest {

	@InjectMocks
	private KosarajuStronglyConnectedComponentsComputer kosarajuStronglyConnectedComponentsComputer;

	@Test
	public void compute() {
		final List<Pair<Integer, Integer>> initialEdges = ImmutableList.<Pair<Integer, Integer>>builder()
				.add(Pair.of(3, 4)).add(Pair.of(4, 6))
				.add(Pair.of(1, 2)).add(Pair.of(1, 3))
				.add(Pair.of(2, 4)).add(Pair.of(6, 3))
				.add(Pair.of(5, 6)).add(Pair.of(5, 7))
				.build();
		int verticesCount = 7;

		kosarajuStronglyConnectedComponentsComputer.init(verticesCount, initialEdges).compute();
	}

}
