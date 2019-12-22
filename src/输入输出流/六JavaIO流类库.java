package 输入输出流;

import java.io.File;
import java.io.FileInputStream;

public class 六JavaIO流类库 {
	public static void main(String[] args) {
		try {
			File file = new File("D:\file\text.txt");
			FileInputStream fileInputStream = new FileInputStream(file);
			int bufferSize = 512;
			byte bufferByte[] = new byte[bufferSize];
			while (fileInputStream.read(bufferByte, 0, bufferSize) != -1) {
				
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
