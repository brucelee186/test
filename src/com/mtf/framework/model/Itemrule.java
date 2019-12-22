package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 办公用品领取规则
 * 作者:     Auto
 * 日期:     2013/12/24
 **********************************************
 */
public class Itemrule extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 名称
	private String type;
	// 规格
	private String specification;
	// 单位
	private String unit;
	// 单价
	private Double price;
	// 供应商
	private String supplier;
	// 备注
	private String remarks;
	// 默认数量
	private Integer amountDefault;
	// 数量上限
	private Integer amountMax;
	// 添加时间
	private String addDate;
	// 修改时间
	private String modifiedDate;
	// 办公用品状态（0：可用，1：不可用）
	private Integer status;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getAmountDefault() {
		return amountDefault;
	}

	public void setAmountDefault(Integer amountDefault) {
		this.amountDefault = amountDefault;
	}
	public Integer getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Integer amountMax) {
		this.amountMax = amountMax;
	}
	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}