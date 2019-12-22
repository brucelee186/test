package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.Question;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 题目表
 * 作者:     Auto
 * 日期:     2014-03-06
**********************************************
*/
public interface QuestionService {
	/**
	 * 新增实体对象
	 * @param question
	 * @return
	 * @throws PmException
	 */
	public Question insert(Question question) throws PmException;

	/**
	 * 删除实体对象
	 * @param question
	 * @return
	 * @throws PmException
	 */
	public int delete(Question question) throws PmException;

	/**
	 * 更新实体对象
	 * @param question
	 * @return
	 * @throws PmException
	 */
	public boolean update(Question question) throws PmException;

	/**
	 * 查询实体数量
	 * @param question
	 * @return
	 * @throws PmException
	 */
	public DataGrid<Question> select(Question question) throws PmException;

	/**
	 * 取得单一对象
	 * @param question
	 * @return
	 * @throws PmException
	 */
	public Question get(Question question) throws PmException;

}