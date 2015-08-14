package algorithms.sort.impl;

import algorithms.pivot.Pivot;
import algorithms.sort.Sort;
import algorithms.utils.Helper;
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
		Helper.swap(b, start, picked);

		System.out.println(Arrays.toString(b));

		// Sort array
		int edge = start + 1;
		for(int index = edge; index < end; index++) {
			if (b[index].compareTo(b[start]) < 0) {
				Helper.swap(b, index, edge++);
			}
		}

		Helper.swap(b, start, --edge);

		System.out.println(Arrays.toString(b));

		sort(b, start, edge);
		sort(b, edge + 1, end);
	}

}
