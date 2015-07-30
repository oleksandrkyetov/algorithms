package algorithms.heap;

public interface Heap<T extends Comparable<T>> {

	public Heap<T> init(T[] a);

	public Heap<T> insert(T e);

	public Heap<T> pop();

}
