package algorithms.sort.impl;

import algorithms.sort.Partitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 2-way partitioning
 * This implementation does not handle duplicates in the array correctly
 * @param <T>
 */
@Component
// TODO Check it
public class TwoWayPartitioner<T extends Comparable<T>> implements Partitioner<T> {

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

			T tmp = b[i];
			b[i] = b[j];
			b[j] = tmp;
		}

		T tmp = b[j];
		b[j] = b[0];
		b[0] = tmp;

		return b;
	}

}
