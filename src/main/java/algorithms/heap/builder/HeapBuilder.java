package algorithms.heap.builder;

import org.springframework.stereotype.Component;

@Component
public interface HeapBuilder<T extends Comparable<T>> {

	/**
	 * @param a array to be built as a heap
	 * @return array
	 */
	public T[] build(T[] a);

}
