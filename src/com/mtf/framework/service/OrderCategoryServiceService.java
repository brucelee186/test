package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 科目申请服务
 * 作者:     Auto
 * 日期:     2016/6/22
**********************************************
*/
public interface OrderCategoryServiceService {
	/**
	 * 新增实体对象
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryServiceImpl insert(OrderCategoryServiceImpl orderCategoryService) throws PmException;

	/**
	 * 删除实体对象
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public int delete(OrderCategoryServiceImpl orderCategoryService) throws PmException;

	/**
	 * 更新实体对象
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public boolean update(OrderCategoryServiceImpl orderCategoryService) throws PmException;

	/**
	 * 查询实体列表
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public List<OrderCategoryServiceImpl> select(OrderCategoryServiceImpl orderCategoryService) throws PmException;

	/**
	 * 取得单一对象
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryServiceImpl get(OrderCategoryServiceImpl orderCategoryService) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderCategoryServiceImpl> search(OrderCategoryServiceImpl orderCategoryService) throws PmException;
	
	/**
	 * 查询实体分页列表
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderCategoryServiceImpl> searchJson(OrderCategoryServiceImpl orderCategoryService) throws PmException;

}