package 工具类;


public class 字符串反转 {

	private static String input = "我爱你";
	
	private static StringBuilder reversal = new StringBuilder();
	
	public static void main(String[] args) {
		for (int i = input.length(); i > 0; i--) {
			String singleString = input.substring(i-1, i);
			reversal.append(singleString);
		}
		System.err.println(reversal);
	}
}
