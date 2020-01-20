package com.mtf.framework.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.RolePermissionImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 角色权限列表
 * 作者:     Auto
 * 日期:     2015/1/15
**********************************************
*/
public interface RolePermissionService {
	/**
	 * 新增实体对象
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl insert(RolePermissionImpl rolePermission, HttpSession session) throws PmException;

	/**
	 * 删除实体对象
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public int delete(RolePermissionImpl rolePermission) throws PmException;

	/**
	 * 更新实体对象
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public boolean update(RolePermissionImpl rolePermission) throws PmException;

	/**
	 * 查询实体数量
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public DataGrid<RolePermissionImpl> select(RolePermissionImpl rolePermission) throws PmException;

	/**
	 * 取得单一对象
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl get(RolePermissionImpl rolePermission) throws PmException;
	
	/**
	 * 取得权限表以角色权限数据
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl searchPermissionList(RolePermissionImpl rolePermission) throws PmException;
	
	/**
	 * 编辑角色权限
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl editRolePermission(RolePermissionImpl rolePermission, HttpSession session) throws PmException;
	
	/**
	 * 复制角色权限
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl copyRolePermission(RolePermissionImpl rolePermission, HttpSession session) throws PmException;

	/**
	 * 取得角色权限列表
	 * @param listRole
	 * @return
	 * @throws PmException
	 */
	public Map<String, String> SearchRolePermission(List<String> listRole) throws PmException;
	
	/**
	 * 查询用户审批时所具有的部门权限
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public List<String> searchRolePermissionDivision(RolePermissionImpl rolePermission) throws PmException;
	
	/**
	 * 搜索权限键值对
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	Set<Map<String, String>> selectMap(RolePermissionImpl rolePermission) throws PmException;

}