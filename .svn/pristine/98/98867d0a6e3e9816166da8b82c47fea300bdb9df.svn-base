package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.SysTempImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 系统缓存
 * 作者:     Auto
 * 日期:     2017/9/18
**********************************************
*/
public interface SysTempService {
	/**
	 * 新增实体对象
	 * @param sysTemp
	 * @return
	 * @throws PmException
	 */
	public SysTempImpl insert(SysTempImpl sysTemp) throws PmException;

	/**
	 * 删除实体对象
	 * @param sysTemp
	 * @return
	 * @throws PmException
	 */
	public int delete(SysTempImpl sysTemp) throws PmException;

	/**
	 * 更新实体对象
	 * @param sysTemp
	 * @return
	 * @throws PmException
	 */
	public boolean update(SysTempImpl sysTemp) throws PmException;

	/**
	 * 查询实体列表
	 * @param sysTemp
	 * @return
	 * @throws PmException
	 */
	public List<SysTempImpl> select(SysTempImpl sysTemp) throws PmException;

	/**
	 * 取得单一对象
	 * @param sysTemp
	 * @return
	 * @throws PmException
	 */
	public SysTempImpl get(SysTempImpl sysTemp) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param sysTemp
	 * @return
	 * @throws PmException
	 */
	public DataGrid<SysTempImpl> search(SysTempImpl sysTemp) throws PmException;

}