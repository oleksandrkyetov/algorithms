package algorithms.sort.impl;

import algorithms.sort.Partitioner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Dijkstra's 3-way partitioning
 * This implementation does handle duplicates in the array correctly
 * @param <T>
 */
@Component
// TODO Check it
public class ThreeWayPartitioner<T extends Comparable<T>> implements Partitioner<T> {

	@Override
	public T[] partition(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		int pivot = 0;
		int i = 0;
		int j = b.length - 1;

		while (i <= j) {
			if(b[i].compareTo(b[pivot]) < 0) {
				T tmp = b[i];
				b[i] = b[pivot];
				b[pivot] = tmp;

				i++;
				pivot++;
			} else if(b[i].compareTo(b[pivot]) > 0) {
				T tmp = b[i];
				b[i] = b[j];
				b[j] = tmp;

				j--;
			} else {
				i++;
			}
 		}

		return b;
	}

}
