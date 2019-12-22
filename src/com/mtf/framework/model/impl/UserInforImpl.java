package com.mtf.framework.model.impl;

import java.util.List;

import com.mtf.framework.model.UserInfor;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 用户基础信息维护
 * 作者:    Auto
 * 日期:    2016/3/24
 **********************************************
 */
public class UserInforImpl extends UserInfor {
	private static final long serialVersionUID = 1L;
	private List<UserInforImpl> listUserInfor;
	public List<UserInforImpl> getListUserInfor() {
		return listUserInfor;
	}
	public void setListUserInfor(List<UserInforImpl> listUserInfor) {
		this.listUserInfor = listUserInfor;
	}
	
	
}