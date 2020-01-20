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
 * 模块名称: 基础资料 -> 角色权限列表
 * 作者:    Auto
 * 日期:    2016/11/2
 **********************************************
 */
public class RolePermission extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 权限编号
	private Long id;
	// 角色编号
	private String roleId;
	// 权限编码
	private String code;
	// 父权限
	private String parentCode;
	// 角色类型(s:系统,d:部门,u:用户)
	private String type;
	// 角色类型编号
	private String typeId;
	// 记录类型(r: reference 引用外表,n: non reference 非外用外表)
	private String typeSys;
	// 继承 y:是,n:否
	private String haveExtends;
	// 继承编码有效 y:是,n:否
	private String haveCode;
	// 一级审批人
	private String approver1;
	// 二级审批人
	private String approver2;
	// 三级审批人
	private String approver3;
	// 一级审批人是否使用限定金额　 y:是,n:否
	private String approver1Limit;
	// 一级审批人如果使用取得限定规则编号
	private Long approver1LimitRuleId;
	// 一级审批人金额下限
	private Double approver1AmonutLower;
	// 一级审批人金额上限
	private Double approver1AmonutUpper;
	// 二级审批人是否使用限定金额　 y:是,n:否
	private String approver2Limit;
	// 三级审批人是否使用限定金额　 y:是,n:否
	private String approver3Limit;
	// 审批类型(一级:l1,二级:l2,双审:ld)
	private String approveType;
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
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeSys() {
		return typeSys;
	}

	public void setTypeSys(String typeSys) {
		this.typeSys = typeSys;
	}
	public String getHaveExtends() {
		return haveExtends;
	}

	public void setHaveExtends(String haveExtends) {
		this.haveExtends = haveExtends;
	}
	public String getHaveCode() {
		return haveCode;
	}

	public void setHaveCode(String haveCode) {
		this.haveCode = haveCode;
	}
	public String getApprover1() {
		return approver1;
	}

	public void setApprover1(String approver1) {
		this.approver1 = approver1;
	}
	public String getApprover2() {
		return approver2;
	}

	public void setApprover2(String approver2) {
		this.approver2 = approver2;
	}
	public String getApprover3() {
		return approver3;
	}

	public void setApprover3(String approver3) {
		this.approver3 = approver3;
	}
	public String getApprover1Limit() {
		return approver1Limit;
	}

	public void setApprover1Limit(String approver1Limit) {
		this.approver1Limit = approver1Limit;
	}
	public Long getApprover1LimitRuleId() {
		return approver1LimitRuleId;
	}

	public void setApprover1LimitRuleId(Long approver1LimitRuleId) {
		this.approver1LimitRuleId = approver1LimitRuleId;
	}
	public Double getApprover1AmonutLower() {
		return approver1AmonutLower;
	}

	public void setApprover1AmonutLower(Double approver1AmonutLower) {
		this.approver1AmonutLower = approver1AmonutLower;
	}
	public Double getApprover1AmonutUpper() {
		return approver1AmonutUpper;
	}

	public void setApprover1AmonutUpper(Double approver1AmonutUpper) {
		this.approver1AmonutUpper = approver1AmonutUpper;
	}
	public String getApprover2Limit() {
		return approver2Limit;
	}

	public void setApprover2Limit(String approver2Limit) {
		this.approver2Limit = approver2Limit;
	}
	public String getApprover3Limit() {
		return approver3Limit;
	}

	public void setApprover3Limit(String approver3Limit) {
		this.approver3Limit = approver3Limit;
	}
	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}
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