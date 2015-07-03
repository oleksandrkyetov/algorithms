package algorithms.princeton.part1.excercises.sort;

import algorithms.princeton.part1.excercises.sort.impl.InsertionSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InsertionSortTest {

	@InjectMocks
	private InsertionSort insertionSort;

	@Before
	public void before() {
	}

	@Test
	public void sort_desc() {
		final int[] initialArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		final int[] expectedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		final int[] actualArray = insertionSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void sort_random() {
		final int[] initialArray = new int[]{8, 6, 2, 4, 1, 3, 5, 0, 9, 7};
		final int[] expectedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		final int[] actualArray = insertionSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

}
