package 设计模式.三单例模式_Singleton;


public class SingletonUdateProperty {
	private SingletonUdateProperty singleton = null;
	private Integer count = null;
	private SingletonUdateProperty() {
	}
	
	
	
	public Integer getCount() {
		return count;
	}


	private synchronized void initSingle() {
		if (singleton == null) {
			this.singleton = new SingletonUdateProperty();
		}
	}
	
	public SingletonUdateProperty getSingleton() {
		if (singleton == null) {
			initSingle();
		}
		return singleton;
	}
	
	public void updateProperty() {
		SingletonUdateProperty singletonUdateProperty = new SingletonUdateProperty();
		count = singletonUdateProperty.getCount();
	}
}
