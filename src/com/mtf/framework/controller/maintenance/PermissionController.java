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
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.service.PermissionService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 权限列表
 * 作者:    Auto
 * 日期:    2015/2/11
**********************************************
*/
@Controller("permissionController")
@RequestMapping("/maintenance/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@Autowired
	public PermissionService getPermissionService() {
		return permissionService;
	}

	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/maintenance/permission/searchPermission");
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
	public DataGrid<PermissionImpl> doSearch(PermissionImpl permission, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<PermissionImpl> list = new DataGrid<PermissionImpl>();
		list = this.permissionService.search(permission);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param permission
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(PermissionImpl permission, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/permission/editPermission");
		String editState = permission.getEditState();
		if ("u".equals(editState)) {
		permission = permissionService.get(permission);
		}
		permission.setEditState(editState);
		mv.addObject("permission", permission);
		return mv;
	}

	/**
	 * 编辑
	 * @param permission
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(PermissionImpl permission, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = permission.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(permission, session);
				permissionService.insert(permission);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(permission, session);
				permissionService.update(permission);
			} else if ("d".equals(editState)) {
				permissionService.delete(permission);
			}
			j.setSuccess(true);
			j.setObj(permission);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

