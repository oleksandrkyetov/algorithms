package algorithms.heap;

import algorithms.utils.Helper;

public final class HeapHelper {

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
			maxIndex = b[leftIndex].compareTo(b[rightIndex]) > 0 ? leftIndex : rightIndex;
		}

		if (maxIndex < b.length && b[maxIndex] != null && b[index].compareTo(b[maxIndex]) < 0) {
			// Swap greater child element with current element
			Helper.swap(b, index, maxIndex);
			// Proceed with sink
			sink(b, maxIndex);
		}
	}

}
