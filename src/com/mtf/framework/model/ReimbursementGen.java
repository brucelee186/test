package com.mtf.framework.model;

import java.io.Serializable;
import java.util.Date;

public class ReimbursementGen implements Serializable {
	private Integer number;

	private Long tick;

	private String userId;
	
	private String userName;

	private Date dateTime;

	private static final long serialVersionUID = 1L;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getTick() {
		return tick;
	}

	public void setTick(Long tick) {
		this.tick = tick;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}