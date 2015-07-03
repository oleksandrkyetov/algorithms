package algorithms.princeton.part1.excercises.dynamic.connectivity.impl;

import algorithms.princeton.part1.excercises.dynamic.connectivity.DynamicConnectivity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DefaultQuickFind implements DynamicConnectivity {

	private int[] array;

	@Override
	public DynamicConnectivity init(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
		return this;
	}

	@Override
	public DynamicConnectivity union(int p, int q) {
		int pi = array[p];
		int qi = array[q];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == pi) {
				array[i] = qi;
			}
		}
		return this;
	}

	@Override
	public boolean connected(int p, int q) {
		return array[p] == array[q];
	}

	@Override
	public int[] getArray() {
		return Arrays.copyOf(array, array.length);
	}

}
