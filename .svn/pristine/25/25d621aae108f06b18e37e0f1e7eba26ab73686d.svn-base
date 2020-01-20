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
 * 模块名称: 基础资料 -> 科目申请服务
 * 作者:    Auto
 * 日期:    2017/11/23
 **********************************************
 */
public class OrderCategoryService extends CommonModel {
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
	// 付款人编号
	private String payeeId;
	// 付款人类别(u:员工,o other:外来人员)
	private String payeeType;
	// 开户行
	private String bankName;
	// 银行卡号
	private String bankCard;
	// 外币总金额
	private Double totalAmount;
	// 人民币总金额
	private Double totalAmountRmb;
	// 币种
	private String currencyCode;
	// 汇率
	private String exchangeRate;
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
	// 状态标识(e:enable 有效, d:disable 无效,d:drift 草稿,s:submit 提交,a:approving 审批中,re:驳回,af:affirm 账务确认,c:complete 完成)
	private String status;
	// 记录标识(a:active, d:delete, f:forbid)
	private String tag;
	// 数据类型(r:Reimbursement 报销,a:applicant 申请)
	private String typeData;
	// 明细记录数量
	private Integer countDetail;
	// 审批后的记录数量
	private Integer countApprove;
	// 审批完成百分比
	private Integer countApprovePercent;
	// 审批备注
	private String remarkApprove;
	// 订车报销月总统计表编号
	private Long idOrderServiceRecord;
	// 付款方式编号
	private String typePaymentCode;
	// 付款方式名称
	private String typePaymentName;
	// 发票类型编号
	private String typeInvoiceCode;
	// 发票类型名称
	private String typeInvoiceName;
	// 档期（生成月份）
	private String month;
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
	// 附件数量
	private Integer countAttachment;
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
	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeType() {
		return payeeType;
	}

	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getTotalAmountRmb() {
		return totalAmountRmb;
	}

	public void setTotalAmountRmb(Double totalAmountRmb) {
		this.totalAmountRmb = totalAmountRmb;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
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
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}
	public Integer getCountDetail() {
		return countDetail;
	}

	public void setCountDetail(Integer countDetail) {
		this.countDetail = countDetail;
	}
	public Integer getCountApprove() {
		return countApprove;
	}

	public void setCountApprove(Integer countApprove) {
		this.countApprove = countApprove;
	}
	public Integer getCountApprovePercent() {
		return countApprovePercent;
	}

	public void setCountApprovePercent(Integer countApprovePercent) {
		this.countApprovePercent = countApprovePercent;
	}
	public String getRemarkApprove() {
		return remarkApprove;
	}

	public void setRemarkApprove(String remarkApprove) {
		this.remarkApprove = remarkApprove;
	}
	public Long getIdOrderServiceRecord() {
		return idOrderServiceRecord;
	}

	public void setIdOrderServiceRecord(Long idOrderServiceRecord) {
		this.idOrderServiceRecord = idOrderServiceRecord;
	}
	public String getTypePaymentCode() {
		return typePaymentCode;
	}

	public void setTypePaymentCode(String typePaymentCode) {
		this.typePaymentCode = typePaymentCode;
	}
	public String getTypePaymentName() {
		return typePaymentName;
	}

	public void setTypePaymentName(String typePaymentName) {
		this.typePaymentName = typePaymentName;
	}
	public String getTypeInvoiceCode() {
		return typeInvoiceCode;
	}

	public void setTypeInvoiceCode(String typeInvoiceCode) {
		this.typeInvoiceCode = typeInvoiceCode;
	}
	public String getTypeInvoiceName() {
		return typeInvoiceName;
	}

	public void setTypeInvoiceName(String typeInvoiceName) {
		this.typeInvoiceName = typeInvoiceName;
	}
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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
	public Integer getCountAttachment() {
		return countAttachment;
	}

	public void setCountAttachment(Integer countAttachment) {
		this.countAttachment = countAttachment;
	}
}