package myjava.lang.Object;

public class Test {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 构造无返回值
	public Test(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		Object t = new Test("test");
		Object o = new java.lang.Object();
		System.err.println(t);
		System.err.println(o);
	}
}
