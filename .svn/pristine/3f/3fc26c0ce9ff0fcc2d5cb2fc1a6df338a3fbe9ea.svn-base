package 线程.实现线程的几种方式;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableAndFuture {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		});
		try {
			Thread.sleep(500);
			System.err.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
