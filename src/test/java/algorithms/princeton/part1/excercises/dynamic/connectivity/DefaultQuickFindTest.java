package algorithms.princeton.part1.excercises.dynamic.connectivity;

import algorithms.princeton.part1.excercises.dynamic.connectivity.impl.DefaultQuickFind;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DefaultQuickFindTest {

	@InjectMocks
	private DefaultQuickFind defaultQuickFind;

	@Before
	public void before() { }

	@Test
	public void union_twoElementArray() {
		final int[] initialArray = new int[] {0, 1};
		final int[] expectedArray = new int[] {1, 1};

		final int[] actualArray = defaultQuickFind.init(initialArray)
				.union(0, 1).getArray();

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void connected_true() {
		final int[] initialArray = new int[] {0, 1, 2};

		assertTrue(defaultQuickFind.init(initialArray).union(0, 1).connected(0, 1));
	}

	@Test
	public void connected_false() {
		final int[] initialArray = new int[] {0, 1, 2};

		assertFalse(defaultQuickFind.init(initialArray).union(0, 1).connected(0, 2));
	}

	@Test
	public void union_week1_question1() {
		final int[] initialArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		final int[] expectedArray = new int[] {1, 1, 1, 1, 6, 1, 6, 7, 8, 1};

		final int[] actualArray = defaultQuickFind.init(initialArray)
				.union(5, 2).union(0, 2).union(5, 9)
				.union(2, 1).union(3, 9).union(4, 6)
				.getArray();

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

}
