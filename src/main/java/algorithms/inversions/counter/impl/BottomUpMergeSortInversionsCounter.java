package algorithms.inversions.counter.impl;

import algorithms.inversions.counter.Counter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BottomUpMergeSortInversionsCounter<T extends Comparable<T>> implements Counter<T> {

	private long count = 0;

	@Override
	public long count(T[] a) {
		final T[] b = Arrays.copyOf(a, a.length);

		for (int size = 1; size < a.length; size += size) {
			for (int start = 0; start < b.length - size; start += size * 2) {
				countMerge(b, start, start + size, Math.min(start + size * 2, b.length));
			}
		}

		return count;
	}

	private void countMerge(T[] b, int start, int middle, int end) {
		T[] auxiliary = Arrays.copyOf(b, b.length);

		int leftIndex = start;
		int rightIndex = middle;
		for (int k = start; k < end; k++) {
			if (leftIndex < middle
				&& (rightIndex >= end || auxiliary[leftIndex].compareTo(auxiliary[rightIndex]) < 0)) {

				b[k] = auxiliary[leftIndex++];
			} else {
				count += (middle - leftIndex);

				b[k] = auxiliary[rightIndex++];
			}
		}
	}

}
