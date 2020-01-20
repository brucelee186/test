package myjava.lang.Thread;

public class ThreadPriority implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.err.println(Thread.currentThread().getName() + i);
		}
	}
	
	/**
	 * 实现运行效果还是cpu分配,与优先级关联不明显
	 * @param args
	 */
	public static void main(String[] args) {
		// new Thread时不加bean参数线程是不会运行的
		Thread A = new Thread(new ThreadPriority(), "A");
		Thread B = new Thread(new ThreadPriority(), "B");
		Thread C = new Thread(new ThreadPriority(), "C");
		A.setPriority(8);
		// 优先级(priority)为1-10的数字
		//t2.setPriority(0);
		B.setPriority(3);
		C.setPriority(10);
		A.start();
		B.start();
		C.start();
	}
}
