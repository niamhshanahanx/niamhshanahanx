import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
 * This class implements the competition using Floyd-Warshall algorithm
 */



public class CompetitionFloydWarshall {
	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */


	private int numVertices;
	private int numEdges;
	private int sA;
	private int sB;
	private int sC;
	private String filename;
	public static final double INF = Double.POSITIVE_INFINITY;

	double tableDist[][];          //table of street distances
	int tableSequence[][];         // table of shortest path intersections

	CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
		File file;
		Scanner scan;
		try {
			this.sA = sA;
			this.sB = sB;
			this.sC = sC;
			this.filename = filename;
			file = new File(filename);
			scan = new Scanner(file);
			numVertices = scan.nextInt();
			numEdges = scan.nextInt();
			createTables(scan);
			scan.close();

		}catch (FileNotFoundException e) {} catch( NullPointerException e) {}
		//TODO
	}


	public void createTables(Scanner scan) {
		tableDist = new double[numVertices][numVertices];
		for(int i = 0; i < numVertices; i++) {
			for(int j= 0; j< numVertices; j++) {
				tableDist[i][j] = INF;
			}
		}
		for(int i = 0; i < numEdges; i++) {
			int numVertices = scan.nextInt();
			int numEdges = scan.nextInt();
			double distance = scan.nextDouble();
			tableDist[numVertices][numEdges] = distance;
		}
		for (int i=0; i<numVertices; i++ ) {
			tableDist[i][i] = 0.0;
		}

		tableSequence = new int[numVertices][numVertices];
		for(int i =0;i<numVertices; i++ ) {
			for(int j = 0; j<numVertices; j++) {
				if(j==i){
					tableSequence[i][j] = 0;
				}
				else {
					tableSequence[i][j] = j;
				}
			}
		}

	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){

		if(numVertices >= 3) {
			if((sA >= 50) && (sA <= 100) && (sB >= 50) && (sB <= 100) && (sC >= 50) && (sC <= 100)) {
				findTheShortestPath();
				double maximum = 0.0;
				if(ableToReach()) {
					for(int i = 0; i < numVertices; i++) {
						for (int j = 0; j < numVertices; j++) {
							if ((tableDist[i][j] > maximum) && (tableDist[i][j] != INF)) {
								maximum = tableDist[i][j];
							}	
						}
					}
					int velocity = Math.min(sA, Math.min(sB, sC));
					return (int) Math.ceil((maximum * 1000) / velocity);

				}
			}
		}
		return -1;
	}


	private boolean ableToReach() {
		for(int i = 0; i<numVertices; i++){
			for(int j = 0; j<numVertices; j++){
				if(tableDist[i][j] == INF) {
					return false;
				}
			}
		}
		return true;
	}


	private void findTheShortestPath() {
		for(int k = 0; k<numVertices; k++) {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					if (tableDist[i][k] + tableDist[k][j] < tableDist[i][j]) {
						tableDist[i][j] = tableDist[i][k] + tableDist[k][j];
						tableSequence[i][j] = k;
					}
				}
				// TODO Auto-generated method stub
			}
		}
	}



}
