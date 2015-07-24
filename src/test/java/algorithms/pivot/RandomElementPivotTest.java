package algorithms.pivot;

import algorithms.pivot.impl.RandomElementPivot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RandomElementPivotTest {

	@InjectMocks
	private RandomElementPivot<String> randomElementPivot;

	@Before
	public void before() { }

	@Test
	public void pick_full() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int start = 0;
		final int end = array.length;

		for (int i = 0; i < 100; i++) {
			int pivot = randomElementPivot.pick(array, start, end);

			assertTrue(pivot >= start && pivot < end);
		}
	}

	@Test
	public void pick_part() {
		final String[] array = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final int start = 3;
		final int end = array.length - 4;

		for (int i = 0; i < 100; i++) {
			int pivot = randomElementPivot.pick(array, start, end);

			assertTrue(pivot >= start && pivot < end);
		}
	}

}
