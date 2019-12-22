package com.mtf.framework.model.impl;

import java.util.Date;
import java.util.List;

import com.mtf.framework.model.Attendance;


/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 门禁数据
 * 作者:    Auto
 * 日期:    2015/4/15
 **********************************************
 */
public class AttendanceImpl extends Attendance {
	private static final long serialVersionUID = 1L;
	
	// 补签标记
	private String tagRecheck;

	// 而且搜索标记(re:补签, ap:审批)
	private String tagSearch;
	
	// 审批标记 一级驳回：re1， 二级驳回：re2
	private String tagApprove;
	
	// 编号数组
	private String arrayId;
	
	// 部门编号
	private String divisionId;
	
	// 部门名称
	private String divisionName;
	
	private Date dateStart;
	
	private Date dateEnd;
	
	private String collectDate;
	
	// 周日
	private String dayOfWeek1;
	// 周一
	private String dayOfWeek2;
	// 周二
	private String dayOfWeek3;
	// 周三
	private String dayOfWeek4;
	// 周四
	private String dayOfWeek5;
	// 周五
	private String dayOfWeek6;
	// 周六
	private String dayOfWeek7;
	// 一周工作日
	private String dayOfWeek;
	
	// 用户所具有的部门补签审批权限
	private List<PermissionImpl> listDivision;
	
	// 采集考勤数据搜索用户日期是否有记录专用
	private Date dateForCalendar;
	
	// 审批时where后的判断条件 ap1,一级审批，ap2二级
	private String judApprove;
	
	// 邮件
	private String email;
	
	// 数据类型(v:vacate请假，a:attendance考勤)
	private String typeDate;
	
	// 查询旷工三天以上的记录
	private String se_absence;
	private Long b_id;
	private String b_date;
	private String b_absenteeism;
	private Long c_id;
	private String c_date;
	private String c_absenteeism;
	
	
	// 忽略更新条件标记
	private String upIgnoreIdVacate;
	
	private String searchUserName;
	
	public String getSearchUserName() {
		return searchUserName;
	}

	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}

	public String getUpIgnoreIdVacate() {
		return upIgnoreIdVacate;
	}

	public void setUpIgnoreIdVacate(String upIgnoreIdVacate) {
		this.upIgnoreIdVacate = upIgnoreIdVacate;
	}

	public Long getB_id() {
		return b_id;
	}

	public void setB_id(Long b_id) {
		this.b_id = b_id;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public String getB_absenteeism() {
		return b_absenteeism;
	}

	public void setB_absenteeism(String b_absenteeism) {
		this.b_absenteeism = b_absenteeism;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getC_absenteeism() {
		return c_absenteeism;
	}

	public void setC_absenteeism(String c_absenteeism) {
		this.c_absenteeism = c_absenteeism;
	}

	public String getSe_absence() {
		return se_absence;
	}

	public void setSe_absence(String se_absence) {
		this.se_absence = se_absence;
	}

	public String getTypeDate() {
		return typeDate;
	}

	public void setTypeDate(String typeDate) {
		this.typeDate = typeDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJudApprove() {
		return judApprove;
	}

	public void setJudApprove(String judApprove) {
		this.judApprove = judApprove;
	}

	public Date getDateForCalendar() {
		return dateForCalendar;
	}

	public void setDateForCalendar(Date dateForCalendar) {
		this.dateForCalendar = dateForCalendar;
	}

	public String getTagRecheck() {
		return tagRecheck;
	}

	public void setTagRecheck(String tagRecheck) {
		this.tagRecheck = tagRecheck;
	}

	public String getTagSearch() {
		return tagSearch;
	}

	public void setTagSearch(String tagSearch) {
		this.tagSearch = tagSearch;
	}

	public String getTagApprove() {
		return tagApprove;
	}

	public void setTagApprove(String tagApprove) {
		this.tagApprove = tagApprove;
	}

	public String getArrayId() {
		return arrayId;
	}

	public void setArrayId(String arrayId) {
		this.arrayId = arrayId;
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

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}

	public String getDayOfWeek1() {
		return dayOfWeek1;
	}

	public void setDayOfWeek1(String dayOfWeek1) {
		this.dayOfWeek1 = dayOfWeek1;
	}

	public String getDayOfWeek2() {
		return dayOfWeek2;
	}

	public void setDayOfWeek2(String dayOfWeek2) {
		this.dayOfWeek2 = dayOfWeek2;
	}

	public String getDayOfWeek3() {
		return dayOfWeek3;
	}

	public void setDayOfWeek3(String dayOfWeek3) {
		this.dayOfWeek3 = dayOfWeek3;
	}

	public String getDayOfWeek4() {
		return dayOfWeek4;
	}

	public void setDayOfWeek4(String dayOfWeek4) {
		this.dayOfWeek4 = dayOfWeek4;
	}

	public String getDayOfWeek5() {
		return dayOfWeek5;
	}

	public void setDayOfWeek5(String dayOfWeek5) {
		this.dayOfWeek5 = dayOfWeek5;
	}

	public String getDayOfWeek6() {
		return dayOfWeek6;
	}

	public void setDayOfWeek6(String dayOfWeek6) {
		this.dayOfWeek6 = dayOfWeek6;
	}

	public String getDayOfWeek7() {
		return dayOfWeek7;
	}

	public void setDayOfWeek7(String dayOfWeek7) {
		this.dayOfWeek7 = dayOfWeek7;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<PermissionImpl> getListDivision() {
		return listDivision;
	}

	public void setListDivision(List<PermissionImpl> listDivision) {
		this.listDivision = listDivision;
	}

}