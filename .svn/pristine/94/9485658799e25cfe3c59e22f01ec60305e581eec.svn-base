package 线程.练习;

import recursion.test1;

public class 模拟售票 implements Runnable{
	private String name;
	private static int ticket = 10;
	
	public 模拟售票(String name) {
		super();
		this.name = name;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (ticket >= 0) {
				System.err.println(name + " 票数余额为: " + ticket--);
			} 
			if (0 == ticket) {
				System.err.println("循环终止:" + i);
			}
			System.err.println("全局:" + i);
		}
	}
	public static void main(String[] args) {
		模拟售票 窗口1 = new 模拟售票("窗口1");
		模拟售票 窗口2 = new 模拟售票("窗口2");
		模拟售票 窗口3 = new 模拟售票("窗口3");
		Thread t1 = new Thread(窗口1);
		System.err.println(t1.isAlive());
		t1.start();
		System.err.println(t1.isAlive());
		new Thread(窗口2).start();
		new Thread(窗口3).start();
//		for (int i = 0; i < 20; i++) {
//			if (ticket >= 0) {
//				System.err.println(" 票数余额为: " + ticket--);
//			} 
//			if (0 == ticket) {
//				System.err.println("循环终止:" + i);
//				break;
//			}
//			System.err.println("全局:" + i);
//		}
	}
}
