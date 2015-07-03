package algorithms.princeton.part1.excercises.sort.impl;

import algorithms.princeton.part1.excercises.sort.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);

		int[] c = innerSort(b);


		for (int i = 0; i < b.length; i++) {
			int min = i;

			for (int j = i; j < b.length; j++) {
				if (b[j] < b[min]) {
					min = j;
				}
			}

			int tmp = b[i];
			b[i] = b[min];
			b[min] = tmp;
		}

		return b;
	}

	private int[] innerSort(int[] b) {
		int medium = b.length / 2;

		innerSort();
		innerSort();
		merge();
	}

	private int[] merge(int[] b) {
		return null;
	}

}
