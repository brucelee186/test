package com.mtf.framework.model.impl;

import java.util.Date;
import java.util.List;

import com.mtf.framework.model.Action;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.User;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.UserProfile;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 人员信息表
 * 作者:    Auto
 * 日期:    2015/3/11
 **********************************************
 */
public class UserImpl extends User {
	private static final long serialVersionUID = 1L;
	private String stateInit;
	/**
	 * 本项目只允许一个用户对应一个角色
	 */
	private String			roleId;

	private String			name;
	// 1 员工 2 业务经理 3 事业经理 4 总经理
	private Integer			level;

	private String			description;

	private Integer			system;

	private String			userId;
	
	private Date			datetime;
	
	private String			roleIds;
	
	// 0启用、1禁用、2注册、3驳回
	private String				statusRegist;
	
	private String				englishName;
	
	// 入职时间
	private Date dateTime;
	
	// 入职日期
	private Date				entryDate;
	// 首次工作日期
	private Date				initialDate;

	// 应聘岗位
	private String				targetPosition;
	// 性别
	private String				gender;
	// 出生日期
	private String				birthDate;
	// 民族
	private String				ethnicGroup;
	
	// 民族名称
	private String				ethnicGroupName;
	
	// 国籍
	private String				nationality;
	// 婚姻状况 n:否，y：是
	private String				maritalStatus;
	// 政治身份
	private String				politicalIdentity;
	// 宗教信仰
	private String				religion;
	// 身份证或者护照
	private String				idNo;
	// 户口所在地
	private String				resgisteredResidence;

	// 省
	private String				province;
	// 市
	private String				city;
	// 区
	private String				district;

	// 宅电或者移动电话
	private String				phoneNo;
	
	private String middleNameEn;
	private String rank;
	// 添加人Id
	private Long addUserId;
	// 修改人员ID
	private String modifieduserId;
	// 修改时间
	private Date modifiedDate;
	// IP地址
	private String modifiedIp;
	
	
	private String middleName;


	private String		divisionId;

	private String		divisionName;

	private Division	divisions;
	
	// division
	private List<User2Division> user2Divisions;
	
	private String[] arrayDivision;
	
	public String[] getArrayDivision() {
		return arrayDivision;
	}
	public void setArrayDivision(String[] arrayDivision) {
		this.arrayDivision = arrayDivision;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public List<User2Division> getUser2Divisions() {
		return user2Divisions;
	}
	public void setUser2Divisions(List<User2Division> user2Divisions) {
		this.user2Divisions = user2Divisions;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getStatusRegist() {
		return statusRegist;
	}
	public void setStatusRegist(String statusRegist) {
		this.statusRegist = statusRegist;
	}
	private List<String>    listCode;
	
	// role
	private List<RoleImpl>	roles;
	
	// profile
	private UserProfile	userProfile;
	
	public String getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public List<RoleImpl> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleImpl> roles) {
		this.roles = roles;
	}
	public List<String> getListCode() {
		return listCode;
	}
	public void setListCode(List<String> listCode) {
		this.listCode = listCode;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSystem() {
		return system;
	}
	public void setSystem(Integer system) {
		this.system = system;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getStateInit() {
		return stateInit;
	}
	public void setStateInit(String stateInit) {
		this.stateInit = stateInit;
	}
	
}