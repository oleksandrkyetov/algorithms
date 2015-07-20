package algorithms.sort;

public interface Partitioner<T extends Comparable<T>> {

	/**
	 * Partition array into two half
	 * @param a array to partition
	 * @return partitioned copy of the array
	 */
	T[] partition(T[] a);

}
