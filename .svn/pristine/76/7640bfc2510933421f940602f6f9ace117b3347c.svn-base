package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.QuestionImpl;
import com.mtf.framework.model.impl.QuestionnaireImpl;
import com.mtf.framework.model.impl.SelecterImpl;
import com.mtf.framework.dao.QuestionMapper;
import com.mtf.framework.dao.QuestionnaireMapper;
import com.mtf.framework.dao.SelecterMapper;
import com.mtf.framework.model.Questionnaire;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.QuestionService;
import com.mtf.framework.service.QuestionnaireService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 问卷表
 * 作者:     Auto
 * 日期:     2014-03-06
**********************************************
*/
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends CommonServiceImpl implements QuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private SelecterMapper selecterMapper;

	@Autowired
	public QuestionnaireMapper getQuestionnaireMapper() {
		return questionnaireMapper;
	}

	@Autowired
	public void setQuestionnaireMapper(QuestionnaireMapper questionnaireMapper) {
		this.questionnaireMapper = questionnaireMapper;
	}
	
	@Autowired
	public QuestionMapper getQuestionMapper() {
		return questionMapper;
	}

	@Autowired
	public void setQuestionMapper(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}

	@Autowired
	public SelecterMapper getSelecterMapper() {
		return selecterMapper;
	}

	@Autowired
	public void setSelecterMapper(SelecterMapper selecterMapper) {
		this.selecterMapper = selecterMapper;
	}

	/**
	 * 新增实体对象
	 * @param questionnaire
	 */
	public QuestionnaireImpl insert(QuestionnaireImpl questionnaireImpl) throws PmException {
		this.questionnaireMapper.insert(questionnaireImpl);
		insertListQuestion(questionnaireImpl);
		return questionnaireImpl;
	}

	/**
	 * 删除实体对象
	 * @param questionnaire
	 */
	public int delete(QuestionnaireImpl questionnaireImpl) throws PmException {
		return this.questionnaireMapper.delete(questionnaireImpl);
	}

	/**
	 * 更新实体对象
	 * @param questionnaire
	 */
	public boolean update(QuestionnaireImpl questionnaireImpl) throws PmException {
		boolean result = true;
		//更新问卷表
		this.questionnaireMapper.update(questionnaireImpl);
		insertListQuestion(questionnaireImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param questionnaire
	 */
	public QuestionnaireImpl get(QuestionnaireImpl questionnaireImpl) throws PmException {
		return (QuestionnaireImpl) this.questionnaireMapper.get(questionnaireImpl);
	}
	/**
	 * 查询实体列表
	 * @param questionnaire
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<QuestionnaireImpl> select(QuestionnaireImpl questionnaireImpl) throws PmException {
		DataGrid<QuestionnaireImpl> grid = new DataGrid<QuestionnaireImpl>();
		Object obj = questionnaireImpl;
		List list = questionnaireMapper.select(obj);
		grid.setRows(list);
		int count;
		count = questionnaireMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	//添加问卷的问题list
	public void insertListQuestion(QuestionnaireImpl questionnaireImpl) throws PmException{
		Long quesId = questionnaireImpl.getId();
		QuestionImpl delQuestion = new QuestionImpl();
		SelecterImpl delSelecter = new SelecterImpl();
		int num = 1;
		delQuestion.setQuesId(quesId);
		delSelecter.setQuesId(quesId);
		String editState = questionnaireImpl.getEditState();
		// 更新状态
		if ("u".equals(editState)) {
			// 删除问卷ID对应的问题数据和问题中选项数据
			questionMapper.delete(delQuestion);
			selecterMapper.delete(delSelecter);
		}
		List<QuestionImpl> listQuestion = questionnaireImpl.getListQuestion();
		if (listQuestion != null && listQuestion.size() > 0) {
			for (int i = 0; i < listQuestion.size(); i++) {
				QuestionImpl question = listQuestion.get(i);
				String content = question.getContent();
				if (!(null == content)) {
					// 添加问卷ID
					question.setQuesId(quesId);
					// 添加问题序号
					question.setNumber(num);
					questionMapper.insert(question);
					insertListSelecter(question, quesId,num);
					num++;
				}
				
			}
		}
	}
	
	//添加选项list
	public void insertListSelecter(QuestionImpl question,Long quesId,int num) throws PmException{
		Long questionId = question.getId();
		// 选项的编号
		int snum = 1;
		List<SelecterImpl> listSelecter = question.getListSelecter(); 
		if (listSelecter != null && listSelecter.size() > 0) {
			for (int i = 0; i < listSelecter.size(); i++) {
				SelecterImpl selecter = listSelecter.get(i);
				String content = selecter.getContent();
				if (!(null == content)&&content.length() > 0) {
					// 添加问题ID
					selecter.setQuestionId(questionId);
					// 添加问卷ID
					selecter.setQuesId(quesId);
					//添加选项序号
					selecter.setNumber(snum);
					snum++;
					selecterMapper.insert(selecter);
				}
			}
		}
		
	}

	@Override
	public QuestionnaireImpl getQuestionAndSelecter(QuestionnaireImpl questionnaireImpl) throws PmException {
		QuestionImpl question = new QuestionImpl();
		questionnaireImpl = (QuestionnaireImpl) questionnaireMapper.get(questionnaireImpl);
		question.setQuesId(questionnaireImpl.getId());
		List<QuestionImpl> listQuestion = questionMapper.selectWithSelecter(question);
		questionnaireImpl.setListQuestion(listQuestion);
		return questionnaireImpl;
	}


}