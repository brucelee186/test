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
package com.mtf.payment.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.ICategoryService;
import com.mtf.framework.util.UUIDUtils;

/**
 * 付款协议相关入口控制器
 *
 * @author Bill.Qi
 * @version 1.0	2013-4-25	Bill.Qi		created.
 * @version <ver>
 */
@Controller("paymentCategoryController")
@RequestMapping("/payment/category")
public class CategoryController {

	private ICategoryService	categoryService;

	@Autowired
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	/**
	 * 跳转到搜索Category界面
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public String toSearch() throws PmException {
		return "payment/category";
	}

	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<Category> doSearch(Category category, Page page) throws PmException {
		DataGrid<Category> result = new DataGrid<Category>();
		try {
			List<Category> list = this.categoryService.list(category, page);
			result.setRows(list);
			result.setTotal(list.size());
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}

	@RequestMapping(value="/doList", method=RequestMethod.POST)
	@ResponseBody
	public List<Category> doList(Category category, Page page) throws PmException {
		List<Category> result = null;
		try {
			result = this.categoryService.list(category, page);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}

	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(Category category) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
//		if (StringUtils.isBlank(category.getCpvNo())) {
//			msg.append("名称<br>");
//		}
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
//		category.setId(UUIDUtils.genUUID());
		// process
		try {
			category = this.categoryService.add(category);
			j.setSuccess(true);
			j.setObj(category);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(Category category) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
//		if (StringUtils.isBlank(category.getCpvNo())) {
//			msg.append("名称<br>");
//		}
		if (msg.length() > 0) {
			throw new PmException("");
		}
		
		// process
		try {
			category = this.categoryService.edit(category);
			j.setSuccess(true);
			j.setObj(category);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}

	@RequestMapping(value = "/doGet", method = RequestMethod.POST)
	@ResponseBody
	public Category doGet(Integer id) throws PmException {
		List<Message> errList = new ArrayList<>();

		if (id == null) {
			throw new PmException("参数无效.");
		}

		Category dbCategory = null;
		try {
			dbCategory = this.categoryService.get(id);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return dbCategory;
	}
}
