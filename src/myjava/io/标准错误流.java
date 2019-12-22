package myjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 标准错误流 {
	public static void main(String[] args) {
		InputStreamReader inputRead = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(inputRead);
		System.err.println("start");
		// 每次读一行数据
		try {
			String s = bufferReader.readLine();
			while (null != s) {
				System.err.println(s);
				s = bufferReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
