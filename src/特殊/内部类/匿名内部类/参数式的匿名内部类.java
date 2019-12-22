package 特殊.内部类.匿名内部类;

class 测试参数式的匿名内部类 {
	public void test(InterfaceTest interfaceTest) {
		interfaceTest.say();
	}
}

interface InterfaceTest {
	public void say();
}

public class 参数式的匿名内部类 {
	public static void main(String[] args) {
		测试参数式的匿名内部类 测试类 = new 测试参数式的匿名内部类();
		测试类.test(new InterfaceTest() {
			@Override
			public void say() {
				System.err.println("fuck off");
			}
		});
	}
}
