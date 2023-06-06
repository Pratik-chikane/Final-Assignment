package assignment.FinalAssignment.CoreJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Producer implements Runnable {

	public final Queue<Integer> queue;
	public final int maxCapacity;

	public Producer(Queue<Integer> queue, int maxCapacity) {
		super();
		this.queue = queue;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (true) {

			synchronized (queue) {
				if (queue.size() == maxCapacity) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int number = random.nextInt(100);
				queue.add(number);
				System.out.println("Produced: " + number);

				queue.notify();

				try {
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}

class Consumer implements Runnable {
	private final Queue<Integer> queue;
	private final int maxCapacity;

	public Consumer(Queue<Integer> queue, int maxCapacity) {
		this.queue = queue;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				// Wait if the queue is empty
				while (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Retrieve a number from the queue and calculate the sum
				int number = queue.poll();
				int sum = calculateSum();

				System.out.println("Consumed: " + number);
				System.out.println("Sum: " + sum);

				// Notify the producer thread
				queue.notify();

				// Sleep for a random interval
				try {
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private int calculateSum() {
		int sum = 0;
		for (int num : queue) {
			sum += num;
		}
		return sum;
	}
}

public class Q9 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		int maxCapacity = 10;

		Thread producerThread = new Thread(new Producer(queue, maxCapacity));
		Thread consumerThread = new Thread(new Consumer(queue, maxCapacity));

		// Start the threads
		producerThread.start();
		consumerThread.start();
	}

}