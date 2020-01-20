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

import com.mtf.framework.dao.PaymentVoucherGenMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PaymentVoucherGen;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IPaymentVoucherGenService;

@Service("paymentVoucherGenService")
public class PaymentVoucherGenServiceImpl implements IPaymentVoucherGenService {

	private PaymentVoucherGenMapper		paymentVoucherGenMapper;

	@Autowired
	public void setPaymentVoucherGenMapper(PaymentVoucherGenMapper paymentVoucherGenMapper) {
		this.paymentVoucherGenMapper = paymentVoucherGenMapper;
	}
	@Override
	public PaymentVoucherGen add(PaymentVoucherGen paymentVoucherGen) throws PmException {
		// step 1 : check parameter(s)
		if (paymentVoucherGen == null) {
			throw new PmException("Parameter paymentVoucherGen is NULL.", 1);
		}

		// step 2 : insert into db
		this.paymentVoucherGenMapper.insert(paymentVoucherGen);
		
		PaymentVoucherGen dbPaymentVoucherGen = this.paymentVoucherGenMapper.selectByTick(paymentVoucherGen.getTick());

		return dbPaymentVoucherGen;
	}

	@Override
	public void delete(Integer id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}

		// step 3 : do delete
		int result = this.paymentVoucherGenMapper.deleteById(id);
		
		if(result == 0) {
			throw new PmException("PaymentVoucherGen not found.", 1);
		}
	}
	
	@Override
	public PaymentVoucherGen edit(PaymentVoucherGen paymentVoucherGen) throws PmException {
		// step 1 : check parameter(s)
		if (paymentVoucherGen == null) {
			throw new PmException("Parameter paymentVoucherGen is NULL.", 1);
		}
		
		// step 2 : check exists
		PaymentVoucherGen dbPaymentVoucherGen = this.paymentVoucherGenMapper.selectById(paymentVoucherGen.getNumber());
		if (dbPaymentVoucherGen == null) {
			throw new PmException("paymentVoucherGen not found.", 2);
		}
		
		// step 4 : do update
//		dbPaymentVoucherGen.setName(paymentVoucherGen.getName());
//		dbPaymentVoucherGen.setStatus(paymentVoucherGen.getStatus());
//		dbPaymentVoucherGen.setUpdateUserId(getUserId());
//		dbPaymentVoucherGen.setUpdateUserName(getUserName());
//		dbPaymentVoucherGen.setIndex(paymentVoucherGen.getIndex());
//		dbPaymentVoucherGen.setUpdateDatetime(new Date());
		this.paymentVoucherGenMapper.updateById(dbPaymentVoucherGen);
		
		return paymentVoucherGen;
	}

	@Override
	public PaymentVoucherGen get(Integer id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		PaymentVoucherGen dbPaymentVoucherGen = this.paymentVoucherGenMapper.selectById(id);
		return dbPaymentVoucherGen;
	}

	@Override
	public DataGrid<PaymentVoucherGen> grid(PaymentVoucherGen paymentVoucherGen, Page page) throws PmException {
		DataGrid<PaymentVoucherGen> result = new DataGrid<PaymentVoucherGen>();
		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			//map.put("xx", "C_xx");
			page.generateOrderBy(map);
		}
		
		// step 2 : get count;
		int count = paymentVoucherGenMapper.count(paymentVoucherGen);
		result.setTotal(count);;
		
		// step 3 : do query
		if (count > 0) {
			List<PaymentVoucherGen> trimList = this.paymentVoucherGenMapper.select(paymentVoucherGen, page);
			// step 3 : fill result
			if (trimList != null && trimList.size() > 0) {
				result.setRows(trimList);
			}
		}
		
		return result;
	}
	
	@Override
	public List<PaymentVoucherGen> list(PaymentVoucherGen paymentVoucherGen, Page page) throws PmException {
		// step 1 : do search
		List<PaymentVoucherGen> list = this.paymentVoucherGenMapper.select(paymentVoucherGen, page);
		if (list == null) {
			list = new ArrayList<PaymentVoucherGen>();
		}
		
		return list;
	}
}
