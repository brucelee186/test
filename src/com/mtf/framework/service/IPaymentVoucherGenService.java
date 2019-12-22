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
package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PaymentVoucherGen;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;

public interface IPaymentVoucherGenService {

	PaymentVoucherGen add(PaymentVoucherGen paymentVoucherGen) throws PmException;

	PaymentVoucherGen edit(PaymentVoucherGen paymentVoucherGen) throws PmException;

	PaymentVoucherGen get(Integer id) throws PmException;

	void delete(Integer id) throws PmException;
	
	List<PaymentVoucherGen> list(PaymentVoucherGen paymentVoucherGen, Page page) throws PmException;

	DataGrid<PaymentVoucherGen> grid(PaymentVoucherGen paymentVoucherGen, Page page) throws PmException;
}
