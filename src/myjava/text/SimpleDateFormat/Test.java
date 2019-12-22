package myjava.text.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
	}
}
