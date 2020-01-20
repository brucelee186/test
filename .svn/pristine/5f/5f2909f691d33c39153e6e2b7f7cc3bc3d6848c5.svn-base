package 测试;


final class TestFinalClass {}
// final类型class 将无法被继承
// class subFinalClass extends TestFinalClass {}

public class TestFinalFinallyFinalize {
	public static void main(String[] args) {
		final int a = 0;
		// 定义为final类型后将无法变更数值
		//a = 3;
		try {
			System.err.println(new Exception());
			throw new Exception();
		} catch (Exception e) {
			System.err.println("catch exception" + e);
			// finally是无伦是否异常都会执行的代码 
		} finally {
			System.err.println("finally");
		}
		TestFinalFinallyFinalize test = new TestFinalFinallyFinalize();
		test = null;
		System.gc();
	}
	@Override
	// 对象指向堆内存为空时,执行垃圾回收方法,会触发finalize,告知垃圾回收完成
	protected void finalize() throws Throwable {
		super.finalize();
		System.err.println("垃圾回收完成");
	}
}
