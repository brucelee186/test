package 输入输出流;

import java.io.File;
import java.io.IOException;


public class 五非流式文件类File类 {
	public static void main(String[] args) {
		File file = new File("d:\\file");
		File file2 = new File(file, "test.java");
		File file3 = new File(file, "test.txt");
		try {
			if (!file.exists()) {
				file.mkdir();
			}
			if (!file2.exists()) {
				file2.createNewFile();
			}
			if (!file3.exists()) {
				file3.createNewFile();
			}
			System.err.println("file2 abslouate path: " + file2.getAbsolutePath());
			System.err.println("file2 can read: " + file2.canRead());
			System.err.println("file2 length: " + file2.length());
			
			String[] fileList = file.list();
			int i = 0;
			for (i = 0; i < fileList.length; i++) {
				System.err.println(fileList[i]);
			}
			System.err.println("there are " + i + "files in " + "d:/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
