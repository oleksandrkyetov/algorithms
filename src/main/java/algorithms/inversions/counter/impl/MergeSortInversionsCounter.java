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

		countSort(b, 0, b.length);

		return count;
	}

	private void countSort(T[] b, int start, int end) {
		if ((end - start) <= 1) {
			return;
		}

		int middle = (end + start) / 2;

		countSort(b, start, middle);
		countSort(b, middle, end);

		countMerge(b, start, middle, end);
	}

	private void countMerge(T[] b, int start, int middle, int end) {
		final T[] auxiliary = Arrays.copyOf(b, b.length);

		int leftIndex = start;
		int rightIndex = middle;
		for (int k = start; k < end; k++) {
			if (leftIndex < middle
				&& (rightIndex >= end || auxiliary[leftIndex].compareTo(auxiliary[rightIndex]) < 0)) {

				b[k] = auxiliary[leftIndex++];
			} else {
				count += middle - leftIndex;

				if (middle - leftIndex < 1) {
					System.out.println("count " + count);
					System.out.println("leftIndex " + leftIndex);
					System.out.println("rightIndex " + rightIndex);
					System.out.println("middle " + middle);
				}

				b[k] = auxiliary[rightIndex++];
			}

			/*
			if (leftIndex < middle && rightIndex < end) {
				if (auxiliary[leftIndex].compareTo(auxiliary[rightIndex]) < 0) {
					b[k] = auxiliary[leftIndex++];
					// TODO Add count here
				} else {
					b[k] = auxiliary[rightIndex++];
					// TODO Add count here
				}
			} else {
				if (leftIndex >= middle && rightIndex < end) {
					b[k] = auxiliary[rightIndex++];
					// TODO Add count here
				}
				if (rightIndex >= end && leftIndex < middle) {
					b[k] = auxiliary[leftIndex++];
					// TODO Add count here
				}
			}
			*/
		}
	}

}
