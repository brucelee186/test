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

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.RbsCategory;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.service.IRbsCategoryService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.JacksonUtils;

/**
 * 付款协议相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2013-4-25	Bill.Qi		created.
 * @version <ver>
 */
@Controller("maintenanceRbsCategoryController")
@RequestMapping("/maintenance/rbsCategory")
public class RbsCategoryController {

	private IRbsCategoryService	rbsCategoryService;

	@Autowired
	public void setRbsCategoryService(IRbsCategoryService rbsCategoryService) {
		this.rbsCategoryService = rbsCategoryService;
	}
	
	
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(RbsCategory rbsCategory) throws PmException {
		
		ModelAndView mv = new ModelAndView("maintenance/category2division/search");
		
		return mv;
	}
	

	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public List<RbsCategory> doSearch(RbsCategory rbsCategory, Page page) throws PmException {
		//DataGrid<RbsCategory> result = new DataGrid<RbsCategory>();
		List<RbsCategory> list = new ArrayList<RbsCategory>();
		
		try {
			list = this.rbsCategoryService.list(rbsCategory, page);
			/*result.setRows(list);
			result.setTotal(list.size());*/
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}

	@RequestMapping(value="/doList", method=RequestMethod.POST)
	@ResponseBody
	public List<RbsCategory> doList(RbsCategory rbsCategory, Page page) throws PmException {
		List<RbsCategory> result = null;
		try {
			result = this.rbsCategoryService.list(rbsCategory, page);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	
	@RequestMapping(value="/doListForLv1", method=RequestMethod.POST)
	@ResponseBody
	public List<RbsCategory> doListForLv1(RbsCategory rbsCategory, Page page) throws PmException {
		List<RbsCategory> result = null;
		try {
			result = this.rbsCategoryService.listForLv1(rbsCategory);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}

	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(RbsCategory rbsCategory) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		try {
			rbsCategory = this.rbsCategoryService.add(rbsCategory);
			j.setSuccess(true);
			j.setObj(rbsCategory);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doAddForDivision", method=RequestMethod.POST)
	@ResponseBody
	public Json doAddForDivision(RbsCategory rbsCategory) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		try {
			rbsCategory = this.rbsCategoryService.add(rbsCategory);
			j.setSuccess(true);
			j.setObj(rbsCategory);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(RbsCategory rbsCategory) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
//		if (StringUtils.isBlank(rbsCategory.getCpvNo())) {
//			msg.append("名称<br>");
//		}
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		// process
		try {
			rbsCategory = this.rbsCategoryService.edit(rbsCategory);
			j.setSuccess(true);
			j.setObj(rbsCategory);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}

	@RequestMapping(value = "/doGet", method = RequestMethod.POST)
	@ResponseBody
	public RbsCategory doGet(Integer id) throws PmException {
		List<Message> errList = new ArrayList<>();

		if (id == null) {
			throw new PmException("参数无效.");
		}

		RbsCategory dbCategory = null;
		try {
			dbCategory = this.rbsCategoryService.get(id);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return dbCategory;
	}
	
}
