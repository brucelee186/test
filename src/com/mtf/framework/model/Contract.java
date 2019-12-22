package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 合同
 * 作者:     Auto
 * 日期:     2013-11-05
 **********************************************
 */
public class Contract extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 合同编号
	private String contractNo;
	// 合同生成日期
	private String addDateContract;
	// 修改时间毫秒数（防止并发）
	private Long modified;
	// 合同类型 (1 售货合同 SaleContract:s, 2 订货合同 OrderContract:o, 3 面辅料采购合同 MaterialPurchase:mp, 4 面辅料销售合同: MaterialSellContract:ms, 5 来(进)料服装委托加工合同ManufacturingConsignmentContract:m, 6 服装采购合同ClothingPurchaseContract:c, 7 代理出口协议 AgentExportAgreement:a)
	private String flag;
	// 卖方编号
	private Long sellerId;
	// 卖方名称
	private String sellerName;
	// 买方编号
	private Long buyerId;
	// 买方名称
	private String buyerName;
	// 买方地址编号
	private Long buyerAddressId;
	// 买方地址
	private String buyerAddress;
	// 卖方地址编号
	private Long sellerAddressId;
	// 卖方地址
	private String sellerAddress;
	// 总金额
	private String totalValue;
	// 产地
	private String origin;
	// 制造厂商
	private String manufacturers;
	// 交货地
	private String deliveryTo;
	// 交货日期
	private String deliveryDate;
	// 付款条件及方式
	private String termsOfPayment;
	// 保险及费用承担
	private String insuranceAndFees;
	// 唛头
	private String shippingMarks;
	// 质量及技术标准要求
	private String qualityAndTechnicalStandard;
	// 检验
	private String inspection;
	// 运输方式及费用承担
	private String transportationAndFees;
	// 装货日期
	private String shipment;
	// 保险
	private String insurance;
	// 签约地
	private String signedAt;
	// 目的港
	private String destination;
	// 包装
	private String packing;
	// 运输方式
	private String transportaion;
	// 其它条款
	private String otherTerms;
	// 合同状态 budget:已提交预算, saved:已提交审批, submit:已提交, reject1:一级驳回, reject2:二级驳回, approval1:一级审批完毕, approval2:二级审批完毕，commit：审批完毕，confirm:已提交确认函
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
	// 核算日期
	private String accData;
	// 部门
	private String accDepartment;
	// 生产单位
	private String accProductionUnit;
	// 合约号
	private String accContractNo;
	// 商品名称
	private String accTradeName;
	// 客 户
	private String accCustomer;
	// 款   号
	private String accStyleNumber;
	// 规  格
	private String accSpecification;
	// 单位
	private String accUnit;
	// 总数量
	private String accTotalAmount;
	// 原辅料成本总金额合计
	private String accRawMaterialTotalAmount;
	// 包装材料成本总金额合计
	private String accPackagingTotalAmount;
	// 加工费
	private String accProcessCost;
	// 总成本
	private String accTotalCost;
	// 备注
	private String accRemark;
	// 
	private String accCIF;
	// 
	private String accI;
	// 
	private String accFOB;
	// 退税
	private String accDrawBack;
	// 外汇牌价
	private String accOreignExchangeRate;
	// 其它收入
	private String accOtherIncome;
	// 收入合计
	private String accTotalIncome;
	// 原辅材料成本
	private String accRawMaterialCost;
	// 包装材料成本
	private String accPackagingCost;
	// 其它成本
	private String accOtherCost;
	// 其它费用
	private String accOtherExpense;
	// 间接费用
	private String accIndirectCost;
	// 成本合计
	private String accTotalProductCost;
	// 利润
	private String accProfit;
	// 
	private String accF;
	// 加工费成本
	private String accProcessFeeCost;
	// 添加人
	private String addUser;
	// 添加时间
	private Date addDate;
	// 添加IP
	private String addIp;
	// 修改人
	private String modifiedUser;
	// 修改时间
	private Date modifiedDate;
	// 修改IP
	private Date modifiedIp;
	// 当前审批人
	private String approver;
	// 当前审批日期
	private Date approverDate;
	// 合同类型:自制合同:diy, 外方合同:foreign, 订单合同:order
	private String contractType;
	// 附加条款
	private String additionalProvisions;
	// 驳回原因
	private String rejectReason;
	// 百分比
	private String percentage;
	// 备注
	private String remark;
	// 主合同号
	private String masterContractNo;
	// 操作人编号
	private String approverId;
	// 人民币价格
	private String accRMB;
	// 业务员编号
	private String approverId0;
	// 一级审批人编号
	private String approverId1;
	// 二级审批人
	private String approverId2;
	// 三级审批人编号
	private String approverId3;
	// 最终审批人(1 业务经理 2 事业经理 3 总经理)
	private String finalApprover;
	// 审批时的提示信息
	private String approveReason;
	// 加工费
	private String processCost;
	// 币种类型
	private String currencyType;
	// 代理手续费
	private String agentPoundage;
	// 违约手续费
	private String breachPoundage;
	// 违约金
	private String penalty;
	// 实收方
	private String actualRecipient;
	// 受托方法定代表
	private String trusteeLegal;
	// 委托方法定代表
	private String clientLegal;
	// 退税方
	private String drawbackRecipient;
	// 签名路径
	private String signature;
	// 合同版本
	private Double version;
	// 父编号
	private Long superId;
	// 是否为历史版本(是:y,否:n)
	private String flgHistory;
	// 公章路径
	private String cachet;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getAddDateContract() {
		return addDateContract;
	}

	public void setAddDateContract(String addDateContract) {
		this.addDateContract = addDateContract;
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
	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public Long getBuyerAddressId() {
		return buyerAddressId;
	}

	public void setBuyerAddressId(Long buyerAddressId) {
		this.buyerAddressId = buyerAddressId;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public Long getSellerAddressId() {
		return sellerAddressId;
	}

	public void setSellerAddressId(Long sellerAddressId) {
		this.sellerAddressId = sellerAddressId;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}
	public String getDeliveryTo() {
		return deliveryTo;
	}

	public void setDeliveryTo(String deliveryTo) {
		this.deliveryTo = deliveryTo;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getTermsOfPayment() {
		return termsOfPayment;
	}

	public void setTermsOfPayment(String termsOfPayment) {
		this.termsOfPayment = termsOfPayment;
	}
	public String getInsuranceAndFees() {
		return insuranceAndFees;
	}

	public void setInsuranceAndFees(String insuranceAndFees) {
		this.insuranceAndFees = insuranceAndFees;
	}
	public String getShippingMarks() {
		return shippingMarks;
	}

	public void setShippingMarks(String shippingMarks) {
		this.shippingMarks = shippingMarks;
	}
	public String getQualityAndTechnicalStandard() {
		return qualityAndTechnicalStandard;
	}

	public void setQualityAndTechnicalStandard(String qualityAndTechnicalStandard) {
		this.qualityAndTechnicalStandard = qualityAndTechnicalStandard;
	}
	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	public String getTransportationAndFees() {
		return transportationAndFees;
	}

	public void setTransportationAndFees(String transportationAndFees) {
		this.transportationAndFees = transportationAndFees;
	}
	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}
	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getSignedAt() {
		return signedAt;
	}

	public void setSignedAt(String signedAt) {
		this.signedAt = signedAt;
	}
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPacking() {
		return packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getTransportaion() {
		return transportaion;
	}

	public void setTransportaion(String transportaion) {
		this.transportaion = transportaion;
	}
	public String getOtherTerms() {
		return otherTerms;
	}

	public void setOtherTerms(String otherTerms) {
		this.otherTerms = otherTerms;
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
	public String getAccData() {
		return accData;
	}

	public void setAccData(String accData) {
		this.accData = accData;
	}
	public String getAccDepartment() {
		return accDepartment;
	}

	public void setAccDepartment(String accDepartment) {
		this.accDepartment = accDepartment;
	}
	public String getAccProductionUnit() {
		return accProductionUnit;
	}

	public void setAccProductionUnit(String accProductionUnit) {
		this.accProductionUnit = accProductionUnit;
	}
	public String getAccContractNo() {
		return accContractNo;
	}

	public void setAccContractNo(String accContractNo) {
		this.accContractNo = accContractNo;
	}
	public String getAccTradeName() {
		return accTradeName;
	}

	public void setAccTradeName(String accTradeName) {
		this.accTradeName = accTradeName;
	}
	public String getAccCustomer() {
		return accCustomer;
	}

	public void setAccCustomer(String accCustomer) {
		this.accCustomer = accCustomer;
	}
	public String getAccStyleNumber() {
		return accStyleNumber;
	}

	public void setAccStyleNumber(String accStyleNumber) {
		this.accStyleNumber = accStyleNumber;
	}
	public String getAccSpecification() {
		return accSpecification;
	}

	public void setAccSpecification(String accSpecification) {
		this.accSpecification = accSpecification;
	}
	public String getAccUnit() {
		return accUnit;
	}

	public void setAccUnit(String accUnit) {
		this.accUnit = accUnit;
	}
	public String getAccTotalAmount() {
		return accTotalAmount;
	}

	public void setAccTotalAmount(String accTotalAmount) {
		this.accTotalAmount = accTotalAmount;
	}
	public String getAccRawMaterialTotalAmount() {
		return accRawMaterialTotalAmount;
	}

	public void setAccRawMaterialTotalAmount(String accRawMaterialTotalAmount) {
		this.accRawMaterialTotalAmount = accRawMaterialTotalAmount;
	}
	public String getAccPackagingTotalAmount() {
		return accPackagingTotalAmount;
	}

	public void setAccPackagingTotalAmount(String accPackagingTotalAmount) {
		this.accPackagingTotalAmount = accPackagingTotalAmount;
	}
	public String getAccProcessCost() {
		return accProcessCost;
	}

	public void setAccProcessCost(String accProcessCost) {
		this.accProcessCost = accProcessCost;
	}
	public String getAccTotalCost() {
		return accTotalCost;
	}

	public void setAccTotalCost(String accTotalCost) {
		this.accTotalCost = accTotalCost;
	}
	public String getAccRemark() {
		return accRemark;
	}

	public void setAccRemark(String accRemark) {
		this.accRemark = accRemark;
	}
	public String getAccCIF() {
		return accCIF;
	}

	public void setAccCIF(String accCIF) {
		this.accCIF = accCIF;
	}
	public String getAccI() {
		return accI;
	}

	public void setAccI(String accI) {
		this.accI = accI;
	}
	public String getAccFOB() {
		return accFOB;
	}

	public void setAccFOB(String accFOB) {
		this.accFOB = accFOB;
	}
	public String getAccDrawBack() {
		return accDrawBack;
	}

	public void setAccDrawBack(String accDrawBack) {
		this.accDrawBack = accDrawBack;
	}
	public String getAccOreignExchangeRate() {
		return accOreignExchangeRate;
	}

	public void setAccOreignExchangeRate(String accOreignExchangeRate) {
		this.accOreignExchangeRate = accOreignExchangeRate;
	}
	public String getAccOtherIncome() {
		return accOtherIncome;
	}

	public void setAccOtherIncome(String accOtherIncome) {
		this.accOtherIncome = accOtherIncome;
	}
	public String getAccTotalIncome() {
		return accTotalIncome;
	}

	public void setAccTotalIncome(String accTotalIncome) {
		this.accTotalIncome = accTotalIncome;
	}
	public String getAccRawMaterialCost() {
		return accRawMaterialCost;
	}

	public void setAccRawMaterialCost(String accRawMaterialCost) {
		this.accRawMaterialCost = accRawMaterialCost;
	}
	public String getAccPackagingCost() {
		return accPackagingCost;
	}

	public void setAccPackagingCost(String accPackagingCost) {
		this.accPackagingCost = accPackagingCost;
	}
	public String getAccOtherCost() {
		return accOtherCost;
	}

	public void setAccOtherCost(String accOtherCost) {
		this.accOtherCost = accOtherCost;
	}
	public String getAccOtherExpense() {
		return accOtherExpense;
	}

	public void setAccOtherExpense(String accOtherExpense) {
		this.accOtherExpense = accOtherExpense;
	}
	public String getAccIndirectCost() {
		return accIndirectCost;
	}

	public void setAccIndirectCost(String accIndirectCost) {
		this.accIndirectCost = accIndirectCost;
	}
	public String getAccTotalProductCost() {
		return accTotalProductCost;
	}

	public void setAccTotalProductCost(String accTotalProductCost) {
		this.accTotalProductCost = accTotalProductCost;
	}
	public String getAccProfit() {
		return accProfit;
	}

	public void setAccProfit(String accProfit) {
		this.accProfit = accProfit;
	}
	public String getAccF() {
		return accF;
	}

	public void setAccF(String accF) {
		this.accF = accF;
	}
	public String getAccProcessFeeCost() {
		return accProcessFeeCost;
	}

	public void setAccProcessFeeCost(String accProcessFeeCost) {
		this.accProcessFeeCost = accProcessFeeCost;
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
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
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
	public Date getModifiedIp() {
		return modifiedIp;
	}

	public void setModifiedIp(Date modifiedIp) {
		this.modifiedIp = modifiedIp;
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
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getAdditionalProvisions() {
		return additionalProvisions;
	}

	public void setAdditionalProvisions(String additionalProvisions) {
		this.additionalProvisions = additionalProvisions;
	}
	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
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
	public String getAccRMB() {
		return accRMB;
	}

	public void setAccRMB(String accRMB) {
		this.accRMB = accRMB;
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
	public String getFinalApprover() {
		return finalApprover;
	}

	public void setFinalApprover(String finalApprover) {
		this.finalApprover = finalApprover;
	}
	public String getApproveReason() {
		return approveReason;
	}

	public void setApproveReason(String approveReason) {
		this.approveReason = approveReason;
	}
	public String getProcessCost() {
		return processCost;
	}

	public void setProcessCost(String processCost) {
		this.processCost = processCost;
	}
	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getAgentPoundage() {
		return agentPoundage;
	}

	public void setAgentPoundage(String agentPoundage) {
		this.agentPoundage = agentPoundage;
	}
	public String getBreachPoundage() {
		return breachPoundage;
	}

	public void setBreachPoundage(String breachPoundage) {
		this.breachPoundage = breachPoundage;
	}
	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}
	public String getActualRecipient() {
		return actualRecipient;
	}

	public void setActualRecipient(String actualRecipient) {
		this.actualRecipient = actualRecipient;
	}
	public String getTrusteeLegal() {
		return trusteeLegal;
	}

	public void setTrusteeLegal(String trusteeLegal) {
		this.trusteeLegal = trusteeLegal;
	}
	public String getClientLegal() {
		return clientLegal;
	}

	public void setClientLegal(String clientLegal) {
		this.clientLegal = clientLegal;
	}
	public String getDrawbackRecipient() {
		return drawbackRecipient;
	}

	public void setDrawbackRecipient(String drawbackRecipient) {
		this.drawbackRecipient = drawbackRecipient;
	}
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}
	public Long getSuperId() {
		return superId;
	}

	public void setSuperId(Long superId) {
		this.superId = superId;
	}
	public String getFlgHistory() {
		return flgHistory;
	}

	public void setFlgHistory(String flgHistory) {
		this.flgHistory = flgHistory;
	}
	public String getCachet() {
		return cachet;
	}

	public void setCachet(String cachet) {
		this.cachet = cachet;
	}
}