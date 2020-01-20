package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.PermissionImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 权限列表
 * 作者:     Auto
 * 日期:     2015/2/11
**********************************************
*/
public interface PermissionService {
	/**
	 * 新增实体对象
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public PermissionImpl insert(PermissionImpl permission) throws PmException;

	/**
	 * 删除实体对象
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public int delete(PermissionImpl permission) throws PmException;

	/**
	 * 更新实体对象
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public boolean update(PermissionImpl permission) throws PmException;

	/**
	 * 查询实体列表
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public List<PermissionImpl> select(PermissionImpl permission) throws PmException;

	/**
	 * 取得单一对象
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public PermissionImpl get(PermissionImpl permission) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PermissionImpl> search(PermissionImpl permission) throws PmException;
	
	/**
	 * 根据用户权限查询可以审批的部门
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public List<PermissionImpl> searchUserDivisionByPermission(PermissionImpl permission) throws PmException;
	

}