package 继承;

public class Father {
	
	private static String name = "father";
	
	
	public static String getName() {
		return name;
	}
	
	public void print() {
		System.err.println("this is a test father");
	}

	public static void setName(String name) {
		Father.name = name;
	}


	public Father() {
		System.err.println("I'm the father");
	}
}
