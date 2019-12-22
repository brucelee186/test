package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 门禁数据
 * 作者:    Auto
 * 日期:    2015/4/9
 **********************************************
 */
public class AttMonitorLog extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Integer id;
	// 
	private String change_operator;
	// 
	private Date change_time;
	// 
	private String create_operator;
	// 
	private Date create_time;
	// 
	private String delete_operator;
	// 
	private Date delete_time;
	// 
	private Integer status;
	// 
	private Integer log_tag;
	// 
	private Date time;
	// 
	private String pin;
	// 
	private String card_no;
	// 
	private Integer device_id;
	// 
	private String device_sn;
	// 
	private String device_name;
	// 
	private Integer door_id;
	// 
	private String door_name;
	// 
	private Integer in_address;
	// 
	private Integer out_address;
	// 
	private Integer verified;
	// 
	private Integer state;
	// 
	private Integer event_type;
	// 
	private Integer trigger_opt;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getChange_operator() {
		return change_operator;
	}

	public void setChange_operator(String change_operator) {
		this.change_operator = change_operator;
	}
	public Date getChange_time() {
		return change_time;
	}

	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}
	public String getCreate_operator() {
		return create_operator;
	}

	public void setCreate_operator(String create_operator) {
		this.create_operator = create_operator;
	}
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getDelete_operator() {
		return delete_operator;
	}

	public void setDelete_operator(String delete_operator) {
		this.delete_operator = delete_operator;
	}
	public Date getDelete_time() {
		return delete_time;
	}

	public void setDelete_time(Date delete_time) {
		this.delete_time = delete_time;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getLog_tag() {
		return log_tag;
	}

	public void setLog_tag(Integer log_tag) {
		this.log_tag = log_tag;
	}
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public Integer getDevice_id() {
		return device_id;
	}

	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	public String getDevice_sn() {
		return device_sn;
	}

	public void setDevice_sn(String device_sn) {
		this.device_sn = device_sn;
	}
	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public Integer getDoor_id() {
		return door_id;
	}

	public void setDoor_id(Integer door_id) {
		this.door_id = door_id;
	}
	public String getDoor_name() {
		return door_name;
	}

	public void setDoor_name(String door_name) {
		this.door_name = door_name;
	}
	public Integer getIn_address() {
		return in_address;
	}

	public void setIn_address(Integer in_address) {
		this.in_address = in_address;
	}
	public Integer getOut_address() {
		return out_address;
	}

	public void setOut_address(Integer out_address) {
		this.out_address = out_address;
	}
	public Integer getVerified() {
		return verified;
	}

	public void setVerified(Integer verified) {
		this.verified = verified;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getEvent_type() {
		return event_type;
	}

	public void setEvent_type(Integer event_type) {
		this.event_type = event_type;
	}
	public Integer getTrigger_opt() {
		return trigger_opt;
	}

	public void setTrigger_opt(Integer trigger_opt) {
		this.trigger_opt = trigger_opt;
	}
}