package com.mtf.framework.controller.attendance;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.UserDetail;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.model.impl.AttenVacateImpl;
import com.mtf.framework.model.impl.AttenVacateRuleImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.AttenVacateRuleService;
import com.mtf.framework.service.AttenVacateService;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.service.UserService;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 请假天数限定
 * 作者:    Auto
 * 日期:    2015/7/26
 **********************************************
 */
@Controller("attenVacateRuleController")
@RequestMapping("/attendance/attenVacateRule")
public class AttenVacateRuleController extends BaseController {

	@Autowired
	private AttenVacateRuleService attenVacateRuleService;

	@Autowired
	private AttenVacateService attenVacateService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDetailService getUserDetailService() {
		return userDetailService;
	}

	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	public AttenVacateService getAttenVacateService() {
		return attenVacateService;
	}

	public void setAttenVacateService(AttenVacateService attenVacateService) {
		this.attenVacateService = attenVacateService;
	}

	@Autowired
	public AttenVacateRuleService getAttenVacateRuleService() {
		return attenVacateRuleService;
	}

	@Autowired
	public void setAttenVacateRuleService(
			AttenVacateRuleService attenVacateRuleService) {
		this.attenVacateRuleService = attenVacateRuleService;
	}

	/**
	 * 跳转页面
	 * 
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView(
				"/attendance/attenVacateRule/searchAttenVacateRule");
		// 加载时间段json
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArrayUser = new JSONArray();
		List<AttenVacateImpl> listAttenVacate = null;
		try {
			AttenVacateImpl attenVacate = new AttenVacateImpl();
			attenVacate.setTagType("m");
			listAttenVacate = this.attenVacateService.select(attenVacate);
			jsonArray.add(listAttenVacate);
			UserImpl user = new UserImpl();
			user.setStatus("0");
			List<UserImpl> listUser = userService.select(user);
			jsonArrayUser.add(listUser);
		} catch (PmException e) {
			e.printStackTrace();
		}
		mv.addObject("jsonListAttenVacate", jsonArray.toString());
		mv.addObject("jsonArrayUser", jsonArrayUser.toString());
		return mv;
	}

	/**
	 * 查询
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	@ResponseBody
	public DataGrid<AttenVacateRuleImpl> doSearch(
			AttenVacateRuleImpl attenVacateRule, HttpSession session)
			throws Exception {
		new PmException(session);
		DataGrid<AttenVacateRuleImpl> list = new DataGrid<AttenVacateRuleImpl>();
		list = this.attenVacateRuleService.search(attenVacateRule);
		return list;
	}

	/**
	 * 跳转编辑
	 * 
	 * @param attenVacateRule
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenVacateRuleImpl attenVacateRule,
			HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView(
				"/attendance/attenVacateRule/editAttenVacateRule");
		String editState = attenVacateRule.getEditState();
		if ("u".equals(editState)) {
			attenVacateRule = attenVacateRuleService.get(attenVacateRule);
		}
		attenVacateRule.setEditState(editState);
		mv.addObject("attenVacateRule", attenVacateRule);
		return mv;
	}

	/**
	 * 编辑
	 * 
	 * @param attenVacateRule
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenVacateRuleImpl attenVacateRule, HttpSession session)
			throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenVacateRule.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attenVacateRule, session);
				attenVacateRuleService.insert(attenVacateRule);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenVacateRule, session);
				attenVacateRuleService.update(attenVacateRule);
			} else if ("d".equals(editState)) {
				attenVacateRuleService.delete(attenVacateRule);
			}
			j.setSuccess(true);
			j.setObj(attenVacateRule);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}
