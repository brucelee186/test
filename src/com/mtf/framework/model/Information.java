package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 系统管理员提示信息
 * 作者:     Auto
 * 日期:     2014/1/21
 **********************************************
 */
public class Information extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 系统管理员提示信息
	private String remarks;
	// 连接提示语
	private String linkRemarks;
	// 连接提示语链接
	private String url;
	// 添加时间
	private String addDate;
	// 修改时间
	private String modifiedDate;
	// 提示语状态（0：可用，1：不可用）
	private Integer status;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLinkRemarks() {
		return linkRemarks;
	}

	public void setLinkRemarks(String linkRemarks) {
		this.linkRemarks = linkRemarks;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}