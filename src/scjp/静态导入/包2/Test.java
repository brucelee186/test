package scjp.静态导入.包2;

//不同导的静态方法导入方式
import static scjp.静态导入.包1.Repeat.twice;

public class Test {
	public static void main(String[] args) {
		System.err.println(twice("some "));
	}
}
