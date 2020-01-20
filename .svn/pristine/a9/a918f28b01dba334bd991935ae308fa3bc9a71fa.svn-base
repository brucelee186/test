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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category;
import com.mtf.framework.model.PaymentVoucher;
import com.mtf.framework.model.PaymentVoucherGen;
import com.mtf.framework.model.PaymentVoucherItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.service.ICategoryService;
import com.mtf.framework.service.IPaymentVoucherGenService;
import com.mtf.framework.service.IPaymentVoucherItemService;
import com.mtf.framework.service.IPaymentVoucherService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.UUIDUtils;

/**
 * 付款协议相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2013-4-25	Bill.Qi		created.
 * @version <ver>
 */
@Controller("paymentPaymentVoucherController")
@RequestMapping("/payment/paymentVoucher")
public class PaymentVoucherController {

	private ICategoryService				categoryService;
	private IPaymentVoucherGenService		paymentVoucherGenService;
	private IPaymentVoucherService			paymentVoucherService;

	@Autowired
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Autowired
	public void setPaymentVoucherGenService(IPaymentVoucherGenService paymentVoucherGenService) {
		this.paymentVoucherGenService = paymentVoucherGenService;
	}
	@Autowired
	public void setPaymentVoucherService(IPaymentVoucherService paymentVoucherService) {
		this.paymentVoucherService = paymentVoucherService;
	}
	
	/**
	 * 跳转到搜索PaymentVoucher界面
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public String toSearch() throws PmException {
		return "payment/paymentVoucher";
	}
	
	/**
	 * 跳转到搜索PaymentVoucher界面
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		PaymentVoucherGen paymentVoucherGen = new PaymentVoucherGen();
		List<Category> categorys = null;
		// process
		try {
			Date now = new Date();
			
			//generate number
			paymentVoucherGen.setDateTime(new Date());
			paymentVoucherGen.setTick(now.getTime());
			paymentVoucherGen.setUserId(sessionInfo.getUserId());			
			paymentVoucherGen = this.paymentVoucherGenService.add(paymentVoucherGen);
			
			categorys = this.categoryService.list(null, null);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		ModelAndView mv = new ModelAndView("payment/addPaymentVoucher");
		mv.addObject("number", paymentVoucherGen.getNumber());
		mv.addObject("categorysJson", JSON.toJSONString(categorys));
		return mv;
	}

	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PaymentVoucher> doSearch(PaymentVoucher paymentVoucher, Page page) throws PmException {
		DataGrid<PaymentVoucher> result = new DataGrid<PaymentVoucher>();
		try {
			List<PaymentVoucher> list = this.paymentVoucherService.list(paymentVoucher, page);
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
	public Json doAdd(PaymentVoucher paymentVoucher, String itemStr, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();		
		List<PaymentVoucherItem> paymentVoucherItems = null;
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (paymentVoucher.getApplicationDate() == null) {
			msg.append("申请日期 必须输入.<br>");
		}
		if(StringUtils.isBlank(paymentVoucher.getRecipient())){
			msg.append("收款人 必须输入.<br>");
		}
		if(StringUtils.isBlank(paymentVoucher.getApplicantDeptId())){
			msg.append("报销部门 必须输入.<br>");
		}
		if(paymentVoucher.getCurrencyId() == null){
			msg.append("货币 必须输入.<br>");
		}
		if (StringUtils.isBlank(paymentVoucher.getCpvNo())) {
			msg.append("cpvNo 错误.<br>");
		}
		if (StringUtils.isBlank(itemStr)) {
			msg.append("申请单项 必须输入.<br>");
		}else{
			paymentVoucherItems = JSON.parseArray(itemStr, PaymentVoucherItem.class);
			
			if(paymentVoucherItems.size() == 0){
				msg.append("申请单项 必须输入.<br>");
			}else{
				for (PaymentVoucherItem paymentVoucherItem : paymentVoucherItems) {
					if(StringUtils.isBlank(paymentVoucherItem.getLevel1CategoryId())){
						msg.append(String.format("[%d] 用途分类1必须输入<br>", paymentVoucherItem.getIndex()));
					}
					if(StringUtils.isBlank(paymentVoucherItem.getLevel2CategoryId())){
						msg.append(String.format("[%d] 用途分类2必须输入<br>", paymentVoucherItem.getIndex()));
					}
					if(StringUtils.isBlank(paymentVoucherItem.getDescription())){
						msg.append(String.format("[%d] 用途描述必须输入<br>", paymentVoucherItem.getIndex()));
					}
					if(paymentVoucherItem.getAmount() == null || paymentVoucherItem.getAmount() < 0){
						msg.append(String.format("[%d] 金额格式不正确<br>", paymentVoucherItem.getIndex()));
					}
				}
			}
		}
		
		if (msg.length() > 0) {
			j.setMsg(msg.toString());
			return j;
		}
		
		// process
		try {
			paymentVoucher.setId(UUIDUtils.genUUID());
			paymentVoucher.setApplicantId(sessionInfo.getUserId());
			
			double totalAmount = 0.;
			for (PaymentVoucherItem paymentVoucherItem : paymentVoucherItems) {
				paymentVoucherItem.setId(UUIDUtils.genUUID());
				paymentVoucherItem.setPaymentVoucherId(paymentVoucher.getId());
				totalAmount += paymentVoucherItem.getAmount();
			}
			
			paymentVoucher.setTotalAmount(totalAmount);
			
			paymentVoucher = this.paymentVoucherService.add(paymentVoucher, paymentVoucherItems);
			j.setSuccess(true);
			j.setObj(paymentVoucher);
		} catch (PmException e) {
			j.setMsg(e.getMessage());
			return j;
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}

	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(PaymentVoucher paymentVoucher) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (StringUtils.isBlank(paymentVoucher.getCpvNo())) {
			msg.append("名称<br>");
		}
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		// process
		try {
			paymentVoucher = this.paymentVoucherService.edit(paymentVoucher);
			j.setSuccess(true);
			j.setObj(paymentVoucher);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}

	@RequestMapping(value = "/doGet", method = RequestMethod.POST)
	@ResponseBody
	public PaymentVoucher doGet(String id) throws PmException {
		if (!UUIDUtils.isValidUUID(id)) {
			throw new PmException("参数无效.");
		}

		PaymentVoucher dbPaymentVoucher = null;
		try {
			dbPaymentVoucher = this.paymentVoucherService.get(id);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return dbPaymentVoucher;
	}
	
	@RequestMapping(value = "/doPdfReport", method = RequestMethod.POST)
	public ModelAndView doPdfReport(String paymentVoucherStr, String paymentVoucherItemStr, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		PaymentVoucher paymentVoucher = null;
		List<PaymentVoucherItem> paymentVoucherItems = null;
		
		JSON.DEFFAULT_DATE_FORMAT = "yyyy/MM/dd";
		
		if(StringUtils.isBlank(paymentVoucherStr)){
			paymentVoucher = new PaymentVoucher();
		}else{
			paymentVoucher = JSON.parseObject(paymentVoucherStr, PaymentVoucher.class);
		}
		
		if(StringUtils.isBlank(paymentVoucherItemStr)){
			paymentVoucherItems = new ArrayList<>();
		}else{
			paymentVoucherItems = JSON.parseArray(paymentVoucherItemStr, PaymentVoucherItem.class);
		}
		
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", new ArrayList<>());
		parameterMap.put("paymentVoucher", paymentVoucher);
		parameterMap.put("paymentVoucherItems", paymentVoucherItems);
		parameterMap.put("applicantName", sessionInfo.getDisplayName());
		
		ModelAndView mv = null;
		mv = new ModelAndView("paymentVoucherReport", parameterMap);

		return mv;
	}
}
