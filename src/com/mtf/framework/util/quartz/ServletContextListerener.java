package com.mtf.framework.util.quartz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;


public class ServletContextListerener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			Scheduler sched = new StdSchedulerFactory().getScheduler();
			sched.getContext().put("servletContext", servletContextEvent.getServletContext());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}   
		   
	}

}
