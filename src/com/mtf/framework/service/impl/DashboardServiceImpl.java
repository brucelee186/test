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

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.DashboardMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Payment;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ApplicationImpl;
import com.mtf.framework.model.impl.ContractImpl;
import com.mtf.framework.model.impl.PaymentImpl;
import com.mtf.framework.service.DashboardService;


/**
 * Description
 *
 * @author BillQi
 * @version 1.0	2013-8-22	BillQi		created.
 * @version <ver>
 */
@Service("dashboardService")
public class DashboardServiceImpl implements DashboardService {

	private DashboardMapper dashboradMapper;
	
	@Autowired
	public void setDashboradMapper(DashboardMapper dashboradMapper) {
		this.dashboradMapper = dashboradMapper;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ContractImpl> select(String uid,ContractImpl contractImpl)
			throws PmException {
		Object obj = contractImpl;
		List<ContractImpl> lc = dashboradMapper.selectAll(contractImpl);
		return lc;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ApplicationImpl> select(String uid,ApplicationImpl applicationImpl)
			throws PmException {
		Object obj = applicationImpl;
		List<ApplicationImpl> lc = dashboradMapper.selectAllForApplication(applicationImpl);
		return lc;
	}

	



}
