package algorithms.sort;

import algorithms.sort.impl.LastElementPivotPicker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LastElementPivotPickerTest {

	@InjectMocks
	private LastElementPivotPicker<String> lastElementPivotPicker;

	@Before
	public void before() { }

	@Test
	public void pick_full() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int start = 0;
		final int end = array.length;

		assertEquals(end - 1, lastElementPivotPicker.pick(array, start, end));
	}

	@Test
	public void pick_part() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int start = 0;
		final int end = array.length - 3;

		assertEquals(end - 1, lastElementPivotPicker.pick(array, start, end));
	}

}
