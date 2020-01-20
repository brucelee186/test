package 设计模式.三单例模式_Singleton;

public class Singleton3 {
	private static Singleton3 instance = null;

	private Singleton3() {
		// do something
	}

	//保证,同一时刻,只能一个线程访问,直到访问完为止
	public static synchronized Singleton3 getInstance() {
		if (instance == null) {
			instance = new Singleton3();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		//两个new的对象为一个
		@SuppressWarnings("static-access")
		Singleton3 myBean = new Singleton3().getInstance();
		@SuppressWarnings("static-access")
		Singleton3 myBean2 = new Singleton3().getInstance();
		Singleton3 myBean3 = new Singleton3();
		Singleton3 myBean4 = new Singleton3();
		System.err.println(myBean);
		System.err.println(myBean2);
		System.err.println(myBean3);
		System.err.println(myBean4);
	}
}
