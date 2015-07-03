package algorithms.princeton.part1.excercises.sort.impl;

import algorithms.princeton.part1.excercises.sort.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);

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

}
