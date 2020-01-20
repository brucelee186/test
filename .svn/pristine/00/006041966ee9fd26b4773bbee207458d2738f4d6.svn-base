package com.mtf.framework.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.util.JsonDateSerializer;
import com.mtf.framework.util.JsonDateTimeSerializer;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 报销表
 * 作者:    Auto
 * 日期:    2015/3/16
 **********************************************
 */
public class Reimbursement extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 编号
	private Integer no;
	// 申请人ID
	private String applicantId;
	// 申请人姓名
	private String applicantName;
	// 申请部门ID
	private String applicantDivisionId;
	// 申请部门名称
	private String applicantDivisionName;
	// 申请部门日期
	private Date applicantDivisionDate;
	// 付款人姓名
	private String payeeName;
	// 总金额
	private Double totalAmount;
	// 币种
	private String currencyId;
	//汇率
	private double exchangeRate;
	//转换人民币总金额
	private double totalRmbAmount;
	//实际总金额
	private double actualTotalAmount;
	// 签报人ID
	private String signerId;
	// 签报人名称
	private String signerName;
	// 审核人ID
	private String auditorId;
	// 审核人姓名
	private String auditorName;
	// 是否审核
	private Integer isAudited;
	// 审核日期
	private Date auditDate;
	// 是否导出Flex
	private Integer isExportFlex;
	// 状态（0：可用，1：不可用）
	private Integer status;
	// 创建人ID
	private String createUserId;
	// 创建人姓名
	private String createUserName;
	// 创建人时间
	private Date createDatetime;
	// 更新人ID
	private String updateUserId;
	// 更新人名称
	private String updateUserName;
	// 更新人时间
	private Date updateDatetime;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
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
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getApplicantDivisionDate() {
		return applicantDivisionDate;
	}

	public void setApplicantDivisionDate(Date applicantDivisionDate) {
		this.applicantDivisionDate = applicantDivisionDate;
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
	
	public double getExchangeRate() {
		return exchangeRate;
	}

	
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	
	public double getTotalRmbAmount() {
		return totalRmbAmount;
	}

	
	public void setTotalRmbAmount(double totalRmbAmount) {
		this.totalRmbAmount = totalRmbAmount;
	}

	
	public double getActualTotalAmount() {
		return actualTotalAmount;
	}

	
	public void setActualTotalAmount(double actualTotalAmount) {
		this.actualTotalAmount = actualTotalAmount;
	}

	public String getSignerId() {
		return signerId;
	}

	public void setSignerId(String signerId) {
		this.signerId = signerId;
	}
	public String getSignerName() {
		return signerName;
	}

	public void setSignerName(String signerName) {
		this.signerName = signerName;
	}
	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public Integer getIsAudited() {
		return isAudited;
	}

	public void setIsAudited(Integer isAudited) {
		this.isAudited = isAudited;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public Integer getIsExportFlex() {
		return isExportFlex;
	}

	public void setIsExportFlex(Integer isExportFlex) {
		this.isExportFlex = isExportFlex;
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