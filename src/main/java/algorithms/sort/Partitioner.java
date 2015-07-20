package algorithms.sort;

public interface Partitioner<T> {

	/**
	 * Does in place partitioning for quick sort
	 * Details of partitioning depends on implementation
	 */
	T[] partition(T[] a);

}
