package myjava.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceClassByConstructorsArrayMethod {
	public static void main(String[] args) {
		try {
			CustomerBean cus1 = null;
			CustomerBean cus2 = null;
			CustomerBean cus3 = null;
			CustomerBean cus4 = null;
			Class<?> c = Class.forName("myjava.lang.reflect.CustomerBean");
			Constructor<?> constructorArray[] = c.getConstructors();
			try {
				// 第0个构造实际上是类中的最后一个构造,下面同理
				cus1 = (CustomerBean)constructorArray[0].newInstance("tom", 222);
				System.err.println(cus1);
				cus2 = (CustomerBean)constructorArray[1].newInstance(10);
				System.err.println(cus2);
				cus3 = (CustomerBean)constructorArray[2].newInstance("jim");
				System.err.println(cus3);
				cus4 = (CustomerBean)constructorArray[3].newInstance();
				System.err.println(cus4);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class CustomerBean extends Object {
	// constructor 1
	public CustomerBean() {
	}
	// constructor 2
	public CustomerBean(String name) {
		super();
		this.name = name;
	}
	// constructor 3
	public CustomerBean(int age) {
		super();
		this.age = age;
	}
	// constructor 4
	public CustomerBean(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}




	@Override
	public String toString() {
		return "name: " + this.name + " age: " + this.age;
	}
}
