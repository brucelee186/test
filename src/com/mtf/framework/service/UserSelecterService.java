package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserSelecterImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 人员选择选项表
 * 作者:     Auto
 * 日期:     2014-03-03
**********************************************
*/
public interface UserSelecterService {
	/**
	 * 新增实体对象
	 * @param userSelecter
	 * @return
	 * @throws PmException
	 */
	public UserSelecterImpl insert(UserSelecterImpl userSelecterImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param userSelecter
	 * @return
	 * @throws PmException
	 */
	public int delete(UserSelecterImpl userSelecterImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param userSelecter
	 * @return
	 * @throws PmException
	 */
	public boolean update(UserSelecterImpl userSelecterImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param userSelecter
	 * @return
	 * @throws PmException
	 */
	public DataGrid<UserSelecterImpl> select(UserSelecterImpl userSelecterImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param userSelecter
	 * @return
	 * @throws PmException
	 */
	public UserSelecterImpl get(UserSelecterImpl userSelecterImpl) throws PmException;

}