package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.OrderCategoryServiceMapper;
import com.mtf.framework.dao.OrderServiceMapper;
import com.mtf.framework.dao.OrderServiceRecordConditionMapper;
import com.mtf.framework.dao.OrderServiceRecordMapper;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.model.impl.OrderServiceRecordImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OrderServiceRecordService;
import com.mtf.framework.service.OrderServiceService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤审批记录
 * 作者:     Auto
 * 日期:     2015/11/30
**********************************************
*/
@Service("orderServiceRecordService")
public class OrderServiceRecordServiceImpl extends CommonServiceImpl implements OrderServiceRecordService {
	@Autowired
	private OrderServiceRecordMapper orderServiceRecordMapper;
	
	@Autowired
	private OrderServiceMapper orderServiceMapper;
	
	@Autowired
	private OrderServiceRecordConditionMapper orderServiceRecordConditionMapper;
	
	@Autowired
	private OrderCategoryServiceMapper orderCategoryServiceMapper;

	public OrderCategoryServiceMapper getOrderCategoryServiceMapper() {
		return orderCategoryServiceMapper;
	}

	public void setOrderCategoryServiceMapper(
			OrderCategoryServiceMapper orderCategoryServiceMapper) {
		this.orderCategoryServiceMapper = orderCategoryServiceMapper;
	}

	public OrderServiceRecordConditionMapper getOrderServiceRecordConditionMapper() {
		return orderServiceRecordConditionMapper;
	}

	public void setOrderServiceRecordConditionMapper(
			OrderServiceRecordConditionMapper orderServiceRecordConditionMapper) {
		this.orderServiceRecordConditionMapper = orderServiceRecordConditionMapper;
	}

	public OrderServiceMapper getOrderServiceMapper() {
		return orderServiceMapper;
	}

	public void setOrderServiceMapper(OrderServiceMapper orderServiceMapper) {
		this.orderServiceMapper = orderServiceMapper;
	}

	@Autowired
	public OrderServiceRecordMapper getOrderServiceRecordMapper() {
		return orderServiceRecordMapper;
	}

	@Autowired
	public void setOrderServiceRecordMapper(OrderServiceRecordMapper orderServiceRecordMapper) {
		this.orderServiceRecordMapper = orderServiceRecordMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderServiceRecord
	 */
	public OrderServiceRecordImpl insert(OrderServiceRecordImpl orderServiceRecord) throws PmException {
		this.orderServiceRecordMapper.insert(orderServiceRecord);
		return orderServiceRecord;
	}

	/**
	 * 删除实体对象
	 * @param orderServiceRecord
	 */
	public int delete(OrderServiceRecordImpl orderServiceRecord) throws PmException {
		return this.orderServiceRecordMapper.delete(orderServiceRecord);
	}

	/**
	 * 更新实体对象
	 * @param orderServiceRecord
	 */
	public boolean update(OrderServiceRecordImpl orderServiceRecord) throws PmException {
		boolean result = true;
		String editState = orderServiceRecord.getEditState();
		String typeRecord = orderServiceRecord.getTypeRecord();
		if ("u".equals(editState)) {
			this.orderServiceRecordMapper.update(orderServiceRecord);
		}
		// 数据类型(订车:ov order vehicle, 报销:or order reimbursement)
		// 模块(订车 o:order, 派车 a:allocation)
		else if ("a".equals(editState) && "ov".equals(typeRecord)) {
			Long idOrderServiceRecord = 0L;
			//orderServiceRecord.setTypeRecord("ov");
			SimpleDateFormat sa = new SimpleDateFormat("yyyy-MM");
			String applyMonth = sa.format(new Date());
			orderServiceRecord.setApplyMonth(applyMonth);
			// 查询这个月是否有审批过的记录,如果有更新,没有插入
			OrderServiceRecordImpl orderServiceRecordTemp = new OrderServiceRecordImpl();
			orderServiceRecordTemp.setApplyMonth(applyMonth);
			orderServiceRecordTemp = (OrderServiceRecordImpl) orderServiceRecordMapper.get(orderServiceRecordTemp);
			OrderServiceImpl orderService = new OrderServiceImpl();
			if (null == orderServiceRecordTemp) {
				// 统计出需要参与审批的所有数据,并更新
				//orderServiceRecord.setApproveState("s");
				this.orderServiceRecordMapper.insert(orderServiceRecord);
				idOrderServiceRecord = orderServiceRecord.getId();
			} else {
				idOrderServiceRecord = orderServiceRecordTemp.getId();
			}
			// 订车状态(d:draft 草稿,s:提交,ar:已分配草稿,a:已分配,ap1:部门审批,ap2:行政审批,生成报销单草稿:rd)
			orderService.setStatusOrderUpdate("ap2");
			orderService.setStatusOrderUpdateValue("ap3");
			orderService.setIdOrderServiceRecord(idOrderServiceRecord);
			orderServiceMapper.update(orderService);
			
//			List<OrderServiceImpl> listOrderService = orderServiceMapper.select()
			
		} 
		// 数据类型(订车:ov order vehicle, 报销:or order reimbursement)
		else if ("a".equals(editState) && "or".equals(typeRecord)) {
			// 数据类型(订车:ov order vehicle)
			//orderServiceRecord.setTypeRecord("ov");
			SimpleDateFormat sa = new SimpleDateFormat("yyyy-MM");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date dateTemp = new Date();
			String month = sa.format(dateTemp);
			String date = sd.format(dateTemp);
			orderServiceRecord.setApplyMonth(month);
			orderServiceRecord.setMonth(month);
			Calendar ca = Calendar.getInstance();
			ca.setTime(dateTemp);
			int dayOfWeek = ca.get(Calendar.WEEK_OF_MONTH);
			String week = String.valueOf(dayOfWeek);
			String weekOfMonth = month + "-" + week;
			orderServiceRecord.setWeek(week);
			orderServiceRecord.setDate(date);
			orderServiceRecord.setWeekOfMonth(weekOfMonth);
			// 查询这个月是否有审批过的记录,如果有更新,没有插入
			OrderServiceRecordImpl orderServiceRecordTemp = new OrderServiceRecordImpl();
			orderServiceRecordTemp.setWeekOfMonth(weekOfMonth);;
			orderServiceRecordTemp = (OrderServiceRecordImpl) orderServiceRecordMapper.get(orderServiceRecordTemp);
			Long idOrderServiceRecord = null;
			if (null == orderServiceRecordTemp) {
				// 统计出需要参与审批的所有数据,并更新
				//orderServiceRecord.setApproveState("s");
				this.orderServiceRecordMapper.insert(orderServiceRecord);
				idOrderServiceRecord = orderServiceRecord.getId();
		} else {
			idOrderServiceRecord = orderServiceRecordTemp.getId();
		}
			OrderCategoryServiceImpl orderCategoryService = new OrderCategoryServiceImpl();
			orderCategoryService.setIdOrderServiceRecord(idOrderServiceRecord);
			orderCategoryService.setCountApprovePercent(100);
			orderCategoryService.setTagUpdate("statusCom");
			orderCategoryService.setStatus("c");
			orderCategoryService.setTagMapper("updateOrderRecord");
			orderCategoryServiceMapper.update(orderCategoryService);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderServiceRecord
	 */
	@SuppressWarnings("unchecked")
	public List<OrderServiceRecordImpl> select(OrderServiceRecordImpl orderServiceRecord) throws PmException {
		return (List<OrderServiceRecordImpl>) this.orderServiceRecordMapper.select(orderServiceRecord);
	}
	/**
	 * 查询单个实体
	 * @param orderServiceRecord
	 */
	public OrderServiceRecordImpl get(OrderServiceRecordImpl orderServiceRecord) throws PmException {
		return (OrderServiceRecordImpl) this.orderServiceRecordMapper.get(orderServiceRecord);
	}
	/**
	 * 查询实体分页列表
	 * @param orderServiceRecord
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderServiceRecordImpl> search(OrderServiceRecordImpl orderServiceRecord) throws PmException {
		DataGrid<OrderServiceRecordImpl> grid = new DataGrid<OrderServiceRecordImpl>();
		Object obj = orderServiceRecord;
		List list = orderServiceRecordMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderServiceRecordMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 查询万生报销单
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public List<OrderServiceImpl> selectOrderServiceRecordForReimburse(
			OrderServiceRecordImpl orderServiceRecord) throws PmException {
		return (List<OrderServiceImpl>) orderServiceRecordConditionMapper.selectOrderServiceRecordForReimburse(orderServiceRecord);
	}
	
	/**
	 * 查询万生报销单
	 * @param orderServiceRecord
	 * @return
	 * @throws PmException
	 */
	public List<OrderServiceImpl> selectOrderServiceRecordForDriver(
			OrderServiceRecordImpl orderServiceRecord) throws PmException {
		return (List<OrderServiceImpl>) orderServiceRecordConditionMapper.selectOrderServiceRecordForDriver(orderServiceRecord);
	}
}