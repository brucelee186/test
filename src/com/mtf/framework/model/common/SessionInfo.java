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
package com.mtf.framework.model.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mtf.framework.model.User;

/**
 * 用于储存当前登录用户相关信息
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class SessionInfo implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;
	
	// 用户信息
	private User				user;
	private String				userId;
	private String				displayName;
	private String				ip;
	private String				pass;
	// 服务器的访问IP
	private String				serverIp;
	// 当前服务器地址
	private String 				contextPath;
	private String				language;
	private String				loginName;
	private String				defaultPageCode;
	private Date				datetime;
	private String				status;
	private List<String>		roleIds;
	// 用户等级 0 员工 1 业务经理 2 事业经理 3 总经理 4 财务
	private Integer				userLever;
	
	// 部门
	private String				divisionName;
	private String				divisionId;
	
	// 当前月份
	private String 				nowMonth;
	
	// 上个月份
	private String 				lastMonth;
	
	// 登录信息是否成功判断(成功:true, 失败:false)
	private boolean				loginResult;
	
	// 登录提示信息
	private String				loginMessage;
	
	// 邮箱
	private String				email;
	
	// 是否为真实系统,true:真实系统,false:测试系统
	private boolean				tagSys;
	
	// 当前员工如果为领导时,子员工的编号集合
	private List<String>		listEmployee;
	
	// 员工权限集合
	private Map<String, String> mapRolePermission;

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getDefaultPageCode() {
		return defaultPageCode;
	}

	public void setDefaultPageCode(String defaultPageCode) {
		this.defaultPageCode = defaultPageCode;
	}

	public boolean getTagSys() {
		return tagSys;
	}

	public void setTagSys(boolean tagSys) {
		this.tagSys = tagSys;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}

	public Map<String, String> getMapRolePermission() {
		return mapRolePermission;
	}

	public void setMapRolePermission(Map<String, String> mapRolePermission) {
		this.mapRolePermission = mapRolePermission;
	}

	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

	
	public String getUserId() {
		return userId;
	}

	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getDisplayName() {
		return displayName;
	}

	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	
	public String getIp() {
		return ip;
	}

	
	public void setIp(String ip) {
		this.ip = ip;
	}

	
	public String getPass() {
		return pass;
	}

	
	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public String getServerIp() {
		return serverIp;
	}

	
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	
	public String getLanguage() {
		return language;
	}

	
	public void setLanguage(String language) {
		this.language = language;
	}

	
	public String getLoginName() {
		return loginName;
	}

	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	public Date getDatetime() {
		return datetime;
	}

	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	
	public List<String> getRoleIds() {
		return roleIds;
	}

	
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	
	public Integer getUserLever() {
		return userLever;
	}

	
	public void setUserLever(Integer userLever) {
		this.userLever = userLever;
	}

	
	public String getDivisionName() {
		return divisionName;
	}

	
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	
	public String getDivisionId() {
		return divisionId;
	}

	
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	
	public String getNowMonth() {
		return nowMonth;
	}

	
	public void setNowMonth(String nowMonth) {
		this.nowMonth = nowMonth;
	}

	
	public boolean isLoginResult() {
		return loginResult;
	}

	
	public void setLoginResult(boolean loginResult) {
		this.loginResult = loginResult;
	}

	
	public String getLoginMessage() {
		return loginMessage;
	}

	
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	
	public List<String> getListEmployee() {
		return listEmployee;
	}

	
	public void setListEmployee(List<String> listEmployee) {
		this.listEmployee = listEmployee;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
}
