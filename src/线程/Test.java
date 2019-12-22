package 线程;

public class Test {
	public static void main(String[] args) {
		Factory factory = new Factory();
		T1 t1 = new T1(factory);
		T2 t2 = new T2(factory);
		Thread thread1 = new Thread(t1,"增加线程1");
		Thread thread2 = new Thread(t1,"增加线程2");
		Thread thread3 = new Thread(t2,"减少线程3");
		Thread thread4 = new Thread(t2,"减少线程4");
//		thread1.start();
//		thread2.start();
		thread3.start();
		thread4.start();
	}
}
