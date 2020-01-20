package 线程.练习;



public class 线程的强制执行 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("线程:" + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		线程的强制执行 线程的强制执行 = new 线程的强制执行();
		Thread 子线程 = new Thread(线程的强制执行, "子线程");
		子线程.start();
		for (int i = 0; i < 50; ++i) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i > 10) {
				try {
					子线程.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.err.println("主线程执行: " + i);
		}
	}
}
