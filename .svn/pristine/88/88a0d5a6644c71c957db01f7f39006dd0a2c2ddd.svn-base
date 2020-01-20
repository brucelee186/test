package com.mtf.framework.service;

import java.lang.reflect.InvocationTargetException;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ApplicationImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 合同
 * 作者:     Auto
 * 日期:     2013/9/27
**********************************************
*/
public interface ApplicationService {
	/**
	 * 新增实体对象
	 * @param applicationImpl
	 * @return
	 * @throws PmException
	 */
	public ApplicationImpl insert(ApplicationImpl applicationImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param applicationImpl
	 * @return
	 * @throws PmException
	 */
	public int delete(ApplicationImpl applicationImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param applicationImpl
	 * @return
	 * @throws PmException
	 */
	public boolean update(ApplicationImpl applicationImpl) throws PmException;
	
	public boolean updatePayment(ApplicationImpl applicationImpl) throws PmException, IllegalAccessException, InvocationTargetException;

	/**
	 * 查询实体数量
	 * @param applicationImpl
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ApplicationImpl> select(ApplicationImpl applicationImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param applicationImpl
	 * @return
	 * @throws PmException
	 */
	public ApplicationImpl get(ApplicationImpl applicationImpl) throws PmException;

}