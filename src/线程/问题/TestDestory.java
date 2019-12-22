package 线程.问题;

public class TestDestory implements Runnable {
	static int i = 0;
	@Override
	public void run() {
		while (true) {
			System.err.println("Thread: " + Thread.currentThread().getName() + " i: " + i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		TestDestory testDestory = new TestDestory();
		Thread thread = new Thread(testDestory);
		Thread thread2 = new Thread(testDestory);
		thread.start();
		thread2.start();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// 返回当前系统中运行中的线程
		System.err.println(Thread.activeCount());
		
		
	}
}
