package com.mtf.framework.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.util.JsonDateTimeSerializer;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 采购子列表
 * 作者:    Auto
 * 日期:    2015/3/23
 **********************************************
 */
public class PurchaseItem extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 采购主表ID
	private String purchaseId;
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
	// 部门ID
	private String divisionId;
	// 部门名称
	private String divisionName;
	// 客户ID
	private String customerId;
	// 客户名称
	private String customerName;
	// 评估价格
	private Double quoteAmount;
	// 索引
	private Integer index;
	// 是否采购已完成
	private Integer isPurchased;
	// 采购完成日期
	private Date purchaseCompleteDate;
	// 是否已报销
	private Integer isReimbursed;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
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
	public Double getQuoteAmount() {
		return quoteAmount;
	}

	public void setQuoteAmount(Double quoteAmount) {
		this.quoteAmount = quoteAmount;
	}
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getIsPurchased() {
		return isPurchased;
	}

	public void setIsPurchased(Integer isPurchased) {
		this.isPurchased = isPurchased;
	}
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getPurchaseCompleteDate() {
		return purchaseCompleteDate;
	}

	public void setPurchaseCompleteDate(Date purchaseCompleteDate) {
		this.purchaseCompleteDate = purchaseCompleteDate;
	}
	public Integer getIsReimbursed() {
		return isReimbursed;
	}

	public void setIsReimbursed(Integer isReimbursed) {
		this.isReimbursed = isReimbursed;
	}
}