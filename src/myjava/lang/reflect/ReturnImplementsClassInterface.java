package myjava.lang.reflect;

interface PersonInt {
	public final String sex = "famle";
	public void say ();
	public void sleep ();
}

class Student implements PersonInt {

	@Override
	public void say() {
		System.err.println("holly shit");
	}

	@Override
	public void sleep() {
		System.err.println("home sweet home , go to sleep");
	}
	
}

public class ReturnImplementsClassInterface {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("myjava.lang.reflect.Students");
			Class<?>[] cArray = c.getInterfaces();
			for (int i = 0; i < cArray.length; i++) {
				System.err.println(cArray[i].getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
