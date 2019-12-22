package 线程;

public class 线程的定义 extends Thread {

	@Override
	public void run() {
		System.err.println("自动执行");
	}
	
	// 重载
	public void run(int i) {
		System.err.println("重载的方法不自动执行");
	}
	
	public static void main(String[] args) {
		线程的定义 defining = new 线程的定义();
		defining.start();
	}
}
