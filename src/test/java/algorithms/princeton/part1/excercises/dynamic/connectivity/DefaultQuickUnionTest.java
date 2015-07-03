package algorithms.princeton.part1.excercises.dynamic.connectivity;

import algorithms.princeton.part1.excercises.dynamic.connectivity.impl.DefaultQuickUnion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultQuickUnionTest {

	@InjectMocks
	private DefaultQuickUnion defaultQuickUnion;

	@Before
	public void before() { }

	@Test
	public void union_twoElementArray() {
		final int[] initialArray = new int[] {0, 1};
		final int[] expectedArray = new int[] {0, 0};

		final int[] actualArray = defaultQuickUnion.init(initialArray)
				.union(0, 1).getArray();

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void connected_true() {
		final int[] initialArray = new int[] {0, 1, 2};

		assertTrue(defaultQuickUnion.init(initialArray).union(0, 1).connected(0, 1));
	}

	@Test
	public void connected_false() {
		final int[] initialArray = new int[] {0, 1, 2};

		assertFalse(defaultQuickUnion.init(initialArray).union(0, 1).connected(0, 2));
	}

}
