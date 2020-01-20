package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.QuestionnaireImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 问卷表
 * 作者:     Auto
 * 日期:     2014-03-06
**********************************************
*/
public interface QuestionnaireService {
	/**
	 * 新增实体对象
	 * @param questionnaire
	 * @return
	 * @throws PmException
	 */
	public QuestionnaireImpl insert(QuestionnaireImpl questionnaireImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param questionnaire
	 * @return
	 * @throws PmException
	 */
	public int delete(QuestionnaireImpl questionnaireImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param questionnaire
	 * @return
	 * @throws PmException
	 */
	public boolean update(QuestionnaireImpl questionnaireImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param questionnaire
	 * @return
	 * @throws PmException
	 */
	public DataGrid<QuestionnaireImpl> select(QuestionnaireImpl questionnaireImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param questionnaire
	 * @return
	 * @throws PmException
	 */
	public QuestionnaireImpl get(QuestionnaireImpl questionnaireImpl) throws PmException;
	/**
	 * 取得单一问卷带问题和选项
	 * @param questionnaireImpl
	 * @return
	 * @throws PmException
	 */
	public QuestionnaireImpl getQuestionAndSelecter(QuestionnaireImpl questionnaireImpl) throws PmException;

}