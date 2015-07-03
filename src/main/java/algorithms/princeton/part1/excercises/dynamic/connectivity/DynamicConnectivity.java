package algorithms.princeton.part1.excercises.dynamic.connectivity;

public interface DynamicConnectivity {

	DynamicConnectivity init(int[] array);

	DynamicConnectivity union(int p, int q);

	boolean connected(int p, int q);

	int[] getArray();

}
