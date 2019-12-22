package com.mtf.framework.model;

public class Category2User {

	private String		id;

	private Integer		categoryId;
	
	private String		userId;

	
	public String getId() {
		return id;
	}	
	public void setId(String id) {
		this.id = id;
	}	
	public Integer getCategoryId() {
		return categoryId;
	}	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}