package 特殊.内部类.成员方法内部类;

public class TestInnerOuterClass {
	// 内部类相当于外部类的一个成员变量,内部类可以访问外部类的成员变量
	//成员变量内部类
	class InnerClass {
		// 内部类中还可以有内部类
		class InnerClass3 {
			public void testInnerClass() {
				@SuppressWarnings("unused")
				// 方法内部类
				class InnerClass4 {
				}
			}
		}
	}
	
	int a = 10;
	public void testInner() {
		class Inner {
			public void test() {
				System.err.println(a);
			}
		}
		Inner i = new Inner();
		i.test();
	}
	
	public static void main(String[] args) {
		TestInnerOuterClass t = new TestInnerOuterClass();
		t.testInner();
	}
}
