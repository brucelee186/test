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
 * 模块名称: 基础资料 -> 考勤时段
 * 作者:    Auto
 * 日期:    2018/4/12
 **********************************************
 */
public class AttenDay extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 时段名称
	private String name;
	// 起始时间
	private Date timeStart;
	// 结束时间
	private Date timeEnd;
	// 起始小时
	private String hourStart;
	// 结束小时
	private String hourEnd;
	// 起始分
	private String minuteStart;
	// 结束分
	private String minuteEnd;
	// 工时系数(请假后可领到的工资比例)
	private String proportion;
	// 工作时长(包括午休时间)
	private Double workDuration;
	// 备注
	private String remark;
	// 起始时间
	private String rangeArea;
	// 标记（d:delete)
	private String tag;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getHourStart() {
		return hourStart;
	}

	public void setHourStart(String hourStart) {
		this.hourStart = hourStart;
	}
	public String getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(String hourEnd) {
		this.hourEnd = hourEnd;
	}
	public String getMinuteStart() {
		return minuteStart;
	}

	public void setMinuteStart(String minuteStart) {
		this.minuteStart = minuteStart;
	}
	public String getMinuteEnd() {
		return minuteEnd;
	}

	public void setMinuteEnd(String minuteEnd) {
		this.minuteEnd = minuteEnd;
	}
	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public Double getWorkDuration() {
		return workDuration;
	}

	public void setWorkDuration(Double workDuration) {
		this.workDuration = workDuration;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRangeArea() {
		return rangeArea;
	}

	public void setRangeArea(String rangeArea) {
		this.rangeArea = rangeArea;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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