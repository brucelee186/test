package 线程.练习;

import recursion.test1;

public class 继承Thread类 extends Thread{
	private String a;
	
	public 继承Thread类(String a) {
		super();
		this.a = a;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.err.println(a + " : " + i);
		}
	}
	public static void main(String[] args) {
		Thread t0 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.err.println("t0: " + i);
				}
			}
		},"t0");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.err.println("t1: " + i);
				}
			}
		}, "t1");
//		t0.start();
//		t1.start();
		继承Thread类 a = new 继承Thread类("A");
		继承Thread类 b = new 继承Thread类("B");
		a.start();
		b.start();
	}
}
