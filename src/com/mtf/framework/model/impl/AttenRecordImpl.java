package com.mtf.framework.model.impl;

import com.mtf.framework.model.AttenRecord;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 考勤审批记录
 * 作者:    Auto
 * 日期:    2015/5/15
 **********************************************
 */
public class AttenRecordImpl extends AttenRecord {
	private static final long serialVersionUID = 1L;
	
	// 上个月份
	private String lastMonth;
	
	// 审批人权限对应的所有部门
	private String divisions;
	
	// 驳回类型（re1,re2)
	private String stateReject;
	
	// 审批时where后的判断条件 ap1,一级审批，ap2二级
	private String judApprove;

	public String getJudApprove() {
		return judApprove;
	}

	public void setJudApprove(String judApprove) {
		this.judApprove = judApprove;
	}

	public String getStateReject() {
		return stateReject;
	}

	public void setStateReject(String stateReject) {
		this.stateReject = stateReject;
	}

	public String getDivisions() {
		return divisions;
	}

	public void setDivisions(String divisions) {
		this.divisions = divisions;
	}

	public String getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}

}