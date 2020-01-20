package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

import com.mtf.framework.util.JsonDateSerializer;

import com.mtf.framework.util.JsonDateTimeSerializer;

import com.mtf.framework.util.JsonYearSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 分类科目表
 * 作者:    Auto
 * 日期:    2017/12/4
 **********************************************
 */
public class OrderCategory extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 科目编号
	private Long id;
	// 科目父编号
	private Long pid;
	// 科目名称
	private String name;
	// 数据类型(r:Reimbursement 报销,a:applicant 申请)
	private String typeData;
	// 层级
	private Integer level;
	// 费用上限
	private Double expenseUpper;
	// 费用下限
	private Double expenseLower;
	// 科目值1
	private String text1;
	// 科目值2
	private String text2;
	// 需要一级审批(y,n)
	private String approveLeve1;
	// 需要二级审批(y,n)
	private String approveLeve2;
	// 需要三级审批(y,n)
	private String approveLeve3;
	// 备注
	private String remark;
	// 是否可用(a:可,f:不可)
	private String tag;
	// 会计科目
	private String financeCategory;
	// 会计编号
	private String financeNo;
	// 创建时间
	private Date addDate;
	// 创建者
	private String addUser;
	// IP地址
	private String addIp;
	// 修改时间
	private Date modifiedDate;
	// 修改者
	private String modifiedUser;
	// IP地址
	private String modifiedIp;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	public Double getExpenseUpper() {
		return expenseUpper;
	}

	public void setExpenseUpper(Double expenseUpper) {
		this.expenseUpper = expenseUpper;
	}
	public Double getExpenseLower() {
		return expenseLower;
	}

	public void setExpenseLower(Double expenseLower) {
		this.expenseLower = expenseLower;
	}
	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getApproveLeve1() {
		return approveLeve1;
	}

	public void setApproveLeve1(String approveLeve1) {
		this.approveLeve1 = approveLeve1;
	}
	public String getApproveLeve2() {
		return approveLeve2;
	}

	public void setApproveLeve2(String approveLeve2) {
		this.approveLeve2 = approveLeve2;
	}
	public String getApproveLeve3() {
		return approveLeve3;
	}

	public void setApproveLeve3(String approveLeve3) {
		this.approveLeve3 = approveLeve3;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getFinanceCategory() {
		return financeCategory;
	}

	public void setFinanceCategory(String financeCategory) {
		this.financeCategory = financeCategory;
	}
	public String getFinanceNo() {
		return financeNo;
	}

	public void setFinanceNo(String financeNo) {
		this.financeNo = financeNo;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public String getModifiedIp() {
		return modifiedIp;
	}

	public void setModifiedIp(String modifiedIp) {
		this.modifiedIp = modifiedIp;
	}
}