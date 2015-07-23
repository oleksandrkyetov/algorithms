package algorithms.sort.impl;

import algorithms.pivot.Pivot;
import algorithms.sort.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	@Autowired
	private Pivot<T> pivot;

	@Override
	public T[] sort(T[] a) {
		T[] b = Arrays.copyOf(a, a.length);

		sort(b, 0, b.length);

		return b;
	}

	private void sort(T[] b, int start, int end) {
		if (end - start < 2) {
			return;
		}

		// Pick pivot according to the strategy
		int picked = pivot.pick(b, start, end);
		// Exchange picked pivot with a first element
		T tmp = b[picked];
		b[picked] = b[start];
		b[start] = tmp;

		// Sort array
		int edge = start + 1;
		for(int index = edge; index < end; index++) {
			if (b[index].compareTo(b[start]) < 0) {
				tmp = b[index];
				b[index] = b[edge];
				b[edge++] = tmp;
			}
		}

		tmp = b[--edge];
		b[edge] = b[start];
		b[start] = tmp;

		sort(b, start, edge);
		sort(b, edge + 1, end);
	}

}
