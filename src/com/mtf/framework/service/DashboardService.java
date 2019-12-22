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
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.impl.ApplicationImpl;
import com.mtf.framework.model.impl.ContractImpl;
import com.mtf.framework.model.impl.PaymentImpl;



/**
 * Description
 * 控制台
 * @author BillQi
 * @version 1.0	2013-8-22	BillQi		created.
 * @version <ver>
 */
public interface DashboardService {
	
	
	List<ContractImpl> select(String uid, ContractImpl contractImpl) throws PmException;
	List<ApplicationImpl> select(String uid, ApplicationImpl applicationImpl) throws PmException;
	
}
