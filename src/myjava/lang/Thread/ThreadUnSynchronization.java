package myjava.lang.Thread;

public class ThreadUnSynchronization implements Runnable {

	private int ticket = 5;
	// 同一时间一次执行三个线程,每次虚拟机只会判断同一时刻第一个线程的ticket状态,所以会存在负票的情况,因为同一时间执行了三个线程,发生了并发
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ticket > 0){
				System.err.println(Thread.currentThread().getName() + " ticket: " + ticket-- + " step: " + i);
			}
		}
	}

	public static void main(String[] args) {
		ThreadUnSynchronization tb = new ThreadUnSynchronization();
		Thread t1 = new Thread(tb, "A");
		Thread t2 = new Thread(tb, "B");
		Thread t3 = new Thread(tb, "C");
		t1.start();
		t2.start();
		t3.start();
	}
}
