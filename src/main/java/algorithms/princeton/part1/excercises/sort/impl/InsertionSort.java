package algorithms.princeton.part1.excercises.sort.impl;

import algorithms.princeton.part1.excercises.sort.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		for (int i = 0; i < b.length; i++) {
			int k = i;
			while (k > 0 && b[k].compareTo(b[k - 1]) < 0) {
				T tmp = b[k - 1];
				b[k - 1] = b[k];
				b[k] = tmp;
				k--;
			}
		}

		return b;
	}

}
