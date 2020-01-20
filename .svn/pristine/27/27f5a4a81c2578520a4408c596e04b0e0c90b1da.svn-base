/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.controller.reimbursement;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.PurchaseCommentImpl;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.service.PurchaseCommentService;
import com.mtf.framework.service.PurchaseService;
import com.mtf.framework.util.JacksonUtils;



/**
 * PurchaseComment相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2015-3-10	Bill.Qi		created.
 * @version <ver>
 */
@Controller("purchaseCommentController")
@RequestMapping("/workgroup/purchase/purchaseComment")

public class PurchaseCommentController extends BaseController {
	private PurchaseCommentService			purchaseCommentService;
	private PurchaseService 				purchaseService;

	@Autowired
	public void setPurchaseCommentService(PurchaseCommentService purchaseCommentService) {
		this.purchaseCommentService = purchaseCommentService;
	}
	
	@Autowired
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@RequestMapping(value="/toSearch")
	public ModelAndView toSearch(PurchaseCommentImpl purchaseComment) throws PmException {
		
		// process
		List<PurchaseCommentImpl> purchaseComments = null;
		try {
			purchaseComments = this.purchaseCommentService.select(purchaseComment);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("purchaseComments", JacksonUtils.objectToJson(purchaseComments));
		mv.setViewName("reimbursement/purchaseComment");
		
		return mv;
	}
	
	@RequestMapping(value="/addComment", method=RequestMethod.POST)
	@ResponseBody
	public Json addComment(PurchaseCommentImpl purchaseComment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			this.purchaseCommentService.addComment(purchaseComment, session);
			j.setSuccess(true);
			j.setObj(purchaseComment);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
}
