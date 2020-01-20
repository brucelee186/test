package com.mtf.framework.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.util.JsonDateTimeSerializer;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 采购评论
 * 作者:    Auto
 * 日期:    2015/3/10
 **********************************************
 */
public class PurchaseComment extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 采购主表ID
	private String purchaseId;
	// 评论
	private String comment;
	// 创建人ID
	private String createUserId;
	// 创建人名称
	private String createUserName;
	// 创建日期
	private Date createDatetime;
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
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
}