package com.mtf.framework.model.impl;

import com.mtf.framework.model.AttenVacate;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 请假管理
 * 作者:    Auto
 * 日期:    2015/5/5
 **********************************************
 */
public class AttenVacateImpl extends AttenVacate {
	private static final long serialVersionUID = 1L;
	
	// 请假类型名称
	private String nameVacate;
	
	// 剩余时长
	private String durationRemain;
	
	// 总请假时长
	private String durationTotal;
	
	// 规定时长
	private String durationRule;
	
	private String nameDetail;

	public String getNameDetail() {
		return nameDetail;
	}

	public void setNameDetail(String nameDetail) {
		this.nameDetail = nameDetail;
	}

	public String getDurationTotal() {
		return durationTotal;
	}

	public void setDurationTotal(String durationTotal) {
		this.durationTotal = durationTotal;
	}

	public String getDurationRemain() {
		return durationRemain;
	}

	public void setDurationRemain(String durationRemain) {
		this.durationRemain = durationRemain;
	}

	public String getDurationRule() {
		return durationRule;
	}

	public void setDurationRule(String durationRule) {
		this.durationRule = durationRule;
	}

	public String getNameVacate() {
		return nameVacate;
	}

	public void setNameVacate(String nameVacate) {
		this.nameVacate = nameVacate;
	}
	
	
}