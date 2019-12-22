package myjava.lang.Thread;

public class ThreadJield implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.err.println(Thread.currentThread().getName() + " running " + i);
			if (i == 3) {
				System.err.println(Thread.currentThread().getName() + " is yielded");
				//将来线程交给下一线程运行
				//Thread.currentThread().yield();
			}
		}
	}

	public static void main(String[] args) {
		Thread a = new Thread(new ThreadJield(), "A thread");
		Thread b = new Thread(new ThreadJield(), "B thread");
		a.start();
		b.start();
	}
}
