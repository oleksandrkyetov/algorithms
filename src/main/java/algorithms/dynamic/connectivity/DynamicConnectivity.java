package algorithms.dynamic.connectivity;

public interface DynamicConnectivity<T extends Comparable<T>> {

	DynamicConnectivity<T> init(T[] a);

	DynamicConnectivity<T> union(T p, T q);

	boolean connected(T p, T q);

	T[] getElements();

	int[] getIndexes();

}
