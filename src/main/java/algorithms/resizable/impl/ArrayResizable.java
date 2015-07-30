package algorithms.resizable.impl;

import algorithms.resizable.Resizable;
import algorithms.utils.Helper;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ArrayResizable<T extends Comparable<T>> implements Resizable<T> {

	private T[] elements;
	private int size;

	@Override
	public Resizable<T> init(T[] a) {
		elements = Arrays.copyOf(a, a.length * 2);
		size = a.length;

		return this;
	}

	@Override
	public Resizable<T> add(T e) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}

		elements[size++] = e;

		return this;
	}

	@Override
	public T remove(int i) {
		T element = elements[i];

		// Shrink size
		int capacity = elements.length;
		if (size <= capacity / 4) {
			capacity = capacity / 2;
		}

		// Copy array
		T[] tmp = Arrays.copyOf(elements, capacity);
		for (int k = 0; k < size - 1 ; k++) {
			tmp[k] = elements[k < i ? k : k + 1];
		}
		elements = tmp;

		size--;
		return element;
	}

	@Override
	public T set(int i, T e) {
		T element = elements[i];
		elements[i] = e;

		return element;
	}

	@Override
	public T get(int i) {
		return elements[i];
	}

	@Override
	public Resizable<T> swap(int i, int j) {
		Helper.swap(elements, i, j);

		return this;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getCapacity() {
		return elements.length;
	}

	@Override
	public T[] getElements() {
		return Arrays.copyOf(elements, size);
	}

}
