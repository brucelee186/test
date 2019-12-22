package com.mtf.framework.util.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CronTrigger implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//System.err.println("ok");
	}

	public static void main(String[] args) {
		
	}
}
