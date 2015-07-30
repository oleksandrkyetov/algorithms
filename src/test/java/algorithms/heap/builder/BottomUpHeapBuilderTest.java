package algorithms.heap.builder;

import algorithms.heap.builder.impl.BottomUpHeapBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BottomUpHeapBuilderTest {

	@InjectMocks
	private BottomUpHeapBuilder<String> bottomUpHeapBuilder;

	@Before
	public void before() { }

	@Test
	public void build_array_threeNodes_noSinks() {
		final String[] initialArray = new String[] {"3", "2", "1"};
		final String[] expectedArray = new String[] {"3", "2", "1"};

		final String[] actualArray = bottomUpHeapBuilder.build(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void build_array_threeNodes_oneSink() {
		final String[] initialArray = new String[] {"3", "4", "5"};
		final String[] expectedArray = new String[] {"5", "4", "3"};

		final String[] actualArray = bottomUpHeapBuilder.build(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void build_array_twoNodes_oneSink() {
		final String[] initialArray = new String[] {"1", "2"};
		final String[] expectedArray = new String[] {"2", "1"};

		final String[] actualArray = bottomUpHeapBuilder.build(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void build_array_fiveNodes_twoSinks() {
		final String[] initialArray = new String[] {"1", "2", "3", "4", "5"};
		final String[] expectedArray = new String[] {"5", "4", "3", "1", "2"};

		final String[] actualArray = bottomUpHeapBuilder.build(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	@Ignore
	public void build_resizable_threeNodes_noSinks() {

	}

	@Test
	@Ignore
	public void build_resizable_threeNodes_oneSink() {

	}

	@Test
	@Ignore
	public void build_resizable_twoNodes_oneSink() {

	}

	@Test
	@Ignore
	public void build_resizable_fiveNodes_twoSinks() {

	}

}
