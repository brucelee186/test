package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.CurrencyImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 货币
 * 作者:     Auto
 * 日期:     2015/5/27
**********************************************
*/
public interface CurrencyService {
	/**
	 * 新增实体对象
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	public CurrencyImpl insert(CurrencyImpl currency, HttpSession session) throws PmException;

	/**
	 * 删除实体对象
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	public int delete(CurrencyImpl currency) throws PmException;

	/**
	 * 更新实体对象
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	public boolean update(CurrencyImpl currency, HttpSession session) throws PmException;

	/**
	 * 查询实体列表
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	public List<CurrencyImpl> select(CurrencyImpl currency) throws PmException;

	/**
	 * 取得单一对象
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	public CurrencyImpl get(CurrencyImpl currency) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	public DataGrid<CurrencyImpl> search(CurrencyImpl currency) throws PmException;

}