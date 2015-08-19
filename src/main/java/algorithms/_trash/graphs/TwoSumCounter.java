package algorithms._trash.graphs;

public interface TwoSumCounter {

	/**
	 *
	 * @param elements
	 * @return
	 */
	TwoSumCounter init(final long[] elements);

	/**
	 *
	 * @param min inclusive
	 * @param max inclusive
	 * @return
	 */
	Integer count(final long min, final long max);

}
