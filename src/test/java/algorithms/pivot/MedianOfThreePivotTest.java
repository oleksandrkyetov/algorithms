package algorithms.pivot;

import algorithms.pivot.impl.MedianOfThreePivot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MedianOfThreePivotTest {

	@InjectMocks
	private MedianOfThreePivot<String> medianOfThreePivotPicker;

	@Before
	public void before() { }

	@Test
	public void pick_full() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int start = 0;
		final int end = array.length;

		assertEquals(5, medianOfThreePivotPicker.pick(array, start, end));
	}

	@Test
	public void pick_part() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int start = 3;
		final int end = array.length - 1;

		assertEquals(6, medianOfThreePivotPicker.pick(array, start, end));
	}

}