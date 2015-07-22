package algorithms.partition.impl;

import algorithms.partition.Partition;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1-way partitioning
 * This implementation does not handle duplicates in the array correctly
 * @param <T>
 */
@Component
public class OneWayPartition<T extends Comparable<T>> implements Partition<T> {

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

		T tmp = b[--edge];
		b[edge] = b[pivot];
		b[pivot] = tmp;

		return b;
	}

}
