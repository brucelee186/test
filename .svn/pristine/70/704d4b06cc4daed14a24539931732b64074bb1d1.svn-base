package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.PaymentImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 合同
 * 作者:     Auto
 * 日期:     2013/10/14
**********************************************
*/
public interface PaymentService {
	/**
	 * 新增实体对象
	 * @param payment
	 * @return
	 * @throws PmException
	 */
	public PaymentImpl insert(PaymentImpl paymentImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param paymentImpl
	 * @return
	 * @throws PmException
	 */
	public int delete(PaymentImpl paymentImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param paymentImpl
	 * @return
	 * @throws PmException
	 */
	public boolean update(PaymentImpl paymentImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param paymentImpl
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PaymentImpl> select(PaymentImpl paymentImpl) throws PmException;
	
	/**
	 * 查询实体数量
	 * @param paymentImpl
	 * @return
	 * @throws PmException
	 */
	public DataGrid<PaymentImpl> selectItem(PaymentImpl paymentImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param paymentImpl
	 * @return
	 * @throws PmException
	 */
	public PaymentImpl get(PaymentImpl paymentImpl) throws PmException;
	
	public List<PaymentImpl> selectList(PaymentImpl paymentImpl) throws PmException;

}