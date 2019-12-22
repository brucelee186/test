package com.mtf.framework.model.impl;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mtf.framework.model.Purchase;



public class PurchaseImpl extends Purchase{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	//0 : 草稿，1：已提交， 2：lv1已审批， 3： 已估价， 4：lv2已审批， 5：lv2已完成采购， 8：拒绝， 9：取消
	public static final int STATUS_DRAFT		=	0;
	public static final int STATUS_SUBMIT		=	1;
	public static final int STATUS_LV1			=	2;
	public static final int STATUS_QUOTE		=	3;
	public static final int STATUS_LV2			=	4;
	public static final int STATUS_PURCHASED	=	5;
	public static final int STATUS_COMPLETE		=	6;
	public static final int STATUS_REJECT		=	8;
	public static final int STATUS_CANCEL		=	9;
	
	List<PurchaseItemImpl> listPurchaseItem;
	
	//db
	private String			userId;
	private String			mailAddress;
	
	//Page
	private Date			applicationDateFrom;
	private Date			applicationDateTo;
	private double			totalAmount;
	private String			monthApplicantDatetime;
	private String			yearApplicantDatetime;
	private String			quarterApplicantDatetime;
	private String			sortTime;
	private String			mainCategory1Name;
	private String			customerName;
	private double			sumTotalRmbAmount;
	private Integer			pIndex;
	
	//搜索采购状态 1：采购完成；2：采购中
	private int				purchaseStatus;
	// 0 : 草稿，1：已提交， 2：申购审批完成， 3： 已估价， 4：采购审批完成，5：已采购， 6：采购完成,  8：拒绝， 9：取消
	//1我的申购（0-8）	2申购审批（1）	3采购审批（3）	4历史审批（2,4）	5待估价（2）	6待采购（4）	7历史采购（3,5,6） , 8我的估价（3-8）, 9采购查看（6）
	private int				statusGroup;
	
	public List<PurchaseItemImpl> getListPurchaseItem() {
		return listPurchaseItem;
	}

	public void setListPurchaseItem(List<PurchaseItemImpl> listPurchaseItem) {
		this.listPurchaseItem = listPurchaseItem;
	}

	@JsonIgnore
	public Date getApplicationDateFrom() {
		return applicationDateFrom;
	}

	
	public void setApplicationDateFrom(Date applicationDateFrom) {
		this.applicationDateFrom = applicationDateFrom;
	}

	@JsonIgnore
	public Date getApplicationDateTo() {
		return applicationDateTo;
	}

	
	public void setApplicationDateTo(Date applicationDateTo) {
		this.applicationDateTo = applicationDateTo;
	}

	@JsonIgnore
	public int getStatusGroup() {
		return statusGroup;
	}

	
	public void setStatusGroup(int statusGroup) {
		this.statusGroup = statusGroup;
	}

	
	public String getUserId() {
		return userId;
	}

	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	@JsonIgnore
	public String getMailAddress() {
		return mailAddress;
	}

	
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getMonthApplicantDatetime() {
		return monthApplicantDatetime;
	}

	
	public void setMonthApplicantDatetime(String monthApplicantDatetime) {
		this.monthApplicantDatetime = monthApplicantDatetime;
	}

	public String getYearApplicantDatetime() {
		return yearApplicantDatetime;
	}

	
	public void setYearApplicantDatetime(String yearApplicantDatetime) {
		this.yearApplicantDatetime = yearApplicantDatetime;
	}

	public String getQuarterApplicantDatetime() {
		return quarterApplicantDatetime;
	}

	
	public void setQuarterApplicantDatetime(String quarterApplicantDatetime) {
		this.quarterApplicantDatetime = quarterApplicantDatetime;
	}

	@JsonIgnore
	public String getSortTime() {
		return sortTime;
	}

	
	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	
	public int getPurchaseStatus() {
		return purchaseStatus;
	}

	
	public void setPurchaseStatus(int purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	
	public double getSumTotalRmbAmount() {
		return sumTotalRmbAmount;
	}

	
	
	public String getCustomerName() {
		return customerName;
	}

	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setSumTotalRmbAmount(double sumTotalRmbAmount) {
		this.sumTotalRmbAmount = sumTotalRmbAmount;
	}

	
	public Integer getPIndex() {
		return pIndex;
	}

	
	public void setPIndex(Integer pIndex) {
		this.pIndex = pIndex;
	}

	
	public String getMainCategory1Name() {
		return mainCategory1Name;
	}

	
	public void setMainCategory1Name(String mainCategory1Name) {
		this.mainCategory1Name = mainCategory1Name;
	}



}
