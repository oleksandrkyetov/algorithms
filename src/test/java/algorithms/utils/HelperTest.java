package algorithms.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HelperTest {

	@Test
	public void swap() {
		final String[] initialArray = new String[] {"9", "8"};
		final String[] expectedArray = new String[] {"8", "9"};

		Helper.swap(initialArray, 0, 1);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(initialArray));
	}

	@Test
	public void greater_indexes() {
		final String[] array = new String[] {"9", "8"};

		assertTrue(Helper.greater(array, 0, 1));
	}

	@Test
	public void greater_elements() {
		final String[] array = new String[] {"9", "8"};

		assertFalse(Helper.greater(array[1], array[0]));
	}

	@Test
	public void less_indexes() {
		final String[] array = new String[] {"9", "8"};

		assertFalse(Helper.less(array, 0, 1));
	}

	@Test
	public void less_elements() {
		final String[] array = new String[] {"9", "8"};

		assertTrue(Helper.less(array[1], array[0]));
	}

	@Test
	public void even() {
		assertTrue(Helper.even(16));
	}

	@Test
	public void odd() {
		assertTrue(Helper.odd(15));
	}

}
