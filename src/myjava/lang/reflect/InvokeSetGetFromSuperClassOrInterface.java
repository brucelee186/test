package myjava.lang.reflect;

import java.lang.reflect.Method;

interface PersonInterface5 {
	public static final String name = "jim";
	public static final int age = 50;
	public void sayChina();
	public void sayHello(String name, int age);
}

/**
 * 注释
 * @author hp
 *
 */
class Prisoner5 implements PersonInterface5 {
	
	private String sex;

	public String getSex() {
		System.err.println(sex);
		return sex;
	}

	public void setSex(String sex) {
		System.err.println(sex);
		this.sex = sex;
	}

	public Prisoner5() {
	}
	
	public Prisoner5(String sex) {
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

public class InvokeSetGetFromSuperClassOrInterface {
	public static void main(String[] args) {
		try {
			// 使用object对象是为了set与get关联,如果使用两个new interance会造成set时有值,取值时因为新建对象无法取到
			Object o = null;
			Class<?> c = Class.forName("myjava.lang.reflect.Prisoner5");
			o = c.newInstance();
			Method set = o.getClass().getMethod("setSex", String.class);
			set.invoke(o, "mail");
			Method get = o.getClass().getMethod("getSex");
			get.invoke(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
