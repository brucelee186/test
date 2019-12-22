package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.DivisionRoleMapper;
import com.mtf.framework.model.impl.DivisionRoleImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.DivisionRoleService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 部门角色
 * 作者:     Auto
 * 日期:     2016/6/30
**********************************************
*/
@Service("divisionRoleService")
public class DivisionRoleServiceImpl extends CommonServiceImpl implements DivisionRoleService {
	@Autowired
	private DivisionRoleMapper divisionRoleMapper;

	@Autowired
	public DivisionRoleMapper getDivisionRoleMapper() {
		return divisionRoleMapper;
	}

	@Autowired
	public void setDivisionRoleMapper(DivisionRoleMapper divisionRoleMapper) {
		this.divisionRoleMapper = divisionRoleMapper;
	}

	/**
	 * 新增实体对象
	 * @param divisionRole
	 */
	public DivisionRoleImpl insert(DivisionRoleImpl divisionRole) throws PmException {
		this.divisionRoleMapper.insert(divisionRole);
		return divisionRole;
	}

	/**
	 * 删除实体对象
	 * @param divisionRole
	 */
	public int delete(DivisionRoleImpl divisionRole) throws PmException {
		return this.divisionRoleMapper.delete(divisionRole);
	}

	/**
	 * 更新实体对象
	 * @param divisionRole
	 */
	public boolean update(DivisionRoleImpl divisionRole) throws PmException {
		boolean result = true;
		this.divisionRoleMapper.update(divisionRole);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param divisionRole
	 */
	@SuppressWarnings("unchecked")
	public List<DivisionRoleImpl> select(DivisionRoleImpl divisionRole) throws PmException {
		return (List<DivisionRoleImpl>) this.divisionRoleMapper.select(divisionRole);
	}
	/**
	 * 查询单个实体
	 * @param divisionRole
	 */
	public DivisionRoleImpl get(DivisionRoleImpl divisionRole) throws PmException {
		return (DivisionRoleImpl) this.divisionRoleMapper.get(divisionRole);
	}
	/**
	 * 查询实体分页列表
	 * @param divisionRole
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<DivisionRoleImpl> search(DivisionRoleImpl divisionRole) throws PmException {
		DataGrid<DivisionRoleImpl> grid = new DataGrid<DivisionRoleImpl>();
		Object obj = divisionRole;
		List list = divisionRoleMapper.select(obj);
		grid.setRows(list);
		int count;
		count = divisionRoleMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}