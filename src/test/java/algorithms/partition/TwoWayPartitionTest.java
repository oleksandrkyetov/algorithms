package algorithms.partition;

import algorithms.partition.impl.TwoWayPartition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TwoWayPartitionTest {

	@InjectMocks
	private TwoWayPartition<String> twoWayPartitioner;

	@Before
	public void before() { }
	
	@Test
	public void partition_distinctElements() {
		final String[] initialArray = new String[] {"4", "5", "6", "2", "3", "1", "0", "7", "9", "8"};
		final String[] expectedArray = new String[] {"3", "0", "1", "2", "4", "6", "5", "7", "9", "8"};

		final String[] actualArray = twoWayPartitioner.partition(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}
	
	@Test
	public void partition_repeatedElements() {
		final String[] initialArray = new String[] {"1", "1", "2", "0", "2", "0"};
		final String[] expectedArray = new String[] {"0", "0", "1", "2", "2", "1"};

		final String[] actualArray = twoWayPartitioner.partition(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

}
