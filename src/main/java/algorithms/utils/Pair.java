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

}