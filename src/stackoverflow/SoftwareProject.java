package stackoverflow;

public class SoftwareProject implements Comparable<SoftwareProject> {
	String porjectID;
	double cost;
	int duration;

	public SoftwareProject(String id, double cost, int duration) {
		this.porjectID = id;
		this.cost = cost;
		this.duration = duration;
	}

	@Override
	public int compareTo(SoftwareProject rhs) {
		return Double.valueOf(this.cost).compareTo(rhs.cost);
	}
}