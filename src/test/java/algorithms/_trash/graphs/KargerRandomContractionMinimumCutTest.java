package algorithms._trash.graphs;

import algorithms._trash.graphs.impl.KargerRandomContractionMinimumCut;
import algorithms.utils.Pair;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class KargerRandomContractionMinimumCutTest {

	@InjectMocks
	private KargerRandomContractionMinimumCut kargerRandomContractionMinimumCut;

	@Test
	public void find() {
		final List<Pair<String, List<String>>> graph = ImmutableList.<Pair<String, List<String>>>builder()
			.add(Pair.of("1", ImmutableList.<String>builder().add("2", "3").build()))
			.add(Pair.of("2", ImmutableList.<String>builder().add("1", "3", "4").build()))
			.add(Pair.of("3", ImmutableList.<String>builder().add("1", "2", "4").build()))
			.add(Pair.of("4", ImmutableList.<String>builder().add("2", "3").build()))
			.build();

		int minCut = Integer.MAX_VALUE;
		for (int i = 0; i < graph.size() * 2 * Math.log(graph.size()); i++) {
			int cut = kargerRandomContractionMinimumCut.init(graph).find();
			if (cut < minCut) {
				minCut = cut;
			}
		}

		assertEquals(2, minCut);
	}

	@Test
	public void find_test() throws Exception {
		/*
		final List<Pair<String, List<String>>> graph = ImmutableList.<Pair<String, List<String>>>builder()
			.add(Pair.of("1", ImmutableList.<String>builder().add("2", "3").build()))
			.add(Pair.of("2", ImmutableList.<String>builder().add("1", "3", "4").build()))
			.add(Pair.of("3", ImmutableList.<String>builder().add("1", "2", "4").build()))
			.add(Pair.of("4", ImmutableList.<String>builder().add("2", "3").build()))
			.build();
		*/

		final ImmutableList.Builder<Pair<String, List<String>>> graphBuilder = ImmutableList.<Pair<String, List<String>>>builder();

		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("kargerMinCut.txt")));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] splitted = line.split("\\t");

			List<String> list = new ArrayList<>();
			for (int i = 1; i < splitted.length; i++) {
				if (splitted[i] != null) {
					list.add(splitted[i]);
				}
			}

			graphBuilder.add(Pair.of(splitted[0], list));
		}

		final List<Pair<String, List<String>>> graph = graphBuilder.build();
		/*
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).getRight().size(); j++) {
				if (graph.get(i).getLeft().equals(graph.get(i).getRight().get(j))) {
					System.out.println(graph.get(i).getLeft());
				}
			}
		}
		*/

		int minCut = Integer.MAX_VALUE;
		for (int i = 0; i < graph.size() * 2 * Math.log(graph.size()); i++) {
			int cut = kargerRandomContractionMinimumCut.init(graph).find();
			//System.out.println(cut);
			if (cut < minCut) {
				minCut = cut;
			}
		}

		assertEquals(17, minCut);
	}

}
