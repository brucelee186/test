package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 科目申请服务
 * 作者:     Auto
 * 日期:     2016/6/22
**********************************************
*/
public interface OrderCategoryServiceDetailService {
	/**
	 * 新增实体对象
	 * @param orderCategoryServiceDetail
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryServiceDetailImpl insert(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException;

	/**
	 * 删除实体对象
	 * @param orderCategoryServiceDetail
	 * @return
	 * @throws PmException
	 */
	public int delete(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException;

	/**
	 * 更新实体对象
	 * @param orderCategoryServiceDetail
	 * @return
	 * @throws PmException
	 */
	public boolean update(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException;

	/**
	 * 查询实体列表
	 * @param orderCategoryServiceDetail
	 * @return
	 * @throws PmException
	 */
	public List<OrderCategoryServiceDetailImpl> select(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException;

	/**
	 * 取得单一对象
	 * @param orderCategoryServiceDetail
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryServiceDetailImpl get(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param orderCategoryServiceDetail
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderCategoryServiceDetailImpl> search(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException;

}