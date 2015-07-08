package algorithms.princeton.part1.excercises.dynamic.connectivity;

public interface DynamicConnectivity<T extends Comparable<T>> {

	DynamicConnectivity<T> init(T[] array);

	DynamicConnectivity<T> union(T p, T q);

	boolean connected(T p, T q);

	T[] getElements();

	int[] getIndexes();

}
