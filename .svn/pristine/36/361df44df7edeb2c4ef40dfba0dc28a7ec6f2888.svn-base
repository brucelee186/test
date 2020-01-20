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
import com.mtf.framework.model.PaymentVoucher;
import com.mtf.framework.model.PaymentVoucherItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;

public interface IPaymentVoucherService {

	PaymentVoucher add(PaymentVoucher paymentVoucher, List<PaymentVoucherItem> paymentVoucherItems) throws PmException;

	PaymentVoucher edit(PaymentVoucher paymentVoucher) throws PmException;

	PaymentVoucher get(String id) throws PmException;

	void delete(String id) throws PmException;
	
	List<PaymentVoucher> list(PaymentVoucher paymentVoucher, Page page) throws PmException;

	DataGrid<PaymentVoucher> grid(PaymentVoucher paymentVoucher, Page page) throws PmException;
}
