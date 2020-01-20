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
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PaymentVoucherItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IPaymentVoucherItemService;

@Service("paymentVoucherItemService")
public class PaymentVoucherItemServiceImpl implements IPaymentVoucherItemService {

	private PaymentVoucherItemMapper		paymentVoucherItemMapper;

	@Autowired
	public void setPaymentVoucherItemMapper(PaymentVoucherItemMapper paymentVoucherItemMapper) {
		this.paymentVoucherItemMapper = paymentVoucherItemMapper;
	}
	@Override
	public PaymentVoucherItem add(PaymentVoucherItem paymentVoucherItem) throws PmException {
		// step 1 : check parameter(s)
		if (paymentVoucherItem == null) {
			throw new PmException("Parameter paymentVoucherItem is NULL.", 1);
		}

		// step 2 : insert into db
		this.paymentVoucherItemMapper.insert(paymentVoucherItem);

		return paymentVoucherItem;
	}

	@Override
	public void delete(String id) throws PmException {
		// step 1 : check parameter(s)
		if (StringUtils.isBlank(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}

		// step 3 : do delete
		int result = this.paymentVoucherItemMapper.deleteById(id);
		
		if(result == 0) {
			throw new PmException("PaymentVoucherItem not found.", 1);
		}
	}
	
	@Override
	public PaymentVoucherItem edit(PaymentVoucherItem paymentVoucherItem) throws PmException {
		// step 1 : check parameter(s)
		if (paymentVoucherItem == null) {
			throw new PmException("Parameter paymentVoucherItem is NULL.", 1);
		}
		
		// step 2 : check exists
		PaymentVoucherItem dbPaymentVoucherItem = this.paymentVoucherItemMapper.selectById(paymentVoucherItem.getId());
		if (dbPaymentVoucherItem == null) {
			throw new PmException("paymentVoucherItem not found.", 2);
		}
		
		// step 4 : do update
//		dbPaymentVoucherItem.setName(paymentVoucherItem.getName());
//		dbPaymentVoucherItem.setStatus(paymentVoucherItem.getStatus());
//		dbPaymentVoucherItem.setUpdateUserId(getUserId());
//		dbPaymentVoucherItem.setUpdateUserName(getUserName());
//		dbPaymentVoucherItem.setIndex(paymentVoucherItem.getIndex());
//		dbPaymentVoucherItem.setUpdateDatetime(new Date());
		this.paymentVoucherItemMapper.updateById(dbPaymentVoucherItem);
		
		return paymentVoucherItem;
	}

	@Override
	public PaymentVoucherItem get(String id) throws PmException {
		// step 1 : check parameter(s)
		if (StringUtils.isBlank(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		PaymentVoucherItem dbPaymentVoucherItem = this.paymentVoucherItemMapper.selectById(id);
		return dbPaymentVoucherItem;
	}

	@Override
	public DataGrid<PaymentVoucherItem> grid(PaymentVoucherItem paymentVoucherItem, Page page) throws PmException {
		DataGrid<PaymentVoucherItem> result = new DataGrid<PaymentVoucherItem>();
		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			//map.put("xx", "C_xx");
			page.generateOrderBy(map);
		}
		
		// step 2 : get count;
		int count = paymentVoucherItemMapper.count(paymentVoucherItem);
		result.setTotal(count);;
		
		// step 3 : do query
		if (count > 0) {
			List<PaymentVoucherItem> trimList = this.paymentVoucherItemMapper.select(paymentVoucherItem, page);
			// step 3 : fill result
			if (trimList != null && trimList.size() > 0) {
				result.setRows(trimList);
			}
		}
		
		return result;
	}
	
	@Override
	public List<PaymentVoucherItem> list(PaymentVoucherItem paymentVoucherItem, Page page) throws PmException {
		// step 1 : do search
		List<PaymentVoucherItem> list = this.paymentVoucherItemMapper.select(paymentVoucherItem, page);
		if (list == null) {
			list = new ArrayList<PaymentVoucherItem>();
		}
		
		return list;
	}
}
