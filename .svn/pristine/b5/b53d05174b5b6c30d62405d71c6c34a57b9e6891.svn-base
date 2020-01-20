package 线程.问题;


public class 设计4个线程其中两个线程每次对j增加1另外两个线程对j每次减少1写出程序 {	
	static int j = 0;
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					while (true) {
						j = j + 1;
						System.err.println("thread: " + Thread.currentThread().getName() + " j = " + j);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}	
				}
			}
		}, "t1").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					while (true) {
						j = j + 1;
						System.err.println("thread: " + Thread.currentThread().getName() + " j = " + j);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, "t2").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					while (true) {
						j = j - 1;
						System.err.println("thread: "
								+ Thread.currentThread().getName() + " j = "
								+ j);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, "t3").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					while (true) {
						j = j - 1;
						System.err.println("thread: " + Thread.currentThread().getName() + " j = " + j);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, "t4").start();
	}
}
