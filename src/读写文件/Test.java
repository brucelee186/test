package 读写文件;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Test {

	public static void readFileByBite() {
		try {
			File f = new File("D:\\test\\test.txt");
			InputStream is = new FileInputStream(f);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
