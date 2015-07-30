package algorithms.dynamic.connectivity;

import algorithms.dynamic.connectivity.impl.DefaultQuickFind;
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

		assertTrue(Arrays.equals(new int[] {1, 1}, defaultQuickFind.init(elements).union("0", "1").getIndexes()));
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

}
