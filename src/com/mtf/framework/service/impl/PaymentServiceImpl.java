package com.mtf.framework.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.ApplicationMapper;
import com.mtf.framework.dao.PaymentMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ApplicationImpl;
import com.mtf.framework.model.impl.PaymentImpl;
import com.mtf.framework.service.ApplicationService;
import com.mtf.framework.service.PaymentService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 合同
 * 作者:     Auto
 * 日期:     2013/9/27
**********************************************
*/
@Service("paymentService")
public class PaymentServiceImpl extends CommonServiceImpl implements PaymentService {
	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Autowired
	private PaymentMapper paymentMapper;

	@Autowired
	public void setPaymentMapper(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}

	@Autowired
	public void setApplicationMapper(ApplicationMapper applicationMapper) {
		this.applicationMapper = applicationMapper;
	}

	/**
	 * 新增实体对象
	 * @param applicationImpl
	 */
	public ApplicationImpl insert(ApplicationImpl applicationImpl) throws PmException {
		
		this.applicationMapper.insert(applicationImpl);
		return applicationImpl;
	}

	/**
	 * 删除实体对象
	 * @param applicationImpl
	 */
	public int delete(ApplicationImpl applicationImpl) throws PmException {
		return this.applicationMapper.delete(applicationImpl);
	}

	/**
	 * 更新实体对象
	 * @param applicationImpl
	 */
	public boolean update(ApplicationImpl applicationImpl) throws PmException {
		boolean result = true;
		this.applicationMapper.update(applicationImpl);
		return result;
	}
	/**
	 * 更新实体对象
	 * @param applicationImpl
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public boolean updatePayment(ApplicationImpl applicationImpl) throws PmException, IllegalAccessException, InvocationTargetException {
		boolean result = true;
		PaymentImpl payment = new PaymentImpl();
		BeanUtils.copyProperties(payment, applicationImpl);

		// 第一步：更新application表
		this.applicationMapper.update(applicationImpl);
		// 第二步：插入历史记录
		this.paymentMapper.insert(payment);
		
		return result;
	}
	/**
	 * 查询单个实体
	 * @param applicationImpl
	 */
	public ApplicationImpl get(ApplicationImpl applicationImpl) throws PmException {
		return (ApplicationImpl) this.applicationMapper.get(applicationImpl);
	}
	/**
	 * 查询实体列表
	 * @param applicationImpl
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<ApplicationImpl> select(ApplicationImpl applicationImpl) throws PmException {
		DataGrid<ApplicationImpl> grid = new DataGrid<ApplicationImpl>();
		Object obj = applicationImpl;
		List list = applicationMapper.select(obj);
		grid.setRows(list);
		int count;
		count = applicationMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	@Override
	public PaymentImpl insert(PaymentImpl paymentImpl) throws PmException {
		this.paymentMapper.insert(paymentImpl);
		return paymentImpl;
	}

	@Override
	public int delete(PaymentImpl paymentImpl) throws PmException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(PaymentImpl paymentImpl) throws PmException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataGrid<PaymentImpl> select(PaymentImpl paymentImpl) throws PmException {
		DataGrid<PaymentImpl> grid = new DataGrid<PaymentImpl>();
		Object obj = paymentImpl;
		List list = paymentMapper.select(obj);
		grid.setRows(list);
		int count;
		count = paymentMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	@Override
	public DataGrid<PaymentImpl> selectItem(PaymentImpl paymentImpl) throws PmException {
		DataGrid<PaymentImpl> grid = new DataGrid<PaymentImpl>();
		Object obj = paymentImpl;
		List list = paymentMapper.select(obj);
		grid.setRows(list);
		int count;
		count = paymentMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	@Override
	public PaymentImpl get(PaymentImpl paymentImpl) throws PmException {
		return  (PaymentImpl) this.paymentMapper.get(paymentImpl);
	}

	@Override
	public List<PaymentImpl> selectList(PaymentImpl paymentImpl) throws PmException {
		// TODO Auto-generated method stub
		return null;
	}
}