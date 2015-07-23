package algorithms.select;

public interface Select<T extends Comparable<T>> {

	T select(T[] a, int order);

}
