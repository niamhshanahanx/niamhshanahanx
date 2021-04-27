import java.util.ArrayList;

public class StreetQueue {

	ArrayList<Street> backUp;
	ArrayList<Street> queue;

	StreetQueue() {
		this.queue = new ArrayList<Street>();
		this.backUp = new ArrayList<Street>();
	}

	public void change() {
		for(int i = 0 ; i < this.backUp.size() ; i++) {

			this.queue.add(this.backUp.get(i));
		}

	}

	public int length() {

		return this.queue.size();
	}

	public Street dequeue()
	{
		Street delete = this.queue.remove(0);
		return delete;
	}

	public void enQueue(Street street) {

		if(this.queue.isEmpty()) {
			this.backUp.add(street); 
			this.queue.add(street);

		}
		else {
			for(int i = 0 ; i < this.queue.size(); i++) {
				if(street.distance() < this.queue.get(i).distance()) {
					this.queue.add(i, street);
					this.backUp.add(i, street);
					return;
				}
			}
			this.queue.add(street);
			this.backUp.add(street);
		}
	}


}
