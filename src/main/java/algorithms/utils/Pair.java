package algorithms.utils;

public class Pair<L, R> {
	private final L left;
	private final R right;

	private Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	public static <L, R> Pair<L, R> of(final L left, final R right) {
		return new Pair<L, R>(left, right);
	}

	public static <L, R> Pair<L, R> from(final L left, final R right) {
		return Pair.of(left, right);
	}

	public static <L, R> Pair<L, R> from(final Pair<L, R> pair) {
		return Pair.of(pair.getLeft(), pair.getRight());
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(left) + ", " + String.valueOf(right) + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pair)) return false;

		Pair<?, ?> pair = (Pair<?, ?>) o;

		if (getLeft() != null ? !getLeft().equals(pair.getLeft()) : pair.getLeft() != null) return false;
		return !(getRight() != null ? !getRight().equals(pair.getRight()) : pair.getRight() != null);

	}

	@Override
	public int hashCode() {
		int result = getLeft() != null ? getLeft().hashCode() : 0;
		result = 31 * result + (getRight() != null ? getRight().hashCode() : 0);
		return result;
	}

}