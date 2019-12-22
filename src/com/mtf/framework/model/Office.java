package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 办公用品申请表
 * 作者:     Auto
 * 日期:     2014-02-13
 **********************************************
 */
public class Office extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 申请部门
	private String department;
	// 部门ID
	private String departmentId;
	// 申请月份
	private String applyMonth;
	// 部门负责人编号
	private String leaderId;
	// 部门负责人姓名
	private String leaderName;
	// 添加时间
	private Date addDate;
	// 修改时间
	private Date modifiedDate;
	// 审批状态  save:保存，submit:提交审批，commit：审批完毕
	private String approveState;
	// 行政部审批时间
	private Date approve2Date;
	// 部门审批时间
	private Date approve1Date;
	// 部门物品表ID
	private Long depOfficeId;
	// 与部门信息关联字段
	private Long pid;
	// 标记p:个人记录，d:部门记录
	private String flag;
	// 领取人编号
	private String userId;
	// 领取人姓名
	private String userName;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getApplyMonth() {
		return applyMonth;
	}

	public void setApplyMonth(String applyMonth) {
		this.applyMonth = applyMonth;
	}
	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	public Date getApprove2Date() {
		return approve2Date;
	}

	public void setApprove2Date(Date approve2Date) {
		this.approve2Date = approve2Date;
	}
	public Date getApprove1Date() {
		return approve1Date;
	}

	public void setApprove1Date(Date approve1Date) {
		this.approve1Date = approve1Date;
	}
	public Long getDepOfficeId() {
		return depOfficeId;
	}

	public void setDepOfficeId(Long depOfficeId) {
		this.depOfficeId = depOfficeId;
	}
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
}