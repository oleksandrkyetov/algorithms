package algorithms._trash.graphs;

import algorithms._trash.graphs.impl.KosarajuStronglyConnectedComponentsFinder;
import algorithms.utils.Pair;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class KosarajuStronglyConnectedComponentsFinderTest {

	@InjectMocks
	private KosarajuStronglyConnectedComponentsFinder kosarajuStronglyConnectedComponentsComputer;

	@Test
	public void find() {
		final List<Pair<Integer, Integer>> initialEdges = ImmutableList.<Pair<Integer, Integer>>builder()
				.add(Pair.of(3, 4)).add(Pair.of(4, 6))
				.add(Pair.of(1, 2)).add(Pair.of(1, 3))
				.add(Pair.of(2, 4)).add(Pair.of(6, 3))
				.add(Pair.of(5, 6)).add(Pair.of(5, 7))
				.build();
		int verticesCount = 7;

		final List<Integer> result = kosarajuStronglyConnectedComponentsComputer.init(verticesCount, initialEdges).find();

		System.out.println(result);
	}

	@Test
	public void test() throws Exception {
		final ImmutableList.Builder<Pair<Integer, Integer>> graphBuilder = ImmutableList.<Pair<Integer, Integer>>builder();

		final BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream("SCC.txt")));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] splitted = line.split(" ");

			graphBuilder.add(Pair.of(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1])));
		}

		final List<Pair<Integer, Integer>> graph = graphBuilder.build();

		final List<Integer> result = kosarajuStronglyConnectedComponentsComputer.init(875714, graph).find();

		for (int i = 0; i < 5; i++) {
			System.out.print(result.get(i) + ",");
		}
	}

}
