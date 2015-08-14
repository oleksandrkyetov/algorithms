package algorithms.sort.impl;

import algorithms.sort.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TopDownMergeSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		sort(b, 0, b.length);

		return b;
	}

	private void sort(T[] b, int start, int end) {
		if (end - start < 2) {
			return;
		}

		int middle = (end + start) / 2;

		sort(b, start, middle);
		sort(b, middle, end);

		merge(b, start, middle, end);
	}

	private void merge(T[] b, int start, int middle, int end) {
		T[] auxiliary = Arrays.copyOf(b, b.length);

		int leftIndex = start;
		int rightIndex = middle;
		for (int k = start; k < end; k++) {
			if (leftIndex < middle
					&& (rightIndex >= end || auxiliary[leftIndex].compareTo(auxiliary[rightIndex]) < 0)) {

				b[k] = auxiliary[leftIndex++];
			} else {
				b[k] = auxiliary[rightIndex++];
			}

			/*
			if (leftIndex < middle && rightIndex < end) {
				if (auxiliary[leftIndex].compareTo(auxiliary[rightIndex]) < 0) {
					b[k] = auxiliary[leftIndex++];
				} else {
					b[k] = auxiliary[rightIndex++];
				}
			} else {
				if (leftIndex >= middle && rightIndex < end) {
					b[k] = auxiliary[rightIndex++];
				}
				if (rightIndex >= end && leftIndex < middle) {
					b[k] = auxiliary[leftIndex++];
				}
			}
			*/
		}

		System.out.println(Arrays.toString(b));
	}

}
