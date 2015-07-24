package algorithms.pivot.impl;

import algorithms.pivot.Pivot;
import algorithms.utils.Pair;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MedianOfMediansPivot<T extends Comparable<T>> implements Pivot<T> {

	private static final int LENGTH = 5;

	@Override
	public int pick(T[] a, int start, int end) {
		final Pair<Integer, T>[] b = (Pair<Integer, T>[]) new Pair[end - start];
		for (int i = start; i < end; i++) {
			b[i - start] = Pair.of(i, a[i]);
		}

		return pick(b, LENGTH);
	}

	private int pick(Pair<Integer, T>[] b, int length) {
		if (b.length <= length) {
			Arrays.sort(b, 0, Math.min(length, b.length),
					(Pair<Integer, T> p1, Pair<Integer, T> p2) -> p1.getRight().compareTo(p2.getRight()));

			return b[b.length / 2].getLeft();
		}

		final Pair<Integer, T>[] c = (Pair<Integer, T>[]) new Pair[(int) Math.ceil((double) b.length / length)];
		for (int i = 0; i < b.length; i += length) {
			Arrays.sort(b, i, Math.min(i + length, b.length),
					(Pair<Integer, T> p1, Pair<Integer, T> p2) -> p1.getRight().compareTo(p2.getRight()));
			c[i / length + i % length] = b[(Math.min(i + length, b.length) + i) / 2];
		}

		return pick(c, length);
	}

}
