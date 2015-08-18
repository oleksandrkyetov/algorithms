package algorithms._trash.graphs;

import algorithms._trash.graphs.impl.DijkstraShortestPathFinder;
import algorithms.utils.Pair;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DijkstraShortestPathFinderTest {

	@InjectMocks
	private DijkstraShortestPathFinder dijkstraShortestPathFinder;

	@Test
	public void find() {
		final List<Set<Pair<Integer, Integer>>> adjacencyList = ImmutableList.<Set<Pair<Integer, Integer>>>builder()
				.add(ImmutableSet.of(Pair.of(1, 1), Pair.of(2, 3)))
				.add(ImmutableSet.of(Pair.of(0, 1), Pair.of(2, 1), Pair.of(3, 3)))
				.add(ImmutableSet.of(Pair.of(0, 3), Pair.of(1, 1), Pair.of(3, 1)))
				.add(ImmutableSet.of(Pair.of(1, 3), Pair.of(2, 1))).build();

		assertEquals(Integer.valueOf(3), dijkstraShortestPathFinder.init(adjacencyList).find(0, 3));
	}

	@Test
	public void test() throws Exception {
		final ImmutableList.Builder<Set<Pair<Integer, Integer>>> adjacencyListBuilder = ImmutableList.<Set<Pair<Integer, Integer>>>builder();

		final BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream("dijkstraData.txt")));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] splitted = line.split("\t");

			final Set<Pair<Integer, Integer>> set = new HashSet<>();
			for (int i = 1; i < splitted.length; i++) {
				String[] iw = splitted[i].split(",");
				if (iw.length > 1) {
					set.add(Pair.of(Integer.parseInt(iw[0]) - 1, Integer.parseInt(iw[1])));
				}
			}
			adjacencyListBuilder.add(set);
		}

		final List<Set<Pair<Integer, Integer>>> adjacencyList = adjacencyListBuilder.build();

		final ImmutableList<Integer> testable = ImmutableList.of(7,37,59,82,99,115,133,165,188,197);
		for (Integer test : testable) {
			//System.out.println("Testing: " + (test - 1));
			//System.out.println("Length: " + dijkstraShortestPathFinder.init(adjacencyList).find(0, test - 1));
			System.out.print(dijkstraShortestPathFinder.init(adjacencyList).find(0, test - 1) + ",");
		}
	}

}
