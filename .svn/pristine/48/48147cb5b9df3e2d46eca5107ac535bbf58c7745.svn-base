package myjava.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

interface PersonInterface3 {
	public static final String name = "jim";
	public static final int age = 30;
	public void sayChina();
	public void sayHello(String name, int age);
}

/**
 * 注释
 * @author hp
 *
 */
class Prisoner3 implements PersonInterface3 {
	
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Prisoner3() {
	}
	
	public Prisoner3(String sex) {
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

public class RetrunClassProperty {
	/**
	 * 运行结果
	 * ===============本类属性========================
		private java.lang.String sex;
		===============实现的接口或者父类的属性========================
		public static final java.lang.String name;
		public static final int age;
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Prisoner3");
			System.err.println("父类或父接口属性");
			Field[] fieldArray = c.getFields();
			for (Field field : fieldArray) {
				int m = field.getModifiers();
				String modify = Modifier.toString(m);
				System.err.print(modify + " ");
				System.err.println(field.getName());
			}
			System.err.println("本类属性");
			Field[] fieldArray2 = c.getDeclaredFields();
			for (Field field : fieldArray2) {
				int m = field.getModifiers();
				String modify = Modifier.toString(m);
				System.err.print(modify + " ");
				System.err.println(field.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
