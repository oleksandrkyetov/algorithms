package algorithms.sort.impl;

import algorithms.sort.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
// TODO Check it
public class BottomUpMergeSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		for (int size = 1; size < b.length; size += size) {
			for(int start = 0; start < b.length - size; start += size * 2) {
				merge(b, start, start + size, Math.min(start + size * 2, b.length));
			}
		}

		return b;
	}

	private void merge(T[] b, int start, int middle, int end) {
		final T[] auxiliary = Arrays.copyOf(b, b.length);

		int leftIndex = start;
		int rightIndex = middle;
		for (int k = start; k < end; k++) {
			if (leftIndex < middle
					&& (rightIndex >= end || auxiliary[leftIndex].compareTo(auxiliary[rightIndex]) < 0)) {

				b[k] = auxiliary[leftIndex++];
			} else {
				b[k] = auxiliary[rightIndex++];
			}
		}
	}

}
