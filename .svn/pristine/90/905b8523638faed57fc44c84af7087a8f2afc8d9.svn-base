package myjava.lang.Thread;

public class MainThreanAndSubThread  implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.err.println("线程名: " + Thread.currentThread().getName());
		}
	}
	/**
	 * 从执行结果来看主线程(main)与子线程无直接关系,子纯种不依赖主线程,可以执行完之后再执行再执行子线程,也可先执行子线程再执行主线程,主要由cpu分配
	 * @param args
	 */
	public static void main(String[] args) {
		MainThreanAndSubThread bean = new MainThreanAndSubThread();
		System.err.println("线程 开始");
		new Thread(bean, "线程1").start();
		new Thread(bean, "线程2").start();
		System.err.println("线程 结束");
	}
}
