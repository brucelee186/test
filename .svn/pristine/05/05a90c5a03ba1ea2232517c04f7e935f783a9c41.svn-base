package 线程.实现线程的几种方式;

public class 子线程循环10次主线程循环100次如此循环100次 {
	
	String flag = "m";
	synchronized void main() {
		// 主线程
		while (!flag.equals("m")) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 100; i++) {
			System.err.println("main: " + i);
		}
		flag = "s";
		notify();
	}
	
	synchronized void sub() {
		if (!"s".equals(flag)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		for (int i = 0; i < 10; i++) {
			System.err.println("sub: " + i);
		}
		flag = "m";
	}
	
	public static void main(String[] args) {
		final 子线程循环10次主线程循环100次如此循环100次 t = new 子线程循环10次主线程循环100次如此循环100次();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					t.main();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					t.sub();
				}
			}
		}){}.start();
	}

}
