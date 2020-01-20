package 线程.实现线程的几种方式;

public class 输出数据加锁 {
	static volatile int i = 0, j = 0;
	
	static void caculate () {
		i++;
		j++;
	}
	
	static void output () {
		System.err.println("i = " + i + ", j= " + j);
	}
	
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					output();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					caculate();
				}
			}
		}.start();
	}
}
