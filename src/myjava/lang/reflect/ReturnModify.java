package myjava.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

interface PersonInterface1 {
	public static final String name = "jim";
	public static final int age = 20;
	public void sayChina();
	public void sayHello(String name, int age);
}

/**
 * 注释
 * @author hp
 *
 */
class Prisoner1 implements PersonInterface1 {
	
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Prisoner1() {
	}
	
	public Prisoner1(String sex) {
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

public class ReturnModify {
	// 返回结果如下
	// 构造方法：  public Reflect.Person(){}
	// 构造方法：  public Reflect.Person(java.lang.String arg1){}
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Prisoner1");
			Constructor<?>[] conArray = c.getConstructors();
			for (Constructor<?> constructor : conArray) {
				// Annotation a = constructor.getAnnotation();
				Class<?>[] paramArray = constructor.getParameterTypes();
				int m = constructor.getModifiers();
				String modifier = Modifier.toString(m);
				String methodName = constructor.getName();
				System.err.print(modifier + " ");
				System.err.print(methodName + " (");
				for (Class<?> param : paramArray) {
					System.err.println(param.getName());
				}
				System.err.println( ") {}");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
