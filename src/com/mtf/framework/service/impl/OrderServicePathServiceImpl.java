package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderServicePathMapper;
import com.mtf.framework.model.impl.OrderServicePathImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderServicePathService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤配置
 * 作者:     Auto
 * 日期:     2015/10/28
**********************************************
*/
@Service("orderServicePathService")
public class OrderServicePathServiceImpl extends CommonServiceImpl implements OrderServicePathService {
	@Autowired
	private OrderServicePathMapper orderServicePathMapper;

	@Autowired
	public OrderServicePathMapper getOrderServicePathMapper() {
		return orderServicePathMapper;
	}

	@Autowired
	public void setOrderServicePathMapper(OrderServicePathMapper orderServicePathMapper) {
		this.orderServicePathMapper = orderServicePathMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderServicePath
	 */
	public OrderServicePathImpl insert(OrderServicePathImpl orderServicePath) throws PmException {
		this.orderServicePathMapper.insert(orderServicePath);
		return orderServicePath;
	}

	/**
	 * 删除实体对象
	 * @param orderServicePath
	 */
	public int delete(OrderServicePathImpl orderServicePath) throws PmException {
		return this.orderServicePathMapper.delete(orderServicePath);
	}

	/**
	 * 更新实体对象
	 * @param orderServicePath
	 */
	public boolean update(OrderServicePathImpl orderServicePath) throws PmException {
		boolean result = true;
		String idString = orderServicePath.getIdString();
		if (null == idString) {
			this.orderServicePathMapper.insert(orderServicePath);
		} else {
			Long id = Long.valueOf(idString);
			orderServicePath.setId(id);
			this.orderServicePathMapper.update(orderServicePath);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderServicePath
	 */
	@SuppressWarnings("unchecked")
	public List<OrderServicePathImpl> select(OrderServicePathImpl orderServicePath) throws PmException {
		return (List<OrderServicePathImpl>) this.orderServicePathMapper.select(orderServicePath);
	}
	/**
	 * 查询单个实体
	 * @param orderServicePath
	 */
	public OrderServicePathImpl get(OrderServicePathImpl orderServicePath) throws PmException {
		return (OrderServicePathImpl) this.orderServicePathMapper.get(orderServicePath);
	}
	/**
	 * 查询实体分页列表
	 * @param orderServicePath
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderServicePathImpl> search(OrderServicePathImpl orderServicePath) throws PmException {
		DataGrid<OrderServicePathImpl> grid = new DataGrid<OrderServicePathImpl>();
		Object obj = orderServicePath;
		List list = orderServicePathMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderServicePathMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}