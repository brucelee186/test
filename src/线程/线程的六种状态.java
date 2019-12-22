package 线程;

public class 线程的六种状态 {
	public static void main(String[] args) {
		try {
			ThreadState threadState = new ThreadState();
			Thread thread = new Thread(threadState);
			System.err.println(thread.getState());;
			thread.start();
			System.err.println(thread.getState());
			Thread.sleep(100);
			System.err.println(thread.getState());
			Thread.sleep(1000);
			System.err.println(thread.getState());
			threadState.notifyWait();
			System.err.println(thread.getState());
			Thread.sleep(1000);
			System.err.println(thread.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadState implements Runnable {
	public void run() {
		try {
			waitForASecond();
			waitForEver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void waitForASecond() throws Exception{
		wait(1000);
	}
	
	public synchronized void waitForEver () throws Exception {
		wait();
	}
	
	public synchronized void notifyWait() {
		notify();
	}
}