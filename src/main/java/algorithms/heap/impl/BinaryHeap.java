package algorithms.heap.impl;

import algorithms.heap.Heap;
import algorithms.heap.HeapHelper;
import algorithms.heap.builder.HeapBuilder;
import algorithms.resizable.Resizable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {

	@Autowired
	private Resizable<T> resizable;

	@Autowired
	private HeapBuilder<T> heapBuilder;

	@Override
	public Heap<T> init(T[] a) {
		heapBuilder.build(resizable.init(a));

		return this;
	}

	@Override
	public Heap<T> add(T e) {
		// Add to the end
		resizable.add(e);

		// Swim just inserted last element to the top
		HeapHelper.swim(resizable, resizable.getSize() - 1);

		return this;
	}

	@Override
	public T poll() {
		// Exchange top with last element
		resizable.swap(0, resizable.getSize() - 1);

		// Remove last element as it is max element of the array
		T element = resizable.remove(resizable.getSize() - 1);

		// Sink just exchanged top to make binary heap
		HeapHelper.sink(resizable, 0);

		return element;
	}

	@Override
	public T peek() {
		return resizable.get(0);
	}

	@Override
	public boolean isEmpty() {
		return resizable.isEmpty();
	}

	@Override
	public T[] getElements() {
		return resizable.getElements();
	}

}
