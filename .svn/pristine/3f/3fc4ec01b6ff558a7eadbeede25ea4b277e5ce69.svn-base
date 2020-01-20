package 线程.实现线程的几种方式;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable {
	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		}; 
		FutureTask<?> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		try {
			Thread.sleep(500);
			System.err.println(futureTask.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
