package algorithms.resizable.impl;

import algorithms.resizable.Resizable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ArrayResizable<T extends Comparable<T>> implements Resizable<T> {

	private T[] elements;
	private int size;

	@Override
	public Resizable<T> init(T[] a) {
		elements = Arrays.copyOf(a, a.length);
		size = elements.length;

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
	public T set(int i, T e) {
		T element = elements[i];
		elements[i] = e;

		return element;
	}

	@Override
	public T get(int i) {
		if (size <= elements.length / 4) {
			elements = Arrays.copyOf(elements, elements.length / 2);
		}

		T element = elements[--size];
		elements[size] = null;

		return element;
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
