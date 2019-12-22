package 设计模式.三单例模式_Singleton;

public class Singleton0 {

	private static Singleton0 singleton0 = new Singleton0();
	private Singleton0() {
	}
	
	public Singleton0 getInstance() {
		return singleton0;
	}
}
