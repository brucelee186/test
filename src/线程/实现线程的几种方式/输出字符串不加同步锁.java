package 线程.实现线程的几种方式;

class Output {
	public void output(String name) {
		for (int i = 0; i < name.length(); i++) {
			System.err.print(name.charAt(i));
		}
	}
}

// 由于run方法是能系统(cpu)分配执行的,所以出现输出结果重叠的情况
public class 输出字符串不加同步锁 {
	public static void main(String[] args) {
		// final让局部变量变为常量
		final Output output = new Output();
		new Thread(){
			@Override
			public void run() {
				output.output("#########################################################################################");
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				output.output("******************************************************************************************");
			}
		}.start();
	}
}
