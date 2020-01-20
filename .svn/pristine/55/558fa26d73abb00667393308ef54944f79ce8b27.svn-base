package 编程;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	/**
	 * 【程序1】
		题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一
		对兔子，假如兔子都不死，问每个月的兔子总数为多少？
		1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
	 * 【程序2】
		题目：判断101-200之间有多少个素数，并输出所有素数。
		1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
		则表明此数不是素数，反之是素数。
	 */
	static void q1() {
		System.err.println("1 ***********************************************");
		int x = 1;
		int y = 1;
		int z = 1;
		for (int i = 1; i <= 50; i++) {
			if (i == 1 || i == 2) {
				System.err.println(x);
			} else {
				System.err.println(x + y);
				z = y;
				y = x + y;
				x = z;
			}
		}
	}
	
	/**
	 * 【程序4】
		题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
	 */
	static void q2() {
		int k = 1;
		for (int i = 101; i <= 200; i++) {
			for (int j = 2; j < i; j++) {
				k = i%j;
				if (k == 0) {
					break;
				} 
			}
			if (k == 1) {
				System.err.println(i);
			}
		}
	}


	/*
	 * 【程序3】
		题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：
		153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
		1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
	 */
	static void q3() {
		for (int i = 100; i <= 999; i++) {
			int x = i%10;
			int y = (i%100 - x)/10;
			int z = (i - x - y)/100;
//			System.err.println("个位:" + x);
//			System.err.println("十位:" + y);
//			System.err.println("百位:" + z);
			if (i == (x*x*x + y*y*y + z*z*z)) {
				System.err.println(i);
			}
		}
	}
	

	/**
	 * 【程序7】
	 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
	 */
	static void q7() {
		String string = "test 12345&@!";
		int character = 0;
		int space = 0;
		int number = 0;
		int other = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c > 'A' && c < 'Z' || c > 'a' && c < 'z') {
				character++;
			} else if (c == ' ') {
				space ++;
			} else if (c > '0' && c <'9') {
				number++;
			} else {
				other++;
			}
		}
		System.err.println("字母:" + character + " 空格:" + space + " 数字:" + number + " 其它字符:" + other);
	}
	
	/**
	 * 【程序14】
		题目：输入某年某月某日，判断这一天是这一年的第几天？
		1.程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且
		输入月份大于3时需考虑多加一天。
	 */
	static void q14(int year, int month, int day) {
		boolean tagLeapYear = false; 
		if (year%4 == 0 && year%100 != 0) {
			System.err.println(year);
			tagLeapYear = true;
		} else if (year%400 == 0) {
			System.err.println(year);
			tagLeapYear = true;
		}
		int ferbery = 28;
		if (tagLeapYear) {
			ferbery = 29;
		}
		int bigMonth = 31;
		int smallMonth = 30;
		int days = 0;
		int[] months = {bigMonth, ferbery, bigMonth, smallMonth, bigMonth, smallMonth, bigMonth, bigMonth, smallMonth, bigMonth, smallMonth, bigMonth};
		for (int i = 0; i < month - 1; i++) {
			days += months[i];
		}
		days += day;
		System.err.println(days);
	}
	
	/**
	 * 【程序16】
		题目：输出9*9口诀。
	 * @param args
	 */
	static void q16() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i >= j) {
					System.err.print(i + "*" + j + " = " + i*j + " ");
				}
			}
			System.err.println();
		}
	}
	
	/**
	 * 【程序17】
		题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩
		下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下
		的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
	 */
	static void q17() {
		int count = 1;
		for (int i = 9; i >= 1; i--) {
			count = (count + 1)*2;
		}
		System.err.println(count);
	}

	/**
	 * 【程序18】
		题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向
		队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
	 * @param args
	 */
	static void q18() {
		String[] a = {"a", "b", "c"};
		String[] b = {"x", "y", "z"};
		String[][] c = {};
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				String x = a[i];
				String y = b[j]; 
				list.add(x + y);
			}
		}
		// a != x, c != x c != z
		System.err.println(c);
		System.err.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("ax") || list.get(i).equals("cx") || list.get(i).equals("cz")) {
				list.remove(i);
			}
		}
		System.err.println(list);
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> listTemp = new ArrayList<>();
//		List<Map<String, List<String>>> listRes = new ArrayList<>();
		List<List<String>> listRes = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list2.add("x");
		list2.add("y");
		list2.add("z");
		// a != x, c != x c != z
		for (int i = 0; i < list1.size(); i++) {
			listTemp = new ArrayList<>();
			Map<String, List<String>> mapRes = new HashMap<>();
			String x = list1.get(i);
			for (int j = 0; j < list2.size(); j++) {
				String[] strMap = new String[2];
				String y = list2.get(j);
//				strMap[0] = x;
//				strMap[1] = y;
				if (x.equals("a") && y.equals("x")) {
					continue;
				}
				if (x.equals("c") && (y.equals("x") || y.equals("z"))) {
					continue;
				}
				listTemp.add(y);
			}
//			mapRes.put(x, listTemp);
//			listRes.add(mapRes);
			listTemp.add(x);
			listRes.add(listTemp);
		}
		System.err.println(listRes);
		// a != x, c != x, c != z
		List<List<String>> listTemp2 = new ArrayList<>();
		for (int i = 1; i < listRes.size(); i++) {
			List<String> listX = listRes.get(i - 1);
			
			for (int j = 0; j < listRes.size(); j++) {
				List<String> listY = listRes.get(i);
				int proviousSize = listRes.get(i-1).size();
			}
			System.err.println(listRes);
		}
	}
	
	public static void main(String[] args) {
//		q1();
//		q2();
//		q3();
//		q7();
//		q14(2013, 12, 31);
//		q16();
//		q17();
//		q18();
		String[] array = new String[10];
		array[1] = "a";
		array[2] = "c";
		array[0] = "b";
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				System.err.println(array[i]);
			}
		}
	}
}
