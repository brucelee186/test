package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderCategoryMapper;
import com.mtf.framework.model.impl.OrderCategoryImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderCategoryService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 分类科目表
 * 作者:     Auto
 * 日期:     2016/5/23
**********************************************
*/
@Service("orderCategoryService")
public class OrderCategoryServiceImpl extends CommonServiceImpl implements OrderCategoryService {
	@Autowired
	private OrderCategoryMapper orderCategoryMapper;

	@Autowired
	public OrderCategoryMapper getOrderCategoryMapper() {
		return orderCategoryMapper;
	}

	@Autowired
	public void setOrderCategoryMapper(OrderCategoryMapper orderCategoryMapper) {
		this.orderCategoryMapper = orderCategoryMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderCategory
	 */
	public OrderCategoryImpl insert(OrderCategoryImpl orderCategory) throws PmException {
		Long pid = orderCategory.getPid();
		Integer level = 2;
		if (null == pid) {
			level = 1;
		}
		orderCategory.setLevel(level);
		this.orderCategoryMapper.insert(orderCategory);
		return orderCategory;
	}

	/**
	 * 删除实体对象
	 * @param orderCategory
	 */
	public int delete(OrderCategoryImpl orderCategory) throws PmException {
		return this.orderCategoryMapper.delete(orderCategory);
	}

	/**
	 * 更新实体对象
	 * @param orderCategory
	 */
	public boolean update(OrderCategoryImpl orderCategory) throws PmException {
		boolean result = true;
		Long pid = orderCategory.getPid();
		Integer level = 2;
		if (null == pid) {
			level = 1;
		}
		orderCategory.setLevel(level);
		this.orderCategoryMapper.update(orderCategory);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderCategory
	 */
	@SuppressWarnings("unchecked")
	public List<OrderCategoryImpl> select(OrderCategoryImpl orderCategory) throws PmException {
		List<OrderCategoryImpl> listRes = (List<OrderCategoryImpl>) this.orderCategoryMapper.select(orderCategory);
		return listRes;
	}
	/**
	 * 查询单个实体
	 * @param orderCategory
	 */
	public OrderCategoryImpl get(OrderCategoryImpl orderCategory) throws PmException {
		return (OrderCategoryImpl) this.orderCategoryMapper.get(orderCategory);
	}
	/**
	 * 查询实体分页列表
	 * @param orderCategory
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderCategoryImpl> search(OrderCategoryImpl orderCategory) throws PmException {
		DataGrid<OrderCategoryImpl> grid = new DataGrid<OrderCategoryImpl>();
		Object obj = orderCategory;
		List list = orderCategoryMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderCategoryMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}