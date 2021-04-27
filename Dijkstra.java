// to find the minimum distance

public class Dijkstra 
{
	private static double[] run(Graph graph, int source) {

		double[] dist = new double[graph.numberOfIntersections()];
		for(int i = 0 ; i < dist.length ; i++) {
			dist[i] = Double.MAX_VALUE;
		}
		dist[source] = 0;
		IntersectionQueue intersectionQueue = new IntersectionQueue();
		graph.graph(source).setDist(0);

		for(int i = 0 ; i < graph.graph().length ; i++) {
			if(i != source) graph.graph(i).resetDist();
			graph.graph(i).resetStreets();
			intersectionQueue.enqueue(graph.graph(i));
		}

		Street[] str = new Street[graph.numberOfIntersections()];
		boolean[] relaxed = new boolean[graph.numberOfIntersections()];
		for(int i = 0 ; i < relaxed.length ; i++) {
			relaxed[i] = false;
		}

		relaxInter(intersectionQueue.dequeue(), dist, str, relaxed, intersectionQueue);
		while(!intersectionQueue.isEmpty()) {
			relaxInter(intersectionQueue.dequeue(), dist, str, relaxed, intersectionQueue);
		}

		for(int i = 0 ; i < dist.length ; i++) {
			if(dist[i] == Double.MAX_VALUE) {
				return null;
			}
		}
		return dist;
	}

	private static void relaxInter(Intersection intersection, double[] dist, Street[] edgestr, boolean[] relaxed, IntersectionQueue intersectionQueue) {
		while(intersection.outgoingStreets().length() != 0) {
			relaxStr(intersection.outgoingStreets().dequeue(), dist, edgestr);
		}
		intersectionQueue.updateOrder();
		relaxed[intersection.key()] = true;
	}


	private static void relaxStr(Street str, double[] dist, Street[] edgestr) {
		if(str.destination().dist() > str.origin().dist() + str.distance()) {
			dist[str.destination().key()] = dist[str.origin().key()] + str.distance();
			str.destination().setDist(str.origin().dist() + str.distance());
			edgestr[str.destination().key()] = str;
		}
	}

	public static double maxDist(Graph graph, int source) {
		double[] minDistances = run(graph, source);
		if(minDistances == null) {
			return -1;
		}
		double minDist = Double.MIN_VALUE;
		for(int i = 0 ; i < minDistances.length ; i++) {
			if(i != source) {
				minDist = Math.max(minDist, minDistances[i]);
			}
		}
		return minDist;
	}
}
