package algorithms.sort.impl;

import algorithms.sort.PivotPicker;
import org.springframework.stereotype.Component;

@Component
public class FirstElementPivotPicker<T extends Comparable<T>> implements PivotPicker<T> {

	@Override
	public int pick(T[] a, int start, int end) {
		return start;
	}

}
