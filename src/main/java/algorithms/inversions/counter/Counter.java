package algorithms.inversions.counter;

public interface Counter<T extends Comparable<T>> {

	int count(T[] a);

}
