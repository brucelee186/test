package 日期;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		Date d = new Date();
		//如何取得年月日，小时分秒
		System.err.println("年" + d.getYear() + "月" + d.getMonth() + "日" + d.getDate() + "时" + d.getHours() + "分" + d.getMinutes() + "秒" + d.getSeconds());
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = formate.format(d);
		System.err.println(now);
		//获取某个日期是当月的最后一天
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		int date  = c.get(Calendar.DATE);
		System.err.println(date);
		//怎样得到年，月，日，小时，分种，秒，毫秒数!

		String Pid=(new SimpleDateFormat("yyyyMMddHHmmss", Locale.US)).format(new java.util.Date()); 
		//上面怎样才能>求出毫秒数

		//import java.util.*
		Calendar cal=Calendar.getInstance();

		cal.setTime(new Date());

		int year=cal.get(Calendar.YEAR);

		int month=cal.get(Calendar.MONTH)+1;

		int date2=cal.get(Calendar.DATE);

		int hour=cal.get(Calendar.HOUR);

		int minute=cal.get(Calendar.MINUTE);

		int second=cal.get(Calendar.SECOND);

		int milliSecond=cal.get(Calendar.MILLISECOND);
	}
}
