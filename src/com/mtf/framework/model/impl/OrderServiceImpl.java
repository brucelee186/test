package com.mtf.framework.model.impl;

import java.util.List;

import com.mtf.framework.model.OrderService;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/10/21
 **********************************************
 */
public class OrderServiceImpl extends OrderService {
	private static final long serialVersionUID = 1L;
	
	// 客户名
	private String nameCustomer;
	// 主表编号
	private Long idOrderService;
	// 出发日期
	private String departDate;
	// 出发日间
	private String departTime;
	// 出发月份
	private String departMonth;
	// 模块(订车 o:order, 派车 a:allocation, 审批 ap:approve)
	private String tagModule;
	
	// 所具有的部门审批权限
	private List<PermissionImpl> listDivision;
	
	// 需要更新的新状态
	private String statusOrderUpdate;
	
	// 需要更新的新状态值
	private String statusOrderUpdateValue;
	
	// 需要更新的路线状态
	private String updateIdOrderServicePathId;
	
	// 统计总金额
	private Double sumExpenseTotal;
	
	// 统计通行费
	private Double sumExpenseOther;
	
	// 客户姓名
	private String customerName;
	
	// 按钮编辑标记
	private String tagEditState;
	
	// 更新标记
	private String updateApproveStatusOrder;
	
	// 单据状态集合
	private List<String> listStatusOrder;
			
	private String TypeName;
	
	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}

	public List<String> getListStatusOrder() {
		return listStatusOrder;
	}

	public void setListStatusOrder(List<String> listStatusOrder) {
		this.listStatusOrder = listStatusOrder;
	}

	public String getUpdateApproveStatusOrder() {
		return updateApproveStatusOrder;
	}

	public void setUpdateApproveStatusOrder(String updateApproveStatusOrder) {
		this.updateApproveStatusOrder = updateApproveStatusOrder;
	}

	public String getTagEditState() {
		return tagEditState;
	}

	public void setTagEditState(String tagEditState) {
		this.tagEditState = tagEditState;
	}

	public Double getSumExpenseOther() {
		return sumExpenseOther;
	}

	public void setSumExpenseOther(Double sumExpenseOther) {
		this.sumExpenseOther = sumExpenseOther;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getSumExpenseTotal() {
		return sumExpenseTotal;
	}

	public void setSumExpenseTotal(Double sumExpenseTotal) {
		this.sumExpenseTotal = sumExpenseTotal;
	}

	public String getUpdateIdOrderServicePathId() {
		return updateIdOrderServicePathId;
	}

	public void setUpdateIdOrderServicePathId(String updateIdOrderServicePathId) {
		this.updateIdOrderServicePathId = updateIdOrderServicePathId;
	}

	public String getStatusOrderUpdateValue() {
		return statusOrderUpdateValue;
	}

	public void setStatusOrderUpdateValue(String statusOrderUpdateValue) {
		this.statusOrderUpdateValue = statusOrderUpdateValue;
	}

	public String getStatusOrderUpdate() {
		return statusOrderUpdate;
	}

	public void setStatusOrderUpdate(String statusOrderUpdate) {
		this.statusOrderUpdate = statusOrderUpdate;
	}

	public List<PermissionImpl> getListDivision() {
		return listDivision;
	}

	public void setListDivision(List<PermissionImpl> listDivision) {
		this.listDivision = listDivision;
	}

	public String getTagModule() {
		return tagModule;
	}

	public void setTagModule(String tagModule) {
		this.tagModule = tagModule;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getDepartMonth() {
		return departMonth;
	}

	public void setDepartMonth(String departMonth) {
		this.departMonth = departMonth;
	}

	public Long getIdOrderService() {
		return idOrderService;
	}

	public void setIdOrderService(Long idOrderService) {
		this.idOrderService = idOrderService;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	
	
}