package algorithms.sort;

import algorithms.sort.impl.OneWayPartitioner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static  org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OneWayPartitionerTest {

	@InjectMocks
	private OneWayPartitioner<String> oneWayPartitioner;

	@Before
	public void before() { }
	
	@Test
	public void partition_distinctElements() {
		final String[] initialArray = new String[] {"4", "5", "6", "2", "3", "1", "0", "7", "9", "8"};
		final String[] expectedArray = new String[] {"0", "2", "3", "1", "4", "5", "6", "7", "9", "8"};

		final String[] actualArray = oneWayPartitioner.partition(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}
	
	@Test
	public void partition_repeatedElements() {
		final String[] initialArray = new String[] {"1", "1", "2", "0", "2", "0"};
		final String[] expectedArray = new String[] {"0", "0", "1", "1", "2", "2"};

		final String[] actualArray = oneWayPartitioner.partition(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

}
