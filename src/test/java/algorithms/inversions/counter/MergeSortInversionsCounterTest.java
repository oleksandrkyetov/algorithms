package algorithms.inversions.counter;

import algorithms.inversions.counter.impl.MergeSortInversionsCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MergeSortInversionsCounterTest {

	@InjectMocks
	private MergeSortInversionsCounter<String> mergeSortInversionsCounter;

	@Before
	public void before() { }

	@Test
	public void count_asc() {
		final String[] initialArray = new String[] {"0", "1", "2", "3", "4"};

		assertEquals(0, mergeSortInversionsCounter.count(initialArray));
	}

	@Test
	public void count_desc() {
		final String[] initialArray = new String[] {"4", "3", "2", "1", "0"};

		assertEquals(10, mergeSortInversionsCounter.count(initialArray));
	}

	@Test
	public void count_random() {
		final String[] initialArray = new String[] {"0", "2", "1", "3", "4"};

		assertEquals(1, mergeSortInversionsCounter.count(initialArray));
	}

	@Test
	public void count_assignment() throws Exception {
		final Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource("array.txt").getPath()));
		final int[] arrayInt = stream.mapToInt(new ToIntFunction<String>() {
			@Override
			public int applyAsInt(final String string) {
				return Integer.parseInt(string);
			}
		}).toArray();
		stream.close();

		final Integer[] arrayInteger = new Integer[arrayInt.length];
		for (int i = 0; i < arrayInteger.length; i++) {
			arrayInteger[i] = arrayInt[i];
		}

		System.out.println(new MergeSortInversionsCounter<Integer>().count(arrayInteger));
	}

}
