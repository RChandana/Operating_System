package segmentation;
public class Segment {
	long size;
	String unit;
	long base;
	long limit;
	String limit_Unit;
	public Segment() {
		this.size = -1;
		this.unit = null;
		this.base = -1;
		this.limit = -1;
	}
	public void clear_All() {
		size = -1;
		unit = null;
		base = -1;
		limit = -1;
	}
