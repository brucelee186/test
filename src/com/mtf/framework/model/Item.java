package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 办公用品明细
 * 作者:     Auto
 * 日期:     2013-12-16
 **********************************************
 */
public class Item extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 规则编号
	private Long ruleId;
	// 办公用品申请表编号
	private Long officeId;
	// 名称
	private String type;
	// 规格
	private String specification;
	// 单位
	private String unit;
	// 数量
	private Integer amount;
	// 数量上限
	private Integer amountMax;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Integer amountMax) {
		this.amountMax = amountMax;
	}
}