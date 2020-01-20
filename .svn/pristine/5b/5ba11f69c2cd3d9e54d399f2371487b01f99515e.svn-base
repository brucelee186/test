package 线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 5; i++) {
			// 局部变量在本次方法(循环)执行完,会自动回收,全部变量虽然不被回收,但会被更改值,也就是最后执行循环的时候赋的是最终的值,而无法把每个i的值都赋到run方法中,
			// 此时只有通过final定义的不可变更变量,才会在方法不执行完不回收,每次都可以赋值为不同的最终变量值,final的特点是在run方法中不会被改变,而全局变量只会显示最终赋值的值
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
						System.err.println("第 " + taskId + " 个任务(线程)的的第 " + j + " 次执行");
					}
				}
			});
		}
		threadPool.shutdown();
	}
}
