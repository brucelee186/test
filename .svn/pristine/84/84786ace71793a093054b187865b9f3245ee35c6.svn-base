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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PaymentVoucherItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IPaymentVoucherItemService;
import com.mtf.framework.util.UUIDUtils;

/**
 * 付款协议相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2013-4-25	Bill.Qi		created.
 * @version <ver>
 */
@Controller("paymentPaymentVoucherItemController")
@RequestMapping("/payment/paymentVoucherItem")
public class PaymentVoucherItemController {

	private IPaymentVoucherItemService	paymentVoucherItemService;

	@Autowired
	public void setPaymentVoucherItemService(IPaymentVoucherItemService paymentVoucherItemService) {
		this.paymentVoucherItemService = paymentVoucherItemService;
	}
	/**
	 * 跳转到搜索PaymentVoucherItem界面
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public String toSearch() throws PmException {
		return "payment/paymentVoucherItem";
	}

	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PaymentVoucherItem> doSearch(PaymentVoucherItem paymentVoucherItem, Page page) throws PmException {
		DataGrid<PaymentVoucherItem> result = new DataGrid<PaymentVoucherItem>();
		try {
			List<PaymentVoucherItem> list = this.paymentVoucherItemService.list(paymentVoucherItem, page);
			result.setRows(list);
			result.setTotal(list.size());
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}

	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(PaymentVoucherItem paymentVoucherItem) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
//		if (StringUtils.isBlank(paymentVoucherItem.getCpvNo())) {
//			msg.append("名称<br>");
//		}
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		paymentVoucherItem.setId(UUIDUtils.genUUID());
		// process
		try {
			paymentVoucherItem = this.paymentVoucherItemService.add(paymentVoucherItem);
			j.setSuccess(true);
			j.setObj(paymentVoucherItem);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}

	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(PaymentVoucherItem paymentVoucherItem) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
//		if (StringUtils.isBlank(paymentVoucherItem.getCpvNo())) {
//			msg.append("名称<br>");
//		}
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		// process
		try {
			paymentVoucherItem = this.paymentVoucherItemService.edit(paymentVoucherItem);
			j.setSuccess(true);
			j.setObj(paymentVoucherItem);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value = "/doGet", method = RequestMethod.POST)
	@ResponseBody
	public PaymentVoucherItem doGet(String id) throws PmException {
		List<Message> errList = new ArrayList<>();

		if (!UUIDUtils.isValidUUID(id)) {
			throw new PmException("参数无效.");
		}

		PaymentVoucherItem dbPaymentVoucherItem = null;
		try {
			dbPaymentVoucherItem = this.paymentVoucherItemService.get(id);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return dbPaymentVoucherItem;
	}
}
