package algorithms.inversions.counter;

import algorithms.inversions.counter.impl.BottomUpMergeSortInversionsCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BottomUpMergeSortInversionsCounterTest {

	@InjectMocks
	private BottomUpMergeSortInversionsCounter<String> bottomUpMergeSortInversionsCounter;

	@Before
	public void before() { }

	@Test
	public void count_asc() {
		final String[] initialArray = new String[] {"0", "1", "2", "3", "4"};

		assertEquals(0, bottomUpMergeSortInversionsCounter.count(initialArray));
	}

	@Test
	public void count_desc() {
		final String[] initialArray = new String[] {"4", "3", "2", "1", "0"};

		assertEquals(10, bottomUpMergeSortInversionsCounter.count(initialArray));
	}

	@Test
	public void count_random() {
		final String[] initialArray = new String[] {"0", "2", "1", "3", "4"};

		assertEquals(1, bottomUpMergeSortInversionsCounter.count(initialArray));
	}

}
