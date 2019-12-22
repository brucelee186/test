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
 * 日期:    2017/10/23
 **********************************************
 */
public class OrderServiceRecord extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 主表编号
	private Long idOrderService;
	// 月份
	private String applyMonth;
	// 生成日期
	private String date;
	// 生成相对于本月的第几周
	private String week;
	// 生成月份
	private String month;
	// 生成相对于本月日期的第几周包括年月日
	private String weekOfMonth;
	// 部门负责人编号
	private String leaderId;
	// 部门负责人姓名
	private String leaderName;
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
	// 当前审批状态
	private String approveState;
	// 当前审批时间
	private Date approveDate;
	// 当前审批人编号
	private String approverId;
	// 当前审批人姓名
	private String approverName;
	// 数据类型(订车:ov order vehicle, 报销:or order reimbursement)
	private String typeRecord;
	// 总金额
	private Double totalAmount;
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
	public Long getIdOrderService() {
		return idOrderService;
	}

	public void setIdOrderService(Long idOrderService) {
		this.idOrderService = idOrderService;
	}
	public String getApplyMonth() {
		return applyMonth;
	}

	public void setApplyMonth(String applyMonth) {
		this.applyMonth = applyMonth;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	public String getWeekOfMonth() {
		return weekOfMonth;
	}

	public void setWeekOfMonth(String weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
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
	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}
	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public String getTypeRecord() {
		return typeRecord;
	}

	public void setTypeRecord(String typeRecord) {
		this.typeRecord = typeRecord;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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