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

		assertTrue(Arrays.equals(new int[] {0, 0}, weightedQuickUnion.init(elements).union("0", "1").getIndexes()));
	}

	@Test
	public void union_linkSmallerTreeToTheRootOfLargerTree() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertTrue(Arrays.equals(new int[] {0, 0, 0}, weightedQuickUnion.init(elements).union("0", "1").union("1", "2").getIndexes()));
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

}
