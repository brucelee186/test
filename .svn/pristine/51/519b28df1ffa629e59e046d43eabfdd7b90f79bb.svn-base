package 线程.实现线程的几种方式;


class Count {
	// 全局变量系统会给设置默认值0或空等等
	public void count() {
		// 局部变量必须有默认值
		int num = 0;
		for (int i = 1; i <= 10; i++) num += i;
		System.err.println("threadName: " + Thread.currentThread().getName() + " num = " + num);
	}
}

public class 计算累加 {
	public static void main(String[] args) {
		// 默认输出结果连续累加
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Count count = new Count();
				count.count();
			}
		};
		for(int i = 0; i < 10; i++) new Thread(runnable).start();
	}
}
