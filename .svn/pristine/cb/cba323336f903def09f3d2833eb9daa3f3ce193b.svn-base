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

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mtf.framework.editor.DoubleEditor;
import com.mtf.framework.editor.IntegerEditor;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Unit;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.service.IUnitService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;




@Controller("maintenanceUnitController")
@RequestMapping("/maintenance/unit")
public class UnitController {

	private static final Logger		logger	= Logger.getLogger(UnitController.class);
	
	private IUnitService			unitService;
	private MessageSource			messages;
	
	
	@Autowired
	public void setUnitService(IUnitService unitService) {
		this.unitService = unitService;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		
		binder.registerCustomEditor(Integer.class, new IntegerEditor(true));
		binder.registerCustomEditor(Double.class, new DoubleEditor(true));
	}
	
	/**
	 * 执行添加Unit操作，返回Json
	 * @param unit
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(Unit unit, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(unit.getName())) {
			j.setSuccess(false);
			j.setMsg("From不能为空");
			return j;
		}
		try {
			unit = this.unitService.add(sessionInfo.getUserId(), unit);
			j.setSuccess(true);
			j.setObj(unit);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	/**
	 * 执行编辑Unit操作，返回Json
	 * @param unit
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(Unit unit, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(unit.getId())) {
			j.setSuccess(false);
			j.setMsg("id不能为空");
			return j;
		} else if (TextUtils.isEmpty(unit.getName())) {
			j.setSuccess(false);
			j.setMsg("From不能为空");
			return j;
		} 
		try {
			unit = this.unitService.edit(sessionInfo.getUserId(), unit);
			j.setSuccess(true);
			j.setObj(unit);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	/**
	 * 跳转到搜索Unit界面
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public String toSearch(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		return "maintenance/basic/unit";
	}
	
	/**
	 * 执行搜索Unit操作，返回DataGrid
	 * @param form
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<Unit> doSearch(PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<Unit> result = new DataGrid<Unit>();
		try {
			List<Unit> list = this.unitService.listAll(sessionInfo.getUserId(), form);
			if (list != null && !list.isEmpty()) {
				result.setRows(list);
				result.setTotal(list.size());
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	

}
