package algorithms.resizable;

public interface Resizable<T extends Comparable<T>> {

	public Resizable<T> init(T[] a);

	public Resizable<T> add(T e);

	public T set(int i, T e);

	public T get(int i);

	public int getSize();

	public int getCapacity();

	public T[] getElements();

}
