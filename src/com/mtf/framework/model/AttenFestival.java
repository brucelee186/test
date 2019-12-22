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
 * 模块名称: 基础资料 -> 节假日管理
 * 作者:    Auto
 * 日期:    2015/7/18
 **********************************************
 */
public class AttenFestival extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 父编号
	private Long pid;
	// 节日名称
	private String name;
	// 农历日
	private String calendarImperial;
	// 日历日
	private Date calendar;
	// 日期
	private Date date;
	// 日期（%m-%d格式，年循环专用)
	private String day;
	// 起始时间
	private Date dayStart;
	// 结束时间
	private Date dayEnd;
	// 日期类型(f:假日,w:周末变更为上班日期)
	private String typeDate;
	// 年度
	private String annual;
	// 是否按年循环(y, n)
	private String loopYear;
	// 备注
	private String remark;
	// 标记（d:delete)
	private String tag;
	// 部门编号
	private String divisionId;
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
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCalendarImperial() {
		return calendarImperial;
	}

	public void setCalendarImperial(String calendarImperial) {
		this.calendarImperial = calendarImperial;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCalendar() {
		return calendar;
	}

	public void setCalendar(Date calendar) {
		this.calendar = calendar;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDayStart() {
		return dayStart;
	}

	public void setDayStart(Date dayStart) {
		this.dayStart = dayStart;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(Date dayEnd) {
		this.dayEnd = dayEnd;
	}
	public String getTypeDate() {
		return typeDate;
	}

	public void setTypeDate(String typeDate) {
		this.typeDate = typeDate;
	}
	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}
	public String getLoopYear() {
		return loopYear;
	}

	public void setLoopYear(String loopYear) {
		this.loopYear = loopYear;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
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