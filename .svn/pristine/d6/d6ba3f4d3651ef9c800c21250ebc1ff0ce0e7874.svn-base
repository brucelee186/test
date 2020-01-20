package 线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockSynchroized implements Runnable {
	static Lock lock = null;
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				System.err.println("threadName: " + Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		LockSynchroized lockSynchroized = new LockSynchroized();
		Thread t1 = new Thread(lockSynchroized);
		Thread t2 = new Thread(lockSynchroized);
		Thread t3 = new Thread(lockSynchroized);
		t1.start();
		t2.start();
		t3.start();
		lock = new ReentrantLock();
	}
}

class Synchroized implements Runnable{
	private Lock lock;
	
	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	public Synchroized(Lock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			while (true) {
				System.err.println(Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Synchroized synchroized = new Synchroized(new ReentrantLock());
		Thread thread = new Thread(synchroized);
		Thread thread2 = new Thread(synchroized);
		Thread thread3 = new Thread(synchroized);
		thread.start();
		thread2.start();
		thread3.start();
	}
}

class ReadWriteLock implements Runnable {
	
	private int state;
	private String threadName;
	static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	

	public ReadWriteLock(int state, String threadName) {
		super();
		this.state = state;
		this.threadName = threadName;
	}
	@Override
	public void run() {
		while (true) {
			if (state == 1) {
				ReentrantReadWriteLock.ReadLock readLock = null;
				try {
					readLock = lock.readLock();
					readLock.lock();
					System.err.println("readLock: " + Thread.currentThread().getName());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					readLock.unlock();
				}
			} else {
				ReentrantReadWriteLock.WriteLock writeLock = null;
				try {
					writeLock = lock.writeLock();
					writeLock.lock();
					System.err.println("writeLock: " + Thread.currentThread().getName());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					writeLock.unlock();
				}
			}
		}
	}
	public static void main(String[] args) {
		ReadWriteLock readWriteLock = new ReadWriteLock(0, "thread1");
		ReadWriteLock readWriteLock2 = new ReadWriteLock(0, "thread2");
//		ReadWriteLock readWriteLock3 = new ReadWriteLock(1, "thread3");
		new Thread(readWriteLock).start();
		new Thread(readWriteLock2).start();
//		new Thread(readWriteLock3).start();
	}
}