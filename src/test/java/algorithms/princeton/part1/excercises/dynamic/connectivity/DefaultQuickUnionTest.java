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
	private DefaultQuickUnion<String> defaultQuickUnion;

	@Before
	public void before() { }

	@Test
	public void union_twoElementArray() {
		final String[] elements = new String[] {"0", "1"};

		assertEquals(
				Arrays.toString(new int[] {0, 0}),
				Arrays.toString(defaultQuickUnion.init(elements).union("0", "1").getIndexes()));
	}

	@Test
	public void connected_true() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertTrue(defaultQuickUnion.init(elements).union("0", "1").connected("0", "1"));
	}

	@Test
	public void connected_false() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertFalse(defaultQuickUnion.init(elements).union("0", "1").connected("0", "2"));
	}

}
