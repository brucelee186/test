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
package com.mtf.payment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PaymentVoucherGen;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.service.IPaymentVoucherGenService;
import com.mtf.framework.util.Constants;

/**
 * 付款协议相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2013-4-25	Bill.Qi		created.
 * @version <ver>
 */
@Controller("paymentPaymentVoucherGenController")
@RequestMapping("/payment/paymentVoucherGen")
public class PaymentVoucherGenController {

	private IPaymentVoucherGenService	paymentVoucherGenService;

	@Autowired
	public void setPaymentVoucherGenService(IPaymentVoucherGenService paymentVoucherGenService) {
		this.paymentVoucherGenService = paymentVoucherGenService;
	}
	/**
	 * 跳转到搜索PaymentVoucherGen界面
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public String toSearch() throws PmException {
		return "payment/paymentVoucherGen";
	}

	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PaymentVoucherGen> doSearch(PaymentVoucherGen paymentVoucherGen, Page page) throws PmException {
		DataGrid<PaymentVoucherGen> result = new DataGrid<PaymentVoucherGen>();
		try {
			List<PaymentVoucherGen> list = this.paymentVoucherGenService.list(paymentVoucherGen, page);
			result.setRows(list);
			result.setTotal(list.size());
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}

	@RequestMapping(value="/doGen", method=RequestMethod.POST)
	@ResponseBody
	public Json doGen(HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		Json j = new Json();
		
		PaymentVoucherGen paymentVoucherGen = new PaymentVoucherGen();	
		// process
		try {
			Date now = new Date();
			
			paymentVoucherGen.setDateTime(new Date());
			paymentVoucherGen.setTick(now.getTime());
			paymentVoucherGen.setUserId(sessionInfo.getUserId());
			
			paymentVoucherGen = this.paymentVoucherGenService.add(paymentVoucherGen);
			j.setSuccess(true);
			j.setObj(paymentVoucherGen);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
}
