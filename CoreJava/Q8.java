package assignment.FinalAssignment.CoreJava;

class OddClass implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		for (int i = 1; i < 10; i++) {

			if (i % 2 != 0) {
				System.out.println(i + "Thread name:" + Thread.currentThread().getName());
			}
		}
	}

}

class EvenClass implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {

			if (i % 2 == 0) {
				System.out.println(i + "Thread name:" + Thread.currentThread().getName());
			}
		}

	}

}

public class Q8 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new EvenClass());
		Thread t2 = new Thread(new OddClass());
		t1.start();
		t2.start();

	}
}