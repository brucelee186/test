
package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.ReimbursementImpl;
import com.mtf.framework.model.impl.ReimbursementItemImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 报销表
 * 作者:     Auto
 * 日期:     2015/3/16
**********************************************
*/
public interface ReimbursementService {
	/**
	 * 新增实体对象
	 * @param reimbursement
	 * @return
	 * @throws PmException
	 */
	public ReimbursementImpl insert(ReimbursementImpl reimbursement, List<ReimbursementItemImpl> itemList, HttpSession session) throws PmException;


	/**
	 * 编辑reimbursement及其item
	 * @param reimbursement
	 * @param itemList
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public ReimbursementImpl update(ReimbursementImpl reimbursement, List<ReimbursementItemImpl> itemList, HttpSession session) throws PmException;
	
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateStatusForSubmit(ReimbursementImpl reimbursement, HttpSession session) throws PmException;
	
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateStatusForDelete(ReimbursementImpl reimbursement, HttpSession session) throws PmException;
	
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateStatusForReject(ReimbursementImpl reimbursement, HttpSession session) throws PmException;
	
	/**
	 * 批量更新实体对象的状态
	 * @param ids
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateBatchStatusForReject(List<String> ids, HttpSession session) throws PmException;
	/**
	 * 更新实体对象的状态
	 * @param purchase
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public boolean updateForAudit(ReimbursementImpl reimbursement, List<String> idsList, HttpSession session) throws PmException;

	/**
	 * 取得单一对象
	 * @param reimbursement
	 * @return
	 * @throws PmException
	 */
	public ReimbursementImpl get(ReimbursementImpl reimbursement) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param reimbursement
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ReimbursementImpl> selectWithItem(ReimbursementImpl reimbursement,String statuses, HttpSession session) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param reimbursement
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ReimbursementImpl> selectForReport(ReimbursementImpl reimbursement, String categoryIds, String applicantDivisionIds, HttpSession session) throws PmException;
	
	
	List<ReimbursementImpl> selectForCustomerReport(ReimbursementImpl reimbursement) throws PmException;
	
	
	List<ReimbursementImpl> selectForDivisionReport(ReimbursementImpl reimbursement) throws PmException;
	
	
	List<ReimbursementImpl> selectForDetail(ReimbursementImpl reimbursement) throws PmException;
	
	
}