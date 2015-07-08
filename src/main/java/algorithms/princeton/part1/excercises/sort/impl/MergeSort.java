package algorithms.princeton.part1.excercises.sort.impl;

import algorithms.princeton.part1.excercises.sort.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		T[] c = innerSort(b);

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

	private T[] innerSort(T[] b) {
		int medium = b.length / 2;

		return null;
		/*
		innerSort();
		innerSort();
		merge();
		*/
	}

	private T[] merge(int[] b) {
		return null;
	}

}
