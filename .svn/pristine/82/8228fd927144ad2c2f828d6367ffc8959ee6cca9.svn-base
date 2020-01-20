package com.mtf.framework.controller.maintenance;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.service.UserDivisionService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 员工部门中间表
 * 作者:    Auto
 * 日期:    2018/4/8
**********************************************
*/
@Controller("userDivisionController")
@RequestMapping("/maintenance/userDivision")
public class UserDivisionController extends BaseController{

	@Autowired
	private UserDivisionService userDivisionService;

	@Autowired
	public UserDivisionService getUserDivisionService() {
		return userDivisionService;
	}

	@Autowired
	public void setUserDivisionService(UserDivisionService userDivisionService) {
		this.userDivisionService = userDivisionService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/maintenance/userDivision/searchUserDivision");
		return mv;
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<UserDivisionImpl> doSearch(UserDivisionImpl userDivision, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<UserDivisionImpl> list = new DataGrid<UserDivisionImpl>();
		list = this.userDivisionService.search(userDivision);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param userDivision
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(UserDivisionImpl userDivision, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/userDivision/editUserDivision");
		String editState = userDivision.getEditState();
		if ("u".equals(editState)) {
		userDivision = userDivisionService.get(userDivision);
		}
		userDivision.setEditState(editState);
		mv.addObject("userDivision", userDivision);
		return mv;
	}
	
	/**
	 * 跳转编辑
	 * @param userDivision
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doListUserByDivision")
	public ModelAndView doListUserByDivision(UserDivisionImpl userDivision, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenVacateManage/_listUserDivision");
		userDivision.setTagMapper("doListUserByDivision");
		List<UserDivisionImpl> listUserDivision = userDivisionService.select(userDivision);
		mv.addObject("listUserDivision", listUserDivision);
		return mv;
	}

	/**
	 * 编辑
	 * @param userDivision
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(UserDivisionImpl userDivision, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = userDivision.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(userDivision, session);
				userDivisionService.insert(userDivision);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(userDivision, session);
				userDivisionService.update(userDivision);
			} else if ("d".equals(editState)) {
				userDivisionService.delete(userDivision);
			}
			j.setSuccess(true);
			j.setObj(userDivision);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	

}

