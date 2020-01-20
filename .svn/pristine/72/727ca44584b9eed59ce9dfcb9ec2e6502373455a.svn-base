package com.mtf.framework.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttendanceConditionMapper;
import com.mtf.framework.dao.AttendanceMapper;
import com.mtf.framework.model.impl.AttenRuleImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttendanceService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 门禁数据
 * 作者:     Auto
 * 日期:     2015/4/15
**********************************************
*/
@Service("attendanceService")
public class AttendanceServiceImpl extends CommonServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceMapper attendanceMapper;
	
	@Autowired
	private AttendanceConditionMapper attendanceConditionMapper;

	@Autowired
	public AttendanceConditionMapper getAttendanceConditionMapper() {
		return attendanceConditionMapper;
	}

	@Autowired
	public void setAttendanceConditionMapper(
			AttendanceConditionMapper attendanceConditionMapper) {
		this.attendanceConditionMapper = attendanceConditionMapper;
	}

	@Autowired
	public AttendanceMapper getAttendanceMapper() {
		return attendanceMapper;
	}

	@Autowired
	public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
		this.attendanceMapper = attendanceMapper;
	}

	/**
	 * 新增实体对象
	 * @param attendance
	 */
	public AttendanceImpl insert(AttendanceImpl attendance) throws PmException {
		this.attendanceMapper.insert(attendance);
		return attendance;
	}

	/**
	 * 删除实体对象
	 * @param attendance
	 */
	public int delete(AttendanceImpl attendance) throws PmException {
		return this.attendanceMapper.delete(attendance);
	}

	/**
	 * 更新实体对象
	 * @param attendance
	 */
	public boolean update(AttendanceImpl attendance) throws PmException {
		boolean result = true;
		this.attendanceMapper.update(attendance);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attendance
	 */
	@SuppressWarnings("unchecked")
	public List<AttendanceImpl> select(AttendanceImpl attendance) throws PmException {
		return (List<AttendanceImpl>) this.attendanceMapper.select(attendance);
	}
	/**
	 * 查询单个实体
	 * @param attendance
	 */
	public AttendanceImpl get(AttendanceImpl attendance) throws PmException {
		return (AttendanceImpl) this.attendanceMapper.get(attendance);
	}
	/**
	 * 查询实体分页列表
	 * @param attendance
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttendanceImpl> search(AttendanceImpl attendance) throws PmException {
		String tagSearch = attendance.getTagSearch();
		/*if ("ap1".equals(tagSearch)) {
			attendance.setStatusAttendance("re");
		}
		if ("ap2".equals(tagSearch)) {
			attendance.setStatusAttendance("ap1");
		}*/
		// 根据权限取得对应的审批数据
		DataGrid<AttendanceImpl> grid = new DataGrid<AttendanceImpl>();
		Object obj = attendance;
		List list = attendanceMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attendanceMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	/**
	 * 查询实体分页列表
	 * @param attenRule
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttendanceImpl> searchAttenAbsence(AttendanceImpl attendance) throws PmException {
		DataGrid<AttendanceImpl> grid = new DataGrid<AttendanceImpl>();
		Object obj = attendance;
		List list = attendanceConditionMapper.selectAttenAbsence(obj);
		grid.setRows(list);
		int count;
		count = attendanceConditionMapper.countAttenAbsence(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 取得工作时间,及负荷计算后的考勤记录
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public AttendanceImpl calculateAttendanceWork(AttendanceImpl attendance)
			throws PmException {
		String tagOvertime = attendance.getTagOvertime();
		// 计算审批后的加班
		if ("y".equals(tagOvertime)) {
			this.countAttendanceWorkApprove(attendance);
		} 
		else {
			attendance = this.countAttendanceWork(attendance);
		}
		return attendance;
	}

	public static void main(String[] args) {
		// 字义工作时间
		String timeWork = "13:16:24";
		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
		AttendanceImpl attendance = new AttendanceImpl();
//		// 1 正常工作日 实际工作时间(下班时间 – 上班时间 – 1小时)
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("a");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		attendance.setStatusAttendance("no");
//		attendance.setTimeWork(timeWork);
//		countAttendanceWork(attendance);
//		
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		
//		// 9 工作日加班, 实际工作时间:下班时间 – 上班时间, 应工作时间: 0
//		
//		// 字义工作时间
//		timeWork = "3:16:24";
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 1 正常工作日 实际工作时间(下班时间 – 上班时间 – 1小时)
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("f");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("f");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		attendance.setStatusAttendance("no");
//		attendance.setTimeWork(timeWork);
//		countAttendanceWork(attendance);
//		
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		// 2 作日，全天公出, 实际工作时间:8, 应工作时间:8
//		// 数据如下: id:104500	 赵欣	2508804253						2016-06		2016-06-28		
//		// late: 0,
//		// leaveEarly: 0	
//		// statusAttendance: ns		
//		// 2016-06-29 01:04:25			
//		// 2016-06-29 01:04:25					
//		// typeDate: w		
//		// 6a6843a6-e144-4755-95ae-1953f39d32fe	22b34a63-8540-4566-b6da-89084b549f44	QA	
//		// attenHalf: 0	
//		// absenteeism: 1				
//		// ticks:0	
//		// 2016-06-29	
//		// statusVacate: v	
//		// idVacate: 3702							n		0	
//
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("v");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		attendance.setStatusAttendance("no");
//		attendance.setTimeWork(timeWork);
//		attendance.setCodeVacate("WO");
//		// 请假方式(h:按小时，d:按天)
//		attendance.setTypeVacateDate("d");
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		
//		// 3 工作日，一天以内公出, 实际工作时间: （下班时间 – 上班时间) + 共处时长, 应工作时间: 8
//		// 109225	刚琦	3342127613	2016-07-13 09:02:49	2016-07-13 17:20:34	09:02:49	17:20:34	13	2016-07	4	2016-07-13	
//		// timeWork: 08:17:45	
//		// late: 0	
//		// leaveEarly: 1						
//		// 2016-07-14 01:04:58					
//		// typeDate: w		
//		// b7e1b3ca-a652-44b4-8b3a-5663fd4d0c25	571efe1a-8e5d-44e7-b382-e43c0dd6bc0a	设计开发部	0	0				
//		// ticks: 8	2016-07-14	
//		// statusVacate: v	
//		// idVacateManage: 3865
//		// 17:00:00	19:00:00					n		0										
//		
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("v");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		// attendance.setStatusAttendance(null);
//		attendance.setTimeWork(timeWork);
//		attendance.setCodeVacate("WO");
//		// 请假方式(h:按小时，d:按天)
//		attendance.setTypeVacateDate("h");
//		attendance.setDurationAttenVacate(0.38);
//		attendance.setTimeWork("08:17:45");
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		
//		// 4工作日，全天请假, 实际工作时间:0, 应工作时间:8
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("v");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		// attendance.setStatusAttendance(null);
//		attendance.setTimeWork(timeWork);
//		attendance.setCodeVacate("ba");
//		// 请假方式(h:按小时，d:按天)
//		attendance.setTypeVacateDate("d");
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		
//		// 5工作日，一天以内请假,实际工作时间:（下班时间 – 上班时间) , 应工作时间:8
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("v");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		// attendance.setStatusAttendance(null);
//		attendance.setTimeWork(timeWork);
//		attendance.setCodeVacate("ba");
//		// 请假方式(h:按小时，d:按天)
//		attendance.setTypeVacateDate("h");
//		attendance.setTimeWork("05:17:45");
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
		
//		// 6.1 工作日，旷工, 实际工作时间: 打卡次数≥2 下班时间 – 上班时间 – 1小时, 	应工作时间:8 小时
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("a");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		// attendance.setStatusAttendance(null);
//		attendance.setTimeWork("00:59:38");
//		attendance.setTicks(2L);
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		
//		// 6.1 工作日，旷工, 实际工作时间: 打卡次数<2  0小时 , 	应工作时间:8 小时
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("w");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("a");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		// attendance.setStatusAttendance(null);
//		attendance.setTimeWork("00:59:38");
//		attendance.setTicks(1L);
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
//		// 7工作日，迟到或早退同上, 实际工作时间:下班时间 – 上班时间 – 1小时, 应工作时间:8hour
//		
//		// 8 workday overWork: actual:daystart - dayend, workPermission: 0;
//		// 定义工作时间
//		timeWork = null;
//		// 定义周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
//		attendance = new AttendanceImpl();
//		// 工作日, f:假日,w:周末变更为上班日期
//		attendance.setTypeDate("f");
//		// 无请假记录 vacate:v请假,attendance:a 考勤
//		attendance.setStatusVacate("a");
//		// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回
//		// attendance.setStatusAttendance(null);
//		attendance.setTimeWork("00:59:38");
//		attendance.setTicks(1L);
//		countAttendanceWork(attendance);
//		System.err.println(attendance.getWorkOvertime());
//		System.err.println(attendance.getWorkTime());
//		System.err.println(attendance.getWorkTimeTrue());
	}
	
	private  AttendanceImpl countAttendanceWork(AttendanceImpl attendance) {
		try {
			/*String cardNo = attendance.getCardNo();
			if ("2646560633".equals(cardNo)) {
				System.err.println("test");
			}*/
			// 日期类型(f:假日,w:周末变更为上班日期)
			String typeDate = attendance.getTypeDate();
			// 转换工作时间为小数
			String timeWork = attendance.getTimeWork();
			// 假日类型标记
			String codeVacate = attendance.getCodeVacate();
			Double workTime = 0.00;
			Long idVacateManage = attendance.getIdVacateManage();
			String dayStart = attendance.getDayStart();
			String dayEnd = attendance.getDayEnd();
			String dayStartRule = attendance.getDayStartRule();
			String dayEndRule = attendance.getDayEndRule();
			String tagAjdust = attendance.getTagAdjust();
			String tagModifyOverwork = attendance.getTagModifyOverwork();
			if("y".equals(tagAjdust)){
				attendance.setWorkOvertimeBefore(0.00);
				attendance.setWorkOvertimeAfter(0.00);
				attendance.setWorkTime(9.00);
				attendance.setWorkTimeTrue(8.00);
				attendance.setWorkOvertime(0.00);
				return attendance;
			}else if ("n".equals(tagAjdust) && null == timeWork) {
				attendance.setWorkOvertimeBefore(0.00);
				attendance.setWorkOvertimeAfter(0.00);
				attendance.setWorkTime(0.00);
				attendance.setWorkTimeTrue(0.00);
				attendance.setWorkOvertime(0.00);
				return attendance;
			} 
			if (null != timeWork) {
				try {
					// 计算实际工作时间
					SimpleDateFormat hhmmss = new SimpleDateFormat("HH:mm:ss");
					Date dateTimeWork = hhmmss.parse(timeWork);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dateTimeWork);
					Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
					Float minute = Float.valueOf(calendar.get(Calendar.MINUTE));
					// '%.2f'结果被格式化为十进制普通表示方式,显示十进制两位小数
					String minuteDecmial = String.format("%.2f", minute/60);
					workTime = Double.valueOf(hour) + Double.valueOf(minuteDecmial);
					// 计算早前加班
					if (null != dayStartRule && null != dayEndRule) {
						Date dateDayStart = hhmmss.parse(dayStart);
						Date dateDayEnd = hhmmss.parse(dayEnd);
						Date dateDayStartRule = hhmmss.parse(dayStartRule);
						Date dateDayEndRule = hhmmss.parse(dayEndRule);
						// 早前时间减10分钟允许误差,凑合实际早前打卡时间
						//Double dateBetweenStart = (double) (dateDayStartRule.getTime() - 600000 - dateDayStart.getTime());
						// 更新规则后,无需修正打卡起时时间规则
						Double dateBetweenStart = (double) (dateDayStartRule.getTime() - dateDayStart.getTime());
						Double workOvertimeBefore = dateBetweenStart/(3600000);
						attendance.setWorkOvertimeBefore(workOvertimeBefore);
						// 计算下班后的加班时间
						//Double dateBetweenEnd = (double) (dateDayEnd.getTime() + 600000 - dateDayEndRule.getTime());
						Double dateBetweenEnd = (double) (dateDayEnd.getTime() - dateDayEndRule.getTime());
						Double workOvertimeAfter = dateBetweenEnd/(3600000);
						attendance.setWorkOvertimeAfter(workOvertimeAfter);
						
					}
//					calendar.setTime(new Date(dateBetweenStart));
//					hour = calendar.get(Calendar.HOUR_OF_DAY);
//					minute = Float.valueOf(calendar.get(Calendar.MINUTE));
//					// '%.2f'结果被格式化为十进制普通表示方式,显示十进制两位小数
//					minuteDecmial = String.format("%.2f", minute/60);
//					Double workOvertimeBefore = Double.valueOf(hour) + Double.valueOf(minuteDecmial);
//					System.err.println(workOvertimeBefore);
					// 计算早前加班
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			
			if ("w".equals(typeDate)) {
				String statusVacate = attendance.getStatusVacate();
				// 考勤状态(vacate:v请假,attendance:a 考勤)
				// 当为考勤日的状态
				if ("a".equals(statusVacate)) {
					// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回,
					// ns && statusVacate=a记录为考勤记录的情况下,未补签,ns && statusVacate=v记录为请假的的情况,既然未补签也算正常记录)
					String statusAttendance = attendance.getStatusAttendance();
					
					// 打卡次数
					Long ticks = attendance.getTicks();
					// 正常工作日 实际工作时间(下班时间 – 上班时间 – 1小时)
					if ("no".equals(statusAttendance)) {
						try {
							// 取得星期值(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
							// 1 正常工作日 实际工作时间(下班时间 – 上班时间 – 1小时)
							attendance.setWorkTime(workTime);
							Double workTimeTrue = workTime - 1;
							attendance.setWorkTimeTrue(workTimeTrue);
							Double workOvertime = workTimeTrue - 8;
							attendance.setWorkOvertime(workOvertime);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (null != ticks && ticks >= 2) {
						// 6.1 工作日，旷工, 实际工作时间: 打卡次数≥2 下班时间 – 上班时间 – 1小时, 	应工作时间:8 小时
						attendance.setWorkTime(workTime);
						Double workTimeTrue = workTime - 1;
						if (workTimeTrue > 0) {
							attendance.setWorkTimeTrue(workTimeTrue);
						}
						// 减一小时为负的情况下,工作时间算作0
						else {
							attendance.setWorkTimeTrue(0.00);
							
						}
						attendance.setWorkOvertime(0.00);
						// 6.1 工作日，旷工, 实际工作时间: 打卡次数<2  0小时 , 	应工作时间:8 小时
					} else if (null == ticks || ticks < 2) {
						attendance.setWorkTime(0.00);
						attendance.setWorkTimeTrue(0.00);
						attendance.setWorkOvertime(0.00);
					}
				}
				// 考勤状态(vacate:v请假,attendance:a 考勤)
				else if ("v".equals(statusVacate) && "WO".equals(codeVacate)) {
					// 2 工作日，全天公出, 实际工作时间:8,应工作时间:8
					String typeVacateDate = attendance.getTypeVacateDate();
					if ("d".equals(typeVacateDate)) {
						attendance.setWorkTime(8.00);
						attendance.setWorkTimeTrue(8.00);
						attendance.setWorkOvertime(0.00);
					}
					// 3 工作日，一天以内公出,实际工作时间:（下班时间 – 上班时间) + 共处时长, 应工作时间:8
					else if ("h".equals(typeVacateDate)) {
						Double durationAttenVacate = attendance.getDurationAttenVacate();
						Double workTimeTrue = workTime + durationAttenVacate;
						attendance.setWorkTime(workTime);
						attendance.setWorkTimeTrue(workTimeTrue);
						attendance.setWorkOvertime(0.00);
					}
				}
				else if ("v".equals(statusVacate) && !"WO".equals(codeVacate)) {
					String typeVacateDate = attendance.getTypeVacateDate();
					if ("d".equals(typeVacateDate)) {
						// 4工作日，全天请假, 实际工作时间:0小时, 应工作时间:8小时
						attendance.setWorkTime(0.00);
						attendance.setWorkTimeTrue(0.00);
						attendance.setWorkOvertime(0.00);
					}
					// 5工作日，一天以内请假,实际工作时间:（下班时间 – 上班时间) , 应工作时间:8
					else if ("h".equals(typeVacateDate)) {
						attendance.setWorkTime(workTime);
						attendance.setWorkTimeTrue(workTime);
						Double workOvertime = 0.00;
						attendance.setWorkOvertime(workOvertime);
					}
				}
			}
			// 日期类型(f:假日,w:周末变更为上班日期)
			else if ("f".equals(typeDate)) {
				// 9 工作日加班, 实际工作时间:下班时间 – 上班时间, 应工作时间: 0
				attendance.setWorkTime(workTime);
				attendance.setWorkTimeTrue(workTime);
				Double workOvertime = workTime;
				attendance.setWorkOvertime(workOvertime);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		return attendance;
	}
	
	/**
	 * 计算审批后的加班时间
	 * @param attendance
	 * @return
	 */
	private  AttendanceImpl countAttendanceWorkApprove(AttendanceImpl attendance) {
		try {
			/*String cardNo = attendance.getCardNo();
			if ("2646560633".equals(cardNo)) {
				System.err.println("test");
			}*/
			Long idAttendance = attendance.getId();
			// 测试
//			if(null != idAttendance && 313889 == idAttendance){
//				System.err.println();
//			}
			// 日期类型(f:假日,w:周末变更为上班日期)
			String typeDate = attendance.getTypeDate();
			// 转换工作时间为小数
			String timeWork = attendance.getTimeWork();
			// 假日类型标记
			String codeVacate = attendance.getCodeVacate();
			Double workTime = 0.00;
			Long idVacateManage = attendance.getIdVacateManage();
			String dayStart = attendance.getDayStart();
			String dayEnd = attendance.getDayEnd();
			String dayStartRule = attendance.getDayStartRule();
			String dayEndRule = attendance.getDayEndRule();
			String tagAjdust = attendance.getTagAdjust();
			String hourStartOvertime = attendance.getHourStartOvertime();
			String hourEndOvertime = attendance.getHourEndOvertime();
			String minuteStartOvertime = attendance.getMinuteStartOvertime();
			String minuteEndOvertime = attendance.getMinuteEndOvertime();
			String tagModifyOverwork = attendance.getTagModifyOverwork();
			// 考勤调整标记(y,调整过，null或者n没有)
			if("y".equals(tagAjdust)){
				attendance.setWorkOvertimeBefore(0.00);
				attendance.setWorkOvertimeAfter(0.00);
				attendance.setWorkTime(9.00);
				attendance.setWorkTimeTrue(8.00);
				attendance.setWorkOvertime(0.00);
				return attendance;
			}else if ("n".equals(tagAjdust) && null == timeWork) {
				attendance.setWorkOvertimeBefore(0.00);
				attendance.setWorkOvertimeAfter(0.00);
				attendance.setWorkTime(0.00);
				attendance.setWorkTimeTrue(0.00);
				attendance.setWorkOvertime(0.00);
				return attendance;
			} 
			if (null != timeWork) {
				try {
					// 计算实际工作时间
					SimpleDateFormat hhmmss = new SimpleDateFormat("HH:mm:ss");
					Date dateTimeWork = hhmmss.parse(timeWork);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dateTimeWork);
					Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
					Float minute = Float.valueOf(calendar.get(Calendar.MINUTE));
					// '%.2f'结果被格式化为十进制普通表示方式,显示十进制两位小数
					String minuteDecmial = String.format("%.2f", minute/60);
					workTime = Double.valueOf(hour) + Double.valueOf(minuteDecmial);
					// 计算早前加班
					if (null != dayStartRule && null != dayEndRule) {
						Date dateDayStart = hhmmss.parse(dayStart);
						Date dateDayEnd = hhmmss.parse(dayEnd);
						Date dateDayStartRule = hhmmss.parse(dayStartRule);
						Date dateDayEndRule = hhmmss.parse(dayEndRule);
						if("f".equals(typeDate)){
							dateDayStartRule = hhmmss.parse("11:30:00");
							dateDayEndRule = hhmmss.parse("12:00:00");
						}
						// 早前时间减10分钟允许误差,凑合实际早前打卡时间
						//Double dateBetweenStart = (double) (dateDayStartRule.getTime() - 600000 - dateDayStart.getTime());
						// 更新规则后,无需修正打卡起时时间规则
						Double dateBetweenStart = (double) (dateDayStartRule.getTime() - dateDayStart.getTime());
						Double workOvertimeBefore = dateBetweenStart/(3600000);
						Double workOvertimeBeforeApprove = 0.00;
						Double workOvertimeAfterApprove = 0.00;
						Double workOvertimeApprove = 0.00;
						// 考勤时间<审批时间	按照考勤时间计算
						// 考勤时间>审批时间	按照审批时间计算
						attendance.setWorkOvertimeBefore(workOvertimeBefore);
						if (workOvertimeBefore > 0.5) {
							workOvertimeBeforeApprove = workOvertimeBefore;
						}
						attendance.setWorkOvertimeBeforeApprove(workOvertimeBeforeApprove);
						// 计算下班后的加班时间
						//Double dateBetweenEnd = (double) (dateDayEnd.getTime() + 600000 - dateDayEndRule.getTime());
						Double dateBetweenEnd = (double) (dateDayEnd.getTime() - dateDayEndRule.getTime());
						Double workOvertimeAfter = dateBetweenEnd/(3600000);
						if (workOvertimeAfter > 1) {
							workOvertimeAfterApprove = workOvertimeAfter;
						}
						attendance.setWorkOvertimeAfterApprove(workOvertimeAfterApprove);
						attendance.setWorkOvertimeAfter(workOvertimeAfter);
						
						workOvertimeApprove = workOvertimeBeforeApprove + workOvertimeAfterApprove;
						attendance.setWorkOvertimeApprove(workOvertimeApprove);
					}
//					calendar.setTime(new Date(dateBetweenStart));
//					hour = calendar.get(Calendar.HOUR_OF_DAY);
//					minute = Float.valueOf(calendar.get(Calendar.MINUTE));
//					// '%.2f'结果被格式化为十进制普通表示方式,显示十进制两位小数
//					minuteDecmial = String.format("%.2f", minute/60);
//					Double workOvertimeBefore = Double.valueOf(hour) + Double.valueOf(minuteDecmial);
//					System.err.println(workOvertimeBefore);
					// 计算早前晚后规定加班时长
					Date dateDayStartOverworkRule = hhmmss.parse(hourStartOvertime + ":" + minuteStartOvertime + ":00");
					Date dateDayEndOverworkRule = hhmmss.parse(hourEndOvertime + ":" + minuteEndOvertime + ":00");
					Date dateDayStartRule = hhmmss.parse(dayStartRule);
					Date dateDayEndRule = hhmmss.parse(dayEndRule);
					
					if("f".equals(typeDate)){
						dateDayStartRule = hhmmss.parse("11:30:00");
						dateDayEndRule = hhmmss.parse("12:00:00");
					}
//					Long dateDayStartOverworkRuleLong = dateDayStartOverworkRule.getTime()/3600000;
//					Long dateDayEndOverworkRuleLong = dateDayEndOverworkRule.getTime()/3600000;
//					Long dateDayStartRuleLong = dateDayStartRule.getTime()/3600000;
//					Long dateDayEndRuleLong = dateDayEndRule.getTime()/3600000;
					Double durationOvertimeBefore = 0.00;
					Double durationOvertimeAfter = 0.00;
					// 如果规定早前加班时间小于上班时间,那么计算规定早前加班时间
					if(dateDayStartOverworkRule.getTime() < dateDayStartRule.getTime()){
						durationOvertimeBefore = (double) dateDayStartRule.getTime() - dateDayStartOverworkRule.getTime();
						durationOvertimeBefore = durationOvertimeBefore/3600000;
					}
					
					if(dateDayEndOverworkRule.getTime() > dateDayEndRule.getTime()){
						durationOvertimeAfter = (double) dateDayEndOverworkRule.getTime() - dateDayEndRule.getTime();
						durationOvertimeAfter = durationOvertimeAfter/3600000;
					}
					if("n".equals(tagModifyOverwork)){
						attendance.setWorkOvertimeBeforeApprove(durationOvertimeBefore);
						attendance.setWorkOvertimeAfterApprove(durationOvertimeAfter);
					}
					attendance.setDurationOvertimeBefore(durationOvertimeBefore);
					attendance.setDurationOvertimeAfter(durationOvertimeAfter);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			
			if ("w".equals(typeDate)) {
				String statusVacate = attendance.getStatusVacate();
				// 考勤状态(vacate:v请假,attendance:a 考勤)
				// 当为考勤日的状态
				if ("a".equals(statusVacate)) {
					// 状态(no:正常,ns: not sign in 需要补签,re:已补签,ap1：一级经理审批，ap2:人事部经理审批, re1 :部门驳回, re2 :行政驳回,
					// ns && statusVacate=a记录为考勤记录的情况下,未补签,ns && statusVacate=v记录为请假的的情况,既然未补签也算正常记录)
					String statusAttendance = attendance.getStatusAttendance();
					
					// 打卡次数
					Long ticks = attendance.getTicks();
					// 正常工作日 实际工作时间(下班时间 – 上班时间 – 1小时)
					if ("no".equals(statusAttendance)) {
						try {
							// 取得星期值(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
							// 1 正常工作日 实际工作时间(下班时间 – 上班时间 – 1小时)
							attendance.setWorkTime(workTime);
							Double workTimeTrue = workTime - 1;
							attendance.setWorkTimeTrue(workTimeTrue);
							Double workOvertime = workTimeTrue - 8;
							attendance.setWorkOvertime(workOvertime);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (null != ticks && ticks >= 2) {
						// 6.1 工作日，旷工, 实际工作时间: 打卡次数≥2 下班时间 – 上班时间 – 1小时, 	应工作时间:8 小时
						attendance.setWorkTime(workTime);
						Double workTimeTrue = workTime - 1;
						if (workTimeTrue > 0) {
							attendance.setWorkTimeTrue(workTimeTrue);
						}
						// 减一小时为负的情况下,工作时间算作0
						else {
							attendance.setWorkTimeTrue(0.00);
							
						}
						attendance.setWorkOvertime(0.00);
						// 6.1 工作日，旷工, 实际工作时间: 打卡次数<2  0小时 , 	应工作时间:8 小时
					} else if (null == ticks || ticks < 2) {
						attendance.setWorkTime(0.00);
						attendance.setWorkTimeTrue(0.00);
						attendance.setWorkOvertime(0.00);
					}
				}
				// 考勤状态(vacate:v请假,attendance:a 考勤)
				else if ("v".equals(statusVacate) && "WO".equals(codeVacate)) {
					// 2 工作日，全天公出, 实际工作时间:8,应工作时间:8
					String typeVacateDate = attendance.getTypeVacateDate();
					if ("d".equals(typeVacateDate)) {
						attendance.setWorkTime(8.00);
						attendance.setWorkTimeTrue(8.00);
						attendance.setWorkOvertime(0.00);
					}
					// 3 工作日，一天以内公出,实际工作时间:（下班时间 – 上班时间) + 共处时长, 应工作时间:8
					else if ("h".equals(typeVacateDate)) {
						Double durationAttenVacate = attendance.getDurationAttenVacate();
						Double workTimeTrue = workTime + durationAttenVacate;
						attendance.setWorkTime(workTime);
						attendance.setWorkTimeTrue(workTimeTrue);
						attendance.setWorkOvertime(0.00);
					}
				}
				else if ("v".equals(statusVacate) && !"WO".equals(codeVacate)) {
					String typeVacateDate = attendance.getTypeVacateDate();
					if ("d".equals(typeVacateDate)) {
						// 4工作日，全天请假, 实际工作时间:0小时, 应工作时间:8小时
						attendance.setWorkTime(0.00);
						attendance.setWorkTimeTrue(0.00);
						attendance.setWorkOvertime(0.00);
					}
					// 5工作日，一天以内请假,实际工作时间:（下班时间 – 上班时间) , 应工作时间:8
					else if ("h".equals(typeVacateDate)) {
						attendance.setWorkTime(workTime);
						attendance.setWorkTimeTrue(workTime);
						Double workOvertime = 0.00;
						attendance.setWorkOvertime(workOvertime);
					}
				}
			}
			// 日期类型(f:假日,w:周末变更为上班日期)
			else if ("f".equals(typeDate)) {
				// 9 工作日加班, 实际工作时间:下班时间 – 上班时间, 应工作时间: 0
				attendance.setWorkTime(workTime);
				attendance.setWorkTimeTrue(workTime);
				Double workOvertime = workTime;
				attendance.setWorkOvertime(workOvertime);
				
				// 节假日情况下,早前,晚后加班时间段被设定成为11:30到12:00
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		return attendance;
	}
}