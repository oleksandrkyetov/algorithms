package algorithms.heap.builder.impl;

import algorithms.heap.HeapHelper;
import algorithms.heap.builder.HeapBuilder;
import algorithms.resizable.Resizable;
import org.springframework.stereotype.Component;

@Component
public class BottomUpHeapBuilder<T extends Comparable<T>> implements HeapBuilder<T> {

	@Override
	public T[] build(T[] a) {
		for (int i = a.length - 1; i > -1; i--) {
			HeapHelper.sink(a, i);
		}

		return a;
	}

	@Override
	public Resizable<T> build(Resizable<T> r) {
		for (int i = r.getSize() - 1; i > -1; i--) {
			HeapHelper.sink(r, i);
		}

		return r;
	}

}
