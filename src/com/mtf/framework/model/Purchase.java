package com.mtf.framework.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.util.JsonDateTimeSerializer;
import com.mtf.framework.util.JsonDateSerializer;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 采购表
 * 作者:    Auto
 * 日期:    2015/3/6
 **********************************************
 */
public class Purchase extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 采购单号
	private Integer no;
	// 申请人Id
	private String applicantId;
	// 申请人名称
	private String applicantName;
	// 申请部门ID
	private String applicantdivisionId;
	// 申请部门名称
	private String applicantdivisionName;
	// 申请时间
	private Date applicantDatetime;
	// 一级审批人ID
	private String approvelV1UserId;
	// 一级审批人名称
	private String approvelv1UserName;
	// 一级审批人时间
	private Date approveLv1UserDatetime;
	// 指定的一级审批人ID
	private String specifiedlv1ApproveUserIds;
	// 指定的一级审批人姓名
	private String specifiedlv1ApproveUserNames;
	// 评估人ID
	private String quoteUserId;
	// 评估人姓名
	private String quoteUserName;
	// 评估时间
	private Date quoteDatetime;
	// 评估备注
	private String quoteComment;
	// 评估金额
	private double quoteTotalAmount;
	// 评估货币ID
	private String quoteCurrencyId;
	//汇率
	private double exchangeRate;
	//转换人民币总金额
	private double totalRmbAmount;
	// 是否估计的方式介入 0:申购方式，1：估值方式
	private Integer isQuoted;
	// 指定的二级审批人ID
	private String specifiedlv2ApproveUserIds;
	// 指定的二级审批人姓名
	private String specifiedlv2ApproveUserNames;
	// 二级审批人ID
	private String approvelV2UserId;
	// 二级审批人姓名
	private String approvelv2UserName;
	// 二级审批时间
	private Date approveLv2UserDatetime;
	
	private Integer reqLevel;
	private Integer appLevel;
	// 0 : 草稿，1：已提交， 2：申购审批完成， 3： 已估价， 4：采购审批完成，5：已采购， 6：采购完成,  8：拒绝， 9：取消
	private Integer status;
	// 创建人Id
	private String createUserId;
	// 创建人名称
	private String createUserName;
	// 创建时间
	private Date createDatetime;
	// 更新人ID
	private String updateUserId;
	// 更新人名称
	private String updateUserName;
	// 更新时间
	private Date updateDatetime;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getNo() {
		return no;
	}
	
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public String getApplicantId() {
		return applicantId;
	}
	
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	
	public String getApplicantName() {
		return applicantName;
	}
	
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
	public String getApplicantdivisionId() {
		return applicantdivisionId;
	}
	
	public void setApplicantdivisionId(String applicantdivisionId) {
		this.applicantdivisionId = applicantdivisionId;
	}
	
	public String getApplicantdivisionName() {
		return applicantdivisionName;
	}
	
	public void setApplicantdivisionName(String applicantdivisionName) {
		this.applicantdivisionName = applicantdivisionName;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getApplicantDatetime() {
		return applicantDatetime;
	}
	
	public void setApplicantDatetime(Date applicantDatetime) {
		this.applicantDatetime = applicantDatetime;
	}
	
	public String getApprovelV1UserId() {
		return approvelV1UserId;
	}
	
	public void setApprovelV1UserId(String approvelV1UserId) {
		this.approvelV1UserId = approvelV1UserId;
	}
	
	public String getApprovelv1UserName() {
		return approvelv1UserName;
	}
	
	public void setApprovelv1UserName(String approvelv1UserName) {
		this.approvelv1UserName = approvelv1UserName;
	}
	
	public Date getApproveLv1UserDatetime() {
		return approveLv1UserDatetime;
	}
	
	public void setApproveLv1UserDatetime(Date approveLv1UserDatetime) {
		this.approveLv1UserDatetime = approveLv1UserDatetime;
	}
	@JsonIgnore
	public String getSpecifiedlv1ApproveUserIds() {
		return specifiedlv1ApproveUserIds;
	}
	
	public void setSpecifiedlv1ApproveUserIds(String specifiedlv1ApproveUserIds) {
		this.specifiedlv1ApproveUserIds = specifiedlv1ApproveUserIds;
	}
	@JsonIgnore
	public String getSpecifiedlv1ApproveUserNames() {
		return specifiedlv1ApproveUserNames;
	}
	
	public void setSpecifiedlv1ApproveUserNames(String specifiedlv1ApproveUserNames) {
		this.specifiedlv1ApproveUserNames = specifiedlv1ApproveUserNames;
	}
	
	public String getQuoteUserId() {
		return quoteUserId;
	}
	
	public void setQuoteUserId(String quoteUserId) {
		this.quoteUserId = quoteUserId;
	}
	
	public String getQuoteUserName() {
		return quoteUserName;
	}
	
	public void setQuoteUserName(String quoteUserName) {
		this.quoteUserName = quoteUserName;
	}
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getQuoteDatetime() {
		return quoteDatetime;
	}
	
	public void setQuoteDatetime(Date quoteDatetime) {
		this.quoteDatetime = quoteDatetime;
	}
	
	public String getQuoteComment() {
		return quoteComment;
	}
	
	public void setQuoteComment(String quoteComment) {
		this.quoteComment = quoteComment;
	}
	
	public double getQuoteTotalAmount() {
		return quoteTotalAmount;
	}
	
	public void setQuoteTotalAmount(double quoteTotalAmount) {
		this.quoteTotalAmount = quoteTotalAmount;
	}
	
	public String getQuoteCurrencyId() {
		return quoteCurrencyId;
	}
	
	public void setQuoteCurrencyId(String quoteCurrencyId) {
		this.quoteCurrencyId = quoteCurrencyId;
	}
	
	
	public double getExchangeRate() {
		return exchangeRate;
	}

	
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	
	public double getTotalRmbAmount() {
		return totalRmbAmount;
	}

	
	public void setTotalRmbAmount(double totalRmbAmount) {
		this.totalRmbAmount = totalRmbAmount;
	}

	@JsonIgnore
	public Integer getIsQuoted() {
		return isQuoted;
	}

	public void setIsQuoted(Integer isQuoted) {
		this.isQuoted = isQuoted;
	}

	@JsonIgnore
	public String getSpecifiedlv2ApproveUserIds() {
		return specifiedlv2ApproveUserIds;
	}
	
	public void setSpecifiedlv2ApproveUserIds(String specifiedlv2ApproveUserIds) {
		this.specifiedlv2ApproveUserIds = specifiedlv2ApproveUserIds;
	}
	@JsonIgnore
	public String getSpecifiedlv2ApproveUserNames() {
		return specifiedlv2ApproveUserNames;
	}
	
	public void setSpecifiedlv2ApproveUserNames(String specifiedlv2ApproveUserNames) {
		this.specifiedlv2ApproveUserNames = specifiedlv2ApproveUserNames;
	}
	
	public String getApprovelV2UserId() {
		return approvelV2UserId;
	}
	
	public void setApprovelV2UserId(String approvelV2UserId) {
		this.approvelV2UserId = approvelV2UserId;
	}
	
	public String getApprovelv2UserName() {
		return approvelv2UserName;
	}
	
	public void setApprovelv2UserName(String approvelv2UserName) {
		this.approvelv2UserName = approvelv2UserName;
	}
	
	public Date getApproveLv2UserDatetime() {
		return approveLv2UserDatetime;
	}
	
	public void setApproveLv2UserDatetime(Date approveLv2UserDatetime) {
		this.approveLv2UserDatetime = approveLv2UserDatetime;
	}
		
	public Integer getReqLevel() {
		return reqLevel;
	}
	
	public void setReqLevel(Integer reqLevel) {
		this.reqLevel = reqLevel;
	}
	
	public Integer getAppLevel() {
		return appLevel;
	}
	
	public void setAppLevel(Integer appLevel) {
		this.appLevel = appLevel;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getCreateUserId() {
		return createUserId;
	}
	
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
	public String getCreateUserName() {
		return createUserName;
	}
	
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCreateDatetime() {
		return createDatetime;
	}
	
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	
	public String getUpdateUserId() {
		return updateUserId;
	}
	
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	
	public String getUpdateUserName() {
		return updateUserName;
	}
	
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getUpdateDatetime() {
		return updateDatetime;
	}
	
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
}