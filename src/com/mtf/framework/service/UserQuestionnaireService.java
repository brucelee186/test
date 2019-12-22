package com.mtf.framework.service;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserQuestionnaireImpl;
import com.mtf.framework.model.UserQuestionnaire;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 人员问卷关联表
 * 作者:     Auto
 * 日期:     2014-03-03
**********************************************
*/
public interface UserQuestionnaireService {
	/**
	 * 新增实体对象
	 * @param userQuestionnaire
	 * @return
	 * @throws PmException
	 */
	public UserQuestionnaireImpl insert(UserQuestionnaireImpl userQuestionnaireImpl,HttpSession session) throws PmException;

	/**
	 * 删除实体对象
	 * @param userQuestionnaire
	 * @return
	 * @throws PmException
	 */
	public int delete(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param userQuestionnaire
	 * @return
	 * @throws PmException
	 */
	public boolean update(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param userQuestionnaire
	 * @return
	 * @throws PmException
	 */
	public DataGrid<UserQuestionnaireImpl> select(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param userQuestionnaire
	 * @return
	 * @throws PmException
	 */
	public UserQuestionnaireImpl get(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException;

}