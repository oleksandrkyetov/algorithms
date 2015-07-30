package algorithms.heap;

import algorithms.heap.builder.HeapBuilder;
import algorithms.heap.builder.impl.BottomUpHeapBuilder;
import algorithms.heap.impl.BinaryHeap;
import algorithms.resizable.Resizable;
import algorithms.resizable.impl.ArrayResizable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BottomUpArrayResizableBinaryHeapTest.BottomUpArrayResizableBinaryHeapTestConfiguration.class)
public class BottomUpArrayResizableBinaryHeapTest {

	@Autowired
	private BinaryHeap<Integer> binaryHeap;

	@Before
	public void before() { }

	@Test
	public void addThreeElements() {
		final Integer[] initial = new Integer[] {92, 78, 79, 68, 75, 31, 76, 45, 54, 58};
		final Integer[] expected = new Integer[] {92, 78, 79, 68, 75, 40, 76, 45, 54, 58, 17, 31, 22};

		final Integer[] actual = binaryHeap.init(initial).add(17).add(40).add(22).getElements();

		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void removeThreeElements() {
		final Integer[] initial = new Integer[] {93, 56, 75, 54, 44, 67, 30, 40, 13, 28};
		final Integer[] expected = new Integer[] {56, 54, 30, 40, 44, 28, 13};

		binaryHeap.init(initial);
		for (int i = 0; i < 3; i++) {
			binaryHeap.poll();
		}

		final Integer[] actual = binaryHeap.getElements();

		assertTrue(Arrays.equals(expected, actual));
	}

	@Configuration
	public static class BottomUpArrayResizableBinaryHeapTestConfiguration {

		@Bean
		public Resizable<Integer> resizable() {
			return new ArrayResizable<>();
		}

		@Bean
		public HeapBuilder<Integer> heapBuilder() {
			return new BottomUpHeapBuilder<>();
		}

		@Bean
		public BinaryHeap<Integer> binaryHeap() {
			return new BinaryHeap<>();
		}
	}

}
