package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ItemruleImpl;
import com.mtf.framework.model.Itemrule;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 办公用品领取规则
 * 作者:     Auto
 * 日期:     2013/12/12
**********************************************
*/
public interface ItemruleService {
	/**
	 * 新增实体对象
	 * @param itemRule
	 * @return
	 * @throws PmException
	 */
	public ItemruleImpl insert(ItemruleImpl itemRuleImpl ) throws PmException;

	/**
	 * 删除实体对象
	 * @param itemRule
	 * @return
	 * @throws PmException
	 */
	public int delete(ItemruleImpl itemRuleImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param itemRule
	 * @return
	 * @throws PmException
	 */
	public boolean update(ItemruleImpl itemRuleImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param itemRule
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ItemruleImpl> select(ItemruleImpl itemRuleImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param itemRule
	 * @return
	 * @throws PmException
	 */
	public ItemruleImpl get(ItemruleImpl itemRuleImpl) throws PmException;
	
	/**
	 * 查询实体数量
	 * @param itemRule
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ItemruleImpl> selectByName(ItemruleImpl itemRuleImpl) throws PmException;

}