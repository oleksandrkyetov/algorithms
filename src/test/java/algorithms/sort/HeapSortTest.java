package algorithms.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import algorithms.heap.builder.HeapBuilder;
import algorithms.heap.builder.impl.BottomUpHeapBuilder;
import algorithms.heap.impl.BinaryHeap;
import algorithms.resizable.Resizable;
import algorithms.resizable.impl.ArrayResizable;
import algorithms.sort.impl.HeapSort;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HeapSortTest.HeapSortTestConfiguration.class)
public class HeapSortTest {

	@Autowired
	private HeapSort<String> heapSort;

	@Before
	public void before() { }

	@Test
	public void sort_desc() {
		final String[] initialArray = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
		final String[] expectedArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		final String[] actualArray = heapSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void sort_random() {
		final String[] initialArray = new String[] {"3", "8", "7", "5", "6", "1", "9", "0", "4", "2"};
		final String[] expectedArray = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		final String[] actualArray = heapSort.sort(initialArray);

		assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
	}

	@Test
	public void test() {
		final String[] array = new String[] {"lime", "ecru", "sand", "palm", "drab", "gold", "coal", "cyan", "gray", "dust", "pear", "iris", "kobi", "rose", "mist", "aqua", "dusk", "pink", "bone", "corn", "sage", "jade", "bark", "herb"};

		heapSort.sort(array);
	}

	@Configuration
	public static class HeapSortTestConfiguration {

		@Bean
		public Resizable<String> resizable() {
			return new ArrayResizable<>();
		}

		@Bean
		public HeapBuilder<String> heapBuilder() {
			return new BottomUpHeapBuilder<>();
		}

		@Bean
		public BinaryHeap<String> binaryHeap() {
			return new BinaryHeap<>();
		}

		@Bean
		public HeapSort<String> heapSort() {
			return new HeapSort<>();
		}
	}

}
