package com.mtf.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.report.core.A.e;
import com.mtf.framework.dao.OrderServiceDetailMapper;
import com.mtf.framework.dao.OrderServiceMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.OrderService;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.OrderServiceDetailImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.service.OrderServiceDetailService;
import com.mtf.framework.service.OrderServiceService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤配置
 * 作者:     Auto
 * 日期:     2015/10/26
**********************************************
*/
@Service("orderServiceDetailService")
public class OrderServiceDetailServiceImpl extends CommonServiceImpl implements OrderServiceDetailService {
	@Autowired
	private OrderServiceDetailMapper orderServiceDetailMapper;
	
	@Autowired
	private OrderServiceMapper orderServiceMapper;
	
	@Autowired
	private OrderServiceService orderServiceService;

	@Autowired
	public OrderServiceService getOrderServiceService() {
		return orderServiceService;
	}

	@Autowired
	public void setOrderServiceService(OrderServiceService orderServiceService) {
		this.orderServiceService = orderServiceService;
	}

	@Autowired
	public OrderServiceMapper getOrderServiceMapper() {
		return orderServiceMapper;
	}

	@Autowired
	public void setOrderServiceMapper(OrderServiceMapper orderServiceMapper) {
		this.orderServiceMapper = orderServiceMapper;
	}

	@Autowired
	public OrderServiceDetailMapper getOrderServiceDetailMapper() {
		return orderServiceDetailMapper;
	}

	@Autowired
	public void setOrderServiceDetailMapper(OrderServiceDetailMapper orderServiceDetailMapper) {
		this.orderServiceDetailMapper = orderServiceDetailMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderServiceDetail
	 */
	public OrderServiceDetailImpl insert(OrderServiceDetailImpl orderServiceDetail) throws PmException {
		this.orderServiceDetailMapper.insert(orderServiceDetail);
		return orderServiceDetail;
	}

	/**
	 * 删除实体对象
	 * @param orderServiceDetail
	 */
	public int delete(OrderServiceDetailImpl orderServiceDetail) throws PmException {
		return this.orderServiceDetailMapper.delete(orderServiceDetail);
	}

	/**
	 * 更新实体对象
	 * @param orderServiceDetail
	 */
	public boolean update(OrderServiceDetailImpl orderServiceDetail) throws PmException {
		String editState = orderServiceDetail.getEditState();
		/*boolean result = true;
		Long idOrderService = orderServiceDetail.getIdOrderService();
		OrderServiceImpl orderService = new OrderServiceImpl();
		orderService.setVehiclePlateNo(orderServiceDetail.getVehiclePlateNo());
		orderService.setDriverId(orderServiceDetail.getDriverId());
		orderService.setDeptRequester(orderServiceDetail.getDeptRequester());
		orderService.setTimeTrip(orderServiceDetail.getTimeTrip());
		orderService.setTypeExpense(orderServiceDetail.getTypeExpense());
		orderService.setIdOrderServicePath(orderServiceDetail.getIdOrderService());
		orderService.setPassenger(orderServiceDetail.getPassenger());
		orderService.setExpenseActual(orderServiceDetail.getExpenseActual());
		if (null == idOrderService) {
			// 插入主表数据
			orderServiceMapper.insert(orderService);
			idOrderService = orderService.getId();
			orderServiceDetail.setIdOrderService(idOrderService);
			this.orderServiceDetailMapper.insert(orderServiceDetail);
		} else {
			orderServiceMapper.update(orderService);
			this.orderServiceDetailMapper.update(orderServiceDetail);
		}*/
		Long idOrderService = orderServiceDetail.getIdOrderService();
		boolean result = true;
		if ("i".equals(editState)) {
			this.orderServiceDetailMapper.insert(orderServiceDetail);
		} else if("u".equals(editState)) {
			this.orderServiceDetailMapper.update(orderServiceDetail);
		} else if ("d".equals(editState)) {
			this.orderServiceDetailMapper.delete(orderServiceDetail);
			
		}
		// 计算公里数
		Double mileageTotal = 0.00;
		Double mileage = 0.00;
		orderServiceDetail = new OrderServiceDetailImpl();
		orderServiceDetail.setIdOrderService(idOrderService);
		List<OrderServiceDetailImpl> listOrderSeriveDetail = (List<OrderServiceDetailImpl>) orderServiceDetailMapper.select(orderServiceDetail);
		if (null != listOrderSeriveDetail && listOrderSeriveDetail.size() > 0) {
			for (int i = 0; i < listOrderSeriveDetail.size(); i++) {
				mileage = listOrderSeriveDetail.get(i).getMileageDeparture();
				if (null != mileage && !"".equals(mileage)) {
					mileageTotal += mileage;
				}
			}
	
		}
		OrderServiceImpl orderService = new OrderServiceImpl();
		orderService.setId(idOrderService);
		orderService = orderServiceService.get(orderService);
		orderService.setMileage(mileageTotal);
		orderServiceService.calcuteOrderService(orderService);
		orderServiceMapper.update(orderService);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderServiceDetail
	 */
	@SuppressWarnings("unchecked")
	public List<OrderServiceDetailImpl> select(OrderServiceDetailImpl orderServiceDetail) throws PmException {
		return (List<OrderServiceDetailImpl>) this.orderServiceDetailMapper.select(orderServiceDetail);
	}
	/**
	 * 查询单个实体
	 * @param orderServiceDetail
	 */
	public OrderServiceDetailImpl get(OrderServiceDetailImpl orderServiceDetail) throws PmException {
		return (OrderServiceDetailImpl) this.orderServiceDetailMapper.get(orderServiceDetail);
	}
	/**
	 * 查询实体分页列表
	 * @param orderServiceDetail
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderServiceDetailImpl> search(OrderServiceDetailImpl orderServiceDetail) throws PmException {
		DataGrid<OrderServiceDetailImpl> grid = new DataGrid<OrderServiceDetailImpl>();
		Object obj = orderServiceDetail;
		List list = orderServiceDetailMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderServiceDetailMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

}