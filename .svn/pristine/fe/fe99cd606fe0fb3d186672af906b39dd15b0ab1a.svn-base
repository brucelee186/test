package myjava.lang.Thread;

public class ThreadInterrpt implements Runnable {

	@Override
	public void run() {
		System.err.println("Run method starting execute");
		try {
			Thread.sleep(10000);
			System.err.println("thread complate sleep");
		} catch (InterruptedException e) {
			System.err.println("exception thread has been interrupted");;
			return;
		}
		System.err.println("thread has been stopped sucessful");
	}

	/**
	 * 执行run方法后3秒钟休睡被打断
	 * @param args
	 */
	public static void main(String[] args) {
		//new Thread(new Sleep1Second(), "show time thread").start();
		ThreadInterrpt ti = new ThreadInterrpt();
		Thread t = new Thread(ti, "thread");
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}
}
