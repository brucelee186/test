package 线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 4; i++) {
			final int threadId = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 4; j++) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.err.println("thread " + threadId + " execute " + j);
					}
				}
			});
		}
	}
}
