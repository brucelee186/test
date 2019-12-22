package com.mtf.framework.model.impl;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mtf.framework.model.Reimbursement;



public class ReimbursementImpl extends Reimbursement{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	public static final int STATUS_DRAFT		=	0;
	public static final int STATUS_SUBMIT		=	1;
	public static final int STATUS_AUDITPASS	=	2;
	public static final int STATUS_AUDITFAIL	=	3;
	public static final int STATUS_CANCEL		=	9;
	
	List<ReimbursementItemImpl> listReimbursementItem;

	//Page
	private Date			applicationDateFrom;
	private Date			applicationDateTo;
	private String			amountTotalCn;
	
	private Double			sumTotalAmount;
	private String			monthApplicantDatetime;
	private String			yearApplicantDatetime;
	private String			quarterApplicantDatetime;
	private String			sortTime;
	//搜索报销状态 1：已审核通过；2：报销中
	private int				reimbursementStatus;
	
	
	//0：所有, 1:我的报销（0,1,2,3）, 2: 财务审批（1,2）, 3: 历史审核（2）
	private int				statusGroup;
	//item
	//private String			mainCategory1Name;
	private String			divisionName;
	private String			customerName;
	private String			category1Name;
	private String			category2Name;
	private double			amount;
	private double			sumTotalRmbAmount;
	private String			description;
	
	
	private double			dyf;
	private double			dzyhp;
	private double			jbfy;
	private double			zdf;
	private double			cf;
	private double			gyfy;
	private double			swf;
	private double			clf;
	private double			wxf;
	private double			bgf;
	private double			zc;
	private double			pxfy;
	private double			other;
	private double			customerTotal;
	private double			divisionTotal;
	
	public double getDivisionTotal() {
		return divisionTotal;
	}

	public void setDivisionTotal(double divisionTotal) {
		this.divisionTotal = divisionTotal;
	}
	
	public List<ReimbursementItemImpl> getListReimbursementItem() {
		return listReimbursementItem;
	}

	
	public void setListReimbursementItem(List<ReimbursementItemImpl> listReimbursementItem) {
		this.listReimbursementItem = listReimbursementItem;
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


	
	public String getAmountTotalCn() {
		return amountTotalCn;
	}


	
	public void setAmountTotalCn(String amountTotalCn) {
		this.amountTotalCn = amountTotalCn;
	}


	@JsonIgnore
	public int getStatusGroup() {
		return statusGroup;
	}


	
	public void setStatusGroup(int statusGroup) {
		this.statusGroup = statusGroup;
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


	
	public Double getSumTotalAmount() {
		return sumTotalAmount;
	}


	
	public void setSumTotalAmount(Double sumTotalAmount) {
		this.sumTotalAmount = sumTotalAmount;
	}


	@JsonIgnore
	public int getReimbursementStatus() {
		return reimbursementStatus;
	}


	
	public void setReimbursementStatus(int reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}


	
	public String getCustomerName() {
		return customerName;
	}


	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	
	public double getSumTotalRmbAmount() {
		return sumTotalRmbAmount;
	}


	
	public void setSumTotalRmbAmount(double sumTotalRmbAmount) {
		this.sumTotalRmbAmount = sumTotalRmbAmount;
	}

	public String getDivisionName() {
		return divisionName;
	}
	
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}


	
	public String getCategory1Name() {
		return category1Name;
	}


	
	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}


	
	public String getCategory2Name() {
		return category2Name;
	}


	
	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}


	
	public double getAmount() {
		return amount;
	}


	
	public void setAmount(double amount) {
		this.amount = amount;
	}


	
	public String getDescription() {
		return description;
	}


	
	public void setDescription(String description) {
		this.description = description;
	}


	
	public double getWxf() {
		return wxf;
	}


	
	public void setWxf(double wxf) {
		this.wxf = wxf;
	}


	
	public double getDyf() {
		return dyf;
	}


	
	public void setDyf(double dyf) {
		this.dyf = dyf;
	}


	
	public double getDzyhp() {
		return dzyhp;
	}


	
	public void setDzyhp(double dzyhp) {
		this.dzyhp = dzyhp;
	}


	
	public double getJbfy() {
		return jbfy;
	}


	
	public void setJbfy(double jbfy) {
		this.jbfy = jbfy;
	}


	
	public double getZdf() {
		return zdf;
	}


	
	public void setZdf(double zdf) {
		this.zdf = zdf;
	}


	
	public double getCf() {
		return cf;
	}


	
	public void setCf(double cf) {
		this.cf = cf;
	}


	
	public double getGyfy() {
		return gyfy;
	}


	
	public void setGyfy(double gyfy) {
		this.gyfy = gyfy;
	}


	
	public double getSwf() {
		return swf;
	}


	
	public void setSwf(double swf) {
		this.swf = swf;
	}


	
	public double getClf() {
		return clf;
	}


	
	public void setClf(double clf) {
		this.clf = clf;
	}


	
	public double getBgf() {
		return bgf;
	}


	
	public void setBgf(double bgf) {
		this.bgf = bgf;
	}


	
	public double getZc() {
		return zc;
	}


	
	public void setZc(double zc) {
		this.zc = zc;
	}


	
	public double getPxfy() {
		return pxfy;
	}


	
	public void setPxfy(double pxfy) {
		this.pxfy = pxfy;
	}


	
	public double getOther() {
		return other;
	}


	
	public void setOther(double other) {
		this.other = other;
	}


	
	public double getCustomerTotal() {
		return customerTotal;
	}


	
	public void setCustomerTotal(double customerTotal) {
		this.customerTotal = customerTotal;
	}
	
	

	
}
