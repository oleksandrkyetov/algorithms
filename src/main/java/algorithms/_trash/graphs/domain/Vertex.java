package algorithms._trash.graphs.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertex representation
 */
public class Vertex {

	private final int index;
	private int finishingTime = 0;

	private boolean isForwardExplored;
	private boolean isReverseExplored;

	private List<Integer> outbounds = new ArrayList<>();
	private List<Integer> inbounds = new ArrayList<>();

	public Vertex(int index) {
		this.index = index;
	}

	public int getFinishingTime() {
		return finishingTime;
	}

	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
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

}