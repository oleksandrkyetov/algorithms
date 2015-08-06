package algorithms._trash.graphs.domain;

public class VertexBuilder {

	private final Vertex vertex;

	VertexBuilder() {
		vertex = new Vertex();
	}

	public VertexBuilder withExplored(boolean explored) {
		vertex.setExplored(explored);

		return this;
	}

	public VertexBuilder withFinishingTime(long finishingTime) {
		vertex.setFinishingTime(finishingTime);

		return this;
	}

	public VertexBuilder withPointsTo(long pointsTo) {
		vertex.setPointsTo(pointsTo);

		return this;
	}

	public Vertex build() {
		return vertex;
	}

}