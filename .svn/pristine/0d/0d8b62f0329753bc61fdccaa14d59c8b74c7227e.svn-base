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

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.editor.DateEditor;
import com.mtf.framework.editor.DoubleEditor;
import com.mtf.framework.editor.IntegerEditor;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Action;
import com.mtf.framework.model.Role;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.service.IRoleService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;

/**
 * 角色相关入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
@Controller("maintenanceRoleController")
@RequestMapping("/maintenance/role")
public class RoleController extends BaseController{

	private static final Logger		logger	= Logger.getLogger(RoleController.class);
	
	private IRoleService			roleService;
	
	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor(true));
		binder.registerCustomEditor(Integer.class, new IntegerEditor(true));
		binder.registerCustomEditor(Double.class, new DoubleEditor(true));
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/role/add");
		return mv;
	}
	
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Json doAdd(RoleImpl role, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(role.getName()) || TextUtils.getTrimmedLength(role.getName()) == 0) {
			j.setSuccess(false);
			j.setMsg("角色名称不能为空");
			return j;
		} else if (role.getLevel() == null || role.getLevel() < 1 || role.getLevel() > 9) {
			j.setSuccess(false);
			j.setMsg("角色等级错误");
			return j;
		}
		// set to 'user' role
		role.setSystem(0);
		try {
			role = this.roleService.add(sessionInfo.getUserId(), role);
			j.setSuccess(true);
			j.setObj(role);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(@RequestParam("id") String id, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/role/edit");
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("参数错误");
		}
		try {
			RoleImpl role = this.roleService.get(sessionInfo.getUserId(), id);
			if (role == null) {
				throw new PmException("角色不存在");
			}
			mv.addObject("role", role);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return mv;
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(RoleImpl role, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(role.getId())) {
			j.setSuccess(false);
			j.setMsg("参数错误");
			return j;
		} else if (TextUtils.isEmpty(role.getName())) {
			j.setSuccess(false);
			j.setMsg("角色名称不能为空");
			return j;
		} else if (role.getLevel() == null || role.getLevel() < 1 || role.getLevel() > 9) {
			j.setSuccess(false);
			j.setMsg("角色等级错误");
			return j;
		}
		role.setUserId(sessionInfo.getUserId());
		role.setSystem(0);
		try {
			role = this.roleService.edit(sessionInfo.getUserId(), role);
			j.setSuccess(true);
			j.setObj(role);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Json doDelete(RoleImpl role, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(role.getId())) {
			j.setSuccess(false);
			j.setMsg("参数错误");
			return j;
		} 

		try {
			this.roleService.delete(getUserId(), role.getId());
			j.setSuccess(true);
			j.setObj(role);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping("/toEditActions")
	public ModelAndView toEditActions(@RequestParam("id") String id, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/role/editActions");
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("参数错误");
		}
		try {
			RoleImpl role = this.roleService.getWithActions(sessionInfo.getUserId(), id);
			if (role == null) {
				throw new PmException("角色不存在");
			} else if (role.getSystem() == 1) {
				throw new PmException("不能编辑系统角色");
			}
			mv.addObject("role", role);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return mv;
	}
	
	
	@RequestMapping(value = "/doEditActions", method = RequestMethod.POST)
	@ResponseBody
	public Json doEditActions(@RequestParam("id") String id,
	                          @RequestParam("actionIds") String actionIds,
	                          HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			j.setSuccess(false);
			j.setMsg("参数错误");
			return j;
		}
		try {
			String[] actions = null;
			if (!TextUtils.isEmpty(actionIds) && TextUtils.getTrimmedLength(actionIds) > 0) {
				actions = actionIds.split(",");
			}
			this.roleService.editActions(sessionInfo.getUserId(), id.trim(), actions);
			j.setSuccess(true);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value = "/doSearchActions", method = RequestMethod.POST)
	@ResponseBody
	public DataGrid<Action> doSearchActions(@RequestParam("id") String id, PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<Action> result = new DataGrid<Action>();
		// validate
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("参数错误");
		}
		try {
			RoleImpl role = this.roleService.getWithActions(sessionInfo.getUserId(), id);
			if (role == null) {
				throw new PmException("角色不存在");
			}
			List<Action> actions = role.getActions();
			if (actions != null && !actions.isEmpty()) {
				result.setRows(actions);
				result.setTotal(actions.size());
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/role/search");
		return mv;
	}
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<RoleImpl> doSearch(PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<RoleImpl> result = new DataGrid<RoleImpl>();
		try {
			List<RoleImpl> list = this.roleService.listAll(sessionInfo.getUserId(), form, null, null);
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
	
	@RequestMapping(value="/doSearch4User", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<RoleImpl> doSearch4User(PageForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<RoleImpl> result = new DataGrid<RoleImpl>();
		try {
			List<RoleImpl> list = this.roleService.listAll(sessionInfo.getUserId(), form, null,null);
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
	
	@RequestMapping(value="/doList", method=RequestMethod.POST)
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
}
