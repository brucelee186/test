package com.mtf.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilSystem {
	public static void main(String[] args) {
		try {
			Date date = new SimpleDateFormat("yyyyMMdd").parse("20201111");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			long systime = calendar.getTimeInMillis() ;
			System.err.println(systime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
