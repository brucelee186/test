package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.Information;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 系统管理员提示信息
 * 作者:     Auto
 * 日期:     2014/1/17
**********************************************
*/
public interface InformationService {
	/**
	 * 新增实体对象
	 * @param information
	 * @return
	 * @throws PmException
	 */
	public Information insert(Information information) throws PmException;

	/**
	 * 删除实体对象
	 * @param information
	 * @return
	 * @throws PmException
	 */
	public int delete(Information information) throws PmException;

	/**
	 * 更新实体对象
	 * @param information
	 * @return
	 * @throws PmException
	 */
	public boolean update(Information information) throws PmException;

	/**
	 * 查询实体数量
	 * @param information
	 * @return
	 * @throws PmException
	 */
	public DataGrid<Information> select(Information information) throws PmException;

	/**
	 * 取得单一对象
	 * @param information
	 * @return
	 * @throws PmException
	 */
	public Information get(Information information) throws PmException;

}