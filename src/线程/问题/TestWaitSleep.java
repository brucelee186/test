package 线程.问题;

class ThreadTest extends Thread{
	@Override
	public void run() {
		System.err.println("ThreadTest");
	}
}

class RunnableTest implements Runnable {
	@Override
	public void run() {
		System.err.println("RunnableTest");
	}
};

// sleep不释放资源，wait释放资源
public class TestWaitSleep {
	public static void main(String[] args) {
		try {
			ThreadTest threadTest = new ThreadTest();
			threadTest.start();
			Thread thread = new Thread(new RunnableTest());
			System.err.println(thread.getState());
			thread.start();
			System.err.println(thread.getState());
			// thread.wait(1000);
			thread.sleep(1000);
			System.err.println(thread.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
