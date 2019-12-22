package 特殊.内部类.匿名内部类;

public class 继承式的匿名内部类  {
	public void say() {
		System.err.println("sayAnything");
	}
	
	public static void main(String[] args) {
		// 相当于没有名子的子类继承父类,重写了父类的方法
		/**
		 * 匿名内部类要注意的几个地方
		 * 1 匿名内部类不能有构造方法
		 * 2 不能定义静态成员变量,静态方法
		 * 3 修饰符不能是public, protected, private, static
		 * 4 只能创建匿名内部类的一个实例。
		 * 5 一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。
		 * 6 因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效。
		 */
		继承式的匿名内部类 p = new 继承式的匿名内部类() {
			public void say() {
				System.err.println("nothing");
			}
		};
		p.say();
	}
}
