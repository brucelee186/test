package com.mtf.framework.service;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.ItemImpl;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.model.Item;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 办公用品明细
 * 作者:     Auto
 * 日期:     2013-12-12
**********************************************
*/
public interface ItemService {
	/**
	 * 新增实体对象
	 * @param item
	 * @return
	 * @throws PmException
	 */
	public ItemImpl insert(ItemImpl itemImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param item
	 * @return
	 * @throws PmException
	 */
	public int delete(ItemImpl itemImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param item
	 * @return
	 * @throws PmException
	 */
	public boolean update(String[] ruleId,String[] amount,ItemImpl itemImpl,HttpSession session) throws PmException;

	/**
	 * 查询实体数量
	 * @param item
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ItemImpl> select(ItemImpl item) throws PmException;

	/**
	 * 取得单一对象
	 * @param item
	 * @return
	 * @throws PmException
	 */
	public ItemImpl get(ItemImpl itemImpl) throws PmException;
	
	/**
	 * 
	 */
	public void insertItemRule(String[] ruleId,String[] amount,OfficeImpl officeImpl,HttpSession session) throws PmException;


}