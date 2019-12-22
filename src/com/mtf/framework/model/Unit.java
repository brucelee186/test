package com.mtf.framework.model;

import java.util.Date;

import com.mtf.framework.model.common.CommonModel;

public class Unit extends CommonModel{
	// 添加人
	private String addUser;
	// 添加时间
	private Date addDate;
	// 添加IP
	private String addIp;
	// 修改人
	private String modifiedUser;
	// 修改时间
	private Date modifiedDate;
	// 修改IP
	private String modifiedIp;
	private String	id;

	private String	name;

	private Integer	status;
	
	// 修改时间毫秒数（防止并发）
	private Long modified;

	
	public String getAddUser() {
		return addUser;
	}


	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public String getAddIp() {
		return addIp;
	}


	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}


	public String getModifiedUser() {
		return modifiedUser;
	}


	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getModifiedIp() {
		return modifiedIp;
	}


	public void setModifiedIp(String modifiedIp) {
		this.modifiedIp = modifiedIp;
	}


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

	
	public Integer getStatus() {
		return status;
	}

	
	public void setStatus(Integer status) {
		this.status = status;
	}


	
	public Long getModified() {
		return modified;
	}


	
	public void setModified(Long modified) {
		this.modified = modified;
	}

	
}