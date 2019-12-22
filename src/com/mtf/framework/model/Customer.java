package com.mtf.framework.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.util.JsonDateTimeSerializer;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 客户
 * 作者:    Auto
 * 日期:    2015/4/3
 **********************************************
 */
public class Customer extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 名称
	private String name;
	// 别名
	private String alias;
	// PID
	private String pid;
	// 状态码，【0：客户；1：部门】
	private Integer type;
	// 状态码，【0：正常；1：禁用】
	private Integer status;
	// 创建人Id
	private String createUserId;
	// 创建人名称
	private String createUserName;
	// 创建时间
	private Date createDatetime;
	// 更新人ID
	private String updateUserId;
	// 更新人名称
	private String updateUserName;
	// 更新时间
	private Date updateDatetime;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}