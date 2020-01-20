package recursion;

import javax.swing.JOptionPane;

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = JOptionPane
				.showInputDialog("please input your String: ");
		String numString = JOptionPane
				.showInputDialog("please input the number of your Combination: ");
		int num = Integer.parseInt(numString);
		Combine(input, num);
	}

	private static void Combine(String input, int num) {
		char[] a = input.toCharArray();
		String b = "";
		Combine(a, num, b, 0, a.length);

	}

	private static void Combine(char[] a, int num, String b, int low, int high) {
		if (num == 0) {
			System.out.println(b);
		} else {
			for (int i = low; i < a.length; i++) {
				b += a[i];
				Combine(a, num - 1, b, i + 1, a.length);
				b = b.substring(0, b.length() - 1);
			}
		}

	}
}
