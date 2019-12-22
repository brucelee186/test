package com.mtf.framework.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.AttenVacateManageMapper;
import com.mtf.framework.dao.AttendanceMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenVacateManageImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.service.AttenVacateManageService;
import com.mtf.framework.service.AttendanceService;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 请假管理
 * 作者:     Auto
 * 日期:     2015/6/18
**********************************************
*/
@Service("attenVacateManageService")
public class AttenVacateManageServiceImpl extends CommonServiceImpl implements AttenVacateManageService {
	@Autowired
	private AttenVacateManageMapper attenVacateManageMapper;
	
	@Autowired
	private AttendanceMapper attendanceMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private UserDetailMapper userDetailMapper;

	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}
	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}
	public AttendanceService getAttendanceService() {
		return attendanceService;
	}
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	@Autowired
	public EmailService getEmailService() {
		return emailService;
	}
	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
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
	public AttenVacateManageMapper getAttenVacateManageMapper() {
		return attenVacateManageMapper;
	}

	@Autowired
	public void setAttenVacateManageMapper(AttenVacateManageMapper attenVacateManageMapper) {
		this.attenVacateManageMapper = attenVacateManageMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenVacateManage
	 */
	public AttenVacateManageImpl insert(AttenVacateManageImpl attenVacateManage) throws PmException {
		this.attenVacateManageMapper.insert(attenVacateManage);
		return attenVacateManage;
	}

	/**
	 * 删除实体对象
	 * @param attenVacateManage
	 */
	public int delete(AttenVacateManageImpl attenVacateManage) throws PmException {
		return this.attenVacateManageMapper.delete(attenVacateManage);
	}

	/**
	 * 更新实体对象
	 * @param attenVacateManage
	 */
	public boolean update(AttenVacateManageImpl attenVacateManage) throws PmException {
		boolean result = true;
		String approveStatus = attenVacateManage.getApproveStatus();
		String typeData = attenVacateManage.getTypeData();
		String remarkReject = attenVacateManage.getRemarkReject();
		if ("re4".equals(approveStatus)) {
			attenVacateManage.setApproveStatus("re2");
		}
		this.attenVacateManageMapper.update(attenVacateManage);
		Long idVacateManage = attenVacateManage.getId();
		attenVacateManage = new AttenVacateManageImpl();
		attenVacateManage.setId(idVacateManage);
		AttenVacateManageImpl attenVacateManageTemp = (AttenVacateManageImpl) attenVacateManageMapper.get(attenVacateManage);
		attenVacateManageTemp.setTypeData(typeData);
		// 二级审批更新考勤信息表
		if ("ap1".equals(approveStatus) || "ap2".equals(approveStatus) || "ap3".equals(approveStatus)) {
			// 数据类型(v:vacate请假，a:attendance考勤)
			if ("v".equals(typeData)) {
				updateAttendanceVacate(attenVacateManageTemp);
			} else if ("a".equals(typeData)) {
				AttendanceImpl attendance = new AttendanceImpl();
				CommonUtil.setCommonField(attendance);
				attendance.setStatusAttendance(approveStatus);
				attendance.setIdVacateManage(idVacateManage);
				attendanceMapper.update(attendance);
			}
		}
		/*// 二级审批超过五天,发送邮件给高级管理人员
		if ("ap2".equals(approveStatus)) {
			String duration = attenVacateManageTemp.getDuration();
			if (null != duration && duration.length() > 0) {
				Double db_duration = Double.valueOf(duration);
				Double db_compare = 5.00;
				if (db_duration >= db_compare) {
					EmailImpl email = new EmailImpl();
					email.setReceiver("LiuXiMing@ManchuTimesFashion.com");
					//email.setReceiver("neoyin@ManchuTimesFashion.com");
					email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请");
					email.setAttenVacateManage(attenVacateManageTemp);
					try {
						emailService.sendMailAttenVacate(email);
					} catch (EmailException e) {
						e.printStackTrace();
					}
				}
			}
			
		}*/
		// 二级驳回删除考勤信息表相关的请假信息
		if ("re1".equals(approveStatus) || "re2".equals(approveStatus) || "re3".equals(approveStatus) || "re4".equals(approveStatus)) {
			AttendanceImpl attendance = new AttendanceImpl();
			Long idVacateManage2 = attenVacateManageTemp.getId();
			attendance.setIdVacateManage(idVacateManage2);
			attendance.setRemarkReject(remarkReject);
			// 考勤状态(vacate:v请假,attendance:a 考勤)
			attendance.setStatusVacate("a");
			if ("a".equals(typeData) && ! "re4".equals(approveStatus)) {
				// 新状态(no:正常,ns: not sign in 需要补签,re:补签,ap1：一级经理审批，ap2:人事部经理审批)
				attendance.setStatusAttendance(approveStatus);
				/*// 根据当时日期,延后两天可补签的考勤日
				Calendar ca = Calendar.getInstance();
				ca.setTime(new Date());
				ca.add(Calendar.DAY_OF_MONTH, +2);
				attendance.setDaySignIn(ca.getTime());*/
				// 取得考勤表中信息
				AttendanceImpl attendance2 = new AttendanceImpl();
				attendance2.setIdVacateManage(idVacateManage2);
				attendance2 = (AttendanceImpl) attendanceMapper.get(attendance2);
				if (null != attendance2) {
					// 驳回标记(y,驳回过 n, 没有驳回)
					String tagReject = attendance2.getTagReject();
					if ("n".equals(tagReject)) {
						// 新状态(no:正常,ns: not sign in 需要补签,re:补签,ap1：一级经理审批，ap2:人事部经理审批)
						// 根据当时日期,延后两天可补签的考勤日
						Calendar ca = Calendar.getInstance();
						ca.setTime(new Date());
						ca.add(Calendar.DAY_OF_MONTH, +3);
						attendance.setDaySignIn(ca.getTime());
						attendance.setTagReject("y");
					}
				}
			}
			if ("re4".equals(approveStatus)) {
				// 新状态(no:正常,ns: not sign in 需要补签,re:补签,ap1：一级经理审批，ap2:人事部经理审批)
				attendance.setStatusAttendance("re2");
				// 根据当时日期,延后两天可补签的考勤日
				Calendar ca = Calendar.getInstance();
				ca.setTime(new Date());
				ca.add(Calendar.DAY_OF_MONTH, -2);
				attendance.setDaySignIn(ca.getTime());
			}
			attendanceMapper.update(attendance);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenVacateManage
	 */
	@SuppressWarnings("unchecked")
	public List<AttenVacateManageImpl> select(AttenVacateManageImpl attenVacateManage) throws PmException {
		return (List<AttenVacateManageImpl>) this.attenVacateManageMapper.select(attenVacateManage);
	}
	/**
	 * 查询单个实体
	 * @param attenVacateManage
	 */
	public AttenVacateManageImpl get(AttenVacateManageImpl attenVacateManage) throws PmException {
		return (AttenVacateManageImpl) this.attenVacateManageMapper.get(attenVacateManage);
	}
	/**
	 * 查询实体分页列表
	 * @param attenVacateManage
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenVacateManageImpl> search(AttenVacateManageImpl attenVacateManage) throws PmException {
		DataGrid<AttenVacateManageImpl> grid = new DataGrid<AttenVacateManageImpl>();
		Object obj = attenVacateManage;
		List list = attenVacateManageMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenVacateManageMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	/**
	 * 更新考勤中的请假信息
	 * @param attenVacateManage
	 */
	public void updateAttendanceVacate(AttenVacateManageImpl attenVacateManage) {
		Long idVacateManage = attenVacateManage.getId();
		// 插入对应的考勤记录
		// 取得考勤类型请假方式(h:按小时，d:按天)
		String typeVacateDate = attenVacateManage.getTypeVacateDate();
		// 如果是按天，那么插入对应时间段内的所有考勤记录
		//取得起始和结束时间
		String dateStart = attenVacateManage.getDateStart();
		String userName = attenVacateManage.getUserName();
		String userId = attenVacateManage.getUserId();
		String cardNO = attenVacateManage.getCardNo();
		String divisionId = attenVacateManage.getDivisionId();
		String divisionName = attenVacateManage.getDivisionName();
		String codeVacate = attenVacateManage.getCode();
		String codeVacateDetail = attenVacateManage.getCodeDetail(); 
		Long idVacate = attenVacateManage.getIdVacate();
		Long idVacateDetail = attenVacateManage.getIdVacateDetail();
		String hourStartAttenVacate = attenVacateManage.getHourStart();
		String hourEndAttenVacate = attenVacateManage.getHourEnd();
		String minuteStartAttenVacate = attenVacateManage.getMinuteStart();
		String minuteEndAttenVacate = attenVacateManage.getMinuteEnd();
		Double durationAttenVacate = (attenVacateManage.getDuration() != null ? Double.valueOf(attenVacateManage.getDuration()): 0);
		if ("d".equals(typeVacateDate)) {
			String dateEnd = attenVacateManage.getDateEnd();
			try {
				Date dateStartTemp = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
				Date dateEndTemp = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
				Integer daysBetween = CommonUtil.daysBetween(dateStartTemp, dateEndTemp);
				AttendanceImpl attendance = new AttendanceImpl();
				attendance.setUserId(userId);
				attendance.setUserName(userName);
				attendance.setCardNo(cardNO);
				attendance.setDate(dateStart);
				// 取得月份
				String dateMonth = new SimpleDateFormat("yyyy-MM").format(dateStartTemp);
				attendance.setDateMonth(dateMonth);
				// 请假状态(vacate:v请假,normal:n正常)
				attendance.setStatusVacate("v");
				attendance.setDivisionId(divisionId);
				attendance.setDivisionName(divisionName);
				attendance.setCodeVacate(codeVacate);
				attendance.setCodeVacateDetail(codeVacateDetail);
				attendance.setIdVacateManage(idVacateManage);
				attendance.setIdVacate(idVacate);
				attendance.setIdVacateDetail(idVacateDetail);
				attendance.setTypeVacateDate(typeVacateDate);
				//　如果为零那么只插入一条数据
				if (null != daysBetween && 0 == daysBetween) {
					//  取得今天的考勤是记录,没有的情况下插入,有的话更新
					AttendanceImpl attendanceIn = new AttendanceImpl();
					attendanceIn.setDate(dateStart);
					attendanceIn.setUserId(userId);
					attendanceIn.setIdVacateManage(idVacateManage);
					AttendanceImpl attendanceIn2 = (AttendanceImpl) attendanceMapper.get(attendanceIn);
					if (null != attendanceIn2) {
						attendance.setEditState("u");
						CommonUtil.setCommonModifyField(attendance);
						attendance.setTagUpdate("updateVacateAll");
						if (userId != null && dateStart != null) {
							attendanceMapper.update(attendance);
						}
					}
					else {
						attendance.setEditState("i");
						CommonUtil.setCommonModifyField(attendance);
						attendanceMapper.insert(attendance);
					}
				} else if (null != daysBetween && daysBetween > 0) {
					for (int i = 0; i <= daysBetween; i++) {
						attendance.setDate(dateStart);
						attendance.setId(null);
						AttendanceImpl attendanceTemp = new AttendanceImpl();
						attendanceTemp.setDate(dateStart);
						dateMonth = new SimpleDateFormat("yyyy-MM").format(dateStartTemp);
						attendanceTemp.setCardNo(cardNO);
						attendanceTemp = (AttendanceImpl)attendanceMapper.get(attendanceTemp);
						if (null == attendanceTemp) {
							attendance.setDateMonth(dateMonth);
							attendance.setStatusVacate("v");
							attendance.setDateMonth(dateMonth);
							attendance.setDivisionId(divisionId);
							attendance.setDivisionName(divisionName);
							attendance.setUserId(userId);
							attendance.setIdVacateManage(idVacateManage);
							attendance.setIdVacate(idVacate);
							attendance.setIdVacateDetail(idVacateDetail);
							attendance.setCodeVacate(codeVacate);
							attendance.setCodeVacateDetail(codeVacateDetail);
							attendance.setTypeVacateDate(typeVacateDate);
							attendance.setEditState("i");
							CommonUtil.setCommonModifyField(attendance);
							attendanceMapper.insert(attendance);
							// 审批后的记录,要更新工作时长
							try {
								String typeDateTemp = this.getTypeDate(dateStart);
								attendance.setTypeDate(typeDateTemp);
								attendanceService.calculateAttendanceWork(attendance);
								attendance.setEditState("u");
								CommonUtil.setCommonModifyField(attendance);
								attendanceService.update(attendance);
							} catch (PmException e) {
								e.printStackTrace();
							}
						} else {
							Long id = attendanceTemp.getId();
							attendanceTemp = new AttendanceImpl();
							attendanceTemp.setId(id);
							attendanceTemp.setStatusVacate("v");
							attendanceTemp.setDateMonth(dateMonth);
							attendanceTemp.setDivisionId(divisionId);
							attendanceTemp.setDivisionName(divisionName);
							attendanceTemp.setUserId(userId);
							attendanceTemp.setIdVacateManage(idVacateManage);
							attendanceTemp.setIdVacate(idVacate);
							attendanceTemp.setIdVacateDetail(idVacateDetail);
							attendanceTemp.setCodeVacate(codeVacate);
							attendanceTemp.setCodeVacateDetail(codeVacateDetail);
							attendanceTemp.setTypeVacateDate(typeVacateDate);
							//忽略更新标记,更新时idVacate字段,不参与更新条件
							attendanceTemp.setUpIgnoreIdVacate("y");
							attendanceTemp.setEditState("u");
							CommonUtil.setCommonModifyField(attendanceTemp);
							attendanceMapper.update(attendanceTemp);
							// 审批后的记录,要更新工作时长
							try {
								String typeDateTemp = this.getTypeDate(dateStart);
								attendanceTemp.setTypeDate(typeDateTemp);
								attendanceService.calculateAttendanceWork(attendanceTemp);
								attendanceTemp.setEditState("u");
								CommonUtil.setCommonModifyField(attendanceTemp);
								attendanceService.update(attendanceTemp);
							} catch (PmException e) {
								e.printStackTrace();
							}
						}
						// 日期顺延加一
						Calendar ca = Calendar.getInstance();
						ca.setTime(dateStartTemp);
						ca.add(Calendar.DAY_OF_MONTH, 1);
						dateStart = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
						dateStartTemp = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if ("h".equals(typeVacateDate)) {
			AttendanceImpl attendance = new AttendanceImpl();
			attendance.setUserName(userName);
			attendance.setCardNo(cardNO);
			attendance.setDate(dateStart);
			// 请假状态(vacate:v请假,normal:n正常)
			attendance.setStatusVacate("v");
			attendance.setIdVacateManage(idVacateManage);
			// 小时开始
			String hourStart = attenVacateManage.getHourStart();
			// 小时结束
			String hourEnd = attenVacateManage.getHourEnd();
			// 分钟开始
			String minuteStart = attenVacateManage.getMinuteStart();
			// 分钟结束
			String minuteEnd = attenVacateManage.getMinuteEnd();
			attendance.setVacateTimeStart(hourStart + ":" + minuteStart + ":00");
			attendance.setVacateTimeEnd(hourEnd + ":" + minuteEnd + ":00");
			AttendanceImpl attendanceTemp = new AttendanceImpl();
			attendanceTemp.setCardNo(cardNO);
			attendanceTemp.setDate(dateStart);
			attendanceTemp = (AttendanceImpl)attendanceMapper.get(attendanceTemp);
			if (null == attendanceTemp) {
				attendance.setStatusVacate("v");
				attendance.setDivisionId(divisionId);
				attendance.setDivisionName(divisionName);
				attendance.setUserId(userId);
				attendance.setVacateTimeStart(hourStart + ":" + minuteStart + ":00");
				attendance.setVacateTimeEnd(hourEnd + ":" + minuteEnd + ":00");
				attendance.setIdVacateManage(idVacateManage);
				attendance.setIdVacate(idVacate);
				attendance.setIdVacateDetail(idVacateDetail);
				attendance.setCodeVacate(codeVacate);
				attendance.setCodeVacateDetail(codeVacateDetail);
				attendance.setTypeVacateDate(typeVacateDate);
				attendance.setHourStartAttenVacate(hourStartAttenVacate);
				attendance.setHourEndAttenVacate(hourEndAttenVacate);
				attendance.setMinuteStartAttenVacate(minuteStartAttenVacate);
				attendance.setMinuteEndAttenVacate(minuteEndAttenVacate);
				attendance.setDurationAttenVacate(durationAttenVacate);
				attendance.setEditState("i");
				CommonUtil.setCommonModifyField(attendance);
				attendanceMapper.insert(attendance);
				// 审批后的记录,要更新工作时长
				try {
					String typeDateTemp = this.getTypeDate(dateStart);
					attendance.setTypeDate(typeDateTemp);
					attendanceService.calculateAttendanceWork(attendance);
					CommonUtil.setCommonModifyField(attendance);
					attendance.setEditState("u");
					attendanceService.update(attendance);
				} catch (PmException e) {
					e.printStackTrace();
				}
			} else {
				Long id = attendanceTemp.getId();
				attendanceTemp = new AttendanceImpl();
				attendanceTemp.setId(id);
				attendanceTemp.setStatusVacate("v");
				attendanceTemp.setDivisionId(divisionId);
				attendanceTemp.setDivisionName(divisionName);
				attendanceTemp.setUserId(userId);
				attendanceTemp.setVacateTimeStart(hourStart + ":" + minuteStart + ":00");
				attendanceTemp.setVacateTimeEnd(hourEnd + ":" + minuteEnd + ":00");
				attendanceTemp.setIdVacateManage(idVacateManage);
				attendanceTemp.setIdVacate(idVacate);
				attendanceTemp.setIdVacateDetail(idVacateDetail);
				attendanceTemp.setCodeVacate(codeVacate);
				attendanceTemp.setCodeVacateDetail(codeVacateDetail);
				attendanceTemp.setTypeVacateDate(typeVacateDate);
				attendanceTemp.setHourStartAttenVacate(hourStartAttenVacate);
				attendanceTemp.setHourEndAttenVacate(hourEndAttenVacate);
				attendanceTemp.setMinuteStartAttenVacate(minuteStartAttenVacate);
				attendanceTemp.setMinuteEndAttenVacate(minuteEndAttenVacate);
				attendanceTemp.setDurationAttenVacate(durationAttenVacate);;
				//忽略更新标记,更新时idVacate字段,不参与更新条件
				attendanceTemp.setUpIgnoreIdVacate("y");
				attendanceTemp.setEditState("u");
				CommonUtil.setCommonModifyField(attendanceTemp);
				attendanceMapper.update(attendanceTemp);
				// 审批后的记录,要更新工作时长
				try {
					String typeDateTemp = this.getTypeDate(dateStart);
					attendanceTemp.setTypeDate(typeDateTemp);
					attendanceService.calculateAttendanceWork(attendanceTemp);
					attendanceTemp.setEditState("u");
					CommonUtil.setCommonModifyField(attendanceTemp);
					attendanceService.update(attendanceTemp);
				} catch (PmException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 更新邮件状态
	 */
	public boolean updateEmail(AttenVacateManageImpl attenVacateManage)
			throws PmException {
		boolean result = true;
		try {
			this.attenVacateManageMapper.update(attenVacateManage);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	/**
	 * 根据日期取得工作日状态,(f,w)
	 * @param date
	 * @return
	 */
	private String getTypeDate(String date) {
		String typeDate = "w";
		try {
			// dayOfWeek = "2,3,4,5,6"对应周一到周五
			// 日期类型(f:假日,w:工作日)
			// 根据星期计算工作日状态
			Calendar ca = Calendar.getInstance();
			ca.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			String weekSignIn = String.valueOf(ca.get(ca.DAY_OF_WEEK));
			if ("1".equals(weekSignIn) || "7".equals(weekSignIn)) {
				typeDate = "f";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return typeDate;
	}
	
	/**
	 * 更新加班申请
	 */
	@Override
	public boolean updateWorkOvertime(AttenVacateManageImpl attenVacateManage)
			throws PmException {
			Long idAttenVacateManage = attenVacateManage.getId();
			if(null != idAttenVacateManage){
				attenVacateManage = new AttenVacateManageImpl();
				attenVacateManage.setId(idAttenVacateManage);
				attenVacateManage = (AttenVacateManageImpl) attenVacateManageMapper.get(attenVacateManage);
				String dateStart = attenVacateManage.getDateStart();
				String userId = attenVacateManage.getUserId();
				String divisionId = attenVacateManage.getDivisionId();
				String divisionName = attenVacateManage.getDivisionName();
				String codeVacate = attenVacateManage.getCode();
				String codeVacateDetail = attenVacateManage.getCodeDetail(); 
				Long idVacate = attenVacateManage.getIdVacate();
				Long idVacateDetail = attenVacateManage.getIdVacateDetail();
				String hourStartAttenVacate = attenVacateManage.getHourStart();
				String hourEndAttenVacate = attenVacateManage.getHourEnd();
				String minuteStartAttenVacate = attenVacateManage.getMinuteStart();
				String minuteEndAttenVacate = attenVacateManage.getMinuteEnd();
				String rangeAreaOvertime = attenVacateManage.getRangeArea();
				String durationTemp = attenVacateManage.getDuration();
				Double durationOvertime = 0.00;
				String approver = attenVacateManage.getApproveId();
				String approveStatus = attenVacateManage.getApproveStatus();
				String tagModifyOverwork = attenVacateManage.getTagModifyOverwork();
				if(null != durationTemp){
					durationOvertime = Double.valueOf(attenVacateManage.getDuration());
				}
				String userIdList = attenVacateManage.getUserIdList();
				if(null != approveStatus && approveStatus.startsWith("ap")){
					if(null != userIdList && userIdList.length() > 0){
						String[] arrUserId = userIdList.split(",");
						for (int i = 0; i < arrUserId.length; i++) {
							String userIdTemp = arrUserId[i];
							UserDetailImpl user = new UserDetailImpl();
							user.setUserId(userIdTemp);
							user = (UserDetailImpl)userDetailMapper.get(user);
							if(null == user){
								continue;
							}
							String cardNo = user.getCardNo();
							if(null == cardNo || cardNo.length() == 0){
								continue;
							}
							String userName = user.getDisplayName();
							AttendanceImpl attendance = new AttendanceImpl();
							attendance.setUserId(userIdTemp);
							attendance.setCardNo(user.getCardNo());
							attendance.setDate(dateStart);
							attendance = (AttendanceImpl)attendanceMapper.get(attendance);
							if(null == attendance){
								attendance = new AttendanceImpl();
								attendance.setStatusVacate("a");
								attendance.setDivisionId(divisionId);
								attendance.setDivisionName(divisionName);
								attendance.setUserId(userId);
								attendance.setUserName(userName);
								attendance.setCardNo(cardNo);
								attendance.setDate(dateStart);
								//attendance.setVacateTimeStart(hourStart + ":" + minuteStart + ":00");
								//attendance.setVacateTimeEnd(hourEnd + ":" + minuteEnd + ":00");
								//attendance.setIdVacateManage(idVacateManage);
								attendance.setIdVacateOvertime(idVacate);
								attendance.setIdVacateDetailOvertime(idVacateDetail);
								attendance.setCodeVacateOvertime(codeVacate);
								attendance.setCodeVacateDetailOvertime(codeVacateDetail);
								//attendance.setTypeVacateDate(typeVacateDate);
								attendance.setHourStartOvertime(hourStartAttenVacate);
								attendance.setHourEndOvertime(hourEndAttenVacate);
								attendance.setMinuteStartOvertime(minuteStartAttenVacate);
								attendance.setMinuteEndOvertime(minuteEndAttenVacate);
								//attendance.setDurationAttenVacate(durationAttenVacate);
								String rangeAreaOvertimeApprove = hourStartAttenVacate + ":" + minuteStartAttenVacate
										+ " - " + hourEndAttenVacate + ":" + minuteEndAttenVacate;
								attendance.setRangeAreaOvertimeApprove(rangeAreaOvertimeApprove);
								attendance.setEditState("i");
								attendance.setTagOvertime("y");
								attendance.setRangeAreaOvertime(rangeAreaOvertime);
								attendance.setDurationOvertime(durationOvertime);
								attendance.setIdVacateManageOvertime(idAttenVacateManage);
								//CommonUtil.setCommonModifyField(attendance);
								attendance.setAddDate(new Date());
								attendance.setAddIp(CommonUtil.getIpServer());
								attendance.setAddUser(approver);
								attendance.setTagModifyOverwork(tagModifyOverwork);
								// 计算加班
								attendanceService.calculateAttendanceWork(attendance);
								attendanceMapper.insert(attendance);
							}
							else {
								//attendance.setVacateTimeStart(hourStart + ":" + minuteStart + ":00");
								//attendance.setVacateTimeEnd(hourEnd + ":" + minuteEnd + ":00");
								//attendance.setIdVacateManage(idVacateManage);
								attendance.setIdVacateOvertime(idVacate);
								attendance.setIdVacateDetailOvertime(idVacateDetail);
								attendance.setCodeVacateOvertime(codeVacate);
								attendance.setCodeVacateDetailOvertime(codeVacateDetail);
								//attendance.setTypeVacateDate(typeVacateDate);
								attendance.setHourStartOvertime(hourStartAttenVacate);
								attendance.setHourEndOvertime(hourEndAttenVacate);
								attendance.setMinuteStartOvertime(minuteStartAttenVacate);
								attendance.setMinuteEndOvertime(minuteEndAttenVacate);
								//attendance.setDurationAttenVacate(durationAttenVacate);
								String rangeAreaOvertimeApprove = hourStartAttenVacate + ":" + minuteStartAttenVacate
										+ " - " + hourEndAttenVacate + ":" + minuteEndAttenVacate;
								attendance.setRangeAreaOvertimeApprove(rangeAreaOvertimeApprove);
								attendance.setEditState("u");
								attendance.setTagOvertime("y");
								attendance.setRangeAreaOvertime(rangeAreaOvertime);
								attendance.setDurationOvertime(durationOvertime);
								attendance.setIdVacateManageOvertime(idAttenVacateManage);
								//CommonUtil.setCommonModifyField(attendance);
								// 计算加班
								attendance.setModifiedDate(new Date());
								attendance.setModifiedIp(CommonUtil.getIpServer());
								attendance.setAddUser(approver);
								attendance.setTagModifyOverwork(tagModifyOverwork);
								attendanceService.calculateAttendanceWork(attendance);
								attendanceMapper.update(attendance);
						}
					}
					
//						else if (null != attendance && null != approveStatus && approveStatus.startsWith("re")) {
					}
					// 更新记录为生成完毕
					AttenVacateManageImpl attenVacateManageTemp = new AttenVacateManageImpl();
					attenVacateManageTemp.setId(idAttenVacateManage);
					attenVacateManageTemp.setTagCreateOverwork("y");
					attenVacateManageMapper.update(attenVacateManageTemp);
				}
				else if (null != approveStatus && approveStatus.startsWith("re")) {
					AttendanceImpl attendance = new AttendanceImpl();
					attendance.setTagMapper("updateCreateOverwork");
					attendance.setIdVacateManageOvertime(idAttenVacateManage);
					attendance.setTagOvertime("n");
					// 计算加班
					attendance.setModifiedDate(new Date());
					attendance.setModifiedIp(CommonUtil.getIpServer());
					attendance.setModifiedUser(approver);
					//attendanceService.calculateAttendanceWork(attendance);
					attendanceMapper.update(attendance);
					// 更新记录为生成完毕
					AttenVacateManageImpl attenVacateManageTemp = new AttenVacateManageImpl();
					attenVacateManageTemp.setId(idAttenVacateManage);
					attenVacateManageTemp.setTagCreateOverwork("n");
					attenVacateManageMapper.update(attenVacateManageTemp);
				}
			}
		return true;
	}
}