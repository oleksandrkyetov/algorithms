package algorithms.partition;

public interface Partition<T extends Comparable<T>> {

	/**
	 * Partition array into two half
	 * @param a array to partition
	 * @return partitioned copy of the array
	 */
	T[] partition(T[] a);

}
