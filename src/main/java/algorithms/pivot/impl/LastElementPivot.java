package algorithms.pivot.impl;

import algorithms.pivot.Pivot;
import org.springframework.stereotype.Component;

@Component
public class LastElementPivot<T extends Comparable<T>> implements Pivot<T> {

	@Override
	public int pick(T[] a, int start, int end) {
		return end - 1;
	}

}
