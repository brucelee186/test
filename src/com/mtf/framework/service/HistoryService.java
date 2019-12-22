package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.History;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 人员信息表
 * 作者:     Auto
 * 日期:     2014/4/22
**********************************************
*/
public interface HistoryService {
	/**
	 * 新增实体对象
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public History insertForVersioin(History history) throws PmException;
	/**
	 * 新增实体对象
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public History insert(History history) throws PmException;

	/**
	 * 删除实体对象
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public int delete(History history) throws PmException;

	/**
	 * 更新实体对象
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public boolean update(History history) throws PmException;

	/**
	 * 查询实体数量
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public DataGrid<History> select(History history) throws PmException;
	
	/**
	 * 取得单一对象
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public History get(History history) throws PmException;
	
	/**
	 * 取得单一对象
	 * @param history
	 * @return
	 * @throws PmException
	 */
	public History getMax(History history) throws PmException;

}