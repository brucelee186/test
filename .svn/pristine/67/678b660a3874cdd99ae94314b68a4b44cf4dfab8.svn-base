package 工具.quartz;

import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 项目需要加入
 * quartz-1.6.1-RC3.jar
 * commons-collections.jar(不放此jar会报java.lang.NoClassDefFoundError: org/apache/common)
 * @author admin
 *
 */
public class TestSimpleTrigger implements Job{

	public static void main(String[] args) {
		TestSimpleTrigger t = new TestSimpleTrigger();
//		t.simpleTrigger();
		t.cronTrgger();
	}
	
	private void simpleTrigger(){
		try {
			// 1 simpleTrigger
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			JobDetail jobDetail = new JobDetail("myJob", scheduler.DEFAULT_GROUP, MyJob.class);
			SimpleTrigger simpleTrigger = new SimpleTrigger("myTrigger", scheduler.DEFAULT_GROUP, 100, 2);
			scheduler.scheduleJob(jobDetail, simpleTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * org.quartz.SchedulerException: Based on configured schedule, the given trigger will never fire.
	 * 给定的日期不会触发
	 */
	private void cronTrgger() {
		try {
			JobDetail jobDetail = new JobDetail("myJob", "myGroup", TestSimpleTrigger.class);
			CronTrigger cronTrigger = new CronTrigger("cronTrigger", "myGroup");
            //***************Cron表达式*********************  
            // * 位置    时间域名  允许值   允许的特殊字符  
            // * 1         秒             0-59 ,-*/  
            // * 2         分钟         0-59 ,-*/  
            // * 3        小时          0-23 ,-*/   
            // * 4        日期          1-31 ,-*?/ L W C  
            // * 5        月份          1-12 ,-*/   
            // * 6        星期          1-7  ,-*?/ L C #   
            // * 7        年(可选) 空值1970-2099     ,-*/  
            //***************Cron表达式符号意义*********************  
            /*  星号(*) 可用在所有字段中,表示对应时间域的每一个时刻  
             *  问号(?) 该字符只在日期和星期字段中使用,它通常指定为无意义的值,相当于占位符  
             *  减号(-) 表示一个范围  
             *  逗号(,) 表示一个列表值,比如在日期字段中使用1,4,5 则表示星期一,星期四,星期五  
             *  斜杠(/) x/y x为起始值,y为增长值  
             *  L 在日期中表示这个月的最后一天  在星期中表示星期六  
             *  W 表示离该日期最近的工作日   注意：不能够跨月  如指定1W,如果1号是星期六,结果匹配的是3号的星期一  
             *  LW 当月的最后一个工作日  
             *  井号(#) 表示当月的某个工作日 如 6#3表示当月的第3个星期5  
             *  C 计划所关联的日期,如果没有被关联,相当于所有日期    
             *    5C在日期中相当于5日以后的第一天  
             *    1C相当于星期日后的第一天  
             */ 
			CronExpression cronExpression = new CronExpression("0 44 18 22 4 ? 2014");
			cronTrigger.setCronExpression(cronExpression);
			StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = stdSchedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
			scheduler.deleteJob("myJob", "myGroup");
			scheduler.scheduleJob(jobDetail, cronTrigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.err.println(new Date());
	}
}
