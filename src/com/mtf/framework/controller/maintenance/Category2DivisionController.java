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
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.dao.UserInforMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category2Division;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.service.ICategory2DivisionService;
import com.mtf.framework.util.JacksonUtils;
import com.mtf.framework.util.UUIDUtils;

/**
 * 类别部门相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2015-4-13	Bill.Qi		created.
 * @version <ver>
 * @version <ver>
 */
@Controller("maintenanceCategory2DivisionController")
@RequestMapping("/maintenance/category2division")
public class Category2DivisionController extends BaseController{

	private static final Logger		logger	= Logger.getLogger(Category2DivisionController.class);
	
	private ICategory2DivisionService	category2DivisionService;
	private MessageSource				messages;
	
	@Autowired
	private UserInforMapper userInforMapper;
	
	@Autowired
	public UserInforMapper getUserInforMapper() {
		return userInforMapper;
	}

	@Autowired
	public void setUserInforMapper(UserInforMapper userInforMapper) {
		this.userInforMapper = userInforMapper;
	}

	@Autowired
	public void setCategory2DivisionService(ICategory2DivisionService category2DivisionService) {
		this.category2DivisionService = category2DivisionService;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	
	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(Category2Division category2Division) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (msg.length() > 0) {
			throw new PmException("");
		}
		try {
			this.category2DivisionService.add(category2Division);
			
			j.setSuccess(true);
			j.setObj(category2Division);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(Category2Division category2Division, String divisionIds) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();

		// validate
		List<String> divisionIdsList = JacksonUtils.jsonArrayToList(divisionIds, String.class);
		/*if(divisionIdsList.size() == 0){
			throw new PmException("Paramater 'divisionIds' is invalid!");
		}*/
		for (String divisionId : divisionIdsList) {
			if (!UUIDUtils.isValidUUID(divisionId)) {
				throw new PmException("Paramater 'divisionId' is invalid!");
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		
		try {
			this.category2DivisionService.edit(category2Division, divisionIdsList);
			
			j.setSuccess(true);
			j.setObj(divisionIdsList);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doDelete", method=RequestMethod.POST)
	@ResponseBody
	public Json doDelete(Category2Division category2Division) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (msg.length() > 0) {
			throw new PmException("");
		}
		try {
			this.category2DivisionService.delete(category2Division.getId());
			
			j.setSuccess(true);
			j.setObj(category2Division);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	
}
