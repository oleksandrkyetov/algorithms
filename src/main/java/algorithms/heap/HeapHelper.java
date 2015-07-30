package algorithms.heap;

import algorithms.resizable.Resizable;
import algorithms.utils.Helper;

public final class HeapHelper {

	/**
	 * Mutator method
	 * @param b
	 * @param index
	 * @param <T>
	 */
	public static <T extends Comparable<T>> void sink(T[] b, int index) {
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;

		// Define max child and its index
		int maxIndex;
		if (leftIndex > b.length - 1 || b[leftIndex] == null) {
			maxIndex = rightIndex;
		} else if (rightIndex > b.length - 1 || b[rightIndex] == null) {
			maxIndex = leftIndex;
		} else {
			maxIndex = Helper.greater(b[leftIndex], b[rightIndex]) ? leftIndex : rightIndex;
		}

		if (maxIndex < b.length && b[maxIndex] != null && Helper.less(b[index], b[maxIndex])) {
			// Swap greater child element with current element
			Helper.swap(b, index, maxIndex);
			// Proceed with sink
			sink(b, maxIndex);
		}
	}

	/**
	 * Mutator method
	 * @param r
	 * @param index
	 * @param <T>
	 */
	public static <T extends Comparable<T>> void sink(Resizable<T> r, int index) {
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;

		// Define max child and its index
		int maxIndex;
		if (leftIndex > r.getSize() - 1 || r.get(leftIndex) == null) {
			maxIndex = rightIndex;
		} else if (rightIndex > r.getSize() - 1 || r.get(rightIndex) == null) {
			maxIndex = leftIndex;
		} else {
			maxIndex = Helper.greater(r.get(leftIndex), r.get(rightIndex)) ? leftIndex : rightIndex;
		}

		if (maxIndex < r.getSize() && r.get(maxIndex) != null && Helper.less(r.get(index), r.get(maxIndex))) {
			// Swap greater child element with current element
			r.swap(index, maxIndex);
			// Proceed with sink
			sink(r, maxIndex);
		}
	}

	/**
	 * Mutator method
	 * @param b
	 * @param index
	 * @param <T>
	 */
	public static <T extends Comparable<T>> void swim(T[] b, int index) {
		int parentIndex = Helper.odd(index) ? (index - 1) / 2 : (index - 2) / 2;

		if (parentIndex > -1 && Helper.greater(b[index], b[parentIndex])) {
			// Swap smaller parent element with current element
			Helper.swap(b, index, parentIndex);
			// Proceed with swim
			swim(b, parentIndex);
		}
	}

	/**
	 * Mutator method
	 * @param r
	 * @param index
	 * @param <T>
	 */
	public static <T extends Comparable<T>> void swim(Resizable<T> r, int index) {
		int parentIndex = Helper.odd(index) ? (index - 1) / 2 : (index - 2) / 2;

		if (parentIndex > -1 && Helper.greater(r.get(index), r.get(parentIndex))) {
			// Swap smaller parent element with current element
			r.swap(index, parentIndex);
			// Proceed with swim
			swim(r, parentIndex);
		}
	}

}
