package com.mtf.framework.model;

import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 报销子列表
 * 作者:    Auto
 * 日期:    2015/3/17
 **********************************************
 */
public class ReimbursementItem extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 采购从表ID
	private String purchaseItemId;
	// 报销主表ID
		private String reimbursementId;
	// 种类1ID
	private String category1Id;
	// 种类1名称
	private String category1Name;
	// 种类2ID
	private String category2Id;
	// 种类2名称
	private String category2Name;
	// 描述
	private String description;
	// 金额
	private Double amount;
	// 索引
	private Integer index;
	// 部门ID
	private String divisionId;
	// 部门名称
	private String divisionName;
	// 客户ID
	private String customerId;
	// 客户名称
	private String customerName;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPurchaseItemId() {
		return purchaseItemId;
	}

	
	public void setPurchaseItemId(String purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}

	public String getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(String reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public String getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(String category1Id) {
		this.category1Id = category1Id;
	}
	public String getCategory1Name() {
		return category1Name;
	}

	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}
	public String getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(String category2Id) {
		this.category2Id = category2Id;
	}
	public String getCategory2Name() {
		return category2Name;
	}

	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}