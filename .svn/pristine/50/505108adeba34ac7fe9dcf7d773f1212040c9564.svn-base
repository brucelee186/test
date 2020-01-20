package myjava.lang.Thread;

public class ThreadForceExecute implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.err.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		ThreadForceExecute bean = new ThreadForceExecute();
		Thread t = new Thread(bean, "subThread");
		t.start();
		for (int i = 0; i < 100; i++) {
			try {
				if(i > 10){
					//中断主线和,强行执行本线程
					t.join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("main thread execute " + i + "precent");
		}
	}
}
