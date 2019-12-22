package com.mtf.framework.model;

import com.mtf.framework.model.common.CommonModel;

public class User2Division extends CommonModel {

	private String		id;

	private String		userId;
	// 部门编号
	private String		divisionId;
	// 是否为领导
	private Integer		index;
	
	private Division	division;
	
	private User		user;
	
	// 0 员工 1 业务经理 2 事业经理 3 总经理
	private Integer		level;
	
	// 用户名(显示用)
	private String displayName;
	
	private Integer		mainIndex;
	
	// 岗位ID
	private String positionId;
	
	// 标记(d:division,g:group)
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}

	public Division getDivision() {
		return division;
	}
	
	public void setDivision(Division division) {
		this.division = division;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Integer getMainIndex() {
		return mainIndex;
	}

	
	public void setMainIndex(Integer mainIndex) {
		this.mainIndex = mainIndex;
	}
	
	
}