package 线程.实现线程的几种方式;

public class 输出数字不加锁 {
	static int i=0,j=0;
	static void caculate() {
		i++;
		j++;
	}
	
	static void output() {
		System.err.println("i = " + i + ", j = " + j);
	}
	
	/**
	 * 在实际运行过程中会发生i = 8, j = 30,这是因为计算方法在没有执行完成时,输出方法就调用了执行方法,会造成j比i大的情况
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					output();
				}
			}
		}.start();
		
		//final 输出数字不加锁 c = new 输出数字不加锁();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					caculate();
				}
			}
		}.start();
		
	}
}
