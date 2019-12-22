package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 合同
 * 作者:     Auto
 * 日期:     2013/12/3
 **********************************************
 */
public class Application extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	//iid
	private Long iid;
	// ID
	private Long id;
	// 合同生成日期
	private String addDateContract;
	// 父Id
	private Long superId;
	// 修改时间毫秒数（防止并发）
	private Long modified;
	// 合同类型 (1 售货合同 SaleContract:s, 2 订货合同 OrderContract:o, 3 面辅料采购合同 MaterialPurchase:mp, 4 面辅料销售合同: MaterialSellContract:ms, 5 来(进)料服装委托加工合同ManufacturingConsignmentContract:m, 6 服装采购合同ClothingPurchaseContract:c, 7 代理出口协议 AgentExportAgreement:a, 8付款申请表application:ap)
	private String flag;
	// 单据类型：mp/cp/io
	private String applicationType;
	// 付款类型a:预付款，f:应付款
	private String paymentType;
	// 预付款和应付金额是否完成 0/未完成 1/完成
	private Integer paymentFlag;
	// 预付款是否完成（0/未完成，1/已完成）
	private Integer advanceFlag;
	// 部门
	private String department;
	// 供货方
	private String supplier;
	// 支付方式
	private String payment;
	// 商品名称
	private String commodity;
	// 规格
	private String standard;
	// 数量
	private String quantity;
	// 单价
	private String unitPrice;
	// 总金额
	private String totalPrice;
	// 采购面辅料 合同编号 
	private String mpContractNo;
	// 采购面辅料 成品加工方
	private String mpProcessor;
	// 采购面辅料 发票组数（号）（增值税票）
	private String mpInvoice;
	// 采购面辅料 票面金额
	private String mpFaceAmount;
	// 采购面辅料 预付款金额
	private String mpAdvancePayment;
	// 采购面辅料 应付金额
	private String mpFactPayment;
	// 采购面辅料 付款金额
	private String mpPayment;
	// 采购面辅料 未付金额
	private String mpUnpaidAmount;
	// 采购服装 合同编号
	private String cpContractNo;
	// 采购服装 客户
	private String cpCustomer;
	// 采购服装 发票组数（号）（增值税发票）
	private String cpInvoice;
	// 采购服装 出口发票号
	private String cpExportInvoice;
	// 采购服装 票面金额
	private String cpFaceAmount;
	// 采购服装 预付款金额
	private String cpAdvancePayment;
	// 采购服装 面辅料总金额
	private String cpTotalPrice;
	// 采购服装 应付金额
	private String cpFactPayment;
	// 采购服装 付款金额
	private String cpPayment;
	// 采购服装 未付金额
	private String cpUnpaidAmount;
	// 进口货物 合同编号
	private String importContractNo;
	// 进口货物 信用证号
	private String importCreditNo;
	// 进口货物 入库单号
	private String importGarageInID;
	// 进口货物 合同金额
	private String importContractAmount;
	// 进口货物 预付款金额
	private String importAdvancePayment;
	// 进口货物 应付金额
	private String importFactPayment;
	// 进口货物 付款金额
	private String importPayment;
	// 进口货物 未付金额
	private String importUnpaidAmount;
	// 合同状态 budget:已提交预算, saved:已提交审批, submit:已提交, reject1:一级驳回, reject2:二级驳回, approval1:一级审批完毕, approval2:二级审批完毕,payed:付费完成,paying:付费中
	private String approveState;
	// 业务员姓名
	private String approver0;
	// 业务员添加日期
	private Date approverDate0;
	// 一级审批人
	private String approver1;
	// 一级审批日期
	private Date approverDate1;
	// 二级审批人
	private String approver2;
	// 二级审批日期
	private Date approverDate2;
	// 三级审批人
	private String approver3;
	// 三级审批日期
	private Date approverDate3;
	// 添加人
	private String addUser;
	// 添加时间
	private Date addDate;
	// 修改人
	private String modifiedUser;
	// 修改时间
	private Date modifiedDate;
	// 当前审批人
	private String approver;
	// 当前审批日期
	private Date approverDate;
	// 付款人
	private String payUser;
	// 付款时间
	private Date payDate;
	// 合同类型:自制合同:diy, 外方合同:foreign, 订单合同:order
	private String contractType;
	// 驳回原因
	private String rejectReason;
	// 备注
	private String remark;
	// 主合同号
	private String masterContractNo;
	// 操作人编号
	private String approverId;
	// 业务员编号
	private String approverId0;
	// 一级审批人编号
	private String approverId1;
	// 二级审批人
	private String approverId2;
	// 三级审批人编号
	private String approverId3;
	// 最终审批人(2 业务经理 3 事业经理 4 总经理)
	private Integer finalApprover;
	// 审批时的提示信息
	private String approveReason;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getAddDateContract() {
		return addDateContract;
	}

	public void setAddDateContract(String addDateContract) {
		this.addDateContract = addDateContract;
	}
	public Long getSuperId() {
		return superId;
	}

	public void setSuperId(Long superId) {
		this.superId = superId;
	}
	public Long getModified() {
		return modified;
	}

	public void setModified(Long modified) {
		this.modified = modified;
	}
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(Integer paymentFlag) {
		this.paymentFlag = paymentFlag;
	}
	public Integer getAdvanceFlag() {
		return advanceFlag;
	}

	public void setAdvanceFlag(Integer advanceFlag) {
		this.advanceFlag = advanceFlag;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getMpContractNo() {
		return mpContractNo;
	}

	public void setMpContractNo(String mpContractNo) {
		this.mpContractNo = mpContractNo;
	}
	public String getMpProcessor() {
		return mpProcessor;
	}

	public void setMpProcessor(String mpProcessor) {
		this.mpProcessor = mpProcessor;
	}
	public String getMpInvoice() {
		return mpInvoice;
	}

	public void setMpInvoice(String mpInvoice) {
		this.mpInvoice = mpInvoice;
	}
	public String getMpFaceAmount() {
		return mpFaceAmount;
	}

	public void setMpFaceAmount(String mpFaceAmount) {
		this.mpFaceAmount = mpFaceAmount;
	}
	public String getMpAdvancePayment() {
		return mpAdvancePayment;
	}

	public void setMpAdvancePayment(String mpAdvancePayment) {
		this.mpAdvancePayment = mpAdvancePayment;
	}
	public String getMpFactPayment() {
		return mpFactPayment;
	}

	public void setMpFactPayment(String mpFactPayment) {
		this.mpFactPayment = mpFactPayment;
	}
	public String getMpPayment() {
		return mpPayment;
	}

	public void setMpPayment(String mpPayment) {
		this.mpPayment = mpPayment;
	}
	public String getMpUnpaidAmount() {
		return mpUnpaidAmount;
	}

	public void setMpUnpaidAmount(String mpUnpaidAmount) {
		this.mpUnpaidAmount = mpUnpaidAmount;
	}
	public String getCpContractNo() {
		return cpContractNo;
	}

	public void setCpContractNo(String cpContractNo) {
		this.cpContractNo = cpContractNo;
	}
	public String getCpCustomer() {
		return cpCustomer;
	}

	public void setCpCustomer(String cpCustomer) {
		this.cpCustomer = cpCustomer;
	}
	public String getCpInvoice() {
		return cpInvoice;
	}

	public void setCpInvoice(String cpInvoice) {
		this.cpInvoice = cpInvoice;
	}
	public String getCpExportInvoice() {
		return cpExportInvoice;
	}

	public void setCpExportInvoice(String cpExportInvoice) {
		this.cpExportInvoice = cpExportInvoice;
	}
	public String getCpFaceAmount() {
		return cpFaceAmount;
	}

	public void setCpFaceAmount(String cpFaceAmount) {
		this.cpFaceAmount = cpFaceAmount;
	}
	public String getCpAdvancePayment() {
		return cpAdvancePayment;
	}

	public void setCpAdvancePayment(String cpAdvancePayment) {
		this.cpAdvancePayment = cpAdvancePayment;
	}
	public String getCpTotalPrice() {
		return cpTotalPrice;
	}

	public void setCpTotalPrice(String cpTotalPrice) {
		this.cpTotalPrice = cpTotalPrice;
	}
	public String getCpFactPayment() {
		return cpFactPayment;
	}

	public void setCpFactPayment(String cpFactPayment) {
		this.cpFactPayment = cpFactPayment;
	}
	public String getCpPayment() {
		return cpPayment;
	}

	public void setCpPayment(String cpPayment) {
		this.cpPayment = cpPayment;
	}
	public String getCpUnpaidAmount() {
		return cpUnpaidAmount;
	}

	public void setCpUnpaidAmount(String cpUnpaidAmount) {
		this.cpUnpaidAmount = cpUnpaidAmount;
	}
	public String getImportContractNo() {
		return importContractNo;
	}

	public void setImportContractNo(String importContractNo) {
		this.importContractNo = importContractNo;
	}
	public String getImportCreditNo() {
		return importCreditNo;
	}

	public void setImportCreditNo(String importCreditNo) {
		this.importCreditNo = importCreditNo;
	}
	public String getImportGarageInID() {
		return importGarageInID;
	}

	public void setImportGarageInID(String importGarageInID) {
		this.importGarageInID = importGarageInID;
	}
	public String getImportContractAmount() {
		return importContractAmount;
	}

	public void setImportContractAmount(String importContractAmount) {
		this.importContractAmount = importContractAmount;
	}
	public String getImportAdvancePayment() {
		return importAdvancePayment;
	}

	public void setImportAdvancePayment(String importAdvancePayment) {
		this.importAdvancePayment = importAdvancePayment;
	}
	public String getImportFactPayment() {
		return importFactPayment;
	}

	public void setImportFactPayment(String importFactPayment) {
		this.importFactPayment = importFactPayment;
	}
	public String getImportPayment() {
		return importPayment;
	}

	public void setImportPayment(String importPayment) {
		this.importPayment = importPayment;
	}
	public String getImportUnpaidAmount() {
		return importUnpaidAmount;
	}

	public void setImportUnpaidAmount(String importUnpaidAmount) {
		this.importUnpaidAmount = importUnpaidAmount;
	}
	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}
	public String getApprover0() {
		return approver0;
	}

	public void setApprover0(String approver0) {
		this.approver0 = approver0;
	}
	public Date getApproverDate0() {
		return approverDate0;
	}

	public void setApproverDate0(Date approverDate0) {
		this.approverDate0 = approverDate0;
	}
	public String getApprover1() {
		return approver1;
	}

	public void setApprover1(String approver1) {
		this.approver1 = approver1;
	}
	public Date getApproverDate1() {
		return approverDate1;
	}

	public void setApproverDate1(Date approverDate1) {
		this.approverDate1 = approverDate1;
	}
	public String getApprover2() {
		return approver2;
	}

	public void setApprover2(String approver2) {
		this.approver2 = approver2;
	}
	public Date getApproverDate2() {
		return approverDate2;
	}

	public void setApproverDate2(Date approverDate2) {
		this.approverDate2 = approverDate2;
	}
	public String getApprover3() {
		return approver3;
	}

	public void setApprover3(String approver3) {
		this.approver3 = approver3;
	}
	public Date getApproverDate3() {
		return approverDate3;
	}

	public void setApproverDate3(Date approverDate3) {
		this.approverDate3 = approverDate3;
	}
	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Date getApproverDate() {
		return approverDate;
	}

	public void setApproverDate(Date approverDate) {
		this.approverDate = approverDate;
	}
	public String getPayUser() {
		return payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMasterContractNo() {
		return masterContractNo;
	}

	public void setMasterContractNo(String masterContractNo) {
		this.masterContractNo = masterContractNo;
	}
	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}
	public String getApproverId0() {
		return approverId0;
	}

	public void setApproverId0(String approverId0) {
		this.approverId0 = approverId0;
	}
	public String getApproverId1() {
		return approverId1;
	}

	public void setApproverId1(String approverId1) {
		this.approverId1 = approverId1;
	}
	public String getApproverId2() {
		return approverId2;
	}

	public void setApproverId2(String approverId2) {
		this.approverId2 = approverId2;
	}
	public String getApproverId3() {
		return approverId3;
	}

	public void setApproverId3(String approverId3) {
		this.approverId3 = approverId3;
	}
	public Integer getFinalApprover() {
		return finalApprover;
	}

	public void setFinalApprover(Integer finalApprover) {
		this.finalApprover = finalApprover;
	}
	public String getApproveReason() {
		return approveReason;
	}

	public void setApproveReason(String approveReason) {
		this.approveReason = approveReason;
	}

	
	public Long getIid() {
		return iid;
	}

	
	public void setIid(Long iid) {
		this.iid = iid;
	}
	
}