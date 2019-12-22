package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.model.impl.OrderServiceRecordImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 考勤审批记录
 * 作者:     Auto
 * 日期:     2015/11/30
**********************************************
*/
public interface OrderServiceRecordService {
	/**
	 * 新增实体对象
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public OrderServiceRecordImpl insert(OrderServiceRecordImpl orderServiceRecord) throws PmException;

	/**
	 * 删除实体对象
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public int delete(OrderServiceRecordImpl orderServiceRecord) throws PmException;

	/**
	 * 更新实体对象
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public boolean update(OrderServiceRecordImpl orderServiceRecord) throws PmException;

	/**
	 * 查询实体列表
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public List<OrderServiceRecordImpl> select(OrderServiceRecordImpl orderServiceRecord) throws PmException;
	
	/**
	 * 查询生成报销单
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public List<OrderServiceImpl> selectOrderServiceRecordForReimburse(OrderServiceRecordImpl orderServiceRecord) throws PmException;
	
	/**
	 * 查询生成报销单
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public List<OrderServiceImpl> selectOrderServiceRecordForDriver(OrderServiceRecordImpl orderServiceRecord) throws PmException;

	/**
	 * 取得单一对象
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public OrderServiceRecordImpl get(OrderServiceRecordImpl orderServiceRecord) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderServiceRecordImpl> search(OrderServiceRecordImpl orderServiceRecord) throws PmException;

}