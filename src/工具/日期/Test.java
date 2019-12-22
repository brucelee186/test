package 工具.日期;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {
	public static void main(String[] args) {

		List<Date> list = getAllTheDateOftheMonth(new Date());
		
		for(Date date: list){
			System.out.println(date.toString());
		}

	}

	private static List<Date> getAllTheDateOftheMonth(Date date) {
		List<Date> list = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);

		int month = cal.get(Calendar.MONTH);
		while(cal.get(Calendar.MONTH) == month){
			list.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}
}
