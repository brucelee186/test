package 线程.实现线程的几种方式;

class Output2 {
	/**
	 * 锁对象,每个线程会有两个锁,一个待执行序列,一个阻塞序列,待执行序列当被cpu调度后,会获得对象锁,此时其它线程访问此对象时会被排斥不能执行直到对象锁被释放
	 * @param name
	 */
	// 加同步修饰方法之后只允许一个线程执行完成之后,另一个线程才可以执行
	protected synchronized void output(String name) {
		for (int i = 0; i < name.length(); i++) {
			System.err.print(name.charAt(i));
		}
	}
	
	protected void output2(String name) {
		// 加同步块
		// this代表本类Output2,本类的多线程访问将会被同步
		synchronized (this) {
			for (int i = 0; i < name.length(); i++) {
				System.err.print(name.charAt(i));
			}
			
		}
	}
}

public class 输出字符串加同步锁 {
	public static void main(String[] args) {
		// Cannot refer to a non-final variable output2 inside an inner class defined in a different method
		// 局部变量会在内部类执行完毕之后被回收,只有定义全局变量或最终变量才不会被回收(最终变量相当于常量,不会被改变)
		final Output2 output2 = new Output2();
		new Thread(){
			@Override
			public void run() {
//				output2.output("********************************************************************************************************");
				output2.output2("********************************************************************************************************");
			}
		}.start();
		new Thread(){
			public void run() {
//				output2.output("########################################################################################################");
				output2.output2("########################################################################################################");
			}
		}.start();
	}
}
