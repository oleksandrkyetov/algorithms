package algorithms.sort.impl;

import algorithms.sort.Partitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PivotFirstPartitioner<T extends Comparable<T>> implements Partitioner<T> {

	@Override
	public T[] partition(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		int pivot = 0;
		int edge = 1;

		for(int index = 1; index < b.length; index++) {
			if (b[index].compareTo(b[pivot]) < 0) {
				T tmp = b[index];
				b[index] = b[edge];
				b[edge++] = tmp;
			}
		}

		T tmp = b[edge - 1];
		b[edge - 1] = b[pivot];
		b[pivot] = tmp;

		return b;
	}

}
