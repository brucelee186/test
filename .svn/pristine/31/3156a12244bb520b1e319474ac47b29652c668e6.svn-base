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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.service.IRoleService;
import com.mtf.framework.util.Constants;

/**
 * 角色相关入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
@Controller("commonRoleController")
@RequestMapping("/common/role")
public class RoleCommonController {

	private static final Logger		logger	= Logger.getLogger(RoleCommonController.class);
	
	private IRoleService			roleService;
	
	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping("/doDataGrid")
	@ResponseBody
	public DataGrid<RoleImpl> doDataGrid(PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<RoleImpl> result = new DataGrid<RoleImpl>();
		try {
			List<RoleImpl> list = this.roleService.listAllAvailable(sessionInfo.getUserId(), form, 0);
			if (list != null && !list.isEmpty()) {
				result.setTotal(list.size());
				result.setRows(list);
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	@RequestMapping("/doList")
	@ResponseBody
	public List<RoleImpl> doList(PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<RoleImpl> list = null;
		try {
			list = this.roleService.listAll(sessionInfo.getUserId(), form, null, null);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	
	@RequestMapping("/doListPair")
	@ResponseBody
	public List<Pair<String, String>> doListPair(PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<Pair<String, String>> list = null;
		try {
			List<RoleImpl> roleList = this.roleService.listAll(sessionInfo.getUserId(), form, null, "u");
			if (roleList != null && !roleList.isEmpty()) {
				list = new ArrayList<Pair<String, String>>(roleList.size());
				for (RoleImpl role : roleList) {
					list.add(new Pair<String, String>(role.getId(), role.getName()));
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
