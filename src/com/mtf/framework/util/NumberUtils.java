/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.util;

/**
 * 数字格式化
 *
 * @author Wade.Zhu
 * @version 1.0	2013-12-08	Wade.Zhu		created.
 * @version <ver>
 */
public class NumberUtils {
	/**
	 * Currency参数
	 */
	private static final String[]	majorNames	= { "", " THOUSAND", " MILLION", " BILLION", " TRILLION", " QUADRILLION", " QUINTILLION" };

	private static final String[]	tensNames	= { "", " TEN", " TWENTY", " THIRTY", " FOURTY", " FIFTY", " SIXTY", " SEVENTY", " EIGHTY", " NINETY" };

	private static final String[]	numNames	= { "", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE", " TEN", " ELEVEN",
			" TWELVE", " THIRTEEN", " FOURTEEN", " FIFTEEN", " SIXTEEN", " SEVENTEEN", " EIGHTEEN", " NINETEEN" };

	private NumberUtils() {
		/* cannot be instantiated */
	}
	
	/**
	 * 将double类型转换为字符串，精度为2
	 * 
	 * @param d 数值类型
	 * @return 格式字符串
	 * 
	 * <pre>
	 * 例：
	 * formatNumber2(1234.567890123) = "1234.57"
	 * formatNumber2(1234f) = "1234.00"
	 * </pre>
	 */
	public static String formatNumber2(Double d) {
		return format(d, "%.2f");
	}
	
	/**
	 * 将double类型转换为字符串，精度为4
	 * 
	 * @param d 数值类型
	 * @return 格式字符串
	 * 
	 * <pre>
	 * 例：
	 * formatNumber2(1234.567890123) = "1234.5679"
	 * formatNumber2(1234f) = "1234.0000"
	 * </pre>
	 */
	public static String formatNumber4(Double d) {
		return format(d, "%.4f");
	}
	
	/**
	 * 将double类型转换为字符串，精度为6
	 * 
	 * @param d 数值类型
	 * @return 格式字符串
	 * 
	 * <pre>
	 * 例：
	 * formatNumber2(1234.567890123) = "1234.567901"
	 * formatNumber2(1234f) = "1234.000000"
	 * </pre>
	 */
	public static String formatNumber6(Double d) {
		return format(d, "%.6f");
	}

	
	/**
	 * 将数值类型转换为字符串
	 * 
	 * @param d 数值类型
	 * @param pattern 格式
	 * @return 字符串格式
	 */
	public static String format(Number d, String pattern) {
		if (d == null) {
			return "";
		}
		return String.format(pattern, d);
	}
	
	/**
	 * 将字符串转换为数值类型
	 * 
	 * @param dstr 字符串类型
	 * @param pattern 格式
	 * @return 日期类型
	 */
	public static Number parse(String dstr) {
		if (dstr == null || dstr.trim().length() == 0) {
			return null;
		}
		Double d = null;
		try {
			d = Double.parseDouble(dstr);
		} catch (NumberFormatException pe) {
		}
		return d;
	}

	/***
	 * 比较两个数是否相等
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean compare(Object o1, Object o2) {
		if (o1 != null) {
			return o1.equals(o2);
		} else if (o2 != null) {
			return o2.equals(o1);
		} else {
			return true;
		}
	}

	/***
	 * 比较目标数是否介于两个数之间（包括边界）
	 * @param boj 目标数
	 * @param o1 左边界(Min)
	 * @param o2 右边界(Max)
	 * @return
	 */
	public static boolean between(Integer obj, int start, int end){
		if(obj == null){
			return false;
		} else if(obj >= start && obj <= end){
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 比较目标数是否介于两个数之间（包括边界）
	 * @param boj 目标数
	 * @param o1 左边界(Min)
	 * @param o2 右边界(Max)
	 * @return
	 */
	public static boolean between(Double obj, double start, double end){
		if(obj == null){
			return false;
		} else if(obj >= start && obj <= end){
			return true;
		} else {
			return false;
		}
	}

	public static Integer null2Zero(Integer i) {
		if (i == null) {
			return 0;
		} else {
			return i;
		}
	}
	
	public static Double null2Zero(Double f) {
		if (f == null) {
			return 0.0;
		} else {
			return f;
		}
	}
	/**
	 * 四舍五入，保留2位小数
	 * @param f
	 * @return
	 */
	public static Double round2(Double f) {
		return round(f, 2);
	}
	
	/**
	 * 四舍五入，保留4位小数
	 * @param f
	 * @return
	 */
	public static Double round4(Double f) {
		return round(f, 4);
	}
	
	/**
	 * 四舍五入，保留6位小数
	 * @param f
	 * @return
	 */
	public static Double round6(Double f) {
		return round(f, 6);
	}
	
	/**
	 * 四舍五入，保留scale位小数
	 * @param f
	 * @param scale
	 * @return
	 */
	public static Double round(Double f, int scale) {
		if (f == null) return f;
		double s = Math.pow(10.0, scale);
		return Math.round(f * s) / s;
//		BigDecimal b = new BigDecimal(f);
//		b = b.setScale(scale, BigDecimal.ROUND_HALF_UP);
//		return b.doubleValue();
	}

	
	/**
	 * 数字金额转换成英文大写
	 * @param num
	 * @return
	 */
	public static String convertUppercaseNumber(double num) {
		String strDecimal ="";
		double roundNum = round(num,2);
		String strD = Double.toString(Math.abs(roundNum));
		String[] strs = strD.split("[.]");
		int number = Integer.parseInt(strs[0]);
		int decimal = Integer.parseInt(strs[1]);
		if(0<decimal && decimal<10){
			strDecimal = String.valueOf(decimal)+"0";
		}else{
			strDecimal = String.valueOf(decimal);
		}
		
		/* special case */
		if (number == 0) {
			return "zero";
		}

		String prefix = "";

		/*if (number < 0) {
			number = -number;
			prefix = "negative";
		}*/

		String soFar = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				soFar = s + majorNames[place] + soFar;
			}
			place++;
			number /= 1000;
		}while (number > 0);
		String suffix="";
		if(decimal < 100 && decimal > 0){
			suffix = " AND "+ strDecimal + "/100 ONLY";
		}else{
			suffix = " ONLY";
		}
		return (prefix + soFar + suffix).trim();
	}
	
	private static String convertLessThanOneThousand(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;

			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0) return soFar;
		return numNames[number] + " HUNDRED" + soFar;
	}
}
