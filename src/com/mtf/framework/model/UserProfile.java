package com.mtf.framework.model;

import java.util.Date;

public class UserProfile {

	private String	id;

	private String	userId;

	private String	fullname;

	private String	email;

	private String	language;
	// 入职日期
	private Date entryDate;
	// 首次工作日期
	private Date initialDate;
	// 性别
	private String gender;
	// 用户签章
	private String signature;
	
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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id == null || id.trim().length() == 0) {
			this.id = null;
		} else {
			this.id = id.trim();
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		if (userId == null || userId.trim().length() == 0) {
			this.userId = null;
		} else {
			this.userId = userId.trim();
		}
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		if (fullname == null || fullname.trim().length() == 0) {
			this.fullname = null;
		} else {
			this.fullname = fullname.trim();
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		if (language == null || language.trim().length() == 0) {
			this.language = null;
		} else {
			this.language = language.trim();
		}
	}
}