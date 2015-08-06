package algorithms._trash.graphs.domain;

/**
 * Vertex representation
 */
public class Vertex {

	private boolean explored = false;
	private long finishingTime = -1;
	/**
	 * Where current points to
	 * In another words tail of the current vertex
	 */
	private long pointsTo = -1;

	Vertex() { }

	public boolean isExplored() {
		return explored;
	}

	void setExplored(boolean explored) {
		this.explored = explored;
	}

	public long getFinishingTime() {
		return finishingTime;
	}

	void setFinishingTime(long finishingTime) {
		this.finishingTime = finishingTime;
	}

	public long getPointsTo() {
		return pointsTo;
	}

	void setPointsTo(long pointsTo) {
		this.pointsTo = pointsTo;
	}

	public static VertexBuilder builder() {
		return new VertexBuilder();
	}

}