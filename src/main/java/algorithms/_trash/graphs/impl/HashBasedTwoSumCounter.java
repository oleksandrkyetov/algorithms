package algorithms._trash.graphs.impl;

import algorithms._trash.graphs.TwoSumCounter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HashBasedTwoSumCounter implements TwoSumCounter {

	private long[] elements;

	@Override
	public TwoSumCounter init(final long[] elements) {
		this.elements = Arrays.copyOf(elements, elements.length);

		return this;
	}

	@Override
	public Integer count(final long min, final long max) {
		final Set<Long> set = new HashSet<>();
		int result = 0;

		for (long element : elements) {
			set.add(element);
		}

		for (long range = min; range <= max; range++) {
			for (long element : elements) {
				long number = range - element;

				if (number != element && set.contains(number)) {
					System.out.println(range);
					result++;
					break;
				}
			}
		}

		return result;
	}

}
