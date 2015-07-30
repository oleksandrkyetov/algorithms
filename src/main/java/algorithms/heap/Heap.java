package algorithms.heap;

public interface Heap<T extends Comparable<T>> {

	Heap<T> init(T[] a);

	Heap<T> add(T e);

	T poll();

	T peek();

	T[] getElements();

}
