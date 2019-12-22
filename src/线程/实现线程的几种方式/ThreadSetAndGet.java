package 线程.实现线程的几种方式;

import java.util.ArrayList;
import java.util.List;

// friendly 或 default 包内任何类,或包外的继承类才可以访问
class Plate {
	List<Object> objectList = new ArrayList<>();
	synchronized void setObject() {
		Object object = null;
		while (objectList.size() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		object = new Object();
		objectList.add(object);
		System.err.println("放入对象: " + object);
		// 让其它线种处于可被执行状态, 否则会出现互锁现象，本对象锁没有释放，其它对象无法访问本对象
		this.notify();
	}
	
	synchronized void getObject() {
		Object object = null;
		while (objectList.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		object = objectList.get(0);
		objectList.clear();
		System.err.println("取出对象: " + object);
		// 让其它线种处于可被执行状态, 否则会出现互锁现象，其它对象无法访问本对象
		// notifyall唤醒对当前对象操作的所有线程,而notify只唤醒一个对当前对象执行的线程
		notifyAll();
	}
}

/**
 * 流程: 假设最先运行的是set线程,第一运行判断list为空,添加一个object,并唤醒阻塞线程,假设这时候又运行了set线程,那么此时objectList.size会大于零,并处于阻塞状态,此时get线程运行,并清空list和唤醒所有线程
 * @author admin
 *
 */
public class ThreadSetAndGet {
	static Object object = new Object();
	public static void main(String[] args) {
		final Plate plate = new Plate();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					plate.setObject();
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					plate.getObject();
				}
			}
		}.start();
	}
}
