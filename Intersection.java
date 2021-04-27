
public class Intersection {

	private StreetQueue outgoingStreets;
	private int key;
	private double dist = Double.MAX_VALUE;

	Intersection(int key) {
		this.key = key;
		outgoingStreets = new StreetQueue();
	}

	public double dist() {
		return dist;
	}

	public void setDist(double newVal) {
		this.dist = newVal;
	}

	public void resetDist() {
		this.dist = Double.MAX_VALUE;
	}

	public int key() {
		return key;
	}

	public StreetQueue outgoingStreets() {
		return outgoingStreets;
	}

	public void addStreet(Intersection destination, double distance) {
		outgoingStreets.enQueue(new Street(this, destination, distance));
	}

	public void resetStreets() {
		this.outgoingStreets.change();
	}
}
