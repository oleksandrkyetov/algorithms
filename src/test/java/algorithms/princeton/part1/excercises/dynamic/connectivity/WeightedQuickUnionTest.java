package algorithms.princeton.part1.excercises.dynamic.connectivity;

import algorithms.princeton.part1.excercises.dynamic.connectivity.impl.WeightedQuickUnion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class WeightedQuickUnionTest {

	@InjectMocks
	private WeightedQuickUnion weightedQuickUnion;

	@Before
	public void before() { }

	@Test
	public void union_twoElementArray() {
		final int[] initialArray = new int[] {0, 1};
		final int[] expectedArray = new int[] {0, 0};

		final int[] actualArray = weightedQuickUnion.init(initialArray)
				.union(0, 1).getArray();

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void union_linkSmallerTreeToTheRootOfLargerTree() {
		final int[] initialArray = new int[] {0, 1, 2};
		final int[] expectedArray = new int[] {0, 0, 0};

		final int[] actualArray = weightedQuickUnion.init(initialArray)
				.union(0, 1).union(1, 2).getArray();

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void connected_true() {
		final int[] initialArray = new int[] {0, 1, 2};

		assertTrue(weightedQuickUnion.init(initialArray).union(0, 1).connected(0, 1));
	}

	@Test
	public void connected_false() {
		final int[] initialArray = new int[] {0, 1, 2};

		assertFalse(weightedQuickUnion.init(initialArray).union(0, 1).connected(0, 2));
	}

	@Test
	public void union_week1_question2() {
		final int[] initialArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		final int[] expectedArray = new int[] {8, 5, 8, 7, 8, 7, 8, 8, 8, 8};

		final int[] actualArray = weightedQuickUnion.init(initialArray)
				.union(7, 3).union(8, 6).union(5, 1)
				.union(8, 0).union(0, 9).union(4, 9)
				.union(3, 1).union(6, 7).union(2, 3)
				.getArray();
		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

}
