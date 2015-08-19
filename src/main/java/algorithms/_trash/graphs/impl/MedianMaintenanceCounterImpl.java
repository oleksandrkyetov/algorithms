package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.MedianMaintenanceCounter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

@Component
public class MedianMaintenanceCounterImpl implements MedianMaintenanceCounter {

	private int[] elements;

	@Override
	public MedianMaintenanceCounter init(int[] elements) {
		this.elements = Arrays.copyOf(elements, elements.length);

		return this;
	}

	@Override
	public Integer count() {
		final TreeSet<Integer> minHeap = new TreeSet<>(Comparator.<Integer>naturalOrder());
		final TreeSet<Integer> maxHeap = new TreeSet<>(Comparator.<Integer>reverseOrder());

		int sumOfMedians = elements[0];
		minHeap.add(elements[0]);
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] < minHeap.last()) {
				minHeap.add(elements[i]);
			} else {
				maxHeap.add(elements[i]);
			}

			if (minHeap.size() - maxHeap.size() == 2) {
				maxHeap.add(minHeap.pollLast());
			}

			if (maxHeap.size() - minHeap.size() == 2) {
				minHeap.add(maxHeap.pollLast());
			}

			if ((i / 2 + i % 2) > minHeap.size() - 1) {
				sumOfMedians += minHeap.last();
			} else {
				sumOfMedians += maxHeap.last();
			}
		}

		return sumOfMedians;
	}

}
