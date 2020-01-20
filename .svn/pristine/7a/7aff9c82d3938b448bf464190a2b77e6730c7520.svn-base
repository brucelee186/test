package scjp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {
	static int[] b12;
	static { b12 = new int[2]; b12[0] = 1; b12[1] = 2;}
	
	 /**
	  * Question 15
	  */
	//int...代表x是int型数组(可变长参数)
	 static void foo(int...x) {
		 // falt
		for (int z : x) System.err.println(z);
		//数组没有hasNext方法
		// while (x.hasNext()) System.err.println(x.next);
		 for (int i = 0; i < x.length; i++) System.err.println(x[i]);
	 }
	 /**
	  * Question 16
	  */
	 //int...代表x是int型数组(可变长参数)
	 static void foo16(String...x) {
		 for (String z:x) System.err.println(z);
	 }
	 /**
	  * Question 17
	  */
	 static void foo17(int...x) {
		 System.err.println("可变长参数");
		 for (int z:x) System.err.println(z);
	 }
	 
	 static void foo17(int x, int y) {
		 System.err.println("非可变长参数,重载时最先匹配可固定参数");
		 System.err.println(x);
	 }
	 /**
	  * Question 38
	  */
	int x = 12;
	static void foo38(int x) {
		// 不使用this都是局部变量间的操作
		// this.x += x;
		x += x;
		System.err.println(x);
	}
	public static void main(String[] args) {
		/**
		 * Question 1
		 */
		Test t = new Test();
		System.err.println("Question 1*************************************************");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("Forest.Ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(t);
			objectOutputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/**
		 * 
		 */
		//String #name = "";
		int $age = 24;
		double _test = 36;
		//double ~temp = 37;
		
		/**
		 * 
		 */
		int x = 5;
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		if ((x==5 && !b2))
			System.err.println(1);
		System.err.println(2);
		// if括号条件中会先做运算再根据结果去判断条件是否成立,如果b3赋值为false那种最终运算结果为false所以不显示,如果赋值为true
		// 那么最终运算结果为打印true
		// if括号中的条件变量类型必须为boolean类,否则编译不通过,包括赋值string不可以
		if (b3 = false) {
			System.err.println(b3);
		}
		System.err.println("b3 = " + b3);
		if (b2 = true && b1) {
			System.err.println(3);
		}
		
		/**
		 * Question 4
		 */
		System.err.println("************************Question 4*************************");
		// Boolean.valueOf()方法忽略大小写
		boolean a = Boolean.valueOf("True");
		System.err.println(a);
		boolean b = Boolean.valueOf("true");
		System.err.println(b);
		boolean c = Boolean.valueOf("False");
		System.err.println(c);
		boolean d = Boolean.valueOf("false");
		System.err.println(d);
		boolean e = Boolean.valueOf("FAlse");
		System.err.println(e);
		/**
		 * Question 5
		 */
		System.err.println("************************Question 5*************************");
		// integer可以互相相加
		Integer f = new Integer(1) + new Integer(2);
		switch (f) {
		case 3: System.err.println("case 3 : f = " + f);
			break;
		// 只有没有case条件时才执行default
		default: System.err.println("default");
			break;
		}
		/**
		 * Question 10
		 */
		System.err.println("************************Question 10*************************");
		for (int i1 = 0; i1 < 10; i1++) {
			if (i1 == 6) break;
		}
		// 局部变量无法在外部调用
		// System.err.println(i1);
		/**
		 * Question 12
		 */
		System.err.println("************************Question 12*************************");
		int[] a12 = {1,2};
		/*int[] b12;
		//mian方法中不能加static修饰
		 { b12 = new int[2]; b12[0] = 1; b12[1] = 2;}*/
		 System.err.println(a12);
		 System.err.println(b12);
		 /**
		  * Question 13
		  */
		 System.err.println("************************Question 13*************************");
		 Object objArray = new int[]{1,2,3};
		 int[] intArray = (int[])objArray;
		 for (int i = 0; i < intArray.length; i++)System.err.println(intArray[i]);
		 for (int i : intArray) System.err.println(i);
		 /**
		  * Question 14
		  */
		 System.err.println("************************Question 14*************************");
		 String[] stringArray = {"for", "tea", "too"};
		 String first = (stringArray.length > 0)?null:stringArray[1];
		 String first1 = (stringArray.length < 0)?null:stringArray[1];
		 System.err.println(first);
		 //String是length()方法,数据是length属性,list是size()方法
		 //System.err.println(first.length());
		 System.err.println(first1);
		 /**
		  * Question 15 见上
		  */
		 System.err.println("************************Question 15*************************");
		 foo(1,2,3,4,5,6);
		 /**
		  * Question 16
		  */
		 System.err.println("************************Question 16*************************");
		 foo16("string", "text", "ok");
		 /**
		  * Question 17
		  */
		 System.err.println("************************Question 17*************************");
		 foo17(1);
		 foo17(1,2);
		 foo17(1,2,3);
		 //私有方法不能被别包访问
		 /**
		  * Question 23
		  */
		 System.err.println("************************Question 23*************************");
		 Test t23 = new Test();
		 System.err.println(t23);
		 t23 = null;
		 // 回收地址指向为空的内存对象
		 // 对象如果等于了null那么就有可能被回收机加收掉
		 // 重新new对象是原对象没有被做赋值运算处理,那么重新new也还会是同一个对象,当对象被设置为null,就有可能被jvm回收了
		 // 方法结束后,方法内对象会被回收
		 System.gc();
		 /*
		  * Microsoft Windows [版本 6.1.7601]
			版权所有 (c) 2009 Microsoft Corporation。保留所有权利。
			C:\Users\hp>d:
			D:\>javac Test.java
			D:\>java Test
			D:\>java Test 1,2,3,4,5
			1,2,3,4,5
			D:\>
		  */
		 System.err.println("************************Question 30*************************");
		 // java -Dprop.custom=gobstopper Commander 
		 String myProp = System.getProperty("prop.custom");
		 String myProp1 = System.getProperties().getProperty("prop.custom");
		 System.err.println(myProp);
		 System.err.println(myProp1);
		 System.err.println("************************Question 38*************************");
		 foo38(5);
		 System.err.println("************************Question 41*************************");
		 String o41 = "";
		 z :
			 for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 2; j++) {
					if (i == 1) {
						break;
					}
					// break是跳出的意思,不为中断,所以当i==2 && j==1时z代码块
					if (i==2 && j==1) break z;
					o41 = o41 + i + j;
				}
			}
		 System.err.println("over: " + o41);
	}
}
