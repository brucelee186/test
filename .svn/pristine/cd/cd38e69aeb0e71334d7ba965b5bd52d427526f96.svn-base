package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserQuestionImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 人员题目关联表
 * 作者:     Auto
 * 日期:     2014-03-03
**********************************************
*/
public interface UserQuestionService {
	/**
	 * 新增实体对象
	 * @param userQuestion
	 * @return
	 * @throws PmException
	 */
	public UserQuestionImpl insert(UserQuestionImpl userQuestionImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param userQuestion
	 * @return
	 * @throws PmException
	 */
	public int delete(UserQuestionImpl userQuestionImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param userQuestion
	 * @return
	 * @throws PmException
	 */
	public boolean update(UserQuestionImpl userQuestionImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param userQuestion
	 * @return
	 * @throws PmException
	 */
	public DataGrid<UserQuestionImpl> select(UserQuestionImpl userQuestionImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param userQuestion
	 * @return
	 * @throws PmException
	 */
	public UserQuestionImpl get(UserQuestionImpl userQuestionImpl) throws PmException;

}