package algorithms.dynamic.connectivity.impl;

import algorithms.dynamic.connectivity.DynamicConnectivity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DefaultQuickFind<T extends Comparable<T>> implements DynamicConnectivity<T> {

	private int[] indexes;
	private T[] elements;

	@Override
	public DynamicConnectivity<T> init(T[] a) {
		elements = Arrays.copyOf(a, a.length);

		indexes = new int[elements.length];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = i;
		}

		return this;
	}

	@Override
	public DynamicConnectivity<T>  union(T p, T q) {
		int pi = getIndex(p);
		int qi = getIndex(q);
		for (int i = 0; i < indexes.length; i++) {
			if (indexes[i] == pi) {
				indexes[i] = qi;
			}
		}

		return this;
	}

	@Override
	public boolean connected(T p, T q) {
		return indexes[getIndex(p)] == indexes[getIndex(q)];
	}

	@Override
	public T[] getElements() {
		return Arrays.copyOf(elements, elements.length);
	}

	@Override
	public int[] getIndexes() {
		return Arrays.copyOf(indexes, indexes.length);
	}

	private int getIndex(T element) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(element)) {
				return indexes[i];
			}
		}

		throw new IllegalArgumentException("No such element in the array: " + element + " ...");
	}

}
