package 算法;

import java.io.IOException;

public class Test {
	/*【程序1】 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
	 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int month = 0;
		byte[] b = new byte[32];
		try {
			System.in.read(b);
			// 一定要加trim否则会有回车符号String转int会错误
			String s = new String(b);
			s = s.trim();
			month = Integer.valueOf(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int rabbitCount = 2;
		/*
		 * 2 过三个月4过三个月8过三个月16
		 * **/
		//月份对3取余
		//月份是3的倍数
		int monthTimes = month/3;
		for (int i = 0; i < monthTimes; i++) {
			rabbitCount *= rabbitCount;
		}
		System.err.println(rabbitCount);
	}
}
