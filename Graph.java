
public class Graph {

	private Intersection[] graph;
	private int numberOfIntersections = -1;

	public void addStreet(int originKey, int destinationKey, double dis) {
		graph[originKey].addStreet(graph[destinationKey], dis);

	}


	public Intersection[] graph() {

		return graph;
	}

	public Intersection graph(int i) {

		return this.graph[i];
	}

	public int numberOfIntersections() {

		return numberOfIntersections;
	}

	Graph(int numberofIntersections) {
		this.numberOfIntersections = numberofIntersections;
		graph = new Intersection[numberofIntersections];
		for(int i = 0 ; i < numberOfIntersections ; i++) {
			graph[i] = new Intersection(i);
		}
	}

}
