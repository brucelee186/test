package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderCategoryRuleMapper;
import com.mtf.framework.model.impl.OrderCategoryRuleImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderCategoryRuleService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 授权规则表 
 * 作者:     Auto
 * 日期:     2016/6/15
**********************************************
*/
@Service("orderCategoryRuleService")
public class OrderCategoryRuleServiceImpl extends CommonServiceImpl implements OrderCategoryRuleService {
	@Autowired
	private OrderCategoryRuleMapper orderCategoryRuleMapper;

	@Autowired
	public OrderCategoryRuleMapper getOrderCategoryRuleMapper() {
		return orderCategoryRuleMapper;
	}

	@Autowired
	public void setOrderCategoryRuleMapper(OrderCategoryRuleMapper orderCategoryRuleMapper) {
		this.orderCategoryRuleMapper = orderCategoryRuleMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderCategoryRule
	 */
	public OrderCategoryRuleImpl insert(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		this.orderCategoryRuleMapper.insert(orderCategoryRule);
		return orderCategoryRule;
	}

	/**
	 * 删除实体对象
	 * @param orderCategoryRule
	 */
	public int delete(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		return this.orderCategoryRuleMapper.delete(orderCategoryRule);
	}

	/**
	 * 更新实体对象
	 * @param orderCategoryRule
	 */
	public boolean update(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		boolean result = true;
		Long idMain = orderCategoryRule.getId();
		if (null == idMain) {
			this.orderCategoryRuleMapper.insert(orderCategoryRule);
			
		}
		else {
			this.orderCategoryRuleMapper.update(orderCategoryRule);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderCategoryRule
	 */
	@SuppressWarnings("unchecked")
	public List<OrderCategoryRuleImpl> select(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		return (List<OrderCategoryRuleImpl>) this.orderCategoryRuleMapper.select(orderCategoryRule);
	}
	/**
	 * 查询单个实体
	 * @param orderCategoryRule
	 */
	public OrderCategoryRuleImpl get(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		return (OrderCategoryRuleImpl) this.orderCategoryRuleMapper.get(orderCategoryRule);
	}
	/**
	 * 查询实体分页列表
	 * @param orderCategoryRule
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderCategoryRuleImpl> search(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		DataGrid<OrderCategoryRuleImpl> grid = new DataGrid<OrderCategoryRuleImpl>();
		Object obj = orderCategoryRule;
		List list = orderCategoryRuleMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderCategoryRuleMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}