package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.PermissionConditionMapper;
import com.mtf.framework.dao.PermissionMapper;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.PermissionService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 权限列表
 * 作者:     Auto
 * 日期:     2015/2/11
**********************************************
*/
@Service("permissionService")
public class PermissionServiceImpl extends CommonServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private PermissionConditionMapper permissionConditionMapper;

	@Autowired
	public PermissionConditionMapper getPermissionConditionMapper() {
		return permissionConditionMapper;
	}

	@Autowired
	public void setPermissionConditionMapper(
			PermissionConditionMapper permissionConditionMapper) {
		this.permissionConditionMapper = permissionConditionMapper;
	}

	@Autowired
	public PermissionMapper getPermissionMapper() {
		return permissionMapper;
	}

	@Autowired
	public void setPermissionMapper(PermissionMapper permissionMapper) {
		this.permissionMapper = permissionMapper;
	}

	/**
	 * 新增实体对象
	 * @param permission
	 */
	public PermissionImpl insert(PermissionImpl permission) throws PmException {
		this.permissionMapper.insert(permission);
		return permission;
	}

	/**
	 * 删除实体对象
	 * @param permission
	 */
	public int delete(PermissionImpl permission) throws PmException {
		return this.permissionMapper.delete(permission);
	}

	/**
	 * 更新实体对象
	 * @param permission
	 */
	public boolean update(PermissionImpl permission) throws PmException {
		boolean result = true;
		this.permissionMapper.update(permission);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param permission
	 */
	@SuppressWarnings("unchecked")
	public List<PermissionImpl> select(PermissionImpl permission) throws PmException {
		return (List<PermissionImpl>) this.permissionMapper.select(permission);
	}
	/**
	 * 查询单个实体
	 * @param permission
	 */
	public PermissionImpl get(PermissionImpl permission) throws PmException {
		return (PermissionImpl) this.permissionMapper.get(permission);
	}
	/**
	 * 查询实体分页列表
	 * @param permission
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<PermissionImpl> search(PermissionImpl permission) throws PmException {
		DataGrid<PermissionImpl> grid = new DataGrid<PermissionImpl>();
		Object obj = permission;
		List list = permissionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = permissionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 根据用户权限查询可以审批的部门
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	public List<PermissionImpl> searchUserDivisionByPermission(
			PermissionImpl permission) throws PmException {
		return permissionConditionMapper.searchUserDivisionByPermission(permission);
	}
}