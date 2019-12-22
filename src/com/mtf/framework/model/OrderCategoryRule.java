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
 * 模块名称: 基础资料 -> 授权规则表 
 * 作者:    Auto
 * 日期:    2016/10/31
 **********************************************
 */
public class OrderCategoryRule extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 科目ID
	private Long id;
	// 类型ap:审批人,di:部门,ca:科目
	private String typeRole;
	// 限定类型的名称
	private String name;
	// 限定规则描述
	private String description;
	// 限定规则编码
	private String code;
	// 规则值
	private String value;
	// 备注
	private String remark;
	// 状态标识(e:enable, d:disable,d:drift,s:submit)
	private String status;
	// 金额下限
	private Double amonutLower;
	// 金额上限
	private Double amonutUpper;
	// 数据类型(a:amount:金额)
	private String typeDate;
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
	public String getTypeRole() {
		return typeRole;
	}

	public void setTypeRole(String typeRole) {
		this.typeRole = typeRole;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Double getAmonutLower() {
		return amonutLower;
	}

	public void setAmonutLower(Double amonutLower) {
		this.amonutLower = amonutLower;
	}
	public Double getAmonutUpper() {
		return amonutUpper;
	}

	public void setAmonutUpper(Double amonutUpper) {
		this.amonutUpper = amonutUpper;
	}
	public String getTypeDate() {
		return typeDate;
	}

	public void setTypeDate(String typeDate) {
		this.typeDate = typeDate;
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