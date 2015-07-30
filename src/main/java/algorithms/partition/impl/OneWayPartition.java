package algorithms.partition.impl;

import algorithms.partition.Partition;
import algorithms.utils.Helper;
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
				Helper.swap(b, index, edge++);
			}
		}

		Helper.swap(b, pivot, --edge);

		return b;
	}

}
