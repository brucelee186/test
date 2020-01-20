package 线程.问题;

public class TestWaitSleep2 implements Runnable {
	int number = 10;
	@Override
	public void run() {
		try {
			method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// run方法调用的方法相对与普通方法会后执行
	private void method1() throws Exception {
		synchronized (this) {
			number += 100;
			System.err.println("method1 = " + number);
		}
	}
	
	// 线程的普通方法会被先执行
	private void method2() throws Exception {
		synchronized (this) {
			// 占用当前线程资源,其它线程无法访问,抢占资源
			Thread.sleep(2000);
			// 不占用当前资源,其它线程可以继续访问本资源
			//this.wait(2000);
			number += 200;
			System.err.println("mehtod2 = " + number);
		}
	}
	
	public static void main(String[] args) throws Exception {
		TestWaitSleep2 testWaitSleep2 = new TestWaitSleep2();
		Thread thread = new Thread(testWaitSleep2);
		thread.start();
		//thread.interrupt();
		//System.err.println("interrupt");
		testWaitSleep2.method2();
	}
}
