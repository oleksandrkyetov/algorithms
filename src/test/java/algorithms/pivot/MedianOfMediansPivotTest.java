package algorithms.pivot;

import algorithms.pivot.impl.MedianOfMediansPivot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MedianOfMediansPivotTest {

	@InjectMocks
	private MedianOfMediansPivot<String> medianOfMediansPivot;

	@Before
	public void before() { }

	@Test
	public void pick_full() {
		final String[] array = new String[] {"7", "9", "8", "5", "6", "4", "2", "3", "1", "0"};
		final int start = 0;
		final int end = array.length;

		assertEquals(0, medianOfMediansPivot.pick(array, start, end));
	}

	@Test
	public void pick_part() {
		final String[] array = new String[] {"7", "9", "8", "5", "6", "4", "2", "3", "1", "0"};
		final int start = 2;
		final int end = array.length - 1;

		assertEquals(1, medianOfMediansPivot.pick(array, start, end));
	}

}
