package com.mtf.framework.model.impl;

import java.util.Date;

import com.mtf.framework.model.AttMonitorLog;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 门禁数据
 * 作者:    Auto
 * 日期:    2015/4/27
 **********************************************
 */
public class AttMonitorLogImpl extends AttMonitorLog {
	private static final long serialVersionUID = 1L;
	
	// 采集日期
	private String collectDate;
	
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	
}