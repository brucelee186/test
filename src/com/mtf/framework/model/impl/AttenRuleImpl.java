package com.mtf.framework.model.impl;

import java.util.Date;

import com.informix.util.dateUtil;
import com.mtf.framework.model.AttenRule;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 考勤规则
 * 作者:    Auto
 * 日期:    2015/4/24
 **********************************************
 */
public class AttenRuleImpl extends AttenRule {
	private static final long serialVersionUID = 1L;
	
	// 采集日期
	private String collectDate;
	
	// 起始时间
	private String dayStartString;
	
	// 结束时间
	private String dayEndString;
	
	// 时间段名称1
	private String timeNameSub1;
	
	// 时间段名称2
	private String timeNameSub2;
	
	// 时间段名称3
	private String timeNameSub3;
	
	// 时间段名称4
	private String timeNameSub4;
	
	// 时间段名称5
	private String timeNameSub5;
	
	// 时间段名称6
	private String timeNameSub6;
	
	// 时间段名称7
	private String timeNameSub7;
	
	// 子表开始时间
	private String timeStartSub;
	
	private String timeStartSub1;
	
	private String timeStartSub2;
	
	private String timeStartSub3;
	
	private String timeStartSub4;
	
	private String timeStartSub5;
	
	private String timeStartSub6;
	
	private String timeStartSub7;
	
	// 子表结束时间
	private String timeEndSub;
	
	private String timeEndSub1;
	
	private String timeEndSub2;
	
	private String timeEndSub3;
	
	private String timeEndSub4;
	
	private String timeEndSub5;
	
	private String timeEndSub6;
	
	private String timeEndSub7;
	
	// 部门编号
	private String divisionId;
	
	// 部门名称
	private String divisionName;
	
	// 当前星期日是否为工作日
	private String dayOfWeekSub;
	
	// 更新条件
	private String judApprove;
	
	// 补签日
	private Date daySignIn;
	
	// 邮件路径
	private String pathUpload;
	
	// 是否发送邮件: y 发送, n 不发送
	private String tagEmail;
	
	private String date;
	
	private String rangeArea;
	
	private String attenFestival;

	public String getAttenFestival() {
		return attenFestival;
	}

	public void setAttenFestival(String attenFestival) {
		this.attenFestival = attenFestival;
	}

	public String getRangeArea() {
		return rangeArea;
	}

	public void setRangeArea(String rangeArea) {
		this.rangeArea = rangeArea;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTagEmail() {
		return tagEmail;
	}

	public void setTagEmail(String tagEmail) {
		this.tagEmail = tagEmail;
	}

	public String getPathUpload() {
		return pathUpload;
	}

	public void setPathUpload(String pathUpload) {
		this.pathUpload = pathUpload;
	}

	public Date getDaySignIn() {
		return daySignIn;
	}

	public void setDaySignIn(Date daySignIn) {
		this.daySignIn = daySignIn;
	}

	public String getJudApprove() {
		return judApprove;
	}

	public void setJudApprove(String judApprove) {
		this.judApprove = judApprove;
	}

	public String getDayOfWeekSub() {
		return dayOfWeekSub;
	}

	public void setDayOfWeekSub(String dayOfWeekSub) {
		this.dayOfWeekSub = dayOfWeekSub;
	}

	public String getTimeStartSub() {
		return timeStartSub;
	}

	public void setTimeStartSub(String timeStartSub) {
		this.timeStartSub = timeStartSub;
	}

	public String getTimeEndSub() {
		return timeEndSub;
	}

	public void setTimeEndSub(String timeEndSub) {
		this.timeEndSub = timeEndSub;
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

	public String getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}

	public String getDayStartString() {
		return dayStartString;
	}

	public void setDayStartString(String dayStartString) {
		this.dayStartString = dayStartString;
	}

	public String getDayEndString() {
		return dayEndString;
	}

	public void setDayEndString(String dayEndString) {
		this.dayEndString = dayEndString;
	}

	public String getTimeNameSub1() {
		return timeNameSub1;
	}

	public void setTimeNameSub1(String timeNameSub1) {
		this.timeNameSub1 = timeNameSub1;
	}

	public String getTimeNameSub2() {
		return timeNameSub2;
	}

	public void setTimeNameSub2(String timeNameSub2) {
		this.timeNameSub2 = timeNameSub2;
	}

	public String getTimeNameSub3() {
		return timeNameSub3;
	}

	public void setTimeNameSub3(String timeNameSub3) {
		this.timeNameSub3 = timeNameSub3;
	}

	public String getTimeNameSub4() {
		return timeNameSub4;
	}

	public void setTimeNameSub4(String timeNameSub4) {
		this.timeNameSub4 = timeNameSub4;
	}

	public String getTimeNameSub5() {
		return timeNameSub5;
	}

	public void setTimeNameSub5(String timeNameSub5) {
		this.timeNameSub5 = timeNameSub5;
	}

	public String getTimeNameSub6() {
		return timeNameSub6;
	}

	public void setTimeNameSub6(String timeNameSub6) {
		this.timeNameSub6 = timeNameSub6;
	}

	public String getTimeNameSub7() {
		return timeNameSub7;
	}

	public void setTimeNameSub7(String timeNameSub7) {
		this.timeNameSub7 = timeNameSub7;
	}

	public String getTimeStartSub1() {
		return timeStartSub1;
	}

	public void setTimeStartSub1(String timeStartSub1) {
		this.timeStartSub1 = timeStartSub1;
	}

	public String getTimeStartSub2() {
		return timeStartSub2;
	}

	public void setTimeStartSub2(String timeStartSub2) {
		this.timeStartSub2 = timeStartSub2;
	}

	public String getTimeStartSub3() {
		return timeStartSub3;
	}

	public void setTimeStartSub3(String timeStartSub3) {
		this.timeStartSub3 = timeStartSub3;
	}

	public String getTimeStartSub4() {
		return timeStartSub4;
	}

	public void setTimeStartSub4(String timeStartSub4) {
		this.timeStartSub4 = timeStartSub4;
	}

	public String getTimeStartSub5() {
		return timeStartSub5;
	}

	public void setTimeStartSub5(String timeStartSub5) {
		this.timeStartSub5 = timeStartSub5;
	}

	public String getTimeStartSub6() {
		return timeStartSub6;
	}

	public void setTimeStartSub6(String timeStartSub6) {
		this.timeStartSub6 = timeStartSub6;
	}

	public String getTimeStartSub7() {
		return timeStartSub7;
	}

	public void setTimeStartSub7(String timeStartSub7) {
		this.timeStartSub7 = timeStartSub7;
	}

	public String getTimeEndSub1() {
		return timeEndSub1;
	}

	public void setTimeEndSub1(String timeEndSub1) {
		this.timeEndSub1 = timeEndSub1;
	}

	public String getTimeEndSub2() {
		return timeEndSub2;
	}

	public void setTimeEndSub2(String timeEndSub2) {
		this.timeEndSub2 = timeEndSub2;
	}

	public String getTimeEndSub3() {
		return timeEndSub3;
	}

	public void setTimeEndSub3(String timeEndSub3) {
		this.timeEndSub3 = timeEndSub3;
	}

	public String getTimeEndSub4() {
		return timeEndSub4;
	}

	public void setTimeEndSub4(String timeEndSub4) {
		this.timeEndSub4 = timeEndSub4;
	}

	public String getTimeEndSub5() {
		return timeEndSub5;
	}

	public void setTimeEndSub5(String timeEndSub5) {
		this.timeEndSub5 = timeEndSub5;
	}

	public String getTimeEndSub6() {
		return timeEndSub6;
	}

	public void setTimeEndSub6(String timeEndSub6) {
		this.timeEndSub6 = timeEndSub6;
	}

	public String getTimeEndSub7() {
		return timeEndSub7;
	}

	public void setTimeEndSub7(String timeEndSub7) {
		this.timeEndSub7 = timeEndSub7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}