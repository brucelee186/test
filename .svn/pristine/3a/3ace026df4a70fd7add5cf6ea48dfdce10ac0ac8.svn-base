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
 * 模块名称: 基础资料 -> 考勤审批记录
 * 作者:    Auto
 * 日期:    2015/8/5
 **********************************************
 */
public class AttenRecord extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 部门
	private String department;
	// 部门编号
	private String departmentId;
	// 月份
	private String applyMonth;
	// 部门负责人编号
	private String leaderId;
	// 部门负责人姓名
	private String leaderName;
	// 审批状态
	private String approveState;
	// 领取人编号
	private String userId;
	// 记录类型（一级审批:ap1,二级审批:ap2）
	private String tag;
	// 数据类型(attendance:a 补签,vacate:v请假)
	private String typeRecord;
	// 与行政部信息关联字段
	private Long pid;
	// 一级审批标记
	private String approveState1;
	// 二级审批标记
	private String approveState2;
	// 一级审批时间
	private Date approveDate1;
	// 二级审批时间
	private Date approveDate2;
	// 一级审批人编号
	private String approver1;
	// 二级审批人编号
	private String approver2;
	// 采集起始日期
	private String attenCollectDateStart;
	// 采集结束日期
	private String attenCollectDateEnd;
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
	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTypeRecord() {
		return typeRecord;
	}

	public void setTypeRecord(String typeRecord) {
		this.typeRecord = typeRecord;
	}
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getApproveState1() {
		return approveState1;
	}

	public void setApproveState1(String approveState1) {
		this.approveState1 = approveState1;
	}
	public String getApproveState2() {
		return approveState2;
	}

	public void setApproveState2(String approveState2) {
		this.approveState2 = approveState2;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate1() {
		return approveDate1;
	}

	public void setApproveDate1(Date approveDate1) {
		this.approveDate1 = approveDate1;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate2() {
		return approveDate2;
	}

	public void setApproveDate2(Date approveDate2) {
		this.approveDate2 = approveDate2;
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
	public String getAttenCollectDateStart() {
		return attenCollectDateStart;
	}

	public void setAttenCollectDateStart(String attenCollectDateStart) {
		this.attenCollectDateStart = attenCollectDateStart;
	}
	public String getAttenCollectDateEnd() {
		return attenCollectDateEnd;
	}

	public void setAttenCollectDateEnd(String attenCollectDateEnd) {
		this.attenCollectDateEnd = attenCollectDateEnd;
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