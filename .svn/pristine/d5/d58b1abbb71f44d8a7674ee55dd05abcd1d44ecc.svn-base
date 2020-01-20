package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.SysHistoryImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 系统历史表
 * 作者:     Auto
 * 日期:     2016/5/26
**********************************************
*/
public interface SysHistoryService {
	/**
	 * 新增实体对象
	 * @param sysHistory
	 * @return
	 * @throws PmException
	 */
	public SysHistoryImpl insert(SysHistoryImpl sysHistory) throws PmException;

	/**
	 * 删除实体对象
	 * @param sysHistory
	 * @return
	 * @throws PmException
	 */
	public int delete(SysHistoryImpl sysHistory) throws PmException;

	/**
	 * 更新实体对象
	 * @param sysHistory
	 * @return
	 * @throws PmException
	 */
	public boolean update(SysHistoryImpl sysHistory) throws PmException;

	/**
	 * 查询实体列表
	 * @param sysHistory
	 * @return
	 * @throws PmException
	 */
	public List<SysHistoryImpl> select(SysHistoryImpl sysHistory) throws PmException;

	/**
	 * 取得单一对象
	 * @param sysHistory
	 * @return
	 * @throws PmException
	 */
	public SysHistoryImpl get(SysHistoryImpl sysHistory) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param sysHistory
	 * @return
	 * @throws PmException
	 */
	public DataGrid<SysHistoryImpl> search(SysHistoryImpl sysHistory) throws PmException;

}