package algorithms.pivot.impl;

import algorithms.pivot.Pivot;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MedianOfThreePivot<T extends Comparable<T>> implements Pivot<T> {

	private static final int LENGTH = 3;

	@Override
	public int pick(T[] a, int start, int end) {
		final Pair<Integer, T>[] b = (Pair<Integer, T>[]) new Pair[LENGTH];
		b[0] = Pair.of(start, a[start]);
		b[1] = Pair.of((start + end) / 2, a[(start + end) / 2]);
		b[2] = Pair.of(end - 1, a[end - 1]);

		Arrays.sort(b, 0, LENGTH, (Pair<Integer, T> p1, Pair<Integer, T> p2) -> p1.getRight().compareTo(p2.getRight()));

		return b[1].getLeft() - start;
	}

}
