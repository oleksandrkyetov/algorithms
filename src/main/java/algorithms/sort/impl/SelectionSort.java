package algorithms.sort.impl;

import algorithms.sort.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		for (int i = 0; i < b.length; i++) {
			int min = i;

			for (int j = i; j < b.length; j++) {
				if (b[j].compareTo(b[min]) < 0) {
					min = j;
				}
			}

			T tmp = b[i];
			b[i] = b[min];
			b[min] = tmp;
		}

		return b;
	}

}
