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
package com.mtf.framework.controller.maintenance;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.Tetrad;
import com.mtf.framework.model.impl.CustomerImpl;
import com.mtf.framework.service.CustomerService;
import com.mtf.framework.util.Utils;




/**
 * Description
 *
 * @author BillQi
 * @version 1.0	2013-7-15	BillQi		created.
 * @version <ver>
 */
@Controller("maintenanceCustomerController")
@RequestMapping("/maintenance/customer")
public class CustomerController extends BaseController{

	private static final Logger		logger	= Logger.getLogger(CustomerController.class);
	
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping("/doListTetrad")
	@ResponseBody
	public List<Tetrad<String, String, String, String>> doListTetrad(CustomerImpl customer, Integer aps) throws PmException {
		List<Tetrad<String, String, String, String>> list = null;
		try {
			customer.setStatus(0);
			list = this.customerService.listTetrad(customer);
			Utils.addTetradAPS(list, aps);
		} catch (PmException e) {
			List<Message> errList = new ArrayList<Message>();
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return list;
	}
}


