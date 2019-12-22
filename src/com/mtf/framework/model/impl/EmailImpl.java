package com.mtf.framework.model.impl;

import java.util.List;

import com.mtf.framework.model.Email;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 邮件
 * 作者:    Auto
 * 日期:    2015/5/27
 **********************************************
 */
public class EmailImpl extends Email{
	private static final long serialVersionUID = 1L;
	
	private AttendanceImpl attendance;
	
	private UserDetailImpl userDetail;
	
	// 邮件模板路径
	String pathUpload;
	
	private AttenVacateManageImpl attenVacateManage;
	
	private OrderServiceImpl orderService;
	
	private List<AttenVacateManageImpl> listAttenVacateManage;
	
	private String jumpPageCode;
	
	public String getJumpPageCode() {
		return jumpPageCode;
	}

	public void setJumpPageCode(String jumpPageCode) {
		this.jumpPageCode = jumpPageCode;
	}

	public UserDetailImpl getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetailImpl userDetail) {
		this.userDetail = userDetail;
	}

	public List<AttenVacateManageImpl> getListAttenVacateManage() {
		return listAttenVacateManage;
	}

	public void setListAttenVacateManage(
			List<AttenVacateManageImpl> listAttenVacateManage) {
		this.listAttenVacateManage = listAttenVacateManage;
	}

	public OrderServiceImpl getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}

	public String getPathUpload() {
		return pathUpload;
	}

	public void setPathUpload(String pathUpload) {
		this.pathUpload = pathUpload;
	}


	public AttenVacateManageImpl getAttenVacateManage() {
		return attenVacateManage;
	}

	public void setAttenVacateManage(AttenVacateManageImpl attenVacateManage) {
		this.attenVacateManage = attenVacateManage;
	}

	public AttendanceImpl getAttendance() {
		return attendance;
	}

	public void setAttendance(AttendanceImpl attendance) {
		this.attendance = attendance;
	}
	

}