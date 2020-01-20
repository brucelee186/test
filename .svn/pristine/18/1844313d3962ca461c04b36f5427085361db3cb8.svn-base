package 线程.问题;

public class TestInterrupt {
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					System.err.println("运行在sleep之前");
					// 停止运行1分钟
					Thread.sleep(1000*60);
					System.err.println("sleep后将无法运行");
				} catch (InterruptedException e) {
					System.err.println("执行在catch语句中");
					System.err.println(e);
				}
				System.err.println("执行在try语句后");
			}
		};
		
		// 启动线程
		t.start();
		t.interrupt();
	}
}
