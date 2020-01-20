package com.mtf.framework.model.impl;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Items;
import com.mtf.framework.util.JsonDateSerializer;


public class ContractImpl extends Contract{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 货品类型 c:contract 合同, b:budget 预算
	private String tagItem;
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	// 合同货品列表
	private List<Items> listItems;
	// 预算货品列表
	private List<Items> listItemsAcc;
	// 预算包装货品列表
	private List<Items> listItemsPack;
	// 当前员工如果为领导时,子员工的编号集合
	List<String> listEmployee;
	// 审批状态集合(saved:已保存, submit:已提交, reject1:一级驳回, reject2:二级驳回, approval1:一级审批完毕, approval2:二级审批完毕)
	List<String> listApproveState;
	// 添加时间(仅显示用)
	private String showAddDate;
	// 上传文件
	private List<CommonsMultipartFile> listFile;
	// 用户等级 1 员工 2 业务经理 3 事业经理 4 总经理
	private Integer userLevel;
	// 每种合同数量
	private String count;
	// b:预算表类型，a:决算表类型
	private String budgetType;
	// 预算列表
	private List<BudgetImpl> listBudget;
	
	public List<BudgetImpl> getListBudget() {
		return listBudget;
	}

	public void setListBudget(List<BudgetImpl> listBudget) {
		this.listBudget = listBudget;
	}

	public String getShowAddDate() {
		return showAddDate;
	}

	public void setShowAddDate(String showAddDate) {
		this.showAddDate = showAddDate;
	}

	public String getTagItem() {
		return tagItem;
	}
	
	public void setTagItem(String tagItem) {
		this.tagItem = tagItem;
	}
	

	
	public String getStartDate() {
		return startDate;
	}

	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
	public String getEndDate() {
		return endDate;
	}

	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Items> getListItems() {
		return listItems;
	}
	
	public void setListItems(List<Items> listItems) {
		this.listItems = listItems;
	}
	
	public List<Items> getListItemsAcc() {
		return listItemsAcc;
	}
	
	public void setListItemsAcc(List<Items> listItemsAcc) {
		this.listItemsAcc = listItemsAcc;
	}
	
	public List<Items> getListItemsPack() {
		return listItemsPack;
	}
	
	public void setListItemsPack(List<Items> listItemsPack) {
		this.listItemsPack = listItemsPack;
	}
	
	public List<String> getListEmployee() {
		return listEmployee;
	}
	
	public void setListEmployee(List<String> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	public List<String> getListApproveState() {
		return listApproveState;
	}
	
	public void setListApproveState(List<String> listApproveState) {
		this.listApproveState = listApproveState;
	}
	
	public List<CommonsMultipartFile> getListFile() {
		return listFile;
	}
	
	public void setListFile(List<CommonsMultipartFile> listFile) {
		this.listFile = listFile;
	}
	
	public Integer getUserLevel() {
		return userLevel;
	}
	
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}

	
	public String getBudgetType() {
		return budgetType;
	}

	
	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}
}
