package 测试.效率测试;

public class TestFor {
	/**
	 * 实际上这两种情况是一样的,编译后的生成的机器码是一样的
	 * @param args
	 */
	public static void main(String[] args) {
		for (long i = 0; i < 999999999; i++) {
			i *= i*4;
		}
		
		long startTime = System.currentTimeMillis();
		System.err.println("currentTimeMillis: " + startTime);
		//变量在for循环外定义();
		变量在for循环内定义();
		long endTime = System.currentTimeMillis();
		System.err.println("currentTimeMillis: " + endTime);
		System.err.println("时间差为: " + (endTime - startTime));
		
		long startTime1 = System.currentTimeMillis();
		System.err.println("currentTimeMillis: " + startTime1);
		变量在for循环外定义();
		//变量在for循环内定义();
		long endTime1 = System.currentTimeMillis();
		System.err.println("currentTimeMillis: " + endTime1);
		System.err.println("时间差为: " + (endTime1 - startTime1));
	}
	
	public static void 变量在for循环外定义() {
		String a = null;
		for (int i = 0; i < 999999; i++) {
			a = String.valueOf(i);
			a = null;
		}
	}
	
	public static void 变量在for循环内定义() {
		for (int i = 0; i < 999999; i++) {
			String a = String.valueOf(i);
			a = null;
		}
	}
}
