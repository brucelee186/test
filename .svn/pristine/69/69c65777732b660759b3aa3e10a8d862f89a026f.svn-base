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
 * 模块名称: 基础资料 -> 请假类型
 * 作者:    Auto
 * 日期:    2015/7/27
 **********************************************
 */
public class AttenVacate extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 请假名称
	private String name;
	// 最小时长
	private String duration;
	// 单位
	private String unit;
	// 工时系数(请假后可领到的工资比例)
	private String proportion;
	// 备注
	private String remark;
	// 标记（d:delete)
	private String tag;
	// 排序
	private String orderIndex;
	// 编号,统计报表时使用
	private String code;
	// 起始时长
	private String dayStart;
	// 结束时长
	private String dayEnd;
	// 补假标记(yes:y,No:n)
	private String tagTimeOff;
	// 允许代请(yes:y,No:n)
	private String tagInstead;
	// 允许中断(yes:y,No:n)
	private String tagBreakOff;
	// 审批等级(ap1经理,ap2刘总高总)
	private String approveLevel;
	// 请假提前时长
	private String dayVacateAhead;
	// 是否需要证明(yes:y,No:n)
	private String tagProve;
	// 记录类型(main:m 主记录，detail:d　次记录)
	private String tagType;
	// 父编号
	private Long pid;
	// 创建时间
	private String addDate;
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
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(String orderIndex) {
		this.orderIndex = orderIndex;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}
	public String getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(String dayEnd) {
		this.dayEnd = dayEnd;
	}
	public String getTagTimeOff() {
		return tagTimeOff;
	}

	public void setTagTimeOff(String tagTimeOff) {
		this.tagTimeOff = tagTimeOff;
	}
	public String getTagInstead() {
		return tagInstead;
	}

	public void setTagInstead(String tagInstead) {
		this.tagInstead = tagInstead;
	}
	public String getTagBreakOff() {
		return tagBreakOff;
	}

	public void setTagBreakOff(String tagBreakOff) {
		this.tagBreakOff = tagBreakOff;
	}
	public String getApproveLevel() {
		return approveLevel;
	}

	public void setApproveLevel(String approveLevel) {
		this.approveLevel = approveLevel;
	}
	public String getDayVacateAhead() {
		return dayVacateAhead;
	}

	public void setDayVacateAhead(String dayVacateAhead) {
		this.dayVacateAhead = dayVacateAhead;
	}
	public String getTagProve() {
		return tagProve;
	}

	public void setTagProve(String tagProve) {
		this.tagProve = tagProve;
	}
	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
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