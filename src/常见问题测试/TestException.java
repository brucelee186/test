package 常见问题测试;

public class TestException {
	public static void main(String[] args) {
		// 如果有
		try {
			throw new Exception();
			// 有throw不会继承往下走
			//return;
		} catch (Exception e) {
			System.err.println("catch: " + e);
		} finally {
			System.err.println("finally");
		}
	}
}
