package myjava.lang.Thread;

public class ThreadSleep implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ThreadSleep t = new ThreadSleep();
		Thread t1 = new Thread(t, "thread1");
		t1.start();
	}
}
