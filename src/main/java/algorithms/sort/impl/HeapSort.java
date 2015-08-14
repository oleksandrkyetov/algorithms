package algorithms.sort.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import algorithms.heap.impl.BinaryHeap;
import algorithms.sort.Sort;

@Component
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

	@Autowired
	private BinaryHeap<T> binaryHeap;

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		binaryHeap.init(Arrays.copyOf(a, a.length));

		System.out.println(Arrays.toString(binaryHeap.getElements()));

		int i = b.length;
		while (!binaryHeap.isEmpty()) {
			b[--i] = binaryHeap.poll();
		}

		return b;
	}

}
