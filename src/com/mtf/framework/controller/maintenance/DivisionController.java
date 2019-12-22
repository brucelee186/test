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
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.dao.UserInforMapper;
import com.mtf.framework.editor.DateEditor;
import com.mtf.framework.editor.DoubleEditor;
import com.mtf.framework.editor.IntegerEditor;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.DivisionService;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;

/**
 * 部门相关入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version 1.0	2013-5-30	ShouRen.Sun		modified.
 * @version <ver>
 */
@Controller("maintenanceDivisionController")
@RequestMapping("/maintenance/division")
public class DivisionController {

	private static final Logger		logger	= Logger.getLogger(DivisionController.class);
	
	@Autowired
	private IDivisionService		iDivisionService;
	
	private MessageSource			messages;
	
	
	@Autowired
	private DivisionService		divisionService;
	
	@Autowired
	private UserInforMapper userInforMapper;
	
	public DivisionService getDivisionService() {
		return divisionService;
	}

	public void setDivisionService(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@Autowired
	public UserInforMapper getUserInforMapper() {
		return userInforMapper;
	}

	@Autowired
	public void setUserInforMapper(UserInforMapper userInforMapper) {
		this.userInforMapper = userInforMapper;
	}

	@Autowired
	public IDivisionService getiDivisionService() {
		return iDivisionService;
	}

	@Autowired
	public void setiDivisionService(IDivisionService iDivisionService) {
		this.iDivisionService = iDivisionService;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor(true));
		binder.registerCustomEditor(Integer.class, new IntegerEditor(true));
		binder.registerCustomEditor(Double.class, new DoubleEditor(true));
	}
	
	/**
	 * 跳转到部门添加页面
	 * @param session
	 * @return 部门添加页面
	 * @throws PmException
	 */
	@RequestMapping("/toAdd")
	public String toAdd(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		return "maintenance/division/add";
	}
	
	/**
	 * 执行部门添加操作
	 * @param division 部门信息
	 * @param session
	 * @return 执行结果
	 * @throws PmException
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Json doAdd(Division division, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(division.getName()) || TextUtils.getTrimmedLength(division.getName()) == 0) {
			j.setSuccess(false);
			j.setMsg("部门名称不能为空");
			return j;
		}
		division.setUserId(sessionInfo.getUserId());
		try {
			// 设置插入记录类型为部门
			division = this.iDivisionService.add(sessionInfo.getUserId(), division);
			j.setSuccess(true);
			j.setObj(division);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doAddForGroup", method=RequestMethod.POST)
	@ResponseBody
	public Json doAddForGroup(Division division, Integer categoryId, HttpSession session) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (msg.length() > 0) {
			throw new PmException("");
		}
		try {
			this.iDivisionService.addForGroup(division, session);
			
			j.setSuccess(true);
			j.setObj(division);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditForGroup", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditForGroup(Division division, HttpSession session) throws PmException {
		Json j = new Json();
		
		// validate
		StringBuffer msg = new StringBuffer();
		if (msg.length() > 0) {
			throw new PmException("");
		}
		try {
			this.iDivisionService.editForGroup(division, session);
			
			j.setSuccess(true);
			j.setObj(division);
		} catch (PmException e) {
	
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	/**
	 * 跳转到部门检索页面
	 * @param session
	 * @return 部门检索页面
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(Division division, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("/maintenance/division/search");
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		mv.addObject("division", division);
		return mv;
	}
	
	/**
	 * 获取所有部门信息列表
	 * @param session
	 * @return 部门信息列表
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public List<DivisionImpl> doSearch(DivisionImpl division, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<DivisionImpl> listDivision = null;
		try {
			//listDivision = this.iDivisionService.listAll(sessionInfo.getUserId());
			division.setSort("status");
			division.setOrder("ASC");
			listDivision = this.divisionService.select(division);
			// 取得所有职位
			UserInforImpl userInfo = new UserInforImpl();
			userInfo.setFlag("i");
			userInfo.setType("gwmc");
			@SuppressWarnings("unchecked")
			List<UserInforImpl> listUserInfo = (List<UserInforImpl>) userInforMapper.select(userInfo);
			for (int i = 0; i < listDivision.size(); i++) {
				listDivision.get(i).setListBack1(listUserInfo);
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listDivision;
	}
	
	/**
	 * 获取部门信息列表
	 * @param session
	 * @return 部门信息列表
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearchByCategoryId", method=RequestMethod.POST)
	@ResponseBody
	public List<Division> doSearchByCategoryId(Division division, Integer categoryId) throws PmException {
		List<Division> listDivision = null;
		try {
			listDivision = this.iDivisionService.listByCategoryId(division, categoryId);
			
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listDivision;
	}
	
	/**
	 * 获取所有部门信息列表
	 * @param session
	 * @return 部门信息列表
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearchForGroup", method=RequestMethod.POST)
	@ResponseBody
	public List<Division> doSearchForGroup(Division division) throws PmException {
		List<Division> listDivision = null;
		try {
			listDivision = this.iDivisionService.listForGroup(division);
			
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listDivision;
	}
	
	/**
	 * 获取所有部门信息列表
	 * @param session
	 * @return 部门信息列表
	 * @throws PmException
	 */
	/*@RequestMapping(value="/doSearchForAllGroup", method=RequestMethod.POST)
	@ResponseBody
	public List<Division> doSearchForAllGroup(Division division) throws PmException {
		List<Division> listDivision = null;
		try {
			listDivision = this.divisionService.listByCategoryId(division, null);
			
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listDivision;
	}*/
	
	/**
	 * 跳转到部门编辑页面
	 * @param session
	 * @param divisionId 部门编号
	 * @return 部门编辑页面
	 * @throws PmException
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(@RequestParam("divisionId") String divisionId, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/division/edit");
		if (TextUtils.isEmpty(divisionId)) {
			throw new PmException("参数错误");
		}
		Division division = null;
		try {
			division = this.iDivisionService.get(sessionInfo.getUserId(), divisionId);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		if (division == null) {
			throw new PmException("部门不存在");
		}
		mv.addObject("division", division);
		return mv;
	}
	
	/**
	 * 执行部门编辑操作
	 * @param division 部门信息
	 * @param session
	 * @return 执行结果
	 * @throws PmException
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(Division division, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(division.getId())) {
			j.setSuccess(false);
			j.setMsg("参数错误");
			return j;
		} else if (TextUtils.isEmpty(division.getName())) {
			j.setSuccess(false);
			j.setMsg("部门名称不能为空");
			return j;
		}
		division.setUserId(sessionInfo.getUserId());
		try {
			division.setTag("d");
			this.iDivisionService.edit(sessionInfo.getUserId(), division);
			j.setSuccess(true);
			j.setObj(division);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	/**
	 * 执行部门删除操作
	 * @param divisionId 部门编号
	 * @param session
	 * @return 执行结果
	 * @throws PmException
	 */
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Json doDelete(@RequestParam("divisionId") String divisionId, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		if (TextUtils.isEmpty(divisionId)) {
			throw new PmException("参数错误");
		}
		try {
			this.iDivisionService.delete(sessionInfo.getUserId(), divisionId);
			j.setSuccess(true);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
}
