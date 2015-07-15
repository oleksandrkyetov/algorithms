package algorithms.inversions.counter;

public interface Counter<T extends Comparable<T>> {

	long count(T[] a);

}
