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
 * 模块名称: 基础资料 -> 请假管理
 * 作者:    Auto
 * 日期:    2018/5/9
 **********************************************
 */
public class AttenVacateManage extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 请假名称
	private String name;
	// 部门编号
	private String divisionId;
	// 部门名称
	private String divisionName;
	// 用户编号
	private String userId;
	// 用户姓名
	private String userName;
	// 员工卡编号
	private String cardNo;
	// 请假类型编号
	private Long idVacate;
	// 请假类型名称
	private String nameVacate;
	// 请假类型编号明细
	private Long idVacateDetail;
	// 请假类型名称明细
	private String nameVacateDetail;
	// 编号,统计报表时使用
	private String code;
	// 明细编号,统计报表时使用
	private String codeDetail;
	// 直系亲属(父母;pa, 配偶的父母:ma_pa, 配偶:ma, 子女:ch)
	private String optionDirectly;
	// 旁系亲属
	private String remarkCollateral;
	// 开始日期
	private String dateStart;
	// 结束日期
	private String dateEnd;
	// 小时开始
	private String hourStart;
	// 小时结束
	private String hourEnd;
	// 分钟开始
	private String minuteStart;
	// 分钟结束
	private String minuteEnd;
	// 请假方式(h:按小时，d:按天)
	private String typeVacateDate;
	// 请假原因
	private String reason;
	// 时长
	private String duration;
	// 请假时长(按小时)
	private Double durationAttenVacateHour;
	// 合计时长(单位天)
	private String durationTotal;
	// 工作日
	private String workday;
	// 审批人编号
	private String approveId;
	// 审批人姓名
	private String approveName;
	// 审批日期
	private Date approveDate;
	// 审批等级(approve:ap1,ap2,reject:re1,submit:s)
	private String approveStatus;
	// 审批人编号1
	private String approveId1;
	// 审批人姓名1
	private String approveName1;
	// 审批日期1
	private Date approveDate1;
	// 审批人编号2
	private String approveId2;
	// 审批人姓名2
	private String approveName2;
	// 审批日期2
	private Date approveDate2;
	// 备注
	private String remark;
	// 驳回信息
	private String remarkReject;
	// 记录标识(n:nromal, d:delete)
	private String tag;
	// // 数据类型(v:vacate请假，a:attendance考勤,    od:over work division 部门加班, op:over work person 个人加班)
	private String typeData;
	// 年度
	private String year;
	// 发邮件标记(s:sent,u:unsent)
	private String tagEmail;
	// 申请人姓名列表
	private String userNameList;
	// 申请人编号列表
	private String userIdList;
	// 起始时间
	private String rangeArea;
	// 加班时间(小数格式)
	private Double workOvertimeRule;
	// 加班时间上班前(小数格式)
	private Double workOvertimeBeforeRule;
	// 加班时间下班后(小数格式)
	private Double workOvertimeAfterRule;
	// 周(1:周日, 2:周一, 3:周二, 4:周三, 5:周四, 6:周五, 7:周六)
	private String dateWeek;
	// 备注内容
	private String remarkText;
	// 备注编码
	private String remarkCode;
	// 更新加班标记(y:更新完毕,n:未更新)
	private String tagCreateOverwork;
	// 加班修正标记(y:更新完毕,n:未更新)
	private String tagModifyOverwork;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
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
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Long getIdVacate() {
		return idVacate;
	}

	public void setIdVacate(Long idVacate) {
		this.idVacate = idVacate;
	}
	public String getNameVacate() {
		return nameVacate;
	}

	public void setNameVacate(String nameVacate) {
		this.nameVacate = nameVacate;
	}
	public Long getIdVacateDetail() {
		return idVacateDetail;
	}

	public void setIdVacateDetail(Long idVacateDetail) {
		this.idVacateDetail = idVacateDetail;
	}
	public String getNameVacateDetail() {
		return nameVacateDetail;
	}

	public void setNameVacateDetail(String nameVacateDetail) {
		this.nameVacateDetail = nameVacateDetail;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeDetail() {
		return codeDetail;
	}

	public void setCodeDetail(String codeDetail) {
		this.codeDetail = codeDetail;
	}
	public String getOptionDirectly() {
		return optionDirectly;
	}

	public void setOptionDirectly(String optionDirectly) {
		this.optionDirectly = optionDirectly;
	}
	public String getRemarkCollateral() {
		return remarkCollateral;
	}

	public void setRemarkCollateral(String remarkCollateral) {
		this.remarkCollateral = remarkCollateral;
	}
	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getHourStart() {
		return hourStart;
	}

	public void setHourStart(String hourStart) {
		this.hourStart = hourStart;
	}
	public String getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(String hourEnd) {
		this.hourEnd = hourEnd;
	}
	public String getMinuteStart() {
		return minuteStart;
	}

	public void setMinuteStart(String minuteStart) {
		this.minuteStart = minuteStart;
	}
	public String getMinuteEnd() {
		return minuteEnd;
	}

	public void setMinuteEnd(String minuteEnd) {
		this.minuteEnd = minuteEnd;
	}
	public String getTypeVacateDate() {
		return typeVacateDate;
	}

	public void setTypeVacateDate(String typeVacateDate) {
		this.typeVacateDate = typeVacateDate;
	}
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Double getDurationAttenVacateHour() {
		return durationAttenVacateHour;
	}

	public void setDurationAttenVacateHour(Double durationAttenVacateHour) {
		this.durationAttenVacateHour = durationAttenVacateHour;
	}
	public String getDurationTotal() {
		return durationTotal;
	}

	public void setDurationTotal(String durationTotal) {
		this.durationTotal = durationTotal;
	}
	public String getWorkday() {
		return workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}
	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}
	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getApproveId1() {
		return approveId1;
	}

	public void setApproveId1(String approveId1) {
		this.approveId1 = approveId1;
	}
	public String getApproveName1() {
		return approveName1;
	}

	public void setApproveName1(String approveName1) {
		this.approveName1 = approveName1;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate1() {
		return approveDate1;
	}

	public void setApproveDate1(Date approveDate1) {
		this.approveDate1 = approveDate1;
	}
	public String getApproveId2() {
		return approveId2;
	}

	public void setApproveId2(String approveId2) {
		this.approveId2 = approveId2;
	}
	public String getApproveName2() {
		return approveName2;
	}

	public void setApproveName2(String approveName2) {
		this.approveName2 = approveName2;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate2() {
		return approveDate2;
	}

	public void setApproveDate2(Date approveDate2) {
		this.approveDate2 = approveDate2;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkReject() {
		return remarkReject;
	}

	public void setRemarkReject(String remarkReject) {
		this.remarkReject = remarkReject;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	public String getTagEmail() {
		return tagEmail;
	}

	public void setTagEmail(String tagEmail) {
		this.tagEmail = tagEmail;
	}
	public String getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(String userNameList) {
		this.userNameList = userNameList;
	}
	public String getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(String userIdList) {
		this.userIdList = userIdList;
	}
	public String getRangeArea() {
		return rangeArea;
	}

	public void setRangeArea(String rangeArea) {
		this.rangeArea = rangeArea;
	}
	public Double getWorkOvertimeRule() {
		return workOvertimeRule;
	}

	public void setWorkOvertimeRule(Double workOvertimeRule) {
		this.workOvertimeRule = workOvertimeRule;
	}
	public Double getWorkOvertimeBeforeRule() {
		return workOvertimeBeforeRule;
	}

	public void setWorkOvertimeBeforeRule(Double workOvertimeBeforeRule) {
		this.workOvertimeBeforeRule = workOvertimeBeforeRule;
	}
	public Double getWorkOvertimeAfterRule() {
		return workOvertimeAfterRule;
	}

	public void setWorkOvertimeAfterRule(Double workOvertimeAfterRule) {
		this.workOvertimeAfterRule = workOvertimeAfterRule;
	}
	public String getDateWeek() {
		return dateWeek;
	}

	public void setDateWeek(String dateWeek) {
		this.dateWeek = dateWeek;
	}
	public String getRemarkText() {
		return remarkText;
	}

	public void setRemarkText(String remarkText) {
		this.remarkText = remarkText;
	}
	public String getRemarkCode() {
		return remarkCode;
	}

	public void setRemarkCode(String remarkCode) {
		this.remarkCode = remarkCode;
	}
	public String getTagCreateOverwork() {
		return tagCreateOverwork;
	}

	public void setTagCreateOverwork(String tagCreateOverwork) {
		this.tagCreateOverwork = tagCreateOverwork;
	}
	public String getTagModifyOverwork() {
		return tagModifyOverwork;
	}

	public void setTagModifyOverwork(String tagModifyOverwork) {
		this.tagModifyOverwork = tagModifyOverwork;
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