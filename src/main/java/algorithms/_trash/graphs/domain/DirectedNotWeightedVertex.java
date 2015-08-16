package algorithms._trash.graphs.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * DirectedNotWeightedVertex representation
 */
public class DirectedNotWeightedVertex {

	private final int index;

	private boolean isForwardExplored;
	private boolean isReverseExplored;
	private int size;

	private List<Integer> outbounds = new ArrayList<>();
	private List<Integer> inbounds = new ArrayList<>();

	public DirectedNotWeightedVertex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public boolean isForwardExplored() {
		return isForwardExplored;
	}

	public void setForwardExplored(boolean isForwardExplored) {
		this.isForwardExplored = isForwardExplored;
	}

	public boolean isReverseExplored() {
		return isReverseExplored;
	}

	public void setReverseExplored(boolean isReverseExplored) {
		this.isReverseExplored = isReverseExplored;
	}

	public List<Integer> getOutbounds() {
		return outbounds;
	}

	public void addOutbound(Integer outbound) {
		this.outbounds.add(outbound);
	}

	public void setOutbounds(List<Integer> outbounds) {
		this.outbounds = outbounds;
	}

	public List<Integer> getInbounds() {
		return inbounds;
	}

	public void addInbound(Integer inbound) {
		this.inbounds.add(inbound);
	}

	public void setInbounds(List<Integer> inbounds) {
		this.inbounds = inbounds;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void incrementSize() {
		size++;
	}

}