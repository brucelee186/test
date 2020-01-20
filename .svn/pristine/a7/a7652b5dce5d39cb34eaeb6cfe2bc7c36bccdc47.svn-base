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
 * 模块名称: 基础资料 -> 系统历史表
 * 作者:    Auto
 * 日期:    2018/4/9
 **********************************************
 */
public class SysHistory extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 编号
	private Long id;
	// 原子编号
	private Long atomId;
	// 登录名
	private String loginName;
	// 显示姓名
	private String displayName;
	// 版本号（从1开始）
	private Integer versionNO;
	// 操作人编号
	private String userId;
	// 操作人姓名
	private String userName;
	// 版本变换的类型（部门d，角色r,系统s）,修正报销审批人:ModifyOrderCategoryServiceApprover mosa
	private String type;
	// 变更变前的Id
	private String preCodeId;
	// 变更变后的Id
	private String codeId;
	// 表名
	private String tableName;
	// 列编号
	private Long columnId;
	// 主表列编号
	private Long columnIdMain;
	// 列名
	private String columnName;
	// 修改顺序
	private Integer modifyOrder;
	// 变更前的编号
	private String preId;
	// 变更后的编号
	private String aftId;
	// 变更前的记录
	private String preText;
	// 变更后的记录
	private String aftText;
	// 日志
	private String log;
	// 日志记录时间
	private String logDate;
	// 最新版标识（y：最新，n:不是最新）
	private String currentFlag;
	// 变更前记录
	private String recordPre;
	// 变更后记录
	private String recordCurrent;
	// 变更记录
	private String record;
	// 操作
	private String atcion;
	// 备注
	private String remark;
	// 创建时间
	private Date addDate;
	// 创建者
	private String addUser;
	// IP地址
	private String addIp;
	// 物理网卡地址
	private String addMac;
	// 修改时间
	private Date modifiedDate;
	// 修改者
	private String modifiedUser;
	// IP地址
	private String modifiedIp;
	// 物理网卡地址
	private String modifiedMac;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getAtomId() {
		return atomId;
	}

	public void setAtomId(Long atomId) {
		this.atomId = atomId;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Integer getVersionNO() {
		return versionNO;
	}

	public void setVersionNO(Integer versionNO) {
		this.versionNO = versionNO;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getPreCodeId() {
		return preCodeId;
	}

	public void setPreCodeId(String preCodeId) {
		this.preCodeId = preCodeId;
	}
	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}
	public Long getColumnIdMain() {
		return columnIdMain;
	}

	public void setColumnIdMain(Long columnIdMain) {
		this.columnIdMain = columnIdMain;
	}
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getModifyOrder() {
		return modifyOrder;
	}

	public void setModifyOrder(Integer modifyOrder) {
		this.modifyOrder = modifyOrder;
	}
	public String getPreId() {
		return preId;
	}

	public void setPreId(String preId) {
		this.preId = preId;
	}
	public String getAftId() {
		return aftId;
	}

	public void setAftId(String aftId) {
		this.aftId = aftId;
	}
	public String getPreText() {
		return preText;
	}

	public void setPreText(String preText) {
		this.preText = preText;
	}
	public String getAftText() {
		return aftText;
	}

	public void setAftText(String aftText) {
		this.aftText = aftText;
	}
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getRecordPre() {
		return recordPre;
	}

	public void setRecordPre(String recordPre) {
		this.recordPre = recordPre;
	}
	public String getRecordCurrent() {
		return recordCurrent;
	}

	public void setRecordCurrent(String recordCurrent) {
		this.recordCurrent = recordCurrent;
	}
	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}
	public String getAtcion() {
		return atcion;
	}

	public void setAtcion(String atcion) {
		this.atcion = atcion;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getAddMac() {
		return addMac;
	}

	public void setAddMac(String addMac) {
		this.addMac = addMac;
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
	public String getModifiedMac() {
		return modifiedMac;
	}

	public void setModifiedMac(String modifiedMac) {
		this.modifiedMac = modifiedMac;
	}
}