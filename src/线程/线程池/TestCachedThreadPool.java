package 线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for (int i = 1; i < 5; i++) {
			final int taskId = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 1; j < 5; j++) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.err.println("线程 " + taskId + " 第 " + j + " 次执行");
					}
				}
			});
		}
		threadPool.shutdown();
	}
}
