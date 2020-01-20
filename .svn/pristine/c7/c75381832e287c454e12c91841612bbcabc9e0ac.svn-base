package com.mtf.framework.service.impl;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.report.core.A.t;
import com.mtf.framework.dao.AttMonitorLogConditionMapper;
import com.mtf.framework.dao.AttenDayConditionMapper;
import com.mtf.framework.dao.AttenDayMapper;
import com.mtf.framework.dao.AttenFestivalConditionMapper;
import com.mtf.framework.dao.AttenFestivalMapper;
import com.mtf.framework.dao.AttenRuleConditionMapper;
import com.mtf.framework.dao.AttenRuleMapper;
import com.mtf.framework.dao.AttendanceConditionMapper;
import com.mtf.framework.dao.AttendanceMapper;
import com.mtf.framework.dao.PermissionConditionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenDayImpl;
import com.mtf.framework.model.impl.AttenFestivalImpl;
import com.mtf.framework.model.impl.AttenRuleImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.service.AttenRuleService;
import com.mtf.framework.service.AttendanceService;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤规则
 * 作者:     Auto
 * 日期:     2015/4/24
**********************************************
*/
@Service("attenRuleService")
public class AttenRuleServiceImpl extends CommonServiceImpl implements AttenRuleService {
	@Autowired
	private AttenRuleMapper attenRuleMapper;
	
	@Autowired
	private AttendanceMapper attendanceMapper;
	
	@Autowired
	private AttendanceConditionMapper attendanceConditionMapper;
	
	@Autowired
	private AttenRuleConditionMapper attenRuleConditionMapper;

	@Autowired
	private AttMonitorLogConditionMapper attMonitorLogConditionMapper;
	
	@Autowired
	private AttenDayConditionMapper attenDayConditionMapper;
	
	@Autowired
	private AttenDayMapper attenDayMapper;
	
	@Autowired
	private AttenFestivalMapper attenFestivalMapper;
	
	@Autowired
	private AttenFestivalConditionMapper attenFestivalConditionMapper;

	@Autowired
	private EmailService emailService;

	@Autowired
	private PermissionConditionMapper permissionConditionMapper;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	public AttendanceService getAttendanceService() {
		return attendanceService;
	}

	@Autowired
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	@Autowired
	public PermissionConditionMapper getPermissionConditionMapper() {
		return permissionConditionMapper;
	}

	@Autowired
	public void setPermissionConditionMapper(
			PermissionConditionMapper permissionConditionMapper) {
		this.permissionConditionMapper = permissionConditionMapper;
	}

	@Autowired
	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Autowired
	public AttenFestivalConditionMapper getAttenFestivalConditionMapper() {
		return attenFestivalConditionMapper;
	}

	@Autowired
	public void setAttenFestivalConditionMapper(
			AttenFestivalConditionMapper attenFestivalConditionMapper) {
		this.attenFestivalConditionMapper = attenFestivalConditionMapper;
	}

	@Autowired
	public AttenFestivalMapper getAttenFestivalMapper() {
		return attenFestivalMapper;
	}

	@Autowired
	public void setAttenFestivalMapper(AttenFestivalMapper attenFestivalMapper) {
		this.attenFestivalMapper = attenFestivalMapper;
	}

	@Autowired
	public AttenDayConditionMapper getAttenDayConditionMapper() {
		return attenDayConditionMapper;
	}

	@Autowired
	public void setAttenDayConditionMapper(
			AttenDayConditionMapper attenDayConditionMapper) {
		this.attenDayConditionMapper = attenDayConditionMapper;
	}

	@Autowired
	public AttenDayMapper getAttenDayMapper() {
		return attenDayMapper;
	}

	@Autowired
	public void setAttenDayMapper(AttenDayMapper attenDayMapper) {
		this.attenDayMapper = attenDayMapper;
	}

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

	@Autowired
	public AttMonitorLogConditionMapper getAttMonitorLogConditionMapper() {
		return attMonitorLogConditionMapper;
	}
	
	@Autowired
	public void setAttMonitorLogConditionMapper(
			AttMonitorLogConditionMapper attMonitorLogConditionMapper) {
		this.attMonitorLogConditionMapper = attMonitorLogConditionMapper;
	}

	@Autowired
	public AttenRuleConditionMapper getAttenRuleConditionMapper() {
		return attenRuleConditionMapper;
	}

	@Autowired
	public void setAttenRuleConditionMapper(
			AttenRuleConditionMapper attenRuleConditionMapper) {
		this.attenRuleConditionMapper = attenRuleConditionMapper;
	}

	@Autowired
	public AttenRuleMapper getAttenRuleMapper() {
		return attenRuleMapper;
	}

	@Autowired
	public void setAttenRuleMapper(AttenRuleMapper attenRuleMapper) {
		this.attenRuleMapper = attenRuleMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenRule
	 */
	public AttenRuleImpl insert(AttenRuleImpl attenRule) throws PmException {
		this.attenRuleMapper.insert(attenRule);
		return attenRule;
	}

	/**
	 * 删除实体对象
	 * @param attenRule
	 */
	public int delete(AttenRuleImpl attenRule) throws PmException {
		return this.attenRuleMapper.delete(attenRule);
	}

	/**
	 * 更新实体对象
	 * @param attenRule
	 */
	public boolean update(AttenRuleImpl attenRule) throws PmException {
		boolean result = true;
		Long id = attenRule.getId();
		// 赋值每周工作日为一个字段
		Class<AttenRuleImpl>  clazz = AttenRuleImpl.class;
		Class<?> clazzSuper = clazz.getSuperclass();
		String dayOfWeek = "";
		// 取得时间段数据
		@SuppressWarnings("unchecked")
		List<AttenDayImpl> listAttenDay = (List<AttenDayImpl>) attenDayMapper.select(new AttenDayImpl());
		Map<Long, AttenDayImpl> mapAttenDay = new HashMap<Long, AttenDayImpl>();
		if (null != listAttenDay && listAttenDay.size() > 0) {
			for (int i = 0; i < listAttenDay.size(); i++) {
				AttenDayImpl attenDayTemp = listAttenDay.get(i);
				Long idTemp = attenDayTemp.getId();
				mapAttenDay.put(idTemp, attenDayTemp);
			}
		}
		try {
			for (int i = 1; i <= 7; i++) {
				Field fieldDayOfWeek = clazzSuper.getDeclaredField("dayOfWeek" + i);
				fieldDayOfWeek.setAccessible(true);
				String fieldValue = (String) fieldDayOfWeek.get(attenRule);
				if (null != fieldValue && !" ".equals(fieldValue)) {
					dayOfWeek += fieldValue + ",";
				}
				
				// 取得考勤时间段信息并赋值,虽然可以关联表查询来解决这个问题,但效率低下
				// 取得时间段编号
				Field fieldTime = clazzSuper.getDeclaredField("time" + i);
				fieldTime.setAccessible(true);
				Long attenDayId = (Long) fieldTime.get(attenRule);
				if (null != attenDayId) {
					AttenDayImpl attenDayForTemp = mapAttenDay.get(attenDayId);
					// 取得对应的开始结束时间
					// 起始时间
					Date timeStart = attenDayForTemp.getTimeStart();
					// 结束时间
					Date timeEnd = attenDayForTemp.getTimeEnd();
					// 赋值到当前bean中
					Field fieldTimeStart = clazzSuper.getDeclaredField("timeStart" + i);
					fieldTimeStart.setAccessible(true);
					fieldTimeStart.set(attenRule, timeStart);
					Field fieldTimeEnd = clazzSuper.getDeclaredField("timeEnd" + i);
					fieldTimeEnd.setAccessible(true);
					fieldTimeEnd.set(attenRule, timeEnd);
				}
				
			}
			// 取得截取后的工作日
			if (null != dayOfWeek && dayOfWeek.length() > 0) {
				dayOfWeek = dayOfWeek.substring(0, dayOfWeek.length() -1);
				attenRule .setDayOfWeek(dayOfWeek);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if (null == id || "".equals(id)) {
			attenRuleMapper.insert(attenRule);
		} else {
			this.attenRuleMapper.update(attenRule);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenRule
	 */
	@SuppressWarnings("unchecked")
	public List<AttenRuleImpl> select(AttenRuleImpl attenRule) throws PmException {
		return (List<AttenRuleImpl>) this.attenRuleMapper.select(attenRule);
	}
	/**
	 * 查询单个实体
	 * @param attenRule
	 */
	public AttenRuleImpl get(AttenRuleImpl attenRule) throws PmException {
		return (AttenRuleImpl) this.attenRuleMapper.get(attenRule);
	}
	/**
	 * 查询实体分页列表
	 * @param attenRule
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenRuleImpl> search(AttenRuleImpl attenRule) throws PmException {
		DataGrid<AttenRuleImpl> grid = new DataGrid<AttenRuleImpl>();
		Object obj = attenRule;
		List list = attenRuleMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenRuleMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	@Override
	public DataGrid<AttenRuleImpl> doMonitorCollection(AttenRuleImpl attenRule)
			throws PmException {
		String tagEmail = attenRule.getTagEmail();
		if (null == tagEmail) {
			tagEmail= "y";
		}
		String collectDate = attenRule.getCollectDate();
		String pathUpload = attenRule.getPathUpload();
		if (null == pathUpload) {
			HttpSession session = CommonUtil.getHttpSession();
			pathUpload = session.getServletContext().getRealPath("/upload");
		}
		AttendanceImpl attendance = new AttendanceImpl();
		List<EmailImpl> listEmail = new ArrayList<EmailImpl>();
		EmailImpl email = new EmailImpl();
		int week = 0;
		if (null == collectDate || "".equals(collectDate)) {
			try {
				// 如果为空取当前日期的前一天
				Calendar ca = Calendar.getInstance();
				ca.setTime(new Date());
				ca.add(Calendar.DAY_OF_MONTH, -1);
				collectDate = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
				week = ca.get(Calendar.DAY_OF_WEEK);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Calendar ca = Calendar.getInstance();
				ca.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(collectDate));
				week = ca.get(Calendar.DAY_OF_WEEK);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
		}
		attendance.setCollectDate(collectDate);
		// 取得对应日期的考勤规则信息以部门为划分单位
		Map<String, AttenRuleImpl> mapAttenRule = new HashMap<>();
		try {
			AttenRuleImpl attenRuleTemp1 = new AttenRuleImpl();
			Class<?> classAttenRule = AttenRuleImpl.class;
			Class<?> classAttenRuleSuper = classAttenRule.getSuperclass();
			Field fieldWeek = classAttenRuleSuper.getDeclaredField("dayOfWeek" + week);
			fieldWeek.setAccessible(true);
			// a:access可以访问
			fieldWeek.set(attenRuleTemp1, "a");
			List<AttenRuleImpl> listAttenRule = attenRuleConditionMapper.selectAttenCollect(attenRuleTemp1);
			// 默认考勤规则取得标记
			boolean tagAttenDefault = true;
			for (int i = 0; i < listAttenRule.size(); i++) {
				AttenRuleImpl attenRuleTemp = listAttenRule.get(i);
				// 记入考勤部门标记
				String tagAttendance = attenRuleTemp.getTagAttendance();
				// 默认考勤标记
				String tagDefault = attenRuleTemp.getTagDefault();
				if ("y".equals(tagAttendance)) {
					attenRuleTemp.setCollectDate(collectDate);
					// 取得不同考勤规则相对于今天的补签日是多少
					try {
						// 取得补签日,并赋值
						AttenRuleImpl attenRuleForSingIn = this.searchSignInDay(attenRuleTemp);
						Date daySignIn = attenRuleForSingIn.getDaySignIn();
						attenRuleTemp.setDaySignIn(daySignIn);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					String divisionId = attenRuleTemp.getDivisionId();
					mapAttenRule.put(divisionId, attenRuleTemp);
					// 如果是默认考勤部门,那么也放入键值对中
					if ("y".equals(tagDefault) && tagAttenDefault) {
						mapAttenRule.put("default", attenRuleTemp);
						tagAttenDefault = false;
					}
				}
			}
		} catch (NoSuchFieldException e2) {
			e2.printStackTrace();
		} catch (SecurityException e2) {
			e2.printStackTrace();
		} catch (IllegalArgumentException e2) {
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		}
		// 取得采集日的节假日信息
		AttenFestivalImpl attenFestival = new AttenFestivalImpl();
		attenFestival.setCollectDate(collectDate);
		//AttenFestivalImpl attenFestivalTemp = new AttenFestivalImpl();
		AttenFestivalImpl attenFestivalTemp  = attenFestivalConditionMapper.getAttenFestivalCollection(attenFestival);
		List<AttenFestivalImpl> listAttenFestival = (List<AttenFestivalImpl>) attenFestivalMapper.select(attenFestival);
		Map<String, AttenFestivalImpl> mapAttenFestival = new HashMap<>();
	/*	if (null != listAttenFestival && listAttenFestival.size() == 1) {
			attenFestivalTemp = listAttenFestival.get(0);
		} else */
		if (null != listAttenFestival && listAttenFestival.size() > 0) {
			for (int i = 0; i < listAttenFestival.size(); i++) {
				AttenFestivalImpl attenFestivalForMap = listAttenFestival.get(i);
				mapAttenFestival.put(attenFestivalForMap.getDivisionId(), attenFestivalForMap);
			}
		}
		// 取得节假日类型 (f:假日,w:周末变更为上班日期)
		String typeDate = null;
		if (null != attenFestivalTemp) {
			typeDate = attenFestivalTemp.getTypeDate();
		}
		// 如果为工作日那么走考勤规则流程
		List<AttendanceImpl> listMonitor = attendanceConditionMapper.searchMonitorCollection(attendance);
		if (null != listMonitor && listMonitor.size() > 0) {
			// 计算下一个补签日
			// 取得当前日期
			Date dateNowForSignIn = new Date();
			// 取得节假日后的第一天
			// 查看当前日是否可做为补签日,如果不能,查询下一天
			// 查询当前日是否为节假日,如果是,顺延,如果不是查询当前是否为工作日(根据不同部门的考勤规则)
			AttenFestivalImpl attenFestivalSignIn = new AttenFestivalImpl();
			// 取得当前日期是否为节假日
			String collectDateSignIn = new SimpleDateFormat("yyyy-MM-dd").format(dateNowForSignIn);
			attenFestivalSignIn.setCollectDate(collectDateSignIn);
			attenFestivalSignIn = (AttenFestivalImpl) attenFestivalConditionMapper.getAttenFestivalCollection(attenFestivalSignIn);
			// 如果不为空,并且不为工作日,那么查询下一天,直到查询到
			/*while (null != attenFestivalSignIn && !"w".equals(attenFestivalSignIn.getTypeDate())) {
				Calendar ca = Calendar.getInstance();
				ca.setTime(dateNowForSignIn);
				ca.add(Calendar.DAY_OF_MONTH, 1);
				collectDateSignIn = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
				attenFestivalSignIn.setCollectDate(collectDateSignIn);
				attenFestivalSignIn = (AttenFestivalImpl) attenFestivalConditionMapper.getAttenFestivalCollection(attenFestivalSignIn);
			}*/
			Date dateSignIn = dateNowForSignIn;
			if (null != attenFestivalSignIn) {
				dateSignIn = attenFestivalSignIn.getDate();
			}
			// 查询当前日是否为工作日,如果是,可以做为补签日,不是,顺延
			for (int i = 0; i < listMonitor.size(); i++) {
				// 迟到
				String late = "0";
				// 早退
				String leaveEarly = "0";
				// 半勤
				String attendHalf = "0";
				// 旷工
				String absenteeism = "0";
				attendance = listMonitor.get(i);
				String statusAttendance = "no";
				String cardNo = attendance.getCardNo();
				// 考勤状态(vacate:v请假,attendance:a 考勤)
				String statusVacate = "a";
				// 用户编号
				String userId = attendance.getUserId();
				String dateWeek = attendance.getDateWeek();

				/**************         测试用       *******************/
				// 备用号码2508903837
				String cardNoTest = "1326872949";
				String cardNoTemp1 = attendance.getCardNo();
				if (!"".equals(cardNoTest) && cardNoTemp1 != null && cardNoTemp1.equals(cardNoTest)) {
					System.err.println(attendance.getUserName());
				}
				// 节假日实际状态
				String tagFestivalWorkDay = "f";
				// 如果状态为节假日，那么采集数据状态为no
				// 取得当前员工所在的部门是否为工作日
				// 取得部门编号
				String divisionId = attendance.getDivisionId();
				AttenFestivalImpl attenFestivalForAttenDivision = mapAttenFestival.get(divisionId);
				if (null != attenFestivalForAttenDivision) {
					typeDate = attenFestivalForAttenDivision.getTypeDate();
				} else {
					AttenFestivalImpl attenFestivalForAtten = mapAttenFestival.get("");
					if (null == attenFestivalForAtten) {
						attenFestivalForAtten = mapAttenFestival.get(null);
					}
					if (null == attenFestivalForAtten) {
						typeDate = "w";
					} else {
						if (null != attenFestivalForAtten) {
							typeDate = attenFestivalForAtten.getTypeDate();
							if ("w".equals(typeDate)) {
								tagFestivalWorkDay = "w";
							}
						}
					}
				}
				/*else {
					typeDate = attenFestivalForAtten.getTypeDate();
				}*/
				if (null != typeDate && "f".equals(typeDate)) {
					statusAttendance = "no";
					// 如果为节假日数据,照旧插入表中
					try {
						// 查询本条信息是否存在,如果不存在,插入,存在更新
						AttendanceImpl attendanceTemp2 = new AttendanceImpl();
						attendanceTemp2.setDateForCalendar(new SimpleDateFormat("yyyy-MM-dd").parse(collectDate));
						attendanceTemp2.setCardNo(cardNo);
						attendanceTemp2 = (AttendanceImpl) attendanceMapper.get(attendanceTemp2);
						if (null == attendanceTemp2) {
							attendance.setId(null);
							attendance.setStatusVacate("a");
							attendance.setStatusAttendance("no");
							attendance.setTypeDate("f");
							// 驳回标记(y,驳回过 n, 没有驳回)
							attendance.setTagReject("n");
							attendanceMapper.insert(attendance);
						} 
						else {
							attendance.setAddDate(null);
							attendance.setAddIp(null);
							attendance.setAddUser(null);
							attendance.setStatusAttendance("no");
							attendance.setTypeDate("f");
							// 重新采集的数据不会对状态做修改
							/*if (null == typeDate || "w".equals(typeDate)) {
								statusAttendance = null;
							}*/
							Long id = attendanceTemp2.getId();
							attendance.setId(id);
							attendanceMapper.update(attendance);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					// 如果节假日管理中的日期类型(f:假日,w:周末变更为上班日期)为工作日w,那么按考勤日计算，如果节假日管理中的日期类型为f,那么按节假日计算
					try {
						
						// 无部门采集权限的用户视为异常数据,不做采集处理
						if (null != divisionId) {
							// 取得本部门的当前日信息，并判断是否为考勤日
							AttenRuleImpl attenRuleTemp = mapAttenRule.get(divisionId);
							// 取得最高优先级的是否参与考勤
							PermissionImpl permission1 = new PermissionImpl();
							// 1702002 不记入考勤(无关部门)
							permission1.setCode("1702002");
							permission1.setUserId(attendance.getUserId());
							permission1 = permissionConditionMapper.getPermissionByUserId(permission1);
							if (null != permission1) {
								continue;
							}
							// 取得是否参与考勤,此权限优先级最高,包含此权限的,即使部门规则不参与考勤,本人也要参与默认考勤
							PermissionImpl permission = new PermissionImpl();
							// 1702001 记入考勤(无关部门)
							permission.setCode("1702001");
							permission.setUserId(attendance.getUserId());
							permission = permissionConditionMapper.getPermissionByUserId(permission);
							boolean judgeAttendance = false;
							if (null != permission) {
								judgeAttendance = true;
							}
							// 如果权限中参与考勤,那么取得默认考勤规则,不使用部门规则
							if (judgeAttendance) {
								attenRuleTemp = mapAttenRule.get("default");
							}
							if (null != attenRuleTemp && ("y".equals(attenRuleTemp.getTagAttendance()) ||  judgeAttendance)) {
								/**************         测试用       *******************/
								String cardNoTemp = attendance.getCardNo();
								if (!"".equals(cardNoTest) && cardNoTemp != null && cardNoTemp.equals(cardNoTest)) {
									System.err.println(attenRuleTemp.getDivisionName());
								}
								Class<?> classAtten = attendance.getClass();
								/*String divisionName = attenRuleTemp.getDivisionName();
								attendance.setDivisionName(divisionName);*/
								//Calendar.DAY_OF_WEEK: {1,2,3,4,5,6,7}中用1~7来表示：星期天，星期一，星期二，星期三，星期四，星期五，星期六
								//dayofweek() 一周中的天数（1..7对应周日..Saturday）
								Field fieldWeekField = classAtten.getDeclaredField("dayOfWeek" + week);
								fieldWeekField.setAccessible(true);
								try {
									// 取得采集日期的星期值
									String weekNow = attenRuleTemp.getDayOfWeekSub();
									// 如果是一周中的工作日，那么查询是否本天为节日
									// 如果节假日信息为工作日(如周日变成了工作日,那么以节假日为最高优先级)
									if ((!" ".equals(weekNow) && "w".equals(typeDate)) || "w".equals(tagFestivalWorkDay)) {
										typeDate = "w";
										// 考勤状态(no:正常,re:补签,le:早退,la:迟到,lale:迟到早退,ap1：一级经理审批，ap2:人事部经理审批,旷工:ab, absenteeism, 未打卡: ns: not sign in 需要补签)
										String timeStart = attendance.getDayStart();
										String timeEnd = attendance.getDayEnd();
										// 如果没有开始和结束打卡时间算旷工
										// 2 正常状态看不到时间
										// 取得当前考勤时间起始规则与之前的时间比对
										String timeStartRule = attenRuleTemp.getTimeStartSub();
										String timeEndRule = attenRuleTemp.getTimeEndSub();
										try {
											// 修正打卡起始规定时间
											SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
											Calendar calDateRule = Calendar.getInstance();
											calDateRule.setTime(sdf.parse(timeStartRule));
											calDateRule.add(Calendar.MINUTE, -10);
											String dayStartRule = sdf.format(calDateRule.getTime());
											attendance.setDayStartRule(dayStartRule);
											// 修正打卡截止时间
											calDateRule.setTime(sdf.parse(timeEndRule));
											calDateRule.add(Calendar.MINUTE, 10);
											String dayEndRule = sdf.format(calDateRule.getTime());
											attendance.setDayEndRule(dayEndRule);
										} catch (ParseException e1) {
											e1.printStackTrace();
										}
										// 如果起始打卡时间不为空，并且小于规定打卡时间，那么迟到数标记为零
										// 1，没打卡，就是旷工。
										// 3，打卡一次，过了规定时间，半勤+迟到或早退。 (早11点以后算半勤)
										if (null != timeStart && null != timeEnd) {
											try {
												Date timeStartDate = new SimpleDateFormat("HH:mm").parse(timeStart);
												Date timeStartRuleDate = new SimpleDateFormat("HH:mm").parse(timeStartRule);
												Date timeEndDate = new SimpleDateFormat("HH:mm").parse(timeEnd);
												Date timeEndRuleDate = new SimpleDateFormat("HH:mm").parse(timeEndRule);
												Date timeStartDateCompare = new SimpleDateFormat("HH:mm").parse("11:00:00");
												// 2，打卡一次，在规定时间内，半勤。 (早11点以后算半勤)
												if (timeStart.equals(timeEnd) || timeStartDate.getTime() > timeStartDateCompare.getTime()) {
													attendHalf = "1";
													// ns: not sign in 需要补签
													statusAttendance = "ns";
													// 3，打卡一次，过了规定时间，半勤+迟到或早退。
													
												} 
												if (timeStartDate.getTime() > timeStartRuleDate.getTime()) {
													late = "1";
													// ns: not sign in 需要补签
													statusAttendance = "ns";
												} 
												if (timeEndDate.getTime() < timeEndRuleDate.getTime()) {
													leaveEarly = "1";
													// ns: not sign in 需要补签
													statusAttendance = "ns";
												}
											} catch (ParseException e) {
												e.printStackTrace();
											}
										} 
										// 如果没打卡，算旷工
										else if (null == timeStart && null == timeEnd) {
											// ns: not sign in 需要补签
											statusAttendance = "ns";
											absenteeism = "1";
										}
										
									} else {
										typeDate = "f";
									}
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} 
								attendance.setStatusAttendance(statusAttendance);
								attendance.setTypeDate(typeDate);
								// 迟到
								attendance.setLate(late);
								// 早退
								attendance.setLeaveEarly(leaveEarly);
								// 半勤
								attendance.setAttendHalf(attendHalf);
								// 旷工
								attendance.setAbsenteeism(absenteeism);
								
								Date dateNow = new Date();
								attendance.setAddDate(dateNow);
								attendance.setModifiedDate(dateNow);
								// 计算补签标记,最后一个工作日顺延,至周一,时效为下一个工作日的24小时内,主要考虑中间有间隔的情况
								// 如周五下班需要下周一补签,计算补签日
								if ("ns".equals(statusAttendance)) {
									// 查询第一个补签日(dateSignIn)是否为工作日
									// 取得补签日的星期值
									Date daySignIn = attenRuleTemp.getDaySignIn();
									attendance.setDaySignIn(daySignIn);
									/*Calendar ca = Calendar.getInstance();
									ca.setTime(dateSignIn);
									int weekSingIn = ca.get(Calendar.DAY_OF_WEEK);
									Field fieldWeekSignIn = classAtten.getDeclaredField("dayOfWeek" + weekSingIn);
									fieldWeekSignIn.setAccessible(true);
									try {
										String weekRuleSignIn = String.valueOf(fieldWeekSignIn.get(attendance));
										while (" ".equals(weekRuleSignIn)) {
											// 如果在考勤规则内不是工作日,那么顺延一天
											ca.add(Calendar.DAY_OF_WEEK, 1);
											weekSingIn = ca.get(Calendar.DAY_OF_WEEK);
											fieldWeekSignIn = classAtten.getDeclaredField("dayOfWeek" + weekSingIn);
											weekRuleSignIn = String.valueOf(fieldWeekSignIn.get(attendance));
										}
										// 取得补签日,并赋值
										Date daySignIn = ca.getTime();
										attendance.setDaySignIn(daySignIn);
									} catch (IllegalArgumentException e) {
										e.printStackTrace();
									} catch (IllegalAccessException e) {
										e.printStackTrace();
									}*/
								}
								
								try {
									// 查询本条信息是否存在,如果不存在,插入,存在更新
									AttendanceImpl attendanceTemp2 = new AttendanceImpl();
									attendanceTemp2.setDateForCalendar(new SimpleDateFormat("yyyy-MM-dd").parse(collectDate));
									attendanceTemp2.setCardNo(cardNo);
									attendanceTemp2 = (AttendanceImpl) attendanceMapper.get(attendanceTemp2);
									if (null == attendanceTemp2) {
										attendance.setId(null);
										attendance.setStatusVacate("a");
										attendanceService.calculateAttendanceWork(attendance);
										attendanceMapper.insert(attendance);
									} 
									else {
										statusVacate = attendanceTemp2.getStatusVacate();
										attendance.setAddDate(null);
										attendance.setAddIp(null);
										attendance.setAddUser(null);
										// 重新采集的数据不会对状态做修改
										/*if (null == typeDate || "w".equals(typeDate)) {
											statusAttendance = null;
										}*/
										Long id = attendanceTemp2.getId();
										attendance.setId(id);
										if ("no".equals(statusAttendance)) {
											attendance.setStatusAttendance(statusAttendance);
											
										} else {
											attendance.setStatusAttendance(null);
										}
										attendanceService.calculateAttendanceWork(attendance);
										attendanceMapper.update(attendance);
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								// 如果状态为未补签,那么记录到邮件列表中
								if ("ns".equals(statusAttendance) && "a".equals(statusVacate) && "y".equals(tagEmail)) {
									// 重新设置email内存地址防止add到list中时造成所有的bean是一样的bug
									email = new EmailImpl();
									email.setEmail(attendance.getEmail());
									email.setAttendance(attendance);
									email.setTheme("系统提醒/日常考勤/异常状态发生");
									email.setReceiver(attendance.getEmail());
									// 是否为测试系统 t:test测试系统,r:real 真实系统
									/*String tagTest = CommonUtil.getConfig("tagTest");
									if ("t".equals(tagTest)) {
										email.setReceiver("neoyin@ManchuTimesFashion.com");
									}*/
									listEmail.add(email);
									email = new EmailImpl();
									email.setEmail(attendance.getEmail());
									email.setAttendance(attendance);
									email.setTheme("系统提醒/日常考勤/异常状态发生");
									email.setReceiver("neoyin@ManchuTimesFashion.com");
									listEmail.add(email);
									email = new EmailImpl();
									email.setEmail(attendance.getEmail());
									email.setAttendance(attendance);
									email.setTheme("系统提醒/日常考勤/异常状态发生");
									email.setReceiver("viviansong@ManchuTimesFashion.com");
									listEmail.add(email);
								
								}
								
								// 2508903837测试不计入考勤编号，如果是不用计算考勤人员，那么更新考勤记录为正常状态
								if("2508903837".equals(cardNo) && "ns".equals(statusAttendance) && null != collectDate){
									
									Calendar ca = Calendar.getInstance();
									try {
										ca.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(collectDate));
										PermissionImpl permissionIgnoreAtten = new PermissionImpl();
										// 1702002 不记入考勤(无关部门)
										permissionIgnoreAtten.setParentCode("1703000");
										permissionIgnoreAtten.setUserId(attendance.getUserId());
										permissionIgnoreAtten.setValue1(String.valueOf(ca.get(Calendar.DAY_OF_WEEK)));
										permissionIgnoreAtten = permissionConditionMapper.getPermissionByUserIdValue1(permissionIgnoreAtten);
										if(null != permissionIgnoreAtten){
											Long idAttendance = attendance.getId();
											AttendanceImpl attendanceIgnore = new AttendanceImpl();
											attendanceIgnore.setId(idAttendance);
											attendanceIgnore.setStatusAttendance("no");
											attendanceMapper.update(attendanceIgnore);
										}
									} catch (ParseException e) {
										e.printStackTrace();
									}
								}
							} 
							}
					} catch (NoSuchFieldException e1) {
						e1.printStackTrace();
					} catch (SecurityException e1) {
						e1.printStackTrace();
					}
				}
			}
		}		
		// 发邮件
		if (null != listEmail && listEmail.size() >0) {
			try {
				emailService.sendMail(listEmail, null, pathUpload);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// 查询第一个补签日(dateSignIn)是否为工作日
	// 取得补签日的星期值
	/*Calendar ca = Calendar.getInstance();
	ca.setTime(dateSignIn);
	int weekSingIn = ca.get(Calendar.DAY_OF_WEEK);
	Field fieldWeekSignIn = classAtten.getDeclaredField("dayOfWeek" + weekSingIn);
	fieldWeekSignIn.setAccessible(true);
	try {
		String weekRuleSignIn = String.valueOf(fieldWeekSignIn.get(attendance));
		while (" ".equals(weekRuleSignIn)) {
			// 如果在考勤规则内不是工作日,那么顺延一天
			ca.add(Calendar.DAY_OF_WEEK, 1);
			weekSingIn = ca.get(Calendar.DAY_OF_WEEK);
			fieldWeekSignIn = classAtten.getDeclaredField("dayOfWeek" + weekSingIn);
			weekRuleSignIn = String.valueOf(fieldWeekSignIn.get(attendance));
		}
		// 取得补签日,并赋值
		Date daySignIn = ca.getTime();
		attendance.setDaySignIn(daySignIn);
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	}*/
	
	private void modifyAtten(AttendanceImpl attendance) {
		/*try {
			// 查询本条信息是否存在,如果不存在,插入,存在更新
			AttendanceImpl attendanceTemp2 = new AttendanceImpl();
			attendanceTemp2.setDateForCalendar(new SimpleDateFormat("yyyy-MM-dd").parse(collectDate));
			attendanceTemp2.setCardNo(cardNo);
			attendanceTemp2 = (AttendanceImpl) attendanceMapper.get(attendanceTemp2);
			if (null == attendanceTemp2) {
				attendance.setId(null);
				attendance.setStatusVacate("a");
				attendanceMapper.insert(attendance);
			} 
			else {
				attendance.setAddDate(null);
				attendance.setAddIp(null);
				attendance.setAddUser(null);
				// 重新采集的数据不会对状态做修改
				if (null == typeDate || "w".equals(typeDate)) {
					statusAttendance = null;
				}
				attendance.setStatusAttendance(statusAttendance);
				Long id = attendanceTemp2.getId();
				attendance.setId(id);
				attendanceMapper.update(attendance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	 /**
	  * 取得补签日
	  * @param attenRule
	  * @return
	  * @throws Exception
	  */
	 private AttenRuleImpl searchSignInDay(AttenRuleImpl attenRule) throws Exception {
	 //	String collectDate = attenRule.getCollectDate();
	  // 取得当前星期值
	  //String weekNow = attenRule.getDayOfWeekSub();
	  // 取得当前日期
	  String collectDateSignIn = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	  // 取得一个礼拜中的工作日
	  String dayOfWeek = attenRule.getDayOfWeek();
	  // 取得采集日期的星期值
	  AttenFestivalImpl attenFestivalSignIn = new AttenFestivalImpl();
	  attenFestivalSignIn.setCollectDate(collectDateSignIn);
	  attenFestivalSignIn = (AttenFestivalImpl) attenFestivalConditionMapper.getAttenFestivalCollection(attenFestivalSignIn);
	  Date dateNowForSignIn;
	  Calendar ca = Calendar.getInstance();
	  dateNowForSignIn = new SimpleDateFormat("yyyy-MM-dd").parse(collectDateSignIn);
	  ca.setTime(dateNowForSignIn);
	  String weekSignIn = String.valueOf(ca.get(ca.DAY_OF_WEEK));
	  ca.setTime(new Date());
	  String weekNow = String.valueOf(ca.get(ca.DAY_OF_WEEK));
	  // 工作日 true,非工作日false
	  boolean dayOfWeekWorkDay = false;
	  int dayOfWeekWorkTag = dayOfWeek.indexOf(weekNow);
	  if (dayOfWeekWorkTag >= 0) {
	   dayOfWeekWorkDay = true;
	  }
	  // 节日中的节假日:f,工作日:w
	  String typeDateFestival = "f";
	  if (null != attenFestivalSignIn) {
		  typeDateFestival = attenFestivalSignIn.getTypeDate();
		
	  }
	  // 如果节假日,那么顺延
	  // 如果非节假日(工作日串休),那么强制使用当前日期为补签日是,无论是否为周六,周天
	  if ("w".equals(typeDateFestival)) {
		  attenRule.setDaySignIn(dateNowForSignIn);
		  return attenRule;
	  }
	  // 当前星期数是否为空作日
	  // 如果不为空,查询下一天,直到查询到
	  while (null != attenFestivalSignIn || false == dayOfWeekWorkDay) {
	   ca.setTime(dateNowForSignIn);
	   ca.add(Calendar.DAY_OF_MONTH, 1);
	   dateNowForSignIn = ca.getTime();
	   collectDateSignIn = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
	   // 取得补签日的星期数
	   weekSignIn = String.valueOf(ca.get(ca.DAY_OF_WEEK));
	   // 查询当前节假日信息与星期工作日的交集是否为工作日,可以用来补签
	   dayOfWeekWorkTag = dayOfWeek.indexOf(weekSignIn);
	   if (dayOfWeekWorkTag >= 0) {
	    dayOfWeekWorkDay = true;
	   } else {
	    dayOfWeekWorkDay = false;
	   }
	   // 节假日表中无数据,查询
	   attenFestivalSignIn = new AttenFestivalImpl();
	   attenFestivalSignIn.setCollectDate(collectDateSignIn);
	   attenFestivalSignIn = (AttenFestivalImpl) attenFestivalConditionMapper.getAttenFestivalCollection(attenFestivalSignIn);
	  }
	  Date daySignIn = ca.getTime();
	  attenRule.setDaySignIn(daySignIn);
	  return attenRule;
	 }

	 @Override
	 public DataGrid<AttenRuleImpl> doGetWorkHourRange(AttenRuleImpl attenRule)
			 throws PmException {
		 return null;
	 }
	
	public static void main(String[] args) {
		String tString = "2,3,4,5,6";
		String c = "6";
		int test = tString.indexOf(c);
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		String weekSignIn = String.valueOf(ca.get(ca.DAY_OF_WEEK));
		// 工作日 true,非工作日false
		String dayOfWeek = "2,3,4,5,6";
		int dayOfWeekWorkTag = dayOfWeek.indexOf(weekSignIn);
	}

}