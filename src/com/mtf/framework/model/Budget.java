package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 合同
 * 作者:     Auto
 * 日期:     2013-12-04
 **********************************************
 */
public class Budget extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 合同编号
	private Long contractId;
	// 预算类型 b ;核算类型 a;
	private String type;
	// 修改时间毫秒数（防止并发）
	private Long modified;
	// 合同状态 budget:已提交预算, saved:已提交审批, submit:已提交, reject1:一级驳回, reject2:二级驳回, approval1:一级审批完毕, approval2:二级审批完毕
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
	private String department;
	// 生产单位
	private String productionUnit;
	// 合约号
	private String budgetNo;
	// 商品名称
	private String tradeName;
	// 客 户
	private String customer;
	// 款   号
	private String styleNumber;
	// 规  格
	private String specification;
	// 单位
	private String unit;
	// 总数量
	private String totalAmount;
	// 原辅料成本总金额合计
	private String rawMaterialTotalAmount;
	// 包装材料成本总金额合计
	private String packagingTotalAmount;
	// 加工费
	private String processCost;
	// 总成本
	private String totalCost;
	// 备注
	private String remark;
	// 
	private String accCIF;
	// 
	private String accI;
	// 
	private String accFOB;
	// 退税
	private String drawBack;
	// 外汇牌价
	private String oreignExchangeRate;
	// 其它收入
	private String otherIncome;
	// 收入合计
	private String totalIncome;
	// 原辅材料成本
	private String rawMaterialCost;
	// 包装材料成本
	private String packagingCost;
	// 其它成本
	private String otherCost;
	// 其它费用
	private String otherExpense;
	// 间接费用
	private String indirectCost;
	// 成本合计
	private String totalProductCost;
	// 利润
	private String profit;
	// 
	private String accF;
	// 加工费成本
	private String processFeeCost;
	// 驳回原因
	private String rejectReason;
	// 人民币价格
	private String accRMB;
	// 单价
	private String unitPrice;
	// 审批时的提示信息
	private String approveReason;
	// 添加人
	private String addUser;
	// 添加时间
	private Date addDate;
	// 修改人
	private String modifiedUser;
	// 修改时间
	private Date modifiedDate;
	// 预算表Id
	private Long budgetId;
	// 当前审批人
	private String approver;
	// 当前审批日期
	private Date approverDate;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Long getModified() {
		return modified;
	}

	public void setModified(Long modified) {
		this.modified = modified;
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
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProductionUnit() {
		return productionUnit;
	}

	public void setProductionUnit(String productionUnit) {
		this.productionUnit = productionUnit;
	}
	public String getBudgetNo() {
		return budgetNo;
	}

	public void setBudgetNo(String budgetNo) {
		this.budgetNo = budgetNo;
	}
	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getStyleNumber() {
		return styleNumber;
	}

	public void setStyleNumber(String styleNumber) {
		this.styleNumber = styleNumber;
	}
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRawMaterialTotalAmount() {
		return rawMaterialTotalAmount;
	}

	public void setRawMaterialTotalAmount(String rawMaterialTotalAmount) {
		this.rawMaterialTotalAmount = rawMaterialTotalAmount;
	}
	public String getPackagingTotalAmount() {
		return packagingTotalAmount;
	}

	public void setPackagingTotalAmount(String packagingTotalAmount) {
		this.packagingTotalAmount = packagingTotalAmount;
	}
	public String getProcessCost() {
		return processCost;
	}

	public void setProcessCost(String processCost) {
		this.processCost = processCost;
	}
	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getDrawBack() {
		return drawBack;
	}

	public void setDrawBack(String drawBack) {
		this.drawBack = drawBack;
	}
	public String getOreignExchangeRate() {
		return oreignExchangeRate;
	}

	public void setOreignExchangeRate(String oreignExchangeRate) {
		this.oreignExchangeRate = oreignExchangeRate;
	}
	public String getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(String otherIncome) {
		this.otherIncome = otherIncome;
	}
	public String getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(String totalIncome) {
		this.totalIncome = totalIncome;
	}
	public String getRawMaterialCost() {
		return rawMaterialCost;
	}

	public void setRawMaterialCost(String rawMaterialCost) {
		this.rawMaterialCost = rawMaterialCost;
	}
	public String getPackagingCost() {
		return packagingCost;
	}

	public void setPackagingCost(String packagingCost) {
		this.packagingCost = packagingCost;
	}
	public String getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(String otherCost) {
		this.otherCost = otherCost;
	}
	public String getOtherExpense() {
		return otherExpense;
	}

	public void setOtherExpense(String otherExpense) {
		this.otherExpense = otherExpense;
	}
	public String getIndirectCost() {
		return indirectCost;
	}

	public void setIndirectCost(String indirectCost) {
		this.indirectCost = indirectCost;
	}
	public String getTotalProductCost() {
		return totalProductCost;
	}

	public void setTotalProductCost(String totalProductCost) {
		this.totalProductCost = totalProductCost;
	}
	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getAccF() {
		return accF;
	}

	public void setAccF(String accF) {
		this.accF = accF;
	}
	public String getProcessFeeCost() {
		return processFeeCost;
	}

	public void setProcessFeeCost(String processFeeCost) {
		this.processFeeCost = processFeeCost;
	}
	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getAccRMB() {
		return accRMB;
	}

	public void setAccRMB(String accRMB) {
		this.accRMB = accRMB;
	}
	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getApproveReason() {
		return approveReason;
	}

	public void setApproveReason(String approveReason) {
		this.approveReason = approveReason;
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
	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
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
}