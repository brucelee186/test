package 线程.问题;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	private Lock lock = new ReentrantLock();
	
	public void testLock() {
		lock.lock();
		try {
			System.err.println("testLock");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		TestLock testLock = new TestLock();
		testLock.testLock();
	}
}
