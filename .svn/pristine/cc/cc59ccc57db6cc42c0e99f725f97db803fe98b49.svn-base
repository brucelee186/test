package 测试;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Test {
	
	public Test() {
		super();
	}
	
	// 运算时低类型会向高类型转换转换顺序(short,byte,char) < int < long < float < double
	// 也就是说只要和double类型有运算,那么结果一定为double
	double testShort(byte x, double y) {
		return (short) x / y * 2;
	}
	
	
	// 如何列出某个目录下的所有文件
	static void showFileName(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				System.err.println(files[i]);
			} else if (files[i].isDirectory()) {
				showFileName(files[i].toString());
			}
		}
	}
	
	// 如何列出某个目录下的所有子目录
	static void showDirectoryName(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				System.err.println(files[i]);
				showDirectoryName(files[i].toString());
			} 
		}
	}
	//类的静态变量对于所有类来说只是一个引用,所以即使新建一个对象的时候,引用的类依然不变,同样,对引用值对操作时也会影响到其它创建的对象
	private static int x = 100;
	public static void main(String[] args) {
		Test test1 = new Test();
		test1.x++;
		Test test2 = new Test();
		test2.x++;
		test1 = new Test();
		test1.x++;
		Test.x--;
		System.err.println("x = " + x);
		
		NumberFormat numberFormat = new DecimalFormat("#0.00");
		double a = 2.5491;
		String formatNumber = numberFormat.format(a);
		System.err.println(formatNumber);
		NumberFormat numberFormat2 = new DecimalFormat("#0.00");
		String res = numberFormat2.format(2.4566);
		System.err.println(res);
		System.err.println("2 *************************************");
		String abc = "abc";
		String cba = "";
		for (int i = abc.length(); i > 0; i--) {
			cba += abc.substring(i-1, i);
		}
		System.err.println(cba);
		
		System.err.println("4 *************************************");
		// 4.日期和时间
		//如何取得年月日，小时分秒
		String year = new SimpleDateFormat("yyyy").format(new Date());
		System.err.println(year);
		String month = new SimpleDateFormat("MM").format(new Date());
		System.err.println(month);
		String day = new SimpleDateFormat("dd").format(new Date());
		System.err.println(day);
		String date = new SimpleDateFormat("yyyy MM dd HH:mm:ss").format(new Date());
		System.err.println(date);
		
		System.err.println("6 *************************************");
		// 如何列出某个目录下的所有文件
		showFileName("D:\\file");
		// 如何列出某个目录下的所有子目录
		showDirectoryName("D:\\file");
		System.err.println("7 *************************************");
		// 如何读写文件
		// 读
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(new File("d:\\Test.java"));
			char[] chars = new char[1000];
			int fileLength = fileReader.read(chars);
			if (fileLength != -1) {
				System.err.println(new String(chars, 0, fileLength));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//写
		File file = new File("D:\\test.txt");
		if (file.exists()) {
			file.delete();
		}
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("write test");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.err.println("8 *************************************");
		//8.编码转换，怎样实现将GB2312编码的字符串转换为ISO-8859-1编码的字符串。
		try {
			String iso_8859_1 = new String(new String("GB2312".getBytes(), "GB2312").getBytes(), "ISO-8859-1");
			System.err.println(iso_8859_1);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			// return无论什么时候都是最后执行的
//			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 这种情况是在return之前执行
			//System.err.println("return");
		}
		
		System.err.println("如何获取某个日期是当月的最后一天 **********************************");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		System.err.println(calendar.get(Calendar.DATE));;
	}

}
