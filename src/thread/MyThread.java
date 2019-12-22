package thread;

public class MyThread extends Thread {
	int i = 0;
	public void run() {
		System.err.println(i);
		i++;
	}
}

class MyThread2 implements Runnable{
	int j = 0;
	public void run() {
		System.err.println(j++);
	}
	
}

class TestThread {
	public static void main(String[] args) {
		try {
			//MyThread thread = new MyThread();
			MyThread2 thread = new MyThread2();
			
			for (int i = 0; i < 10; i++) {
				thread.run();
				System.err.println(thread);
				
			}
			thread.wait();
			System.err.println("wait");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
