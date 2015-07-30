package algorithms.utils;

public final class Helper {

	public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static <T extends Comparable<T>> boolean greater(T[] array, int i, int j) {
		return array[i].compareTo(array[j]) > 0;
	}

	public static <T extends Comparable<T>> boolean greater(T e1, T e2) {
		return e1.compareTo(e2) > 0;
	}

	public static <T extends Comparable<T>> boolean less(T[] array, int i, int j) {
		return array[i].compareTo(array[j]) < 0;
	}

	public static <T extends Comparable<T>> boolean less(T e1, T e2) {
		return e1.compareTo(e2) < 0;
	}

	public static boolean even(int i) {
		return i % 2 == 0;
	}

	public static boolean odd(int i) {
		return i % 2 != 0;
	}

}
