package com.mtf.framework.dao;

import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.UserDetailImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 人员信息表
 * 作者:    Auto
 * 日期:    2015/3/5
 **********************************************
 */
public interface UserDetailConditionMapper extends CommonMapper {
	UserDetailImpl selectUserByPermission(UserDetailImpl userDetail);
	
	/**
	 * 取得上级领导
	 * @param userDetail
	 * @return
	 */
	UserDetailImpl getSuperior(UserDetailImpl userDetail);
	
	List<UserDetailImpl> selectUserByPermissionCode(UserDetailImpl userDetail);
	
}