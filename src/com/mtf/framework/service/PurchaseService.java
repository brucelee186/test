package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.PurchaseItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.PurchaseItemImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 采购表
 * 作者:     Auto
 * 日期:     2015/3/5
**********************************************
*/
public interface PurchaseService {
	
	/**
	 * 获得item
	 * @param purchase
	 * @return
	 * @throws PmException
	 */
	public PurchaseImpl get(PurchaseImpl purchase) throws PmException;
	
	/**
	 * 添加item
	 * @param purchase
	 * @param itemList
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public PurchaseImpl insert(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException;
	
	/**
	 * 插入估价item
	 * @param purchase
	 * @param itemList
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public PurchaseImpl insertForQuote(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException;
	
	/**
	 * 编辑item
	 * @param purchase
	 * @param itemList
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public PurchaseImpl update(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException;
	
	/**
	 * 编辑估计item
	 * @param purchase
	 * @param itemList
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public PurchaseImpl updateForQuote(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException;
	
	/**
	 * 编辑多条item quoteAmount
	 * @param purchase
	 * @param itemList
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public PurchaseImpl updateQuoteAmount(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException;
	

	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateForStatus(PurchaseImpl purchase, HttpSession session) throws PmException;
	
	/**
	 * 批量更新实体对象的状态
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateBatchForStatus(PurchaseImpl purchase, List<String> ids, HttpSession session) throws PmException;
	
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param comment
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateForStatusLv1(PurchaseImpl purchase, String comment, HttpSession session) throws PmException;
	
	/**
	 * 批量更新实体对象的状态
	 * @param ids
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateBatchForStatusLv1(List<String> ids, HttpSession session) throws PmException;
	
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param comment
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateForStatusLv2(PurchaseImpl purchase, String comment, HttpSession session) throws PmException;
	
	/**
	 * 批量更新实体对象的状态
	 * @param ids
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateBatchForStatusLv2(List<String> ids, HttpSession session) throws PmException;
	
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param comment
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateForStatusReject(PurchaseImpl purchase, String comment, HttpSession session) throws PmException;
	

	/**
	 * 查询实体列表
	 * @param purchase
	 * @return
	 * @throws PmException
	 */
	public List<PurchaseImpl> select(PurchaseImpl purchase) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PurchaseImpl> selectWithItem(PurchaseImpl purchase, String statuses, HttpSession session) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param purchase
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PurchaseImpl> selectForMyWatch(PurchaseImpl purchase, String statuses, HttpSession session) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param purchase
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PurchaseImpl> selectForReport(PurchaseImpl purchase, String categoryIds, String applicantdivisionIds, HttpSession session) throws PmException;
	
	/**
	 * 新增实体对象
	 * @param purchaseWatcher
	 * @return
	 * @throws PmException
	 */
	public void insert(List<String> idsList, HttpSession sesssion) throws PmException;

	/**
	 * 删除实体对象
	 * @param purchaseWatcher
	 * @param idsList
	 * @return
	 * @throws PmException
	 */
	public void delete(List<String> idsList) throws PmException;
	
	//public void addMail(Mail mail) throws PmException;
	
	List<PurchaseImpl> selectForApplicantReport(PurchaseImpl purchase) throws PmException;
	
	List<PurchaseImpl> selectForCustomerReport(PurchaseImpl purchase) throws PmException;

}