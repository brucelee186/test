package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.DepofficeImpl;
import com.mtf.framework.model.Depoffice;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 部门办公用品
 * 作者:     Auto
 * 日期:     2013-12-17
**********************************************
*/
public interface DepofficeService {
	/**
	 * 新增实体对象
	 * @param depOffice
	 * @return
	 * @throws PmException
	 */
	public DepofficeImpl insert(DepofficeImpl depOfficeImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param depOffice
	 * @return
	 * @throws PmException
	 */
	public int delete(DepofficeImpl depOfficeImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param depOffice
	 * @return
	 * @throws PmException
	 */
	public boolean update(DepofficeImpl depOfficeImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param depOffice
	 * @return
	 * @throws PmException
	 */
	public DataGrid<DepofficeImpl> select(DepofficeImpl depOfficeImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param depOffice
	 * @return
	 * @throws PmException
	 */
	public DepofficeImpl get(DepofficeImpl depOfficeImpl) throws PmException;

}