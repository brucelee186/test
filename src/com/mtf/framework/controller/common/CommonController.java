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
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.Constants;


@Controller("commonController")
@RequestMapping("/common/common")
public class CommonController {
	
	@Autowired
	private UserInforService userInforService;
	
	@Autowired
	private IDivisionService divisionService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;

	@Autowired
	public PermissionService getPermissionService() {
		return permissionService;
	}

	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Autowired
	public IDivisionService getDivisionService() {
		return divisionService;
	}

	@Autowired
	public void setDivisionService(IDivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@Autowired
	public UserInforService getUserInforService() {
		return userInforService;
	}
	
	@Autowired
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@RequestMapping("/checkCode")
	@ResponseBody
	public boolean checkCode(String code, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Map<String, String> mapRolePermission = sessionInfo.getMapRolePermission();
		Set<String> setKey = mapRolePermission.keySet();
		boolean checkResult = setKey.contains(code);
		return checkResult;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/listUserInfo")
	@ResponseBody
	public List<Pair<String, String>> listUserInfo(UserInforImpl userInfor) throws PmException {
		List<Pair<String, String>> list = null;
		try {
			// 查询明细数据
			userInfor.setFlag("i");
			// 按code排序
			userInfor.setSort("orderIndex");
			// 状态(a 启用, f 禁用)
			userInfor.setStatus("a");
			List<UserInforImpl> listUserInfor = userInforService.search(userInfor);
			if (listUserInfor != null && !listUserInfor.isEmpty()) {
				list = new ArrayList<Pair<String, String>> (listUserInfor.size());
				for (UserInforImpl userInfo : listUserInfor) {
					list.add(new Pair<String, String>(userInfo.getCode(), userInfo.getName()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}	
	
	@RequestMapping("/doListPermissionDivision")
	@ResponseBody
	public List<PermissionImpl> doListPermissionDivision(@RequestParam(value="tag", required=false) Integer tag, HttpSession session) throws PmException {
		List<PermissionImpl> listDivision = new ArrayList<>();
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		try {
			// 取得用户部门审批权限
			PermissionImpl permission = new PermissionImpl();
			permission.setParentCode("1403000");
			permission.setUserId(sessionInfo.getUserId());
			listDivision = permissionService.searchUserDivisionByPermission(permission);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listDivision;
	}
	
	public List<UserImpl> searchUserListByPermission(String permissionCode) {
		List<UserImpl> listUser = new ArrayList<>();
		try {
			UserImpl user = new UserImpl();
			user.setCode(permissionCode);
			listUser = userService.selectUserByPermission(user);
		} catch (PmException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public UserImpl getUserByPermission(String permissionCode) {
		UserImpl user = new UserImpl();
		List<UserImpl> listUser = new ArrayList<>();
		try {
			user.setCode(permissionCode);
			listUser = userService.selectUserByPermission(user);
			if (null != listUser && listUser.size() == 1) {
				user = listUser.get(0);
			}
		} catch (PmException e) {
			e.printStackTrace();
		}
		return user;
	}
}
