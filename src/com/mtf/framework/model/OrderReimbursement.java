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
 * 模块名称: 基础资料 -> 申请报销
 * 作者:    Auto
 * 日期:    2016/6/20
 **********************************************
 */
public class OrderReimbursement extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 编号
	private Long id;
	// 报销编号
	private String no;
	// 申请人编号
	private String applicantId;
	// 申请人姓名
	private String applicantName;
	// 申请人部门
	private String applicantDivisionId;
	// 申请人部门名称
	private String applicantDivisionName;
	// 申请日期
	private Date applicantDate;
	// 付款人姓名
	private String payeeName;
	// 总金额
	private Double totalAmount;
	// 币种
	private String currencyId;
	// 汇率
	private String exchangeRate;
	// 人民币总金额
	private Double totalRmbAmount;
	// 实际总金额
	private Double actualTotalAmount;
	// 签报人ID
	private String signerId;
	// 签报人姓名
	private Date signerName;
	// 审批人编号
	private String approverId;
	// 审批人姓名
	private String approverName;
	// 是否需要审批(y,n)
	private String approveNeed;
	// 审批日期
	private Date approveDate;
	// 状态标识(a:active, f:forbid)
	private String status;
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
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantDivisionId() {
		return applicantDivisionId;
	}

	public void setApplicantDivisionId(String applicantDivisionId) {
		this.applicantDivisionId = applicantDivisionId;
	}
	public String getApplicantDivisionName() {
		return applicantDivisionName;
	}

	public void setApplicantDivisionName(String applicantDivisionName) {
		this.applicantDivisionName = applicantDivisionName;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApplicantDate() {
		return applicantDate;
	}

	public void setApplicantDate(Date applicantDate) {
		this.applicantDate = applicantDate;
	}
	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public Double getTotalRmbAmount() {
		return totalRmbAmount;
	}

	public void setTotalRmbAmount(Double totalRmbAmount) {
		this.totalRmbAmount = totalRmbAmount;
	}
	public Double getActualTotalAmount() {
		return actualTotalAmount;
	}

	public void setActualTotalAmount(Double actualTotalAmount) {
		this.actualTotalAmount = actualTotalAmount;
	}
	public String getSignerId() {
		return signerId;
	}

	public void setSignerId(String signerId) {
		this.signerId = signerId;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getSignerName() {
		return signerName;
	}

	public void setSignerName(Date signerName) {
		this.signerName = signerName;
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
	public String getApproveNeed() {
		return approveNeed;
	}

	public void setApproveNeed(String approveNeed) {
		this.approveNeed = approveNeed;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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