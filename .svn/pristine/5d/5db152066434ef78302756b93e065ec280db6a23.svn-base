package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.impl.PurchaseCommentImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 采购评论
 * 作者:     Auto
 * 日期:     2015/3/11
**********************************************
*/
public interface PurchaseCommentService {
	
	/**
	 * 添加评论
	 * @param purchaseComment
	 * @return
	 * @throws PmException
	 */
	public boolean addComment(PurchaseCommentImpl purchaseComment, HttpSession session) throws PmException ;
	/**
	 * 查询实体列表
	 * @param purchaseComment
	 * @return
	 * @throws PmException
	 */
	public List<PurchaseCommentImpl> select(PurchaseCommentImpl purchaseComment) throws PmException;

}