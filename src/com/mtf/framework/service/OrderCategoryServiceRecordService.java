package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderCategoryServiceRecordImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 报销审批记录
 * 作者:     Auto
 * 日期:     2017/10/18
**********************************************
*/
public interface OrderCategoryServiceRecordService {
	/**
	 * 新增实体对象
	 * @param orderCategoryServiceRecord
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryServiceRecordImpl insert(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException;

	/**
	 * 删除实体对象
	 * @param orderCategoryServiceRecord
	 * @return
	 * @throws PmException
	 */
	public int delete(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException;

	/**
	 * 更新实体对象
	 * @param orderCategoryServiceRecord
	 * @return
	 * @throws PmException
	 */
	public boolean update(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException;

	/**
	 * 查询实体列表
	 * @param orderCategoryServiceRecord
	 * @return
	 * @throws PmException
	 */
	public List<OrderCategoryServiceRecordImpl> select(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException;

	/**
	 * 取得单一对象
	 * @param orderCategoryServiceRecord
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryServiceRecordImpl get(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param orderCategoryServiceRecord
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderCategoryServiceRecordImpl> search(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException;

}