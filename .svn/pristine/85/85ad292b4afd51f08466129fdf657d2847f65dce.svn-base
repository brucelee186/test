package 工具类;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 取得年月日小时分 {
	
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("MM");
		SimpleDateFormat format3 = new SimpleDateFormat("dd");
		SimpleDateFormat format4 = new SimpleDateFormat("hh");
		SimpleDateFormat format5 = new SimpleDateFormat("mm");
		SimpleDateFormat format6 = new SimpleDateFormat("ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date date = new Date();
		//如何获取某个日期是当月的最后一天
		Calendar calendarTemp = calendar.getInstance();
		calendarTemp.setTime(new Date());
		//取得当前日期的下个月
		calendarTemp.set(Calendar.DATE, 1);
		calendarTemp.roll(Calendar.DATE, -1);
		System.err.println(calendarTemp.get(Calendar.DATE));
		//下个月的天数减1
		
		//取得取得年月日小时分秒
		System.err.println(calendar.get(Calendar.YEAR));
		System.err.println(calendar.get(Calendar.MONTH) + 1);
		System.err.println(calendar.get(Calendar.DATE));
		System.err.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.err.println(calendar.get(calendar.DAY_OF_WEEK)-1);
		System.err.println(format.format(date));
		System.err.println(format2.format(date));
		System.err.println(format3.format(date));
		System.err.println(format4.format(date));
		System.err.println(format5.format(date));
		System.err.println(format6.format(date));
	}
}
