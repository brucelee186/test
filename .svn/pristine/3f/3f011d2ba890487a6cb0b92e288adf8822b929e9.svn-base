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
 * 模块名称: 基础资料 -> 附件
 * 作者:    Auto
 * 日期:    2017/9/21
 **********************************************
 */
public class Attachment extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 编号
	private Long id;
	// 关联表名称
	private String relevanceTable;
	// 关联表编号
	private Long relevanceId;
	// 操作人编号
	private String userId;
	// 操作人姓名
	private String userName;
	// 合同编号
	private Long contractId;
	// 是否有确认函 0：为否，1：为是
	private String code;
	// 文件名
	private String fileName;
	// 附件后缀类型
	private String suffix;
	// 附件路径
	private String savePathFile;
	// 关联表标记
	private String tag;
	// 创建时间
	private Date addDate;
	// 创建者
	private Long addUser;
	// IP地址
	private String addIp;
	// 修改时间
	private Date modifiedDate;
	// 修改者
	private Long modifiedUser;
	// IP地址
	private String modifiedIp;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getRelevanceTable() {
		return relevanceTable;
	}

	public void setRelevanceTable(String relevanceTable) {
		this.relevanceTable = relevanceTable;
	}
	public Long getRelevanceId() {
		return relevanceId;
	}

	public void setRelevanceId(Long relevanceId) {
		this.relevanceId = relevanceId;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getSavePathFile() {
		return savePathFile;
	}

	public void setSavePathFile(String savePathFile) {
		this.savePathFile = savePathFile;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Long getAddUser() {
		return addUser;
	}

	public void setAddUser(Long addUser) {
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
	public Long getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public String getModifiedIp() {
		return modifiedIp;
	}

	public void setModifiedIp(String modifiedIp) {
		this.modifiedIp = modifiedIp;
	}
}