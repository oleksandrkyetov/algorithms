package algorithms.sort;

import algorithms.sort.impl.TopDownMergeSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TopDownMergeSortTest {

	@InjectMocks
	private TopDownMergeSort<String> topDownMergeSort;

	@Before
	public void before() { }

	@Test
	public void sort_desc() {
		final String[] initialArray = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final String[] expectedArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		final String[] actualArray = topDownMergeSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void sort_random() {
		final String[] initialArray = new String[] {"3", "8", "7", "5", "6", "1", "9", "0", "4", "2"};
		final String[] expectedArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		final String[] actualArray = topDownMergeSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void sort_exercise() {
		new TopDownMergeSort<Integer>().sort(new Integer[] {43, 18, 91, 64, 45, 19, 60, 80, 55, 28, 46, 31});
	}

}
