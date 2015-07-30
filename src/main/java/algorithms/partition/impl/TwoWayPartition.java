package algorithms.partition.impl;

import algorithms.partition.Partition;
import algorithms.utils.Helper;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 2-way partitioning
 * This implementation does not handle duplicates in the array correctly
 * @param <T>
 */
@Component
public class TwoWayPartition<T extends Comparable<T>> implements Partition<T> {

	@Override
	public T[] partition(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		int i = 0;
		int j = b.length;

		while (true) {
			while(b[++i].compareTo(b[0]) < 0) {
				if (i > j) {
					break;
				}
			}

			while(b[--j].compareTo(b[0]) > 0) {
				if (j < i) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			Helper.swap(b, i, j);
		}

		Helper.swap(b, 0, j);

		return b;
	}

}
