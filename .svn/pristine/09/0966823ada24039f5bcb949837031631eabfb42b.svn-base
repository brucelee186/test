package 设计模式.三单例模式_Singleton;

public class Singleton {

	private Singleton singleton;

	private Singleton(){}
	
	public Singleton getSingletonIntence() {
		if (singleton == null) {
			synchronized (singleton) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}
	
}