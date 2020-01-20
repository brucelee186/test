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

import com.mtf.framework.model.common.PageForm;

/**
 * 用户搜索FormBean
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version 1.1	2013-7-4	Wade.Zhu		change loginName to displayName
 * @version <ver>
 */
public class UserSearchForm extends PageForm implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				loginName;
	private String				displayName;
	private String				email;
	// 入职日期
	private Date entryDate;
	// 首次工作日期
	private Date initialDate;
	// 性别
	private String gender;
	//  审批状态    s：提交 a:审批  r:驳回
	private String approveStatus;
	private String	divisionId;
	private String	roleId;

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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		if (loginName == null || loginName.trim().length() == 0) {
			this.loginName = null;
		} else {
			this.loginName = loginName.trim();
		}
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		if (displayName == null || displayName.trim().length() == 0) {
			this.displayName = null;
		} else {
			this.displayName = displayName.trim();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.trim().length() == 0) {
			this.email = null;
		} else {
			this.email = email.trim();
		}
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		if (divisionId == null || divisionId.trim().length() == 0) {
			this.divisionId = null;
		} else {
			this.divisionId = divisionId.trim();
		}
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		if (roleId == null || roleId.trim().length() == 0) {
			this.roleId = null;
		} else {
			this.roleId = roleId.trim();
		}
	}

}
