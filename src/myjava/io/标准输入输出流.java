package myjava.io;

import java.io.IOException;

public class 标准输入输出流 {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.err.println("args[" + i + "] = " + args[i]);
		}
		int b;
		System.err.println("please input");
		try {
			//System.in:标准输入流
			while ((b = System.in.read()) != -1) {
				// 标准输出流
				System.out.println((char)b);
				System.err.print((char)b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
