package 线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/*
 * synchronized 修饰符会自动放锁,而lock需要手动放锁
 */
class Outputter {
	private Lock lock = new ReentrantLock();
	public void output(String name) {
		// 使用了lock(),本线程不会被其它线程干扰
		lock.lock();
		try {
			for (int i = 0; i < name.length(); i++) {
				System.err.println(name.charAt(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

/*
 * 读写冲突情况(无锁)
 */
class Data {
	private int data;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public synchronized void set(int data) {
		readWriteLock.writeLock().lock();
		System.err.println("CurrnetThread get read for write" + Thread.currentThread().getName());
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.writeLock().unlock();
		}
		this.data = data;
		System.err.println(Thread.currentThread().getName() + "Current thread writed " + this.data);
	}
	
	public synchronized void get() {
		readWriteLock.writeLock().lock();
		System.err.println("CurrnetThread get ready for read" + Thread.currentThread().getName());
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.writeLock().unlock();
		}
		System.err.println(Thread.currentThread().getName() + "Current thread readed " + this.data);
	}
}

class Count {
	private int num;
	public void count() {
		for (int i = 0; i < 10; i++) {
			num += i;
		}
		System.err.println("current thread: " + Thread.currentThread().getName() + " num = " + num);
	}
}
public class LockTest {
	public static void main(String[] args) {
		System.err.println("使用Lock对象实现访问对象同步  ************************************************************");
		/*final Outputter outputter = new Outputter();
		
		new Thread(){
			@Override
			public void run() {
				outputter.output("zhangsan");
			}
		}.start();
		
		new Thread() {
			public void run() {
				outputter.output("tom");
			}
		}.start();
		
		System.err.println();
		System.err.println("使用Lock对象实现访问对象同步  ************************************************************");
		final Data data = new Data();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.set(new Random().nextInt(30));
					}
				};
			}.start();
		}
		
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.get();
					}
				};
			}.start();
		}
		
		System.err.println();*/
		System.err.println("1 启动了10个线程  ************************************************************");
		Runnable runnable = new Runnable() {
			Count count = new Count();
			@Override
			public void run() {
				count.count();
			}
		};
		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
	}
}
