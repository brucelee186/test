package 设计模式.三单例模式_Singleton;

public class Singleton1 {
	
	public Singleton1() {
		System.err.println("constructor");
	}
	
	public Singleton1(int i) {
		System.err.println(i);
	}
	private static Singleton1 singleton = null;
	// 单例模式不调用构造,不会生成多个实例,避免多个实例引起的逻辑错误
	public static synchronized Singleton1 getSingleton1(){
		if (singleton == null) {
			singleton = new Singleton1(1);
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (singleton == null) {
				getSingleton1();
			}
		}
	}
}
