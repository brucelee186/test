package myjava.lang.reflect;

import java.lang.reflect.Method;

interface PersonInterface4 {
	public static final String name = "jim";
	public static final int age = 40;
	public void sayChina();
	public void sayHello(String name, int age);
}

/**
 * 注释
 * @author hp
 *
 */
class Prisoner4 implements PersonInterface4 {
	
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Prisoner4() {
	}
	
	public Prisoner4(String sex) {
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

public class InvokeMethod {
	// 调用类中方法
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Prisoner4");
			Method m = c.getMethod("sayChina");
			m.invoke(c.newInstance());
			Method m1 = c.getMethod("sayHello", java.lang.String.class, int.class);
			m1.invoke(c.newInstance(), "neo", 88);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
