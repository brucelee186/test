package scjp;

public class TestMain {
	// An exception is thrown at runtime. 
	public void main(int[] args) {
		// 因为x被定义为局部变量(用户变量)所以在传参的过程中x没有被改变
		// 变量中的x与参数中的x是两个独立的变量,生命周期只在方法中有效
		int x = 6;
		TestMain t = new TestMain();
		t.doStuff(x);
		System.err.println("main x= " + x);
	}
	void doStuff(int x ) {
		System.err.println(" doStuffx ="+ x++);
	}
	
	public static void main(String[] args) {
		int x = 5;
		TestMain t = new TestMain();
		t.doStuff(x);
		System.err.println("main x = "+ x);
	}
}
