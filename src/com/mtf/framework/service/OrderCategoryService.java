package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderCategoryImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 分类科目表
 * 作者:     Auto
 * 日期:     2016/5/23
**********************************************
*/
public interface OrderCategoryService {
	/**
	 * 新增实体对象
	 * @param orderCategory
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryImpl insert(OrderCategoryImpl orderCategory) throws PmException;

	/**
	 * 删除实体对象
	 * @param orderCategory
	 * @return
	 * @throws PmException
	 */
	public int delete(OrderCategoryImpl orderCategory) throws PmException;

	/**
	 * 更新实体对象
	 * @param orderCategory
	 * @return
	 * @throws PmException
	 */
	public boolean update(OrderCategoryImpl orderCategory) throws PmException;

	/**
	 * 查询实体列表
	 * @param orderCategory
	 * @return
	 * @throws PmException
	 */
	public List<OrderCategoryImpl> select(OrderCategoryImpl orderCategory) throws PmException;

	/**
	 * 取得单一对象
	 * @param orderCategory
	 * @return
	 * @throws PmException
	 */
	public OrderCategoryImpl get(OrderCategoryImpl orderCategory) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param orderCategory
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderCategoryImpl> search(OrderCategoryImpl orderCategory) throws PmException;

}