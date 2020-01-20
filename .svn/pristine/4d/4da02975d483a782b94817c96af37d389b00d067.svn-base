package 设计模式.三单例模式_Singleton;

public class 双重锁的形式 {
	private static 双重锁的形式 singleton = null;

	public 双重锁的形式() {
		System.err.println("ok");
	}
	
	public static 双重锁的形式 getSingle() {
		// 防止程序员书写遗漏等号导致错误。null != XX这样少了！也会报错。而XX！=null少了！就不会了
		// obj.someMethod() ==null 和 null==obj.someMethod() 是有区别的
		// 因为obj为空时前者抛出空指针异常，后者不会
		/*boolean testIf;
		if (true = testI) {
			
		}
		if(testIf = true){
		}*/
		if (null == singleton) {
			// 这样在多线程环境中,对getInstance的访问就不会被blocked,而是仅当instance为null时,需要创建时,才要阻塞其他线程
			// 检查其它线程有无调用此线程,如果有那么等执行完再调用此线程
			synchronized (双重锁的形式.class) {
				if (null == singleton) {
					singleton = new 双重锁的形式();
				}
			}
		}
		return singleton;
	}
	
	// 单例模式就是不调用构造生成对象,而且只生成一个唯一的对象,避免不同方式生成的对象产生逻辑错误
	public static void main(String[] are1) {
		for (int i = 0; i < 10; i++) {
			singleton.getSingle();
		}
	}
}
