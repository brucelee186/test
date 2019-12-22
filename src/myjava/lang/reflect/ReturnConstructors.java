package myjava.lang.reflect;

import java.lang.reflect.Constructor;

class Person2 {
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
public class ReturnConstructors {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Person2");
			Constructor<?>[] con = c.getConstructors();
			for (Constructor<?> constructor : con) {
				System.err.println(constructor.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
