package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.PurchaseItemImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 采购子列表
 * 作者:     Auto
 * 日期:     2015/3/5
**********************************************
*/
public interface PurchaseItemService {
	/**
	 * 新增实体对象
	 * @param purchaseItem
	 * @return
	 * @throws PmException
	 */
	public PurchaseItemImpl insert(PurchaseItemImpl purchaseItem, HttpSession session) throws PmException;

	/**
	 * 查询实体列表
	 * @param purchaseItem
	 * @return
	 * @throws PmException
	 */
	public List<PurchaseItemImpl> select(PurchaseItemImpl purchaseItem) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param purchaseItem
	 * @return
	 * @throws PmException
	 */
	public List<PurchaseItemImpl> selectWithPurchase(PurchaseItemImpl purchaseItem, String no, HttpSession session) throws PmException;


	/**
	 * 查询实体分页列表
	 * @param purchaseItem
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PurchaseItemImpl> search(PurchaseItemImpl purchaseItem) throws PmException;

}