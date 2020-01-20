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
package com.mtf.framework.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.PaymentVoucherItemMapper;
import com.mtf.framework.dao.PaymentVoucherMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PaymentVoucher;
import com.mtf.framework.model.PaymentVoucherItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IPaymentVoucherService;

@Service("paymentVoucherService")
public class PaymentVoucherServiceImpl implements IPaymentVoucherService {

	private PaymentVoucherMapper		paymentVoucherMapper;
	private PaymentVoucherItemMapper	paymentVoucherItemMapper;

	@Autowired
	public void setPaymentVoucherMapper(PaymentVoucherMapper paymentVoucherMapper) {
		this.paymentVoucherMapper = paymentVoucherMapper;
	}
	@Autowired
	public void setPaymentVoucherItemMapper(PaymentVoucherItemMapper paymentVoucherItemMapper) {
		this.paymentVoucherItemMapper = paymentVoucherItemMapper;
	}
	@Override
	public PaymentVoucher add(PaymentVoucher paymentVoucher, List<PaymentVoucherItem> paymentVoucherItems) throws PmException {
		// step 1 : check parameter(s)
		if (paymentVoucher == null) {
			throw new PmException("Parameter paymentVoucher is NULL.", 1);
		}else if (paymentVoucherItems == null) {
			throw new PmException("Parameter items is NULL.", 1);
		}

		PaymentVoucher temp = new PaymentVoucher();
		temp.setCpvNo(paymentVoucher.getCpvNo());
		int count = this.paymentVoucherMapper.count(temp);
		if(count > 0){
			throw new PmException("cpvNo already exists.");
		}
		
		// step 2 : insert into db
		this.paymentVoucherMapper.insert(paymentVoucher);
		
		for (PaymentVoucherItem paymentVoucherItem : paymentVoucherItems) {
			this.paymentVoucherItemMapper.insert(paymentVoucherItem);
		}

		return paymentVoucher;
	}

	@Override
	public void delete(String id) throws PmException {
		// step 1 : check parameter(s)
		if (StringUtils.isBlank(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}

		// step 3 : do delete
		int result = this.paymentVoucherMapper.deleteById(id);
		
		if(result == 0) {
			throw new PmException("PaymentVoucher not found.", 1);
		}
	}
	
	@Override
	public PaymentVoucher edit(PaymentVoucher paymentVoucher) throws PmException {
		// step 1 : check parameter(s)
		if (paymentVoucher == null) {
			throw new PmException("Parameter paymentVoucher is NULL.", 1);
		}
		
		// step 2 : check exists
		PaymentVoucher dbPaymentVoucher = this.paymentVoucherMapper.selectById(paymentVoucher.getId());
		if (dbPaymentVoucher == null) {
			throw new PmException("paymentVoucher not found.", 2);
		}
		
		// step 4 : do update
//		dbPaymentVoucher.setName(paymentVoucher.getName());
//		dbPaymentVoucher.setStatus(paymentVoucher.getStatus());
//		dbPaymentVoucher.setUpdateUserId(getUserId());
//		dbPaymentVoucher.setUpdateUserName(getUserName());
//		dbPaymentVoucher.setIndex(paymentVoucher.getIndex());
//		dbPaymentVoucher.setUpdateDatetime(new Date());
		this.paymentVoucherMapper.updateById(dbPaymentVoucher);
		
		return paymentVoucher;
	}

	@Override
	public PaymentVoucher get(String id) throws PmException {
		// step 1 : check parameter(s)
		if (StringUtils.isBlank(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		PaymentVoucher dbPaymentVoucher = this.paymentVoucherMapper.selectById(id);
		return dbPaymentVoucher;
	}

	@Override
	public DataGrid<PaymentVoucher> grid(PaymentVoucher paymentVoucher, Page page) throws PmException {
		DataGrid<PaymentVoucher> result = new DataGrid<PaymentVoucher>();
		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			//map.put("xx", "C_xx");
			page.generateOrderBy(map);
		}
		
		// step 2 : get count;
		int count = paymentVoucherMapper.count(paymentVoucher);
		result.setTotal(count);;
		
		// step 3 : do query
		if (count > 0) {
			List<PaymentVoucher> trimList = this.paymentVoucherMapper.select(paymentVoucher, page);
			// step 3 : fill result
			if (trimList != null && trimList.size() > 0) {
				result.setRows(trimList);
			}
		}
		
		return result;
	}
	
	@Override
	public List<PaymentVoucher> list(PaymentVoucher paymentVoucher, Page page) throws PmException {
		// step 1 : do search
		List<PaymentVoucher> list = this.paymentVoucherMapper.select(paymentVoucher, page);
		if (list == null) {
			list = new ArrayList<PaymentVoucher>();
		}
		
		return list;
	}
}
