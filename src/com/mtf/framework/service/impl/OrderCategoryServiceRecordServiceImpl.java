package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderCategoryServiceRecordMapper;
import com.mtf.framework.model.impl.OrderCategoryServiceRecordImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderCategoryServiceRecordService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 报销审批记录
 * 作者:     Auto
 * 日期:     2017/10/18
**********************************************
*/
@Service("orderCategoryServiceRecordService")
public class OrderCategoryServiceRecordServiceImpl extends CommonServiceImpl implements OrderCategoryServiceRecordService {
	@Autowired
	private OrderCategoryServiceRecordMapper orderCategoryServiceRecordMapper;

	@Autowired
	public OrderCategoryServiceRecordMapper getOrderCategoryServiceRecordMapper() {
		return orderCategoryServiceRecordMapper;
	}

	@Autowired
	public void setOrderCategoryServiceRecordMapper(OrderCategoryServiceRecordMapper orderCategoryServiceRecordMapper) {
		this.orderCategoryServiceRecordMapper = orderCategoryServiceRecordMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderCategoryServiceRecord
	 */
	public OrderCategoryServiceRecordImpl insert(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException {
		this.orderCategoryServiceRecordMapper.insert(orderCategoryServiceRecord);
		return orderCategoryServiceRecord;
	}

	/**
	 * 删除实体对象
	 * @param orderCategoryServiceRecord
	 */
	public int delete(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException {
		return this.orderCategoryServiceRecordMapper.delete(orderCategoryServiceRecord);
	}

	/**
	 * 更新实体对象
	 * @param orderCategoryServiceRecord
	 */
	public boolean update(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException {
		boolean result = true;
		this.orderCategoryServiceRecordMapper.update(orderCategoryServiceRecord);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderCategoryServiceRecord
	 */
	@SuppressWarnings("unchecked")
	public List<OrderCategoryServiceRecordImpl> select(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException {
		return (List<OrderCategoryServiceRecordImpl>) this.orderCategoryServiceRecordMapper.select(orderCategoryServiceRecord);
	}
	/**
	 * 查询单个实体
	 * @param orderCategoryServiceRecord
	 */
	public OrderCategoryServiceRecordImpl get(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException {
		return (OrderCategoryServiceRecordImpl) this.orderCategoryServiceRecordMapper.get(orderCategoryServiceRecord);
	}
	/**
	 * 查询实体分页列表
	 * @param orderCategoryServiceRecord
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderCategoryServiceRecordImpl> search(OrderCategoryServiceRecordImpl orderCategoryServiceRecord) throws PmException {
		DataGrid<OrderCategoryServiceRecordImpl> grid = new DataGrid<OrderCategoryServiceRecordImpl>();
		Object obj = orderCategoryServiceRecord;
		List list = orderCategoryServiceRecordMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderCategoryServiceRecordMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}