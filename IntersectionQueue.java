import java.util.ArrayList;

public class IntersectionQueue {

	ArrayList<Intersection> queue;

	IntersectionQueue() {
		this.queue = new ArrayList<Intersection>();
	}

	public void enqueue(Intersection intersection) {
		if (this.queue.isEmpty()) {
			this.queue.add(intersection);
		}
		else {
			for(int i = 0 ; i < this.queue.size(); i++) {
				if(intersection.dist() < this.queue.get(i).dist()) {
					this.queue.add(i, intersection);
					return;
				}
			}
			this.queue.add(intersection);
		}
	}

	public Intersection dequeue() {
		return this.queue.remove(0);
	}

	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	public void updateOrder() {
		IntersectionQueue sortedQueue = new IntersectionQueue();
		for(int i = 0 ; i < this.queue.size(); i++) {
			sortedQueue.enqueue(this.queue.get(i));
		}
		this.queue = sortedQueue.queue;


	}
}
