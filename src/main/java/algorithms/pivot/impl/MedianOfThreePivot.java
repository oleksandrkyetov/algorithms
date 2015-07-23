package algorithms.pivot.impl;

import algorithms.pivot.Pivot;
import algorithms.utils.Pair;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class MedianOfThreePivot<T extends Comparable<T>> implements Pivot<T> {

	@Override
	public int pick(T[] a, int start, int end) {
		final List<Pair<Integer, T>> list = ImmutableList.<Pair<Integer, T>>builder()
			.add(Pair.of(start, a[start]))
			.add(Pair.of((start + end - 1) / 2, a[(start + end - 1) / 2]))
			.add(Pair.of(end - 1, a[end - 1])).build();

		return Ordering.from(new Comparator<Pair<Integer, T>>() {
			@Override
			public int compare(Pair<Integer, T> p1, Pair<Integer, T> p2) {
				return p1.getRight().compareTo(p2.getRight());
			}
		}).immutableSortedCopy(list).get(1).getLeft();
	}

}
