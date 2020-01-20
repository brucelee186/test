package myjava.io.File;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		File directory = new File("D:\\io");
		File file1 = new File(directory, "text.txt");
		File file2 = new File(directory, "Test.java");
		try {
		if (false == directory.exists()) {
			directory.mkdir();
		}
		if (false == file1.exists()) {
			file1.createNewFile();
		}
		if (false == file2.exists()) {
			file2.createNewFile();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println(file1.getAbsolutePath());
		System.err.println(file1.canRead());
		System.err.println(file1.length());
		int count = 0;
		String[] fileArray = directory.list();
		for (int i = 0; i < fileArray.length; i++) {
			System.err.println(fileArray[i]);
			count++;
		}
		System.err.println(count);
	}
}
