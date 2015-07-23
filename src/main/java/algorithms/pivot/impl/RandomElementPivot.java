package algorithms.pivot.impl;

import algorithms.pivot.Pivot;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomElementPivot<T extends Comparable<T>> implements Pivot<T> {

	@Override
	public int pick(T[] a, int start, int end) {
		return new Random().nextInt(end - start) + start;
	}

}
