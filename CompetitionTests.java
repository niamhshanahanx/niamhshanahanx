import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;


public class CompetitionTests {



	@Test
	public void testDijkstraConstructor() {
		int expectedResult = 31;
		CompetitionDijkstra competition1 = new CompetitionDijkstra("tinyEWD.txt", 90, 80, 60);
		assertEquals(competition1.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition2 = new CompetitionDijkstra("tinyEWD.txt", 90, 60, 70);
		assertEquals(competition2.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition3 = new CompetitionDijkstra("tinyEWD.txt", 90, 90, 60);
		assertEquals(competition3.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition4 = new CompetitionDijkstra("tinyEWD.txt", 100, 90, 60);
		assertEquals(competition4.timeRequiredforCompetition(), expectedResult);
		expectedResult = -1;
		 
		//TODO
	}

	@Test
	public void testFWConstructor() {
		int expectedResult = 31;
		CompetitionFloydWarshall competition1 = new CompetitionFloydWarshall("tinyEWD.txt", 60, 70, 80);
		assertEquals(competition1.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition2 = new CompetitionFloydWarshall("tinyEWD.txt", 80, 70, 60);
		assertEquals(competition2.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition3 = new CompetitionFloydWarshall("tinyEWD.txt", 70, 60, 90);
		assertEquals(competition3.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition4 = new CompetitionFloydWarshall("\"tinyEWD.txt", 100, 90, 60);
		assertEquals(competition4.timeRequiredforCompetition(), expectedResult);
		expectedResult = -1;
		
	}
	@Test
	public void testSpeedsCompetitionFW() {
		int expectedResult = -1;
		CompetitionFloydWarshall competition1 = new CompetitionFloydWarshall("tinyEWD.txt", 0, 50, 50);
		assertEquals(competition1.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition2 = new CompetitionFloydWarshall("tinyEWD.txt", 100, 0, 100);
		assertEquals(competition2.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition3 = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 0);
		assertEquals(competition3.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition4 = new CompetitionFloydWarshall("tinyEWD.txt", 101, 90, 90);
		assertEquals(competition4.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition5 = new CompetitionFloydWarshall("tinyEWD.txt", 90, 101, 90);
		assertEquals(competition5.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition6 = new CompetitionFloydWarshall("tinyEWD.txt", 90, 60, 101);
		assertEquals(competition6.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition7 = new CompetitionFloydWarshall("tinyEWD.txt", 90, 40, 0);
		assertEquals(competition7.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition8 = new CompetitionFloydWarshall("tinyEWD.txt", 40, 80, 40);
		assertEquals(competition8.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition9 = new CompetitionFloydWarshall("tinyEWD.txt", 40, 40, 90);
		assertEquals(competition9.timeRequiredforCompetition(), expectedResult);
		CompetitionFloydWarshall competition10 = new CompetitionFloydWarshall("tinyEWD.txt", 0, 0, 0);
		assertEquals(competition10.timeRequiredforCompetition(), expectedResult);

	}
	//TODO - more tests

	@Test
	public void testSpeedsCompetitionDijkstra() {
		int expectedResult = -1;
		CompetitionDijkstra competition1 = new CompetitionDijkstra("tinyEWD.txt", 0, 50, 50);
		assertEquals(competition1.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition2 = new CompetitionDijkstra("tinyEWD.txt", 100, 0, 100);
		assertEquals(competition2.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition3 = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 0);
		assertEquals(competition3.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition4 = new CompetitionDijkstra("tinyEWD.txt", 101, 90, 90);
		assertEquals(competition4.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition5 = new CompetitionDijkstra("tinyEWD.txt", 90, 101, 90);
		assertEquals(competition5.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition6 = new CompetitionDijkstra("tinyEWD.txt", 90, 60, 101);
		assertEquals(competition6.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition7 = new CompetitionDijkstra("tinyEWD.txt", 90, 40, 0);
		assertEquals(competition7.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition8 = new CompetitionDijkstra("tinyEWD.txt", 40, 80, 40);
		assertEquals(competition8.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition9 = new CompetitionDijkstra("tinyEWD.txt", 40, 40, 90);
		assertEquals(competition9.timeRequiredforCompetition(), expectedResult);
		CompetitionDijkstra competition10 = new CompetitionDijkstra("tinyEWD.txt", 0, 0, 0);
		assertEquals(competition10.timeRequiredforCompetition(), expectedResult);

	} 


	@Test
	public void testNulls() {
		assertEquals(null, new CompetitionDijkstra(null, 50, 60, 70).graph);
		assertEquals(null, new CompetitionDijkstra("", 50, 60, 70).graph);
		assertArrayEquals(null, new CompetitionFloydWarshall("", 50, 60, 70).tableDist);
		assertArrayEquals(null, new CompetitionFloydWarshall(null, 50, 60, 70).tableDist);
	}

}
