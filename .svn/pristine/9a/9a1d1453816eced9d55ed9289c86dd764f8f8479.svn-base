/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.model.page;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.Role;
import com.mtf.framework.model.User;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.util.JsonDateTimeSerializer;

/**
 * 用户搜索DataGrid数据项
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class UserSearchDataGridItem extends User implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	// basic
	private String				userId;
	private String				loginName;
	private String				displayName;
	private String				status;

	private String				lastUserId;
	private String				lastUserName;
	private Date				lastDatetime;

	// profile
	private String				profileId;
	private String				fullname;
	private String				email;
	private String				language;
	
	// 入职日期
	private Date entryDate;
	// 首次工作日期
	private Date initialDate;
	// 性别
	private String gender;
	//  审批状态    s：提交 a:审批  r:驳回
	private String approveStatus;
	
	// 电话号
	private String phoneNo;
	// division
	private List<User2Division> user2Divisions;
	
	// role
	private List<RoleImpl>			roles;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLastUserId() {
		return lastUserId;
	}
	
	public void setLastUserId(String lastUserId) {
		this.lastUserId = lastUserId;
	}
	
	public String getLastUserName() {
		return lastUserName;
	}
	
	public void setLastUserName(String lastUserName) {
		this.lastUserName = lastUserName;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getLastDatetime() {
		return lastDatetime;
	}
	
	public void setLastDatetime(Date lastDatetime) {
		this.lastDatetime = lastDatetime;
	}
	
	public List<User2Division> getUser2Divisions() {
		return user2Divisions;
	}
	
	public void setUser2Divisions(List<User2Division> user2Divisions) {
		this.user2Divisions = user2Divisions;
	}
	
	public List<RoleImpl> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleImpl> roles) {
		this.roles = roles;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	
	public String getPhoneNo() {
		return phoneNo;
	}

	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
