
public class Street
{
	private double distance = -1;
	private Intersection beginning;
	private Intersection end;

	Street(Intersection beginning, Intersection end, double distance){

		this.beginning = beginning;
		this.end = end;
		this.distance = distance;

	}
	public double distance() {

		return distance;
	}


	public Intersection destination(){


		return end;
	}

	public Intersection origin(){

		return beginning;
	}
}
