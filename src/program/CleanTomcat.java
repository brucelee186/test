package program;

import java.io.File;

public class CleanTomcat {
	public static void main(String[] args) {
		String path = "D:\\apache-tomcat-7.0.41\\work\\Catalina\\localhost\\";
		String path2 = "D:\\apache-tomcat-7.0.41\\webapps\\";
		CleanTomcat d = new CleanTomcat();
		d.deleteDirectory(path);
		d.deleteDirectory(path2);
	}
	// flag 为flase会自动退出
	public boolean deleteDirectory(String path) {
		boolean flag = true;
		File file = new File(path);
		// 如果文件夹不存在,或不是一个文件,那么退出 
		if (!file.isDirectory() && !file.isFile()) return false;
		File[] fileArray = file.listFiles();
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				flag = deleteFile(fileArray[i].getAbsolutePath());
				if (false == flag) break;
			} else {
				flag = deleteDirectory(fileArray[i].getAbsolutePath());
				if(false == flag) break;
			}
		}
		if (false == flag) {
			return flag;
		}
		if (true == file.delete()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteFolder(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		} else {
			if (file.isFile()) {
				return deleteFile(path);
			} else {
				return deleteDirectory(path);
			}
		}
	}
	
	public boolean deleteFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
			flag = true;
		}
		return flag;
	}
}
