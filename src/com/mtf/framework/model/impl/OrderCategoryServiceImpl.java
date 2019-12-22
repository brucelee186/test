package com.mtf.framework.model.impl;

import java.util.List;

import com.mtf.framework.model.OrderCategoryService;


/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 科目申请服务
 * 作者:    Auto
 * 日期:    2016/6/22
 **********************************************
 */
/**
 * @author admin
 *
 */
public class OrderCategoryServiceImpl extends OrderCategoryService {
	private static final long serialVersionUID = 1L;
	
	private List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetail;
	
	private String applicantDivisionName;
	
	private Long idOrderCategoryService;
	
	// m:管理,a:审批
	private String tagPage;
	
	private String arrayId;
	
	private String parentCode;
	
	private String approverId1;
	
	private String approverId2;
	
	private String approverId3;
	
	private String approverId4;
	
	private String approveStatus1;
	
	private String approveStatus2;
	
	private String approveStatus3;
	
	private String approveStatus4;
	
	private String currencyName;
	
	private Long idOrderCategoryServiceDetail;

	private List<OrderCategoryImpl> listOrderCategoryLevel1;
	
	private List<OrderCategoryImpl> listOrderCategoryLevel2;
	// 状态列表 
	private List<String> listStatus;
	
	// 状态总表 
	private List<String> listStatusMain;
	
	private List<PermissionImpl> listDivision;
	
	private List<PermissionImpl> listCustomer;
	
	private List<OrderCategoryServiceImpl> listOrderCategoryService;
	
	private String email;
	
	private String userId;
	
	private String userName;
	
	private String approveCondition1;
	
	private String approveCondition2;
	
	private String approveCondition3;
	
	private String approveCondition4;
	
	private String statusCondition;
	
	private String seaApplicantName;
	
	private String seaPayeeName;
	
	private String seaOrderCategory;
	
	private String customerId;
	
	private String seaTypeInvoiceCode;
	
	private String seaTypePaymentCode;
	
	private String[] listSeaOrderCategory; 

	public String getSeaTypeInvoiceCode() {
		return seaTypeInvoiceCode;
	}

	public void setSeaTypeInvoiceCode(String seaTypeInvoiceCode) {
		this.seaTypeInvoiceCode = seaTypeInvoiceCode;
	}

	public String getSeaTypePaymentCode() {
		return seaTypePaymentCode;
	}

	public void setSeaTypePaymentCode(String seaTypePaymentCode) {
		this.seaTypePaymentCode = seaTypePaymentCode;
	}

	public List<String> getListStatusMain() {
		return listStatusMain;
	}

	public void setListStatusMain(List<String> listStatusMain) {
		this.listStatusMain = listStatusMain;
	}

	public String getApproverId4() {
		return approverId4;
	}

	public void setApproverId4(String approverId4) {
		this.approverId4 = approverId4;
	}

	public String getApproveStatus4() {
		return approveStatus4;
	}

	public void setApproveStatus4(String approveStatus4) {
		this.approveStatus4 = approveStatus4;
	}

	public String getApproveCondition4() {
		return approveCondition4;
	}

	public void setApproveCondition4(String approveCondition4) {
		this.approveCondition4 = approveCondition4;
	}

	public String[] getListSeaOrderCategory() {
		return listSeaOrderCategory;
	}

	public void setListSeaOrderCategory(String[] listSeaOrderCategory) {
		this.listSeaOrderCategory = listSeaOrderCategory;
	}

	public String getSeaOrderCategory() {
		return seaOrderCategory;
	}

	public void setSeaOrderCategory(String seaOrderCategory) {
		this.seaOrderCategory = seaOrderCategory;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSeaApplicantName() {
		return seaApplicantName;
	}

	public void setSeaApplicantName(String seaApplicantName) {
		this.seaApplicantName = seaApplicantName;
	}

	public String getSeaPayeeName() {
		return seaPayeeName;
	}

	public void setSeaPayeeName(String seaPayeeName) {
		this.seaPayeeName = seaPayeeName;
	}

	public String getStatusCondition() {
		return statusCondition;
	}

	public void setStatusCondition(String statusCondition) {
		this.statusCondition = statusCondition;
	}

	public String getApproveCondition1() {
		return approveCondition1;
	}

	public void setApproveCondition1(String approveCondition1) {
		this.approveCondition1 = approveCondition1;
	}

	public String getApproveCondition2() {
		return approveCondition2;
	}

	public void setApproveCondition2(String approveCondition2) {
		this.approveCondition2 = approveCondition2;
	}

	public String getApproveCondition3() {
		return approveCondition3;
	}

	public void setApproveCondition3(String approveCondition3) {
		this.approveCondition3 = approveCondition3;
	}

	public String getApproveStatus1() {
		return approveStatus1;
	}

	public void setApproveStatus1(String approveStatus1) {
		this.approveStatus1 = approveStatus1;
	}

	public String getApproveStatus2() {
		return approveStatus2;
	}

	public void setApproveStatus2(String approveStatus2) {
		this.approveStatus2 = approveStatus2;
	}

	public String getApproveStatus3() {
		return approveStatus3;
	}

	public void setApproveStatus3(String approveStatus3) {
		this.approveStatus3 = approveStatus3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<OrderCategoryServiceImpl> getListOrderCategoryService() {
		return listOrderCategoryService;
	}

	public void setListOrderCategoryService(
			List<OrderCategoryServiceImpl> listOrderCategoryService) {
		this.listOrderCategoryService = listOrderCategoryService;
	}

	public Long getIdOrderCategoryServiceDetail() {
		return idOrderCategoryServiceDetail;
	}

	public void setIdOrderCategoryServiceDetail(Long idOrderCategoryServiceDetail) {
		this.idOrderCategoryServiceDetail = idOrderCategoryServiceDetail;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getApproverId1() {
		return approverId1;
	}

	public void setApproverId1(String approverId1) {
		this.approverId1 = approverId1;
	}

	public String getApproverId2() {
		return approverId2;
	}

	public void setApproverId2(String approverId2) {
		this.approverId2 = approverId2;
	}

	public String getApproverId3() {
		return approverId3;
	}

	public void setApproverId3(String approverId3) {
		this.approverId3 = approverId3;
	}

	public List<PermissionImpl> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<PermissionImpl> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public List<PermissionImpl> getListDivision() {
		return listDivision;
	}

	public void setListDivision(List<PermissionImpl> listDivision) {
		this.listDivision = listDivision;
	}

	public List<String> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<String> listStatus) {
		this.listStatus = listStatus;
	}

	public String getArrayId() {
		return arrayId;
	}

	public void setArrayId(String arrayId) {
		this.arrayId = arrayId;
	}

	public List<OrderCategoryImpl> getListOrderCategoryLevel1() {
		return listOrderCategoryLevel1;
	}

	public void setListOrderCategoryLevel1(
			List<OrderCategoryImpl> listOrderCategoryLevel1) {
		this.listOrderCategoryLevel1 = listOrderCategoryLevel1;
	}

	public List<OrderCategoryImpl> getListOrderCategoryLevel2() {
		return listOrderCategoryLevel2;
	}

	public void setListOrderCategoryLevel2(
			List<OrderCategoryImpl> listOrderCategoryLevel2) {
		this.listOrderCategoryLevel2 = listOrderCategoryLevel2;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Long getIdOrderCategoryService() {
		return idOrderCategoryService;
	}

	public void setIdOrderCategoryService(Long idOrderCategoryService) {
		this.idOrderCategoryService = idOrderCategoryService;
	}

	public String getTagPage() {
		return tagPage;
	}

	public void setTagPage(String tagPage) {
		this.tagPage = tagPage;
	}

	public String getApplicantDivisionName() {
		return applicantDivisionName;
	}

	public void setApplicantDivisionName(String applicantDivisionName) {
		this.applicantDivisionName = applicantDivisionName;
	}

	public List<OrderCategoryServiceDetailImpl> getListOrderCategoryServiceDetail() {
		return listOrderCategoryServiceDetail;
	}

	public void setListOrderCategoryServiceDetail(
			List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetail) {
		this.listOrderCategoryServiceDetail = listOrderCategoryServiceDetail;
	}
	
}