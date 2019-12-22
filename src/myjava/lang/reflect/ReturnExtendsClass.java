package myjava.lang.reflect;

class Person1 {
	private String name = "Jim";
	private int age = 20;
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
	
	public  void sayHello() {
		System.err.println("get out my way");
	}
	
}

class Students1 extends Person1 {
	@Override
	public void sayHello() {
		System.err.println("go away");
	}
}

public class ReturnExtendsClass {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Students1");
			Class<?> d = c.getSuperclass();
			System.err.println(d.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
