package 常见问题测试;

public class Java类初始化顺序 {
	
	// 最后执行构造
	Java类初始化顺序(){
		System.err.println(3);
	}
	
	// 再执行普通代码块
	{
		System.err.println(2);
	}
	
	// 先执行静态代码块
	static {
		System.err.println(1);
	}
	
	public static void main(String[] args) {
		// 测试非继承
		Java类初始化顺序 t = new Java类初始化顺序();
		// 测试继承
		SubClass s = new SubClass();
	}
}

class SuperClass {
	// 最后执行构造
	SuperClass (){
		System.err.println(3);
	}
	
	// 再执行普通代码块
	{
		System.err.println(2);
	}
	
	// 先执行静态代码块
	static {
		System.err.println(1);
	}
}

class SubClass extends SuperClass {
	// 最后执行构造
	SubClass (){
		System.err.println(6);
	}
	
	// 再执行普通代码块
	{
		System.err.println(5);
	}
	
	// 先执行静态代码块
	static {
		System.err.println(4);
	}
}
