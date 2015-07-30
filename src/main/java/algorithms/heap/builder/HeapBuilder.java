package algorithms.heap.builder;

import algorithms.resizable.Resizable;
import org.springframework.stereotype.Component;

@Component
public interface HeapBuilder<T extends Comparable<T>> {

	/**
	 * Mutator method
	 * @param a array to be built as a heap
	 * @return array
	 */
	T[] build(T[] a);

	/**
	 * Mutator method
	 * @param r {@link Resizable} array to be built as a heap
	 * @return {@link Resizable}
	 */
	Resizable<T> build(Resizable<T> r);

}
