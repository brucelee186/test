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
 * 模块名称: 基础资料 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/12/24
 **********************************************
 */
public class OrderService extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 车辆牌照
	private String vehiclePlateNo;
	// 用车人
	private String userName;
	// 用车人编号
	private String userId;
	// 司机姓名
	private String nameDriver;
	// 司机编号
	private String driverId;
	// 用车部门
	private String deptRequester;
	// 部门编号
	private String divisionId;
	// 部门名称
	private String divisionName;
	// 随行人
	private String passenger;
	// 计划出行时间
	private Date timeTrip;
	// 计划出行路线
	private String pathTrip;
	// 其它费用
	private Double expenseOther;
	// 通行费
	private Double expensePass;
	// 停车费
	private Double expseseStop;
	// 过桥费
	private Double expensePontage;
	// 住宿费
	private Double expseseStay;
	// 类别
	private String type;
	// 客户编号
	private String customer;
	// 月份
	private String month;
	// 始发地
	private String origin;
	// 目的地
	private String destination;
	// 计费类别
	private String typeExpense;
	// 交车时间
	private Date timeHandIn;
	// 公里数
	private Double mileage;
	// 实际费用
	private Double expenseActual;
	// 合计
	private Double expenseTotal;
	// 报销日期
	private Date timeReimbursement;
	// 备注
	private String remark;
	// 审批备注
	private String remarkApprove;
	// 固定路线编号
	private Long idOrderServicePath;
	// 固定路线名称
	private String nameOrderServicePath;
	// 订车状态(1员工申请: d draft 草稿 s sumbit 提交,            2部门审批:ap1 ,                                            3行政派车: draft allocation da 派车中 submit allocation sa 已派车,4员工确认: affirm submit allocation  asa,5行政录入派车单: draft input aollcation dia 录入派车单草稿, sumbit input aollcation sia 录入派车单完成,6员工派车单确认: affirm input aollcation aia, 7行政审批: ap2)
	private String statusOrder;
	// 一级审批人
	private String approveUser1;
	// 一级审批时间
	private Date approveDate1;
	// 一级审批IP
	private String approveIp1;
	// 二级审批人
	private String approveUser2;
	// 二级审批时间
	private Date approveDate2;
	// 二级审批IP
	private String approveIp2;
	// 统计主表编号
	private Long idOrderServiceRecord;
	// 发邮件标记(s:sent,u:unsent)
	private String tagEmail;
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
	public String getVehiclePlateNo() {
		return vehiclePlateNo;
	}

	public void setVehiclePlateNo(String vehiclePlateNo) {
		this.vehiclePlateNo = vehiclePlateNo;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNameDriver() {
		return nameDriver;
	}

	public void setNameDriver(String nameDriver) {
		this.nameDriver = nameDriver;
	}
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDeptRequester() {
		return deptRequester;
	}

	public void setDeptRequester(String deptRequester) {
		this.deptRequester = deptRequester;
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
	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getTimeTrip() {
		return timeTrip;
	}

	public void setTimeTrip(Date timeTrip) {
		this.timeTrip = timeTrip;
	}
	public String getPathTrip() {
		return pathTrip;
	}

	public void setPathTrip(String pathTrip) {
		this.pathTrip = pathTrip;
	}
	public Double getExpenseOther() {
		return expenseOther;
	}

	public void setExpenseOther(Double expenseOther) {
		this.expenseOther = expenseOther;
	}
	public Double getExpensePass() {
		return expensePass;
	}

	public void setExpensePass(Double expensePass) {
		this.expensePass = expensePass;
	}
	public Double getExpseseStop() {
		return expseseStop;
	}

	public void setExpseseStop(Double expseseStop) {
		this.expseseStop = expseseStop;
	}
	public Double getExpensePontage() {
		return expensePontage;
	}

	public void setExpensePontage(Double expensePontage) {
		this.expensePontage = expensePontage;
	}
	public Double getExpseseStay() {
		return expseseStay;
	}

	public void setExpseseStay(Double expseseStay) {
		this.expseseStay = expseseStay;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTypeExpense() {
		return typeExpense;
	}

	public void setTypeExpense(String typeExpense) {
		this.typeExpense = typeExpense;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getTimeHandIn() {
		return timeHandIn;
	}

	public void setTimeHandIn(Date timeHandIn) {
		this.timeHandIn = timeHandIn;
	}
	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public Double getExpenseActual() {
		return expenseActual;
	}

	public void setExpenseActual(Double expenseActual) {
		this.expenseActual = expenseActual;
	}
	public Double getExpenseTotal() {
		return expenseTotal;
	}

	public void setExpenseTotal(Double expenseTotal) {
		this.expenseTotal = expenseTotal;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getTimeReimbursement() {
		return timeReimbursement;
	}

	public void setTimeReimbursement(Date timeReimbursement) {
		this.timeReimbursement = timeReimbursement;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemarkApprove() {
		return remarkApprove;
	}

	public void setRemarkApprove(String remarkApprove) {
		this.remarkApprove = remarkApprove;
	}
	public Long getIdOrderServicePath() {
		return idOrderServicePath;
	}

	public void setIdOrderServicePath(Long idOrderServicePath) {
		this.idOrderServicePath = idOrderServicePath;
	}
	public String getNameOrderServicePath() {
		return nameOrderServicePath;
	}

	public void setNameOrderServicePath(String nameOrderServicePath) {
		this.nameOrderServicePath = nameOrderServicePath;
	}
	public String getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(String statusOrder) {
		this.statusOrder = statusOrder;
	}
	public String getApproveUser1() {
		return approveUser1;
	}

	public void setApproveUser1(String approveUser1) {
		this.approveUser1 = approveUser1;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate1() {
		return approveDate1;
	}

	public void setApproveDate1(Date approveDate1) {
		this.approveDate1 = approveDate1;
	}
	public String getApproveIp1() {
		return approveIp1;
	}

	public void setApproveIp1(String approveIp1) {
		this.approveIp1 = approveIp1;
	}
	public String getApproveUser2() {
		return approveUser2;
	}

	public void setApproveUser2(String approveUser2) {
		this.approveUser2 = approveUser2;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getApproveDate2() {
		return approveDate2;
	}

	public void setApproveDate2(Date approveDate2) {
		this.approveDate2 = approveDate2;
	}
	public String getApproveIp2() {
		return approveIp2;
	}

	public void setApproveIp2(String approveIp2) {
		this.approveIp2 = approveIp2;
	}
	public Long getIdOrderServiceRecord() {
		return idOrderServiceRecord;
	}

	public void setIdOrderServiceRecord(Long idOrderServiceRecord) {
		this.idOrderServiceRecord = idOrderServiceRecord;
	}
	public String getTagEmail() {
		return tagEmail;
	}

	public void setTagEmail(String tagEmail) {
		this.tagEmail = tagEmail;
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