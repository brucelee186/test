package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

import com.mtf.framework.util.JsonDateSerializer;

import com.mtf.framework.util.JsonDateTimeSerializer;

import com.mtf.framework.util.JsonYearSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 考勤数据采集
 * 作者:    Auto
 * 日期:    2018/5/9
 **********************************************
 */
public class Attendance extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 用户编号
	private String userId;
	// 用户名
	private String userName;
	// 部门编号
	private String divisionId;
	// 部门名称
	private String divisionName;
	// 员工卡编号
	private String cardNo;
	// 打卡起始时间（年月日格式）(例:2015-05-25 09:11:00)
	private Date timeStart;
	// 打卡结束时间（年月日格式）(例:2015-05-25 09:11:00)
	private Date timeEnd;
	// 打卡起始时间(例:09:11:00)
	private String dayStart;
	// 打卡结束时间(例:09:11:00)
	private String dayEnd;
	// 规定打卡起始时间(例:09:11:00)
	private String dayStartRule;
	// 规定打卡结束时间(例:09:11:00)
	private String dayEndRule;
	// 请假起始时间 (时分秒格式）(09:11:00)
	private String vacateTimeStart;
	// 请假结束时间 (时分秒格式）(09:11:00)
	private String vacateTimeEnd;
	// 日
	private String day;
	// 月
	private String dateMonth;
	// 周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
	private String dateWeek;
	// 打卡日期
	private String date;
	// 打卡日期所在月份
	private String dateAddMonth;
	// 工作时间(hh:mm:ss格式)
	private String timeWork;
	// 工作时间(小数格式)
	private Double workTime;
	// 实际工作时间(小数格式)
	private Double workTimeTrue;
	// 加班时间(小数格式)
	private Double workOvertime;
	// 加班时间上班前(小数格式)
	private Double workOvertimeBefore;
	// 加班时间下班后(小数格式)
	private Double workOvertimeAfter;
	// 迟到(1:迟到,0,正常. 累加用)
	private String late;
	// 早退(1:早退,0,正常. 累加用)
	private String leaveEarly;
	// 半勤(1:半勤,0,正常. 累加用)
	private String attendHalf;
	// 旷工(1:旷工,0,正常. 累加用)
	private String absenteeism;
	// 考勤状态(no:正常,re:补签,le:早退,la:迟到,lale:迟到早退,ap1：一级经理审批，ap2:人事部经理审批,旷工:ab, absenteeism) 
    // 新状态(no:正常,ns: not sign in 需要补签,re:补签,ap1：一级经理审批，ap2:人事部经理审批)
	private String statusAttendance;
	// 审批状态（,ap1：一级经理审批，ap2:人事部经理审批,）
	private String statusApprove;
	// 考勤状态(vacate:v请假,attendance:a 考勤)
	private String statusVacate;
	// 考勤主表编号
	private Long idVacateManage;
	// 假期类型主表编号
	private Long idVacate;
	// 考勤假别编号
	private String codeVacate;
	// 假期类型明细编号
	private Long idVacateDetail;
	// 考勤假别编号明细
	private String codeVacateDetail;
	// 请假方式(h:按小时，d:按天)
	private String typeVacateDate;
	// 小时开始
	private String hourStartAttenVacate;
	// 小时结束
	private String hourEndAttenVacate;
	// 分钟开始
	private String minuteStartAttenVacate;
	// 分钟结束
	private String minuteEndAttenVacate;
	// 请假时长(按小时申请时小于8小时)
	private Double durationAttenVacate;
	// 本次考勤记录的截止补签日
	private Date daySignIn;
	// 补签地点
	private String signinLocation;
	// 补签时间段
	private String signinDate;
	// 打卡次数
	private Long ticks;
	// 备注
	private String remark;
	// 驳回备注
	private String remarkReject;
	// 驳回标记(y,驳回过 n, 没有驳回)
	private String tagReject;
	// 考勤调整标记(y,调整过，null或者n没有)
	private String tagAdjust;
	// 是否按年循环(y, n)
	private String loopYear;
	// 日期类型(f:假日,w:周末变更为上班日期)
	private String typeDate;
	// 节日名称
	private String festivelName;
	// 部门审批编号
	private Long attendRecordIdAp1;
	// 行政审批编号
	private Long attendRecordIdAp2;
	// 加班标记(y,有加班 n, 无加班)
	private String tagOvertime;
	// 请假标记(y,有请假 n, 无请假)
	private String tagVacateManage;
	// 考勤主表编号
	private Long idVacateManageOvertime;
	// 考勤类型主表编号
	private Long idVacateOvertime;
	// 考勤假别编号
	private String codeVacateOvertime;
	// 假期类型明细编号
	private Long idVacateDetailOvertime;
	// 考勤类型编号明细
	private String codeVacateDetailOvertime;
	// 加班方式(h:按小时，d:按天)
	private String typeVacateDateOvertime;
	// 加班小时开始
	private String hourStartOvertime;
	// 加班小时结束
	private String hourEndOvertime;
	// 加班分钟开始
	private String minuteStartOvertime;
	// 加班分钟结束
	private String minuteEndOvertime;
	// 规定加班时长(按小时申请时小于8小时)
	private Double durationOvertime;
	// 早前规定加班时长(按小时申请时小于8小时)
	private Double durationOvertimeBefore;
	// 晚后规定加班时长(按小时申请时小于8小时)
	private Double durationOvertimeAfter;
	// 申请后加班时间(小数格式)
	private Double workOvertimeApprove;
	// 申请后加班时间上班前(小数格式)
	private Double workOvertimeBeforeApprove;
	// 申请后加班时间下班后(小数格式)
	private Double workOvertimeAfterApprove;
	// 工作起始时间
	private String rangeAreaOvertime;
	// 申请加班起始时间
	private String rangeAreaOvertimeApprove;
	// 加班修正标记(y:更新完毕,n:未更新)
	private String tagModifyOverwork;
	// 创建时间
	private Date addDate;
	// 创建者
	private String addUser;
	// IP地址
	private String addIp;
	// 修改时间
	private Date modifiedDate;
	// 修改者
	private String modifiedUser;
	// IP地址
	private String modifiedIp;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}
	public String getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(String dayEnd) {
		this.dayEnd = dayEnd;
	}
	public String getDayStartRule() {
		return dayStartRule;
	}

	public void setDayStartRule(String dayStartRule) {
		this.dayStartRule = dayStartRule;
	}
	public String getDayEndRule() {
		return dayEndRule;
	}

	public void setDayEndRule(String dayEndRule) {
		this.dayEndRule = dayEndRule;
	}
	public String getVacateTimeStart() {
		return vacateTimeStart;
	}

	public void setVacateTimeStart(String vacateTimeStart) {
		this.vacateTimeStart = vacateTimeStart;
	}
	public String getVacateTimeEnd() {
		return vacateTimeEnd;
	}

	public void setVacateTimeEnd(String vacateTimeEnd) {
		this.vacateTimeEnd = vacateTimeEnd;
	}
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public String getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}
	public String getDateWeek() {
		return dateWeek;
	}

	public void setDateWeek(String dateWeek) {
		this.dateWeek = dateWeek;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getDateAddMonth() {
		return dateAddMonth;
	}

	public void setDateAddMonth(String dateAddMonth) {
		this.dateAddMonth = dateAddMonth;
	}
	public String getTimeWork() {
		return timeWork;
	}

	public void setTimeWork(String timeWork) {
		this.timeWork = timeWork;
	}
	public Double getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Double workTime) {
		this.workTime = workTime;
	}
	public Double getWorkTimeTrue() {
		return workTimeTrue;
	}

	public void setWorkTimeTrue(Double workTimeTrue) {
		this.workTimeTrue = workTimeTrue;
	}
	public Double getWorkOvertime() {
		return workOvertime;
	}

	public void setWorkOvertime(Double workOvertime) {
		this.workOvertime = workOvertime;
	}
	public Double getWorkOvertimeBefore() {
		return workOvertimeBefore;
	}

	public void setWorkOvertimeBefore(Double workOvertimeBefore) {
		this.workOvertimeBefore = workOvertimeBefore;
	}
	public Double getWorkOvertimeAfter() {
		return workOvertimeAfter;
	}

	public void setWorkOvertimeAfter(Double workOvertimeAfter) {
		this.workOvertimeAfter = workOvertimeAfter;
	}
	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}
	public String getLeaveEarly() {
		return leaveEarly;
	}

	public void setLeaveEarly(String leaveEarly) {
		this.leaveEarly = leaveEarly;
	}
	public String getAttendHalf() {
		return attendHalf;
	}

	public void setAttendHalf(String attendHalf) {
		this.attendHalf = attendHalf;
	}
	public String getAbsenteeism() {
		return absenteeism;
	}

	public void setAbsenteeism(String absenteeism) {
		this.absenteeism = absenteeism;
	}
	public String getStatusAttendance() {
		return statusAttendance;
	}

	public void setStatusAttendance(String statusAttendance) {
		this.statusAttendance = statusAttendance;
	}
	public String getStatusApprove() {
		return statusApprove;
	}

	public void setStatusApprove(String statusApprove) {
		this.statusApprove = statusApprove;
	}
	public String getStatusVacate() {
		return statusVacate;
	}

	public void setStatusVacate(String statusVacate) {
		this.statusVacate = statusVacate;
	}
	public Long getIdVacateManage() {
		return idVacateManage;
	}

	public void setIdVacateManage(Long idVacateManage) {
		this.idVacateManage = idVacateManage;
	}
	public Long getIdVacate() {
		return idVacate;
	}

	public void setIdVacate(Long idVacate) {
		this.idVacate = idVacate;
	}
	public String getCodeVacate() {
		return codeVacate;
	}

	public void setCodeVacate(String codeVacate) {
		this.codeVacate = codeVacate;
	}
	public Long getIdVacateDetail() {
		return idVacateDetail;
	}

	public void setIdVacateDetail(Long idVacateDetail) {
		this.idVacateDetail = idVacateDetail;
	}
	public String getCodeVacateDetail() {
		return codeVacateDetail;
	}

	public void setCodeVacateDetail(String codeVacateDetail) {
		this.codeVacateDetail = codeVacateDetail;
	}
	public String getTypeVacateDate() {
		return typeVacateDate;
	}

	public void setTypeVacateDate(String typeVacateDate) {
		this.typeVacateDate = typeVacateDate;
	}
	public String getHourStartAttenVacate() {
		return hourStartAttenVacate;
	}

	public void setHourStartAttenVacate(String hourStartAttenVacate) {
		this.hourStartAttenVacate = hourStartAttenVacate;
	}
	public String getHourEndAttenVacate() {
		return hourEndAttenVacate;
	}

	public void setHourEndAttenVacate(String hourEndAttenVacate) {
		this.hourEndAttenVacate = hourEndAttenVacate;
	}
	public String getMinuteStartAttenVacate() {
		return minuteStartAttenVacate;
	}

	public void setMinuteStartAttenVacate(String minuteStartAttenVacate) {
		this.minuteStartAttenVacate = minuteStartAttenVacate;
	}
	public String getMinuteEndAttenVacate() {
		return minuteEndAttenVacate;
	}

	public void setMinuteEndAttenVacate(String minuteEndAttenVacate) {
		this.minuteEndAttenVacate = minuteEndAttenVacate;
	}
	public Double getDurationAttenVacate() {
		return durationAttenVacate;
	}

	public void setDurationAttenVacate(Double durationAttenVacate) {
		this.durationAttenVacate = durationAttenVacate;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDaySignIn() {
		return daySignIn;
	}

	public void setDaySignIn(Date daySignIn) {
		this.daySignIn = daySignIn;
	}
	public String getSigninLocation() {
		return signinLocation;
	}

	public void setSigninLocation(String signinLocation) {
		this.signinLocation = signinLocation;
	}
	public String getSigninDate() {
		return signinDate;
	}

	public void setSigninDate(String signinDate) {
		this.signinDate = signinDate;
	}
	public Long getTicks() {
		return ticks;
	}

	public void setTicks(Long ticks) {
		this.ticks = ticks;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkReject() {
		return remarkReject;
	}

	public void setRemarkReject(String remarkReject) {
		this.remarkReject = remarkReject;
	}
	public String getTagReject() {
		return tagReject;
	}

	public void setTagReject(String tagReject) {
		this.tagReject = tagReject;
	}
	public String getTagAdjust() {
		return tagAdjust;
	}

	public void setTagAdjust(String tagAdjust) {
		this.tagAdjust = tagAdjust;
	}
	public String getLoopYear() {
		return loopYear;
	}

	public void setLoopYear(String loopYear) {
		this.loopYear = loopYear;
	}
	public String getTypeDate() {
		return typeDate;
	}

	public void setTypeDate(String typeDate) {
		this.typeDate = typeDate;
	}
	public String getFestivelName() {
		return festivelName;
	}

	public void setFestivelName(String festivelName) {
		this.festivelName = festivelName;
	}
	public Long getAttendRecordIdAp1() {
		return attendRecordIdAp1;
	}

	public void setAttendRecordIdAp1(Long attendRecordIdAp1) {
		this.attendRecordIdAp1 = attendRecordIdAp1;
	}
	public Long getAttendRecordIdAp2() {
		return attendRecordIdAp2;
	}

	public void setAttendRecordIdAp2(Long attendRecordIdAp2) {
		this.attendRecordIdAp2 = attendRecordIdAp2;
	}
	public String getTagOvertime() {
		return tagOvertime;
	}

	public void setTagOvertime(String tagOvertime) {
		this.tagOvertime = tagOvertime;
	}
	public String getTagVacateManage() {
		return tagVacateManage;
	}

	public void setTagVacateManage(String tagVacateManage) {
		this.tagVacateManage = tagVacateManage;
	}
	public Long getIdVacateManageOvertime() {
		return idVacateManageOvertime;
	}

	public void setIdVacateManageOvertime(Long idVacateManageOvertime) {
		this.idVacateManageOvertime = idVacateManageOvertime;
	}
	public Long getIdVacateOvertime() {
		return idVacateOvertime;
	}

	public void setIdVacateOvertime(Long idVacateOvertime) {
		this.idVacateOvertime = idVacateOvertime;
	}
	public String getCodeVacateOvertime() {
		return codeVacateOvertime;
	}

	public void setCodeVacateOvertime(String codeVacateOvertime) {
		this.codeVacateOvertime = codeVacateOvertime;
	}
	public Long getIdVacateDetailOvertime() {
		return idVacateDetailOvertime;
	}

	public void setIdVacateDetailOvertime(Long idVacateDetailOvertime) {
		this.idVacateDetailOvertime = idVacateDetailOvertime;
	}
	public String getCodeVacateDetailOvertime() {
		return codeVacateDetailOvertime;
	}

	public void setCodeVacateDetailOvertime(String codeVacateDetailOvertime) {
		this.codeVacateDetailOvertime = codeVacateDetailOvertime;
	}
	public String getTypeVacateDateOvertime() {
		return typeVacateDateOvertime;
	}

	public void setTypeVacateDateOvertime(String typeVacateDateOvertime) {
		this.typeVacateDateOvertime = typeVacateDateOvertime;
	}
	public String getHourStartOvertime() {
		return hourStartOvertime;
	}

	public void setHourStartOvertime(String hourStartOvertime) {
		this.hourStartOvertime = hourStartOvertime;
	}
	public String getHourEndOvertime() {
		return hourEndOvertime;
	}

	public void setHourEndOvertime(String hourEndOvertime) {
		this.hourEndOvertime = hourEndOvertime;
	}
	public String getMinuteStartOvertime() {
		return minuteStartOvertime;
	}

	public void setMinuteStartOvertime(String minuteStartOvertime) {
		this.minuteStartOvertime = minuteStartOvertime;
	}
	public String getMinuteEndOvertime() {
		return minuteEndOvertime;
	}

	public void setMinuteEndOvertime(String minuteEndOvertime) {
		this.minuteEndOvertime = minuteEndOvertime;
	}
	public Double getDurationOvertime() {
		return durationOvertime;
	}

	public void setDurationOvertime(Double durationOvertime) {
		this.durationOvertime = durationOvertime;
	}
	public Double getDurationOvertimeBefore() {
		return durationOvertimeBefore;
	}

	public void setDurationOvertimeBefore(Double durationOvertimeBefore) {
		this.durationOvertimeBefore = durationOvertimeBefore;
	}
	public Double getDurationOvertimeAfter() {
		return durationOvertimeAfter;
	}

	public void setDurationOvertimeAfter(Double durationOvertimeAfter) {
		this.durationOvertimeAfter = durationOvertimeAfter;
	}
	public Double getWorkOvertimeApprove() {
		return workOvertimeApprove;
	}

	public void setWorkOvertimeApprove(Double workOvertimeApprove) {
		this.workOvertimeApprove = workOvertimeApprove;
	}
	public Double getWorkOvertimeBeforeApprove() {
		return workOvertimeBeforeApprove;
	}

	public void setWorkOvertimeBeforeApprove(Double workOvertimeBeforeApprove) {
		this.workOvertimeBeforeApprove = workOvertimeBeforeApprove;
	}
	public Double getWorkOvertimeAfterApprove() {
		return workOvertimeAfterApprove;
	}

	public void setWorkOvertimeAfterApprove(Double workOvertimeAfterApprove) {
		this.workOvertimeAfterApprove = workOvertimeAfterApprove;
	}
	public String getRangeAreaOvertime() {
		return rangeAreaOvertime;
	}

	public void setRangeAreaOvertime(String rangeAreaOvertime) {
		this.rangeAreaOvertime = rangeAreaOvertime;
	}
	public String getRangeAreaOvertimeApprove() {
		return rangeAreaOvertimeApprove;
	}

	public void setRangeAreaOvertimeApprove(String rangeAreaOvertimeApprove) {
		this.rangeAreaOvertimeApprove = rangeAreaOvertimeApprove;
	}
	public String getTagModifyOverwork() {
		return tagModifyOverwork;
	}

	public void setTagModifyOverwork(String tagModifyOverwork) {
		this.tagModifyOverwork = tagModifyOverwork;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public String getModifiedIp() {
		return modifiedIp;
	}

	public void setModifiedIp(String modifiedIp) {
		this.modifiedIp = modifiedIp;
	}
}