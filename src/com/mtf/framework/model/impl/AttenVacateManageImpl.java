package com.mtf.framework.model.impl;

import java.util.Date;
import java.util.List;

import com.mtf.framework.model.AttenVacateManage;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 请假管理
 * 作者:    Auto
 * 日期:    2015/7/3
 **********************************************
 */
public class AttenVacateManageImpl extends AttenVacateManage {
	private static final long serialVersionUID = 1L;
	// 打卡起始时间（年月日格式）(例:2015-05-25 09:11:00)
		private Date timeStart;
		// 打卡结束时间（年月日格式）(例:2015-05-25 09:11:00)
		private Date timeEnd;
		// 打卡起始时间(例:09:11:00)
		private String dayStart;
		// 打卡结束时间(例:09:11:00)
		private String dayEnd;
		// 请假起始时间 (时分秒格式）(09:11:00)
		private String vacateTimeStart;
		// 请假结束时间 (时分秒格式）(09:11:00)
		private String vacateTimeEnd;
		// 日
		private String day;
		// 月
		private String dateMonth;
		// 周
		private String dateWeek;
		// 打卡日期
		private String date;
		// 打卡日期所在月份
		private String dateAddMonth;
		// 工作时间
		private String timeWork;
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
		// 请假状态(vacate:v请假,normal:n正常)
		private String statusVacate;
		// 本次考勤记录的截止补签日
		private Date daySignIn;
		// 打卡次数
		private Long ticks;
		// 备注
		private String remark;
		// 是否按年循环(y, n)
		private String loopYear;
		// 日期类型(f:假日,w:周末变更为上班日期)
		private String typeDate;
		// 节日名称
		private String festivelName;
		
		private String searchUserName;
		
		private String searchDateStart;
		
		private String searchDateEnd;
		
		private String searchIdVacate;
		
		// 批量审批编号集合
		private String arrayVatateId;
		
		// 员工卡号
		private String badgenumber;
		
		// 所具有的部门审批权限
		private List<PermissionImpl> listDivision;
		
		// 页面标记(审批页approve:a,录入页input:i)
		private String tagPage;
		
		// 剩余时长
		private String durationRemain;
		
		// 规定时长
		private String durationRule;
		
		// 时长搜索条件
		private String se_duration;
		// 驳回原因
		private String remarkReject;
		//	补签地点
		private String signinLocation;
		//	补签时间段
		private String signinDate;
		
		// 总计请假时长
		private String durationTotal;
		
		
		// 是否使用SelectColumn标记(n:不使用)
		private String tagSelectColumn;
		
		// 每日考勤备注
		private String remarkAtten;
		
		private List<UserDetailImpl> listUserDetail;
		
		private String arrayUserString;
		
		public String getArrayUserString() {
			return arrayUserString;
		}

		public void setArrayUserString(String arrayUserString) {
			this.arrayUserString = arrayUserString;
		}

		public List<UserDetailImpl> getListUserDetail() {
			return listUserDetail;
		}

		public void setListUserDetail(List<UserDetailImpl> listUserDetail) {
			this.listUserDetail = listUserDetail;
		}

		public String getRemarkAtten() {
			return remarkAtten;
		}

		public void setRemarkAtten(String remarkAtten) {
			this.remarkAtten = remarkAtten;
		}

		public String getTagSelectColumn() {
			return tagSelectColumn;
		}

		public void setTagSelectColumn(String tagSelectColumn) {
			this.tagSelectColumn = tagSelectColumn;
		}

		public String getDurationTotal() {
			return durationTotal;
		}

		public void setDurationTotal(String durationTotal) {
			this.durationTotal = durationTotal;
		}

		private String[] arrayVacate;

		public String[] getArrayVacate() {
			return arrayVacate;
		}

		public void setArrayVacate(String[] arrayVacate) {
			this.arrayVacate = arrayVacate;
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

		public String getRemarkReject() {
			return remarkReject;
		}

		public void setRemarkReject(String remarkReject) {
			this.remarkReject = remarkReject;
		}

		public String getSearchIdVacate() {
			return searchIdVacate;
		}

		public void setSearchIdVacate(String searchIdVacate) {
			this.searchIdVacate = searchIdVacate;
		}

		public String getSe_duration() {
			return se_duration;
		}

		public void setSe_duration(String se_duration) {
			this.se_duration = se_duration;
		}

		public String getDurationRule() {
			return durationRule;
		}

		public void setDurationRule(String durationRule) {
			this.durationRule = durationRule;
		}

		public String getDurationRemain() {
			return durationRemain;
		}

		public void setDurationRemain(String durationRemain) {
			this.durationRemain = durationRemain;
		}

		public Date getTimeStart() {
			return timeStart;
		}

		public void setTimeStart(Date timeStart) {
			this.timeStart = timeStart;
		}

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

		public Date getDaySignIn() {
			return daySignIn;
		}

		public void setDaySignIn(Date daySignIn) {
			this.daySignIn = daySignIn;
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

		public String getSearchUserName() {
			return searchUserName;
		}

		public void setSearchUserName(String searchUserName) {
			this.searchUserName = searchUserName;
		}

		public String getSearchDateStart() {
			return searchDateStart;
		}

		public void setSearchDateStart(String searchDateStart) {
			this.searchDateStart = searchDateStart;
		}

		public String getSearchDateEnd() {
			return searchDateEnd;
		}

		public void setSearchDateEnd(String searchDateEnd) {
			this.searchDateEnd = searchDateEnd;
		}

		public String getArrayVatateId() {
			return arrayVatateId;
		}

		public void setArrayVatateId(String arrayVatateId) {
			this.arrayVatateId = arrayVatateId;
		}

		public String getBadgenumber() {
			return badgenumber;
		}

		public void setBadgenumber(String badgenumber) {
			this.badgenumber = badgenumber;
		}

		public List<PermissionImpl> getListDivision() {
			return listDivision;
		}

		public void setListDivision(List<PermissionImpl> listDivision) {
			this.listDivision = listDivision;
		}

		public String getTagPage() {
			return tagPage;
		}

		public void setTagPage(String tagPage) {
			this.tagPage = tagPage;
		}
}