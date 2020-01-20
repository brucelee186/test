package com.mtf.framework.util.quartz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class LoadOnStartUp extends HttpServlet {
	@Override
	public void init() throws ServletException {
		TriggerAttendance triggerAttendance = new TriggerAttendance();
		triggerAttendance.triggerAtten();
	}
}
