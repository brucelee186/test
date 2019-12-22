package 特殊.内部类.匿名内部类;

interface 需要匿名的接口 {
	public void test();
}

public class 接口式的匿名内部类 {
	public static void main(String[] args) {
		需要匿名的接口 a = new 需要匿名的接口(){
			@Override
			public void test() {
				System.err.println("ok");
			}
			
		};
		a.test();
	}
}

