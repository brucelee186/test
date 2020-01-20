package 列出某个目录下的所有文件;

import java.io.File;

public class Test {
	public static void getDierector(String path) {
		File f = new File(path);
		File[] fileArray = f.listFiles();
		for (int i = 0; i < fileArray.length; i++) {
			if(fileArray[i].isDirectory()){
				getDierector(path + "\\" + fileArray[i].getName());
			}
			else{
				System.err.println(fileArray[i].getName());
			}
		}
	}
	
	public static void main(String[] args) {
		getDierector("D:\\test");
	}
}
