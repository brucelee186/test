package com.mtf.framework.util.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.mtf.framework.dao.AttMonitorLogDao;
import com.mtf.framework.dao.AttendanceMapper;
import com.mtf.framework.model.impl.AttMonitorLogImpl;
import com.mtf.framework.model.impl.AttenRuleImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.model.impl.AttendanceManageImpl;
import com.mtf.framework.service.AttenRuleService;
import com.mtf.framework.service.AttendanceManageService;
import com.mtf.framework.util.CommonUtil;

/**
 * 项目需要加入
 * quartz-1.6.1-RC3.jar
 * commons-collections.jar(不放此jar会报java.lang.NoClassDefFoundError: org/apache/common)
 * @author admin
 *
 */
public class TriggerAttendance implements Job{
	
	/**
	 * org.quartz.SchedulerException: Based on configured schedule, the given trigger will never fire.
	 * 给定的日期不会触发
	 */
	public void triggerAtten() {
		try {
			JobDetail jobDetail = new JobDetail("myJob", "myGroup", TriggerAttendance.class);
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
			//CronExpression cronExpression = new CronExpression("0 0-59 0-23 1-31 1-12 ?");
			// 取得每日触发的时间
			String dateAttenCollection = "1";
			AttendanceManageImpl attendanceManage;
			try {
				attendanceManage = new AttendanceManageImpl();
				AttendanceManageService attendanceManageService = (AttendanceManageService) CommonUtil.ac.getBean("attendanceManageService");
				attendanceManage = attendanceManageService.get(attendanceManage);
				dateAttenCollection = attendanceManage.getDateAttenCollection();
			} catch (Exception e) {
				e.printStackTrace();
				dateAttenCollection = "1";
			}
//			CronExpression cronExpression = new CronExpression("0 0 " + dateAttenCollection + " 1-31 1-12 ?");
			CronExpression cronExpression = new CronExpression("0 0 " + dateAttenCollection + " 1-31 1-12 ?");
//			CronExpression cronExpression = new CronExpression("0 * " + "*" + " 1-31 1-12 ?");
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
	public void execute(JobExecutionContext context) throws JobExecutionException {
		AttenRuleService attenRuleService = (AttenRuleService) CommonUtil.ac.getBean("attenRuleService");
		try {
			AttenRuleImpl attenRule = new AttenRuleImpl();
		    ServletContext servletContext =(ServletContext)context.getScheduler().getContext().get("servletContext");  
	        String pathUpload = servletContext.getRealPath("/upload");  
			attenRule.setPathUpload(pathUpload);
			// 如果为真实系统再采集
			if (CommonUtil.getTrueSys()) {
				attenRule.setTagEmail("y");
				attenRuleService.doMonitorCollection(attenRule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void execute1(JobExecutionContext arg0) throws JobExecutionException {
		AttMonitorLogDao attMonitorLogDao = (AttMonitorLogDao) CommonUtil.ac.getBean("attMonitorLogDao");
		AttendanceMapper attendanceMapper = (AttendanceMapper) CommonUtil.ac.getBean("attendanceMapper");
		// 如果为空取当前日
		String collectDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		AttMonitorLogImpl attMonitorLog = new AttMonitorLogImpl();
		attMonitorLog.setCollectDate(collectDate);
		List<Map<String, Object>> listMonitor = attMonitorLogDao.search(attMonitorLog);
		if (null != listMonitor && listMonitor.size() >0) {
			for (int i = 0; i < listMonitor.size(); i++) {
				AttendanceImpl attendance = new AttendanceImpl();
				Map<String, Object> mapAttendance = listMonitor.get(i);
				Date date2 = new Date();
				try {
					String date =  String.valueOf(mapAttendance.get("date"));
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String badgenumber = (String)mapAttendance.get("badgenumber");
				
				attendance.setUserName((String)mapAttendance.get("userName"));
				attendance.setCardNo(badgenumber);
				attendance.setDay(String.valueOf(mapAttendance.get("day")));
				attendance.setTimeStart((Date)mapAttendance.get("timeStart"));
				attendance.setTimeEnd((Date)mapAttendance.get("timeEnd"));
				//attendance.setDateMonth(String.valueOf(mapAttendance.get("dateMonth")));
				attendance.setDateWeek(String.valueOf(mapAttendance.get("dateWeek")));
				//attendance.setDate(date2);
				attendance.setDayStart(String.valueOf(mapAttendance.get("dayStart")));
				attendance.setDayEnd(String.valueOf(mapAttendance.get("dayEnd")));
				attendance.setTimeWork(String.valueOf(mapAttendance.get("timeWork")));
				attendance.setLate((String)mapAttendance.get("late"));
				attendance.setLeaveEarly((String)mapAttendance.get("leaveEarly"));
				attendance.setStatusAttendance((String)mapAttendance.get("statusAttendance"));
				attendance.setFestivelName((String)mapAttendance.get("festivelName"));
				attendance.setLoopYear((String)mapAttendance.get("loopYear"));
				attendance.setTypeDate((String)mapAttendance.get("typeDate"));
				Date dateNow = new Date();
				attendance.setAddDate(dateNow);
				attendance.setModifiedDate(dateNow);
				try {
					// 查询本条信息是否存在,如果不存在,插入,存在更新
					AttendanceImpl attendanceTemp = new AttendanceImpl();
					//attendanceTemp.setDate(date2);
					attendanceTemp.setCardNo(badgenumber);
					attendanceTemp = (AttendanceImpl) attendanceMapper.get(attendanceTemp);
					if (null == attendanceTemp) {
						attendanceMapper.insert(attendance);
					} 
					else {
						attendance.setAddDate(null);
						attendance.setAddIp(null);
						attendance.setAddUser(null);
						attendance.setStatusAttendance(null);
						attendanceMapper.update(attendance);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
