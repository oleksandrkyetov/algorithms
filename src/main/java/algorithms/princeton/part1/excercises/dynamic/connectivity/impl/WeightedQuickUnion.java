package algorithms.princeton.part1.excercises.dynamic.connectivity.impl;

import algorithms.princeton.part1.excercises.dynamic.connectivity.DynamicConnectivity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WeightedQuickUnion implements DynamicConnectivity {

	private int[] array;
	private int[] size;

	@Override
	public DynamicConnectivity init(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
		this.size = new int[array.length];
		Arrays.fill(size, 1);

		return this;
	}

	@Override
	public DynamicConnectivity union(int p, int q) {
		int pr = root(p);
		int qr = root(q);

		if (size[pr] < size[qr]) {
			array[pr] = qr;
			size[qr] += size[pr];
		} else {
			array[qr] = pr;
			size[pr] += size[qr];
		}

		return this;
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	public int[] getArray() {
		return Arrays.copyOf(array, array.length);
	}

	private int root(int element) {
		int i = element;
		while (i != array[i]) {
			i = array[i];
		}
		return i;
	}

}
