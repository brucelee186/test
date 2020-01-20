package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.DivisionImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 部门表
 * 作者:     Auto
 * 日期:     2016/10/12
**********************************************
*/
public interface DivisionService {
	/**
	 * 新增实体对象
	 * @param division
	 * @return
	 * @throws PmException
	 */
	public DivisionImpl insert(DivisionImpl division) throws PmException;

	/**
	 * 删除实体对象
	 * @param division
	 * @return
	 * @throws PmException
	 */
	public int delete(DivisionImpl division) throws PmException;

	/**
	 * 更新实体对象
	 * @param division
	 * @return
	 * @throws PmException
	 */
	public boolean update(DivisionImpl division) throws PmException;

	/**
	 * 查询实体列表
	 * @param division
	 * @return
	 * @throws PmException
	 */
	public List<DivisionImpl> select(DivisionImpl division) throws PmException;

	/**
	 * 取得单一对象
	 * @param division
	 * @return
	 * @throws PmException
	 */
	public DivisionImpl get(DivisionImpl division) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param division
	 * @return
	 * @throws PmException
	 */
	public DataGrid<DivisionImpl> search(DivisionImpl division) throws PmException;

}