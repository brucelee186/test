package myjava.lang.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



/**
 * 注释
 * @author hp
 *
 */
interface China{
	public static final String name="Rollen";
	public static  int age=20;
	public void sayChina();
	public void sayHello(String name, int age);
}

class Person implements China{
	public Person() {
		
	}
	public Person(String sex){
		this.sex=sex;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public void sayChina(){
		System.out.println("hello ,china");
	}
	@Override
	public void sayHello(String name, int age){
		System.out.println(name+"  "+age);
	}
	private String sex;
}

/**
 * 【案例】首先来看看如何获得类加载器：  *********************************
	类加载器为: sun.misc.Launcher$AppClassLoader
	其实在java中有三种类类加载器。
	1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
	2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
	3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
 * @author hp
 *
 */

interface Subject {
	public String say(String name, int age);
}

class RealSubject implements Subject {
	@Override
	public String say(String name, int age) {
		return "name: " + name + " age: " + age;
	}
}

class MyInvoctionHandler implements InvocationHandler {
	private Object object = null;
	
	public Object bind(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object temp = method.invoke(this.object, args);
		return temp;
	}
}
public class Test {

	/**
	 * 所有类对象都是Class类的实例
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(Test.class.getName());
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		Test t1 = new Test();
		c1 = t1.getClass();
		c2 = Test.class;
		try {
			c3 = Class.forName("myjava.lang.reflect.Test");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.err.println(c1);
		System.err.println(c2);
		System.err.println(c3);
		
		// 【案例】调用其他类的set和get方法
		System.err.println("【案例】调用其他类的set和get方法 *********************************");
		try {
			
			Class<?> c = Class.forName("myjava.lang.reflect.Person");
			Object o = c.newInstance();
			Method m = o.getClass().getMethod("setSex", String.class);
			m.invoke(o, "男");
			
			Method m2 = o.getClass().getMethod("getSex");
			System.err.println(m2.invoke(o));
			
			// 【案例】通过反射操作属性
			System.err.println("【案例】通过反射操作属性 *********************************");
			Class<?> class1 = Class.forName("myjava.lang.reflect.Person");
			Object object = class1.newInstance();
			java.lang.reflect.Field field = object.getClass().getDeclaredField("sex");
			field.setAccessible(true);
			field.set(object, "nv");
			System.err.println(field.get(object));
			
			System.err.println("【案例】通过反射取得并修改数组的信息： *********************************");
			int[] array = {3, 5, 2, 6, 7};
			Class<?> class2 = array.getClass().getComponentType();
			System.err.println("arrayType = " + class2.getName());
			System.err.println("arrayLength = " + Array.getLength(array));
			System.err.println("arrayIndex_0 = " + Array.get(array, 0));
			Array.set(array, 0, 999);
			System.err.println("Array.set(array, 0, 999);");
			System.err.println("arrayIndex_0 = " + Array.get(array, 0));
			
			System.err.println("【案例】通过反射修改数组大小  *********************************");
			int[] arraySource = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			Class<?> arraySourceClass = array.getClass().getComponentType();
			Object newArrayObject = Array.newInstance(arraySourceClass, 15);
			int newArrayLength = Array.getLength(newArrayObject);
			System.err.println("newArray.getLength = " + newArrayLength);
			// array(原数组, 从某个下标开始复制, 新数组, 从新数组的某个下标开始复制, 原数组的截止长度);
			System.arraycopy(arraySource, 0, newArrayObject, 0, 2);
			int[] newArray = (int[]) newArrayObject;
			System.err.println("arrayLength = " + Array.getLength(newArray));
			for (int i = 0; i < Array.getLength(newArray); i++) {
				System.err.println(Array.get(newArray, i));
			}
			String[] sourceArrayStrings = {"a", "b", "c"};
			// 变成8位长的数组,原数组保留
			Class<?> sourceArrayClass = sourceArrayStrings.getClass().getComponentType();
			// 重新设置数组长度
			Object newArrayObj = Array.newInstance(sourceArrayClass, 8);
			String[] newStringsArray = (String[]) newArrayObj;
			// 数组复制
			System.arraycopy(sourceArrayStrings, 0, newStringsArray, 0, 3);
			System.err.println("new Array length " + Array.getLength(newStringsArray));
			for (int i = 0; i < newStringsArray.length; i++) {
				System.err.println(newStringsArray[i]);
			}
			
			System.err.println();
			System.err.println("动态代理 *********************************");
			System.err.println("【案例】首先来看看如何获得类加载器：  *********************************");
			Test test = new Test();
			System.err.println("类加载器为: " + test.getClass().getClassLoader().getClass().getName());
			System.err.println("其实在java中有三种类类加载器。");
			System.err.println("1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。");
			System.err.println("2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\\lib\\ext目录中的类");
			System.err.println("3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。");
			MyInvoctionHandler myInvoctionHandler = new MyInvoctionHandler();
			Subject subject = (Subject) myInvoctionHandler.bind(new RealSubject());
			String info = subject.say("neo", 20);
			System.err.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
