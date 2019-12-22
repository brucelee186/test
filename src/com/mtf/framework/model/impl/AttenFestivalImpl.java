package com.mtf.framework.model.impl;

import java.util.Date;

import com.mtf.framework.model.AttenFestival;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 节假日管理
 * 作者:    Auto
 * 日期:    2015/4/21
 **********************************************
 */
public class AttenFestivalImpl extends AttenFestival {
	private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String idString;
	// 农历日
	private String calendarImperialString;
	// 日历日
	private String calendarString;
	// 日期
	private String dateString;
	// 起始时间
	private String dayStartString;
	// 结束时间
	private String dayEndString;
	
	// 考勤采集时间
	private String collectDate;
	
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getCalendarImperialString() {
		return calendarImperialString;
	}
	public void setCalendarImperialString(String calendarImperialString) {
		this.calendarImperialString = calendarImperialString;
	}
	public String getCalendarString() {
		return calendarString;
	}
	public void setCalendarString(String calendarString) {
		this.calendarString = calendarString;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
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
	

}