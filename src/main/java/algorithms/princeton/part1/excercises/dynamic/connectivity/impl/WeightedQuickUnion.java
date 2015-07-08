package algorithms.princeton.part1.excercises.dynamic.connectivity.impl;

import algorithms.princeton.part1.excercises.dynamic.connectivity.DynamicConnectivity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WeightedQuickUnion<T extends Comparable<T>> implements DynamicConnectivity<T> {

	private T[] elements;
	private int[] indexes;
	private int[] size;

	@Override
	public DynamicConnectivity<T> init(T[] array) {
		this.elements = Arrays.copyOf(array, array.length);

		this.indexes = new int[elements.length];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = i;
		}

		this.size = new int[array.length];
		Arrays.fill(size, 1);

		return this;
	}

	@Override
	public DynamicConnectivity<T> union(T p, T q) {
		int pr = root(getIndex(p));
		int qr = root(getIndex(q));

		if (size[pr] < size[qr]) {
			indexes[pr] = qr;
			size[qr] += size[pr];
		} else {
			indexes[qr] = pr;
			size[pr] += size[qr];
		}

		return this;
	}

	@Override
	public boolean connected(T p, T q) {
		return root(getIndex(p)) == root(getIndex(q));
	}

	@Override
	public T[] getElements() {
		return Arrays.copyOf(elements, elements.length);
	}

	@Override
	public int[] getIndexes() {
		return Arrays.copyOf(indexes, indexes.length);
	}

	private int root(int index) {
		int i = index;
		while (i != indexes[i]) {
			i = indexes[i];
		}
		return i;
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
