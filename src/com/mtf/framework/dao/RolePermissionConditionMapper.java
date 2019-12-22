package com.mtf.framework.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.RolePermissionImpl;
/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：模型层 -> 角色权限列表
 * 作者:     Auto
 * 日期:     2015/1/22
 **********************************************
 */
public interface RolePermissionConditionMapper extends CommonMapper {

	List<RolePermissionImpl> selectLoginPermission(RolePermissionImpl rolePermission);
	
	List<RolePermissionImpl> selectRolePermissionSys(RolePermissionImpl rolePermission);
	
	List<RolePermissionImpl> selectRolePermissionDiv(RolePermissionImpl rolePermission);
	
	List<RolePermissionImpl> selectRolePermissionUser(RolePermissionImpl rolePermission);
	
	Set<Map<String, String>> selectMap(RolePermissionImpl rolePermission);
}