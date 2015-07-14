package algorithms.inversions.counter;

import algorithms.inversions.counter.impl.MergeSortInversionsCounter;
import algorithms.sort.impl.TopDownMergeSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MergeSortInversionsCounterTest {

	@InjectMocks
	private MergeSortInversionsCounter<String> mergeSortInversionsCounter;

	@Before
	public void before() { }

	@Test
	public void count_zero() {
		final String[] initialArray = new String[] {"0", "1", "2", "3"};

		assertEquals(0, mergeSortInversionsCounter.count(initialArray));
	}

	@Test
	public void count_seven() {
		final String[] initialArray = new String[] {"3", "2", "1", "0"};

		assertEquals(7, mergeSortInversionsCounter.count(initialArray));
	}

}
