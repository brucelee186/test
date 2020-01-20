package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.QuestionMapper;
import com.mtf.framework.model.Question;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.QuestionService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 题目表
 * 作者:     Auto
 * 日期:     2014-03-06
**********************************************
*/
@Service("questionService")
public class QuestionServiceImpl extends CommonServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	public QuestionMapper getQuestionMapper() {
		return questionMapper;
	}

	@Autowired
	public void setQuestionMapper(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}

	/**
	 * 新增实体对象
	 * @param question
	 */
	public Question insert(Question question) throws PmException {
		this.questionMapper.insert(question);
		return question;
	}

	/**
	 * 删除实体对象
	 * @param question
	 */
	public int delete(Question question) throws PmException {
		return this.questionMapper.delete(question);
	}

	/**
	 * 更新实体对象
	 * @param question
	 */
	public boolean update(Question question) throws PmException {
		boolean result = true;
		this.questionMapper.update(question);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param question
	 */
	public Question get(Question question) throws PmException {
		return (Question) this.questionMapper.get(question);
	}
	/**
	 * 查询实体列表
	 * @param question
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<Question> select(Question question) throws PmException {
		DataGrid<Question> grid = new DataGrid<Question>();
		Object obj = question;
		List list = questionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = questionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}