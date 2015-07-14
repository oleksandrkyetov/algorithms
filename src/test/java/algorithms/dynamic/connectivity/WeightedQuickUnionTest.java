package algorithms.dynamic.connectivity;

import algorithms.dynamic.connectivity.impl.WeightedQuickUnion;
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
	private WeightedQuickUnion<String> weightedQuickUnion;

	@Before
	public void before() { }

	@Test
	public void union_twoElementArray() {
		final String[] elements = new String[] {"0", "1"};

		assertEquals(
				Arrays.toString(new int[] {0, 0}),
				Arrays.toString(weightedQuickUnion.init(elements).union("0", "1").getIndexes()));
	}

	@Test
	public void union_linkSmallerTreeToTheRootOfLargerTree() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertEquals(
				Arrays.toString(new int[] {0, 0, 0}),
				Arrays.toString(weightedQuickUnion.init(elements)
						.union("0", "1").union("1", "2").getIndexes()));
	}

	@Test
	public void connected_true() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertTrue(weightedQuickUnion.init(elements).union("0", "1").connected("0", "1"));
	}

	@Test
	public void connected_false() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertFalse(weightedQuickUnion.init(elements).union("0", "1").connected("0", "2"));
	}

	@Test
	public void union_week1_question2() {
		final String[] elements = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		assertEquals(
				Arrays.toString(new int[] {8, 5, 8, 7, 8, 7, 8, 8, 8, 8}),
				Arrays.toString(weightedQuickUnion.init(elements)
						.union("7", "3").union("8", "6").union("5", "1")
						.union("8", "0").union("0", "9").union("4", "9")
						.union("3", "1").union("6", "7").union("2", "3")
						.getIndexes()));
	}

}
