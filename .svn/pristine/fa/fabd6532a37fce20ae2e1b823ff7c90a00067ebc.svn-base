package 输入输出流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class 三标准输入输出数据流 {
	// 标准输出流
	static PrintStream printStream;
	// 标准输入流
	static InputStream inputStream;
	public static void main(String[] args) {
		// 1 标准输入流
		System.out.print("1");
		System.out.println("2");
		// 2标准输出流
		int input;
		System.err.println("input something");
		try {
			while ((input = System.in.read()) != 0) {
				System.err.print((char)input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3标准错误流
		System.err.println("3 ***********************************");
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("Unix系统: ctrl-d 或 ctrl-c 退出 Windows系统: ctrl-z 退出"); 
		try {
			String string = bufferedReader.readLine();
			while (null != string) {
				System.err.println("READ: " + string);
				string = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
