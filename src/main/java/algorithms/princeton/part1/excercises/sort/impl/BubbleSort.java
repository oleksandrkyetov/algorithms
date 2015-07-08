package algorithms.princeton.part1.excercises.sort.impl;

import algorithms.princeton.part1.excercises.sort.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		if (b.length == 1) {
			return b;
		} else {
			boolean swapped;
			int n = a.length;
			do {
				swapped = false;

				for (int i = 1; i < n; i++) {
					if (b[i - 1].compareTo(b[i]) > 0 ) {
						T tmp = b[i - 1];
						b[i - 1] = b[i];
						b[i] = tmp;

						swapped = true;
					}
				}
			} while (swapped);
		}

		return b;
	}

}
