package algorithms.sort;

public interface Pivot<T extends Comparable<T>> {

	/**
	 * Pick a pivot index
	 * @param a array to process
	 * @return index of picked pivot in the array
	 */
	int pick(T[] a, int start, int end);

}
