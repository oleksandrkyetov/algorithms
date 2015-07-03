package algorithms.princeton.part1.excercises.sort.impl;

import algorithms.princeton.part1.excercises.sort.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InsertionSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);

		for (int i = 0; i < b.length; i++) {
			int k = i;
			while (k > 0 && b[k] < b[k - 1]) {
				int tmp = b[k - 1];
				b[k - 1] = b[k];
				b[k] = tmp;
				k--;
			}
		}

		return b;
	}

}
