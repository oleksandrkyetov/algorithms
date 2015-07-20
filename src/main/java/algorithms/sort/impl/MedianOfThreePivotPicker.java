package algorithms.sort.impl;

import algorithms.sort.PivotPicker;
import org.springframework.stereotype.Component;

@Component
public class MedianOfThreePivotPicker<T extends Comparable<T>> implements PivotPicker<T> {

	@Override
	public int pick(T[] a, int start, int end) {
		if (a[start].compareTo(a[(start + end - 1) / 2]) > 0 && a[start].compareTo(a[end - 1]) < 0
			|| a[start].compareTo(a[(start + end - 1) / 2]) < 0 && a[start].compareTo(a[end - 1]) > 0) {

			return start;
		}

		if (a[(start + end - 1) / 2].compareTo(a[start]) > 0 && a[(start + end - 1) / 2].compareTo(a[end - 1]) < 0
			|| a[(start + end - 1) / 2].compareTo(a[start]) < 0 && a[(start + end - 1) / 2].compareTo(a[end - 1]) > 0) {

			return (start + end - 1) / 2;
		}

		return end - 1;
	}

}
