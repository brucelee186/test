package myjava.lang.Thread;

public class ThreadSynchroized implements Runnable {

	private int ticket = 5;
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// 同一时间只会执行一个线程
			synchronized (this) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(ticket > 0) {
					System.err.println(Thread.currentThread().getName() + " step: " + i + " ticketNO: " + ticket--);
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreadSynchroized tb = new ThreadSynchroized();
		Thread t1 = new Thread(tb, "A");
		Thread t2 = new Thread(tb, "B");
		Thread t3 = new Thread(tb, "C");
		t1.start();
		t2.start();
		t3.start();
	}
}
