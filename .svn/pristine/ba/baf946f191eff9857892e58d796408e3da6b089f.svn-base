package 线程;


public class 测试线程中的方法 implements Runnable {
	static int n = 0;
	@Override
	public void run() {
		int m = n;
		//Thread.yield();
		m ++ ;
		n = m;
		System.err.println("n = " + 测试线程中的方法.n);
	}
	
	public static void main(String[] args) {
		try {
			测试线程中的方法 myThread = new 测试线程中的方法();
			Thread[] arrayThread = new Thread[100];
			for (int i = 0; i < 100; i++) arrayThread[i] = new Thread(myThread);
			for (int i = 0; i < 100; i++) arrayThread[i].start();
//			for (int i = 0; i < 100; i++) arrayThread[i].join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
