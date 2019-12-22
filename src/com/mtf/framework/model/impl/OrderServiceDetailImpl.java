package com.mtf.framework.model.impl;

import java.util.Date;

import com.mtf.framework.model.OrderServiceDetail;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/10/26
 **********************************************
 */
public class OrderServiceDetailImpl extends OrderServiceDetail {
	private static final long serialVersionUID = 1L;
	// 考勤数据采集时间
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
	// 客户
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
	public String getPassenger() {
		return passenger;
	}
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
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
	
	
}