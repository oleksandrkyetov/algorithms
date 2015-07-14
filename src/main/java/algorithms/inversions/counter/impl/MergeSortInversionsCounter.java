package algorithms.inversions.counter.impl;

import algorithms.inversions.counter.Counter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MergeSortInversionsCounter<T extends Comparable<T>> implements Counter<T> {

	private int count = 0;

	@Override
	public int count(T[] a) {
		final T[] b = Arrays.copyOf(a, a.length);

		throw new UnsupportedOperationException();
	}

	private void sort(T[] b, int start, int end) {

	}

	private void merge(T[] b, int start, int middle, int end) {

	}

}
