package com.mtf.framework.model.impl;

import java.util.List;

import com.mtf.framework.model.Question;


public class QuestionImpl extends Question{
	
	// 选项列表
	private List<SelecterImpl> listSelecter;
	
	
	public List<SelecterImpl> getListSelecter() {
		return listSelecter;
	}

	
	public void setListSelecter(List<SelecterImpl> listSelecter) {
		this.listSelecter = listSelecter;
	}

	

}
