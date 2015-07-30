package algorithms.heap.impl;

import algorithms.heap.Heap;
import algorithms.heap.builder.HeapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {

	private T[] b;

	@Autowired
	private HeapBuilder<T> heapBuilder;

	@Override
	public Heap<T> init(T[] a) {
		b = heapBuilder.build(a);

		return this;
	}

	@Override
	public Heap<T> insert(T e) {
		return null;
	}

	@Override
	public T pop() {
		return null;
	}

}
