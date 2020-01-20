package myjava.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface PersonInterface2 {
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
class Prisoner2 implements PersonInterface2 {
	
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Prisoner2() {
	}
	
	public Prisoner2(String sex) {
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

public class ReturnClass {

	/**
	 * 返回结果
	 * public java.lang.String  getSex ()

		public void  setSex (java.lang.String arg0)
		
		public void  sayChina ()
		
		public void  sayHello (java.lang.String arg0,int arg1)
		
		public final native void  wait (long arg0) throws java.lang.InterruptedException
		
		public final void  wait () throws java.lang.InterruptedException
		
		public final void  wait (long arg0,int arg1) throws java.lang.InterruptedException
		
		public boolean  equals (java.lang.Object arg0)
		
		public java.lang.String  toString ()
		
		public native int  hashCode ()
		
		public final native java.lang.Class  getClass ()
		
		public final native void  notify ()
		
		public final native void  notifyAll ()
	 */
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Prisoner2");
			Method[] mArray = c.getMethods();
			for (Method method : mArray) {
				int m = method.getModifiers();
				String modify = Modifier.toString(m);
				System.err.print(modify + " ");
				String className = method.getName();
				System.err.print(className + " (");
				Class<?>[] paramArray = method.getParameterTypes();
				String parameter = "";
				for (int i = 0; i < paramArray.length; i++) {
					parameter += paramArray[i].getName();
					parameter += " args" + i + ",";
				}
				if (parameter.length() > 0) {
					parameter = parameter.substring(0, parameter.length() - 1);
				}
				System.err.print(parameter);
				System.err.print(")");
				Class<?>[] exceptionArray = method.getExceptionTypes();
				if (exceptionArray.length >0) {
					System.err.print(" throws ");
				}
				for (Class<?> class1 : exceptionArray) {
					System.err.print(class1);
				}
				System.err.println(" {}");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
