package com.mtf.framework.model;

import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 采购观察
 * 作者:    Auto
 * 日期:    2015/3/13
 **********************************************
 */
public class PurchaseWatcher extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 用户ID
	private String userId;
	// 采购ID
	private String purchaseId;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
}