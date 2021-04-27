import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */
public class CompetitionDijkstra {

	Graph graph;
	int sA;
	int sB;
	int sC;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra (String filename, int sA, int sB, int sC){
		try {
			File file = new File(filename);
			Scanner scan;
			scan = new Scanner(file);
			graph = new Graph(scan.nextInt());
			this.sA = sA;
			this.sB = sB;
			this.sC = sC;
			scan.nextLine();
			scan.nextLine();
			while (scan.hasNextLine()) {
				int v = scan.nextInt();
				int e = scan.nextInt();
				double distance = scan.nextDouble();
				graph.addStreet(v, e, distance);
				if (scan.hasNextLine()) {
					scan.nextLine();
				}
			}
			scan.close();
		} catch (FileNotFoundException e) { } catch (NullPointerException e) { }
	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition() {
		if ((sA >= 50) && (sB >= 50) && (sC >= 50) && (sA <= 100) && (sB <= 100) && (sC <= 100) && (graph.numberOfIntersections() != 0)) {
			double maxDist = -1;
			int slowestSpeed = Math.min(sA, Math.min(sB, sC));
			double minDistance = -1;
			for (int i = 0; i < graph.numberOfIntersections(); i++) {
				minDistance = Dijkstra.maxDist(graph, i);
				if (minDistance == -1) {
					return -1;
				}
				maxDist = Math.max(maxDist, minDistance);
			}
			return (int) Math.ceil(maxDist * 1000 / slowestSpeed);
		}
		return -1;
	}
}
