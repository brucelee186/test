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
 * 模块名称: 基础资料 -> 权限列表
 * 作者:    Auto
 * 日期:    2016/10/24
 **********************************************
 */
public class Permission extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 权限编号
	private Long id;
	// 权限名称
	private String name;
	// 类型 m:menu 菜单,b:button 按钮,l:link 链接, a:approve 审批
	private String typePermission;
	// 数据类型 c:chekcbox,t:text
	private String typeData;
	// 记录类型(r: reference 引用外表,n: non reference 非外用外表)
	private String typeSys;
	// 角色类型(s:系统,d:部门,u:用户)
	private String type;
	// 权限编码
	private String code;
	// 父权限
	private String parentCode;
	// 层级
	private Long level;
	// 包名
	private String bag;
	// 类名
	private String clazz;
	// 方法名
	private String method;
	// 参数名
	private String parameter;
	// 参数值
	private String parameterVal;
	// 跳转链接
	private String skipUrl;
	// 权限值1
	private String value1;
	// 权限值2
	private String value2;
	// 权限值3
	private String value3;
	// 权限值4
	private String value4;
	// 备注
	private String remark;
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
	public String getTypePermission() {
		return typePermission;
	}

	public void setTypePermission(String typePermission) {
		this.typePermission = typePermission;
	}
	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}
	public String getTypeSys() {
		return typeSys;
	}

	public void setTypeSys(String typeSys) {
		this.typeSys = typeSys;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}
	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getParameterVal() {
		return parameterVal;
	}

	public void setParameterVal(String parameterVal) {
		this.parameterVal = parameterVal;
	}
	public String getSkipUrl() {
		return skipUrl;
	}

	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}
	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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