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
 * 模块名称: 基础资料 -> 员工部门中间表
 * 作者:    Auto
 * 日期:    2017/7/27
 **********************************************
 */
public class UserDivision extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 用户编号
	private String userId;
	// 部门编号
	private String divisionId;
	// 是否为领导
	private Integer index;
	// 主部门标记
	private Integer mainIndex;
	// 岗位编号
	private String positionId;
	// 标记(d:division,c:customer,g:group)
	private String tag;
	// 创建时间
	private Date addDate;
	// 创建者
	private String addUser;
	// IP地址
	private String addIp;
	// 修改时间
	private Date modifiedDate;
	// 修改者
	private String modifiedUser;
	// IP地址
	private String modifiedIp;
	// 一级部门编号
	private String divisionId1;
	// 二级部门编号
	private String divisionId2;
	// 三级部门编号
	private String divisionId3;
	// 四级部门编号
	private String divisionId4;
	// 五级部门编号
	private String divisionId5;
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
	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getMainIndex() {
		return mainIndex;
	}

	public void setMainIndex(Integer mainIndex) {
		this.mainIndex = mainIndex;
	}
	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
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
	public String getDivisionId1() {
		return divisionId1;
	}

	public void setDivisionId1(String divisionId1) {
		this.divisionId1 = divisionId1;
	}
	public String getDivisionId2() {
		return divisionId2;
	}

	public void setDivisionId2(String divisionId2) {
		this.divisionId2 = divisionId2;
	}
	public String getDivisionId3() {
		return divisionId3;
	}

	public void setDivisionId3(String divisionId3) {
		this.divisionId3 = divisionId3;
	}
	public String getDivisionId4() {
		return divisionId4;
	}

	public void setDivisionId4(String divisionId4) {
		this.divisionId4 = divisionId4;
	}
	public String getDivisionId5() {
		return divisionId5;
	}

	public void setDivisionId5(String divisionId5) {
		this.divisionId5 = divisionId5;
	}
}