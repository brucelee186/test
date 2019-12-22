package com.mtf.framework.model;

public class User2Role {

	private String	id;

	private String	userId;

	private String	roleId;
	
	private String	mainIndex;
	
	private Integer level;
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMainIndex() {
		return mainIndex;
	}

	public void setMainIndex(String mainIndex) {
		this.mainIndex = mainIndex;
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