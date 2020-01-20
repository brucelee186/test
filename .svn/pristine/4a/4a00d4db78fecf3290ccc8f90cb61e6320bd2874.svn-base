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
 * 模块名称: 基础资料 -> 人员信息表
 * 作者:    Auto
 * 日期:    2018/3/14
 **********************************************
 */
public class User extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 员工编号(以前版本)
	private String code;
	// 登录名
	private String loginName;
	// 名
	private String firstName;
	// 姓
	private String lastName;
	// 显示名
	private String displayName;
	// 密码
	private String password;
	// 用户编号(以过时)
	private String userId;
	// 入职时间
	private Date datetime;
	// 签名
	private String signature;
	// 状态(0 在职, 1 离职, 2 注册, 3 驳回, 4 试用)
	private String status;
	// 邮箱地址
	private String email;
	// 国际化语言
	private String language;
	// 中文名
	private String chineseName;
	// 岗位ID
	private String departmentId;
	// 岗位等级
	private Long positionId;
	// 个人照片地址
	private String personalPhoto;
	// 员工卡号
	private String cardNo;
	// 硬件卡号
	private String badgenumber;
	// 客户
	private String workGroup;
	// 客户明细
	private String workGroupDetail;
	// 添加时间
	private Date addDate;
	// 添加人Id
	private String addIp;
	// IP地址
	private String addUser;
	// 修改人员ID
	private Date modifyDate;
	// 修改时间
	private String modifyIp;
	// IP地址
	private String modifyUser;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public String getPersonalPhoto() {
		return personalPhoto;
	}

	public void setPersonalPhoto(String personalPhoto) {
		this.personalPhoto = personalPhoto;
	}
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getBadgenumber() {
		return badgenumber;
	}

	public void setBadgenumber(String badgenumber) {
		this.badgenumber = badgenumber;
	}
	public String getWorkGroup() {
		return workGroup;
	}

	public void setWorkGroup(String workGroup) {
		this.workGroup = workGroup;
	}
	public String getWorkGroupDetail() {
		return workGroupDetail;
	}

	public void setWorkGroupDetail(String workGroupDetail) {
		this.workGroupDetail = workGroupDetail;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyIp() {
		return modifyIp;
	}

	public void setModifyIp(String modifyIp) {
		this.modifyIp = modifyIp;
	}
	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
}