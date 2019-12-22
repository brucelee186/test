package 设计模式.三单例模式_Singleton;

public class SingletonEnd {
	private SingletonEnd singletonEnd = null;
	
	private SingletonEnd() {
	}

	private SingletonEnd getSingletonEnd() {
		initSingleton ();
		return singletonEnd;
	}
	
	private synchronized void initSingleton () {
		if (singletonEnd == null) {
			this.singletonEnd = new SingletonEnd();
		}
	} 
}
