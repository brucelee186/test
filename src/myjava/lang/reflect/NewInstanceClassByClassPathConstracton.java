package myjava.lang.reflect;

public class NewInstanceClassByClassPathConstracton {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Customer");
			try {
				// 通过路径调用对应路径类的构造方法生成新实例
				Customer p = (Customer)c.newInstance();
				p.setAge(20);
				p.setName("tom");
				System.err.println(p);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 每个类默认都继承Object类,这里重写了Object类的toString方法
 * java虚拟机会为每个没有手写构造方法的类默认分配一个无参构造,如果手动创建了任何构造函数,那么系统默认分配的构造将会失效
 * @author hp
 *
 */
class Customer extends Object {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Customer() {
		super();
	}
	
	// 如果定义了其它有参构造,那么默认有无参构造将会失效,运行时类对象无法加载无参构造,会报异常,所以定义了有参构造,一定要重写无参构造
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// 重写父类Object中的toString方法
	@Override
	public String toString() {
		return "name: " + this.name + " age: " + this.age;
	}
}
