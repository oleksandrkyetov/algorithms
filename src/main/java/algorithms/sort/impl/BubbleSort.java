package algorithms.sort.impl;

import algorithms.sort.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
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
