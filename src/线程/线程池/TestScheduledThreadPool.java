package 线程.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
		threadPool.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("2 second");
			}
		}, 2, TimeUnit.SECONDS);
		threadPool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("3 seconod");
			}
		}, 3, 2, TimeUnit.SECONDS);
	}
}
