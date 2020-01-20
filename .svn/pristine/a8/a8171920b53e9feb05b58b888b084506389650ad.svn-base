package 设计模式.三单例模式_Singleton;

public class Singleton2 {
	private static Singleton2 singleton = new Singleton2();
	public Singleton2() {
		System.err.println("ok");
	}
	
	public static synchronized Singleton2 getSingleton2() {
		return singleton;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			getSingleton2();
		}
	}
}
