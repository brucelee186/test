package myjava.util.StringTokenizer;

import java.util.StringTokenizer;

public class TestStringTokenizer {
	public static void main(String[] args) {
		String s = new String("The Java platform is the ideal platform for network computing");
		StringTokenizer stringTokenizer = new StringTokenizer(s);
		System.err.println("tokenTotal = " + stringTokenizer.countTokens());
		while (stringTokenizer.hasMoreElements()) {
			System.err.println(stringTokenizer.nextToken());
		}
		
		String string = new String("The=Java=platform=is=the=ideal=platform=for=network=computing");
		StringTokenizer stringTokenizer2 = new StringTokenizer(string, "=", true);
		System.err.println("tokeTotal2 = " + stringTokenizer2.countTokens());
		while (stringTokenizer2.hasMoreTokens()) {
			System.err.println(stringTokenizer2.nextToken());
		}
		
	}
}
