package 难题;

public class Test {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			// 代码运行顺序首先执行count++,count本来执行完之后会被加一,但它又被count+=重新做了一个赋值运行,count++被覆盖,所以count++无效
			// 赋值运行会覆盖i++
			count += count++;
		}
		System.err.println(count);
		System.err.println("**************************************");
		int i = 0, j = 0;
		// i++最先执行但没有加一事件,必须等赋值完成之后才会加一
		/*
		 * java编译器中的执行过程是这样的,先把i存进temp变量中,再做i++操作,这时i已经变成了1,但赋值是又用了i = temp,
		 * 这时把临时变量又调了回来造成i由1变成了0
		 */
		i = i++;
//		System.err.println(i);
//		i = 0; j= 0;
		System.err.println("int i = 0, j = 0;");
		System.err.println(i);
		j = i++;
		System.err.println(i);
		System.err.println(j);
//		i = 0; j= 0;
//		i = ++i;
//		System.err.println(i);
		System.err.println("************************************** short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错?");
		// short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错?
		short s1 = 1;
		// byte - short(char) - int - long - float - double
		// 运算是弱类型会自动转换为强类型也就是说 s1 + 1;会转换和1一样的int型,返回值结果与short类型不同,所以会编译错误
//		s1 = s1 + 1;
		// 所有+=, %=, *=, -=, /=都会先把等号右边的值的类型结转为左连类型然后再运算,所以不会有错,返回结果都为同一类型
		s1 += 1;
		System.err.println(s1);
	}
}
