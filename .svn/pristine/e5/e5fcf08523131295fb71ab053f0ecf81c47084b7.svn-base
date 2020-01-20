package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderCategoryServiceDetailMapper;
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderCategoryServiceDetailService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 科目申请服务
 * 作者:     Auto
 * 日期:     2016/6/22
**********************************************
*/
@Service("orderCategoryServiceDetailService")
public class OrderCategoryServiceDetailServiceImpl extends CommonServiceImpl implements OrderCategoryServiceDetailService {
	@Autowired
	private OrderCategoryServiceDetailMapper orderCategoryServiceDetailMapper;

	@Autowired
	public OrderCategoryServiceDetailMapper getOrderCategoryServiceDetailMapper() {
		return orderCategoryServiceDetailMapper;
	}

	@Autowired
	public void setOrderCategoryServiceDetailMapper(OrderCategoryServiceDetailMapper orderCategoryServiceDetailMapper) {
		this.orderCategoryServiceDetailMapper = orderCategoryServiceDetailMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderCategoryServiceDetail
	 */
	public OrderCategoryServiceDetailImpl insert(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException {
		this.orderCategoryServiceDetailMapper.insert(orderCategoryServiceDetail);
		return orderCategoryServiceDetail;
	}

	/**
	 * 删除实体对象
	 * @param orderCategoryServiceDetail
	 */
	public int delete(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException {
		return this.orderCategoryServiceDetailMapper.delete(orderCategoryServiceDetail);
	}

	/**
	 * 更新实体对象
	 * @param orderCategoryServiceDetail
	 */
	public boolean update(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException {
		boolean result = true;
		this.orderCategoryServiceDetailMapper.update(orderCategoryServiceDetail);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderCategoryServiceDetail
	 */
	@SuppressWarnings("unchecked")
	public List<OrderCategoryServiceDetailImpl> select(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException {
		return (List<OrderCategoryServiceDetailImpl>) this.orderCategoryServiceDetailMapper.select(orderCategoryServiceDetail);
	}
	/**
	 * 查询单个实体
	 * @param orderCategoryServiceDetail
	 */
	public OrderCategoryServiceDetailImpl get(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException {
		return (OrderCategoryServiceDetailImpl) this.orderCategoryServiceDetailMapper.get(orderCategoryServiceDetail);
	}
	/**
	 * 查询实体分页列表
	 * @param orderCategoryServiceDetail
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderCategoryServiceDetailImpl> search(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws PmException {
		DataGrid<OrderCategoryServiceDetailImpl> grid = new DataGrid<OrderCategoryServiceDetailImpl>();
		Object obj = orderCategoryServiceDetail;
		List list = orderCategoryServiceDetailMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderCategoryServiceDetailMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}