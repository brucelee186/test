package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderReimbursementMapper;
import com.mtf.framework.model.impl.OrderReimbursementImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderReimbursementService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 申请报销
 * 作者:     Auto
 * 日期:     2016/6/20
**********************************************
*/
@Service("orderReimbursementService")
public class OrderReimbursementServiceImpl extends CommonServiceImpl implements OrderReimbursementService {
	@Autowired
	private OrderReimbursementMapper orderReimbursementMapper;

	@Autowired
	public OrderReimbursementMapper getOrderReimbursementMapper() {
		return orderReimbursementMapper;
	}

	@Autowired
	public void setOrderReimbursementMapper(OrderReimbursementMapper orderReimbursementMapper) {
		this.orderReimbursementMapper = orderReimbursementMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderReimbursement
	 */
	public OrderReimbursementImpl insert(OrderReimbursementImpl orderReimbursement) throws PmException {
		this.orderReimbursementMapper.insert(orderReimbursement);
		return orderReimbursement;
	}

	/**
	 * 删除实体对象
	 * @param orderReimbursement
	 */
	public int delete(OrderReimbursementImpl orderReimbursement) throws PmException {
		return this.orderReimbursementMapper.delete(orderReimbursement);
	}

	/**
	 * 更新实体对象
	 * @param orderReimbursement
	 */
	public boolean update(OrderReimbursementImpl orderReimbursement) throws PmException {
		boolean result = true;
		this.orderReimbursementMapper.update(orderReimbursement);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderReimbursement
	 */
	@SuppressWarnings("unchecked")
	public List<OrderReimbursementImpl> select(OrderReimbursementImpl orderReimbursement) throws PmException {
		return (List<OrderReimbursementImpl>) this.orderReimbursementMapper.select(orderReimbursement);
	}
	/**
	 * 查询单个实体
	 * @param orderReimbursement
	 */
	public OrderReimbursementImpl get(OrderReimbursementImpl orderReimbursement) throws PmException {
		return (OrderReimbursementImpl) this.orderReimbursementMapper.get(orderReimbursement);
	}
	/**
	 * 查询实体分页列表
	 * @param orderReimbursement
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderReimbursementImpl> search(OrderReimbursementImpl orderReimbursement) throws PmException {
		DataGrid<OrderReimbursementImpl> grid = new DataGrid<OrderReimbursementImpl>();
		Object obj = orderReimbursement;
		List list = orderReimbursementMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderReimbursementMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}