package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderServiceImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 考勤配置
 * 作者:     Auto
 * 日期:     2015/10/21
**********************************************
*/
public interface OrderServiceService {
	/**
	 * 新增实体对象
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public OrderServiceImpl insert(OrderServiceImpl orderService) throws PmException;

	/**
	 * 删除实体对象
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public int delete(OrderServiceImpl orderService) throws PmException;

	/**
	 * 更新实体对象
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public boolean update(OrderServiceImpl orderService) throws PmException;

	/**
	 * 查询实体列表
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public List<OrderServiceImpl> select(OrderServiceImpl orderService) throws PmException;
	public void select() throws PmException;

	/**
	 * 取得单一对象
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public OrderServiceImpl get(OrderServiceImpl orderService) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OrderServiceImpl> search(OrderServiceImpl orderService) throws PmException;
	
	/**
	 * 按公里数计算费用
	 * @param orderService
	 * @return
	 * @throws PmException
	 */
	public OrderServiceImpl calcuteOrderService(OrderServiceImpl orderService) throws PmException;

}