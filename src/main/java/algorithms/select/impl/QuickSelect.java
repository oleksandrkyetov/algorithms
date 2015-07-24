package algorithms.select.impl;

import algorithms.pivot.Pivot;
import algorithms.select.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QuickSelect<T extends Comparable<T>> implements Select<T> {

	@Autowired
	private Pivot<T> pivot;

	@Override
	public T select(T[] a, int order) {
		final T[] b = Arrays.copyOf(a, a.length);

		return select(b, order, 0, b.length);
	}

	private T select(T[] b, int order, int start, int end) {
		// Pick pivot according to the strategy
		int picked = pivot.pick(b, start, end) ;

		// Exchange picked pivot with first element
		T tmp = b[start];
		b[start] = b[picked];
		b[picked] = tmp;

		// Sort array
		int edge = start + 1;
		for (int index = start; index < end; index++) {
			if (b[index].compareTo(b[start]) < 0) {
				tmp = b[index];
				b[index] = b[edge];
				b[edge++] = tmp;
			}
		}

		// Switch pivot with min/max edge
		tmp = b[--edge];
		b[edge] = b[start];
		b[start] = tmp;

		// Decide on what part of array to work next
		if (order < edge) {
			return select(b, order, start, edge);
		} else if (order > edge) {
			return select(b, order, edge + 1, end);
		} else {
			return b[edge];
		}
	}

}
