package algorithms.heap.builder.impl;

import algorithms.heap.HeapHelper;
import algorithms.heap.builder.HeapBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BottomUpHeapBuilder<T extends Comparable<T>> implements HeapBuilder<T> {

	@Override
	public T[] build(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		for (int i = b.length - 1; i > -1; i--) {
			HeapHelper.sink(b, i);
		}

		return b;
	}

}
