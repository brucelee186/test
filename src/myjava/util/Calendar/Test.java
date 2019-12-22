package myjava.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Calendar a = new Calendar() {
			
			@Override
			public void roll(int field, boolean up) {
			}
			
			@Override
			public int getMinimum(int field) {
				return 0;
			}
			
			@Override
			public int getMaximum(int field) {
				return 0;
			}
			
			@Override
			public int getLeastMaximum(int field) {
				return 0;
			}
			
			@Override
			public int getGreatestMinimum(int field) {
				return 0;
			}
			
			@Override
			protected void computeTime() {
			}
			
			@Override
			protected void computeFields() {
			}
			
			@Override
			public void add(int field, int amount) {
			}
		};
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date();
		format.format(d);
		Calendar c = Calendar.getInstance();
		Calendar b = Calendar.getInstance(format.getTimeZone());
		System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d));
		System.err.println(b.getTime());
		System.err.println(c.getTime());
		System.err.println(c.get(Calendar.DAY_OF_MONTH));
		System.err.println(c.get(Calendar.ALL_STYLES));
	}
}
