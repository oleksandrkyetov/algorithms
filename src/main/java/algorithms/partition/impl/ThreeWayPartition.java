package algorithms.partition.impl;

import algorithms.partition.Partition;
import algorithms.utils.Helper;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Dijkstra's 3-way partitioning
 * This implementation does handle duplicates in the array correctly
 * @param <T>
 */
@Component
public class ThreeWayPartition<T extends Comparable<T>> implements Partition<T> {

	@Override
	public T[] partition(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		int pivot = 0;
		int i = 0;
		int j = b.length - 1;

		while (i <= j) {
			if(b[i].compareTo(b[pivot]) < 0) {
				Helper.swap(b, i++, pivot++);
			} else if(b[i].compareTo(b[pivot]) > 0) {
				Helper.swap(b, i, j--);
			} else {
				i++;
			}
 		}

		return b;
	}

}
