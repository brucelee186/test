package com.mtf.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateComparaUtil {
	private static Calendar ca = Calendar.getInstance();
	private static int year = ca.get(Calendar.YEAR);
	private static int month = ca.get(Calendar.MONTH)+1;
	private static int day = ca.get(Calendar.DATE);
	private static String smoth = "";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static String nodeDate = CommonUtil.getConfig("nodeDate");
	
	
	public static void monthValue(){
		if (month >= 1 && month <= 9) 
		{
			smoth = "0"+month;
		} else {
			smoth = ""+month;
		}
	}
	public static DateComparaUtil getInstance()
	{
		return new DateComparaUtil();
	}

		// 返回当前月份
		public static String nowMonth(){
			monthValue();
			String date = year + "-" + smoth;
			
			return date;
		}
		
		// 返回下个月份
		public static String nextMonth(){
			monthValue();
			String nextMonth = "";
			if (month == 12){
				nextMonth = (year+1) + "-0"+1;
			} else {
				if (month >= 1 && month <= 8) {
					nextMonth = year+ "-0" +(month+1);
				} else {
					nextMonth = year+ "-" +(month+1);
				}
				
			}
			return nextMonth;
		}
		
		// 利用当前日期与当月15号进行判断
		public static String dateCompara() {
			monthValue();
			String date = year + "-" + smoth + "-" +day;
			String temp = year + "-" + smoth + "-" +nodeDate;
			Date date1 = null;
			Date tempDate = null;
			try {
				date1 = sdf.parse(date);
				tempDate = sdf.parse(temp);
			}
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (date1.after(tempDate)) {
				return nextMonth();
			}else {
				return nowMonth();
			}
			
		}


}
