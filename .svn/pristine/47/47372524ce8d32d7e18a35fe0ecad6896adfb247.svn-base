package myjava.lang.reflect;

import java.lang.reflect.Constructor;

interface PersonInterface {
	public static final String name = "jim";
	public static final int age = 20;
	public void sayChina();
	public void sayHello(String name, int age);
}

class Prisoner implements PersonInterface {
	
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Prisoner() {
	}
	
	public Prisoner(String sex) {
		this.sex = sex;
	}
	
	@Override
	public void sayChina() {
		System.err.println("good night");
	}

	@Override
	public void sayHello(String name, int age) {
		System.err.println("fuck off " + name + " age: " + age);
	}
	
}

public class ReturnExtendsSuperClass {
	public static void main(String[] args) {
		try {
			// 取得本类的父接口
			Class<?> c = Class.forName("myjava.lang.reflect.Prisoner");
			Class<?>[] interfaceArray = c.getInterfaces();
			for (int i = 0; i < interfaceArray.length; i++) {
				System.err.println("本类实现接口为:" + interfaceArray[i].getName());
			}
			// 取得本类的父类
			Class<?> superClass = c.getSuperclass(); 
			System.err.println("本类父类为: " + superClass.getName());
			// 取得本类的全部构造方法
			Constructor<?>[] constructorArray = c.getConstructors(); 
			for (Constructor<?> constructor : constructorArray) {
				System.err.println(" 本类的构造方法为: " + constructor);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
