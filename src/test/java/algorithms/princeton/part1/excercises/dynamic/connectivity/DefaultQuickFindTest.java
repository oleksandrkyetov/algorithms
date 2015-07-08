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
	private DefaultQuickFind<String> defaultQuickFind;

	@Before
	public void before() { }

	@Test
	public void union_twoElementArray() {
		final String[] elements = new String[] {"0", "1"};

		assertEquals(
				Arrays.toString(new int[] {1, 1}),
				Arrays.toString(defaultQuickFind.init(elements).union("0", "1").getIndexes()));
	}

	@Test
	public void connected_true() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertTrue(defaultQuickFind.init(elements).union("0", "1").connected("0", "1"));
	}

	@Test
	public void connected_false() {
		final String[] elements = new String[] {"0", "1", "2"};

		assertFalse(defaultQuickFind.init(elements).union("0", "1").connected("0", "2"));
	}

	@Test
	public void union_week1_question1() {
		final String[] elements = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		assertEquals(
				Arrays.toString(new int[] {1, 1, 1, 1, 6, 1, 6, 7, 8, 1}),
				Arrays.toString(defaultQuickFind.init(elements)
						.union("5", "2").union("0", "2").union("5", "9")
						.union("2", "1").union("3", "9").union("4", "6")
						.getIndexes()));
	}

}
