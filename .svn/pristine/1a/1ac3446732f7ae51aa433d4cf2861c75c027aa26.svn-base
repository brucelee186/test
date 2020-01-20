package com.mtf.framework.controller.maintenance;

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
import com.mtf.framework.model.impl.DivisionRoleImpl;
import com.mtf.framework.service.DivisionRoleService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 部门角色
 * 作者:    Auto
 * 日期:    2016/6/30
**********************************************
*/
@Controller("divisionRoleController")
@RequestMapping("/maintenance/divisionRole")
public class DivisionRoleController extends BaseController{

	@Autowired
	private DivisionRoleService divisionRoleService;

	@Autowired
	public DivisionRoleService getDivisionRoleService() {
		return divisionRoleService;
	}

	@Autowired
	public void setDivisionRoleService(DivisionRoleService divisionRoleService) {
		this.divisionRoleService = divisionRoleService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/maintenance/divisionRole/searchDivisionRole");
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
	public DataGrid<DivisionRoleImpl> doSearch(DivisionRoleImpl divisionRole, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<DivisionRoleImpl> list = new DataGrid<DivisionRoleImpl>();
		list = this.divisionRoleService.search(divisionRole);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param divisionRole
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(DivisionRoleImpl divisionRole, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/divisionRole/editDivisionRole");
		String editState = divisionRole.getEditState();
		if ("u".equals(editState)) {
		divisionRole = divisionRoleService.get(divisionRole);
		}
		divisionRole.setEditState(editState);
		mv.addObject("divisionRole", divisionRole);
		return mv;
	}

	/**
	 * 编辑
	 * @param divisionRole
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(DivisionRoleImpl divisionRole, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = divisionRole.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(divisionRole, session);
				divisionRoleService.insert(divisionRole);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(divisionRole, session);
				divisionRoleService.update(divisionRole);
			} else if ("d".equals(editState)) {
				divisionRoleService.delete(divisionRole);
			}
			j.setSuccess(true);
			j.setObj(divisionRole);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

