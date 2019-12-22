package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 选项表
 * 作者:     Auto
 * 日期:     2014-03-07
 **********************************************
 */
public class Selecter extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// 编号
	private Long id;
	// 题目Id
	private Long questionId;
	// 问卷Id
	private Long quesId;
	// 选项内容
	private String content;
	// 选项序号
	private Integer number;
	// 标记为答案
	private String answer;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getQuesId() {
		return quesId;
	}

	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}