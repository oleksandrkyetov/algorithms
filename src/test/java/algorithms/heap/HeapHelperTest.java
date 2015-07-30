package algorithms.heap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HeapHelperTest {

	@Test
	public void sink_threeNodes_noSinks() {
		final String[] initialArray = new String[] {"3", "2", "1"};
		final String[] expectedArray = new String[] {"3", "2", "1"};

		HeapHelper.sink(initialArray, 0);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(initialArray));
	}

	@Test
	public void sink_threeNodes_oneSink() {
		final String[] initialArray = new String[] {"3", "4", "5"};
		final String[] expectedArray = new String[] {"5", "4", "3"};

		HeapHelper.sink(initialArray, 0);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(initialArray));
	}

	@Test
	public void sink_twoNodes_oneSink() {
		final String[] initialArray = new String[] {"1", "2"};
		final String[] expectedArray = new String[] {"2", "1"};

		HeapHelper.sink(initialArray, 0);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(initialArray));
	}

	@Test
	public void sink_fiveNodes_twoSinks() {
		final String[] initialArray = new String[] {"1", "2", "3", "4", "5"};
		final String[] expectedArray = new String[] {"3", "2", "1", "4", "5"};

		HeapHelper.sink(initialArray, 0);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(initialArray));
	}

}
