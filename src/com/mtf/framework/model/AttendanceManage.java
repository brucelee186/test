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
 * 模块名称: 基础资料 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/8/5
 **********************************************
 */
public class AttendanceManage extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 考勤数据采集时间
	private String dateAttenCollection;
	// 考勤统计日(每月几号截止)
	private String dateAttenCount;
	// 备注
	private String remark;
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
	public String getDateAttenCollection() {
		return dateAttenCollection;
	}

	public void setDateAttenCollection(String dateAttenCollection) {
		this.dateAttenCollection = dateAttenCollection;
	}
	public String getDateAttenCount() {
		return dateAttenCount;
	}

	public void setDateAttenCount(String dateAttenCount) {
		this.dateAttenCount = dateAttenCount;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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