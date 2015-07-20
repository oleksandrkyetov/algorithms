package algorithms.sort.impl;

import algorithms.sort.PivotPicker;
import algorithms.sort.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	@Autowired
	private PivotPicker<T> pivotPicker;

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
		int picked = pivotPicker.pick(b, start, end);
		// Exchange picked pivot with a first element
		T tmp = b[picked];
		b[picked] = b[start];
		b[start] = tmp;

		// Sort array
		int pivot = start;
		int edge = pivot + 1;

		for(int index = edge; index < end; index++) {
			if (b[index].compareTo(b[pivot]) < 0) {
				tmp = b[index];
				b[index] = b[edge];
				b[edge++] = tmp;
			}
		}

		tmp = b[--edge];
		b[edge] = b[pivot];
		b[pivot] = tmp;

		sort(b, start, edge);
		sort(b, edge + 1, end);
	}

}
