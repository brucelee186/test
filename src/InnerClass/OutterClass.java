package InnerClass;

public class OutterClass {
	//成员内部类
	class MemberInnerClass{
		public void printInnerClass() {
			//不充许有静态static变量,注释部分为错误
			//static String msg = "printInnerClass";
			String msg = "printInnerClass";
			System.err.println(msg);
			System.err.println(this);
			System.err.println(OutterClass.this);
		}
	}
	
	//方法内部类
	private void methodInnerClass() {
		class MethodInnerClass{
			public void printMethodInnerClass() {
				System.err.println("printInnerClass");
			}
		}
//		InnerClass innerClass = new InnerClass();
//		innerClass.printInnerClass();
		
	}
	
	//成员内部类的访问
	public void textMemberInnerClass() {
		//成员内部类的访问
		MemberInnerClass innerClass = new MemberInnerClass();
		innerClass.printInnerClass();
	}
	
}

//测试非静态类,要使用非静态类的外部调用方法,否则,非静态类的内部的静态方法是不可以访问到非静态类中的非静态方法
class test{
	public static void main(String[] args) {
		OutterClass outterClass = new OutterClass();
		outterClass.textMemberInnerClass();
	}
}
