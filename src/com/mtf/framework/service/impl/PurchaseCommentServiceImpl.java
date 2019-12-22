package com.mtf.framework.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.PurchaseCommentMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PurchaseComment;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PurchaseCommentImpl;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.PurchaseCommentService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.UUIDUtils;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 采购评论
 * 作者:     Auto
 * 日期:     2015/3/11
**********************************************
*/
@Service("purchaseCommentService")
public class PurchaseCommentServiceImpl extends CommonServiceImpl implements PurchaseCommentService {
	private PurchaseCommentMapper purchaseCommentMapper;

	@Autowired
	public void setPurchaseCommentMapper(PurchaseCommentMapper purchaseCommentMapper) {
		this.purchaseCommentMapper = purchaseCommentMapper;
	}

	@Override
	public boolean addComment(PurchaseCommentImpl purchaseComment, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		//加评论
		purchaseComment.setComment("【评论】" + purchaseComment.getComment() );
		purchaseComment.setId(UUIDUtils.genUUID());
		purchaseComment.setCreateUserId(sessionInfo.getUserId());
		purchaseComment.setCreateUserName(sessionInfo.getDisplayName());
		purchaseComment.setCreateDatetime(new Date());
		
		this.purchaseCommentMapper.insert(purchaseComment);
		
		return result;
	}
	
	/**
	 * 查询实体列表
	 * @param purchaseComment
	 */
	@SuppressWarnings("unchecked")
	public List<PurchaseCommentImpl> select(PurchaseCommentImpl purchaseComment) throws PmException {
		return (List<PurchaseCommentImpl>) this.purchaseCommentMapper.select(purchaseComment);
	}
	
}