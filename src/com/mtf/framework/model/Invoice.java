package com.mtf.framework.model;

import com.mtf.framework.model.common.CommonModel;

public class Invoice extends CommonModel{

	private static final long serialVersionUID = 2107105081103316808L;

	private String id;
	
	private String name;
	
	private String balance;
	
	private String customerId;
	
	// 修改时间毫秒数（防止并发）
	private Long modified;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	public Long getModified() {
		return modified;
	}

	
	public void setModified(Long modified) {
		this.modified = modified;
	}

	
	
}
