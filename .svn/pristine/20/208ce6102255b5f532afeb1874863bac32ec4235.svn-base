package myjava.lang.Thread;

public class DaemonThread implements Runnable {

	@Override
	public void run() {
		do {
			System.err.println("后台线程: " + Thread.currentThread().getName() + "执行中:");
		} while (true);
	}
	
	public static void main(String[] args) {
		System.err.println("main thread execute start");
		DaemonThread daemonThread = new DaemonThread();
		//new Thread(daemonThread, "后台线程1").start();
		Thread t = new Thread(daemonThread, "后台线程2");
		t.setDaemon(true);
		t.start();
		System.err.println("main thread execute complate");
	}
}
