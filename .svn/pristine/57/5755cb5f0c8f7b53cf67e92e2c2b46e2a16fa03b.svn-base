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
package com.mtf.framework.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.common.Triple;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.util.Constants;

/**
 * 部门相关入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
@Controller("commonDivisionController")
@RequestMapping("/common/division")
public class DivisionCommonController {

	private static final Logger		logger	= Logger.getLogger(DivisionCommonController.class);
	
	private IDivisionService		divisionService;
	
	
	@Autowired
	public void setDivisionService(IDivisionService divisionService) {
		this.divisionService = divisionService;
	}
	
	@RequestMapping("/doList")
	@ResponseBody
	public List<Division> doList(@RequestParam(value="tag", required=false) String tag, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<Division> result = new ArrayList<>();
		try {
			List<DivisionImpl> resultTemp = this.divisionService.listAvailable(sessionInfo.getUserId(), tag);
			Division division = new Division();
			division.setId("NULL");
			division.setName("- -");
			division.setPid(null);
			result.add(division);
			result.addAll(resultTemp);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListPair")
	@ResponseBody
	public List<Triple<String, String, String>> doListPair(@RequestParam(value="tag", required=false) String tag, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<Triple<String, String, String>> list = null;
		try {
			List<DivisionImpl> divisionList = this.divisionService.listAvailable(sessionInfo.getUserId(), tag);
			if (divisionList != null && !divisionList.isEmpty()) {
				list = new ArrayList<Triple<String, String, String>>(divisionList.size());
				for (DivisionImpl division : divisionList) {
					list.add(new Triple<String, String, String>(division.getId(), division.getName(),division.getLevel().toString()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}
}
