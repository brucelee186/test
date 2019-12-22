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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.mail.EmailException;
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

import com.alibaba.fastjson.JSONObject;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.editor.DateEditor;
import com.mtf.framework.editor.DoubleEditor;
import com.mtf.framework.editor.IntegerEditor;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.History;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.model.page.UserSearchForm;
import com.mtf.framework.service.DivisionRoleService;
import com.mtf.framework.service.DivisionService;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.HistoryService;
import com.mtf.framework.service.IUser2DivisionService;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;

/**
 * 用户相关入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
@Controller("maintenanceUserController")
@RequestMapping("/maintenance/user")
public class UserController extends BaseController{

	private static final Logger		logger	= Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService			userService;
	private MessageSource			messages;
	private IUser2DivisionService	user2DivisionService;
	private HistoryService historyService;
	
	@Autowired
	private DivisionRoleService divisionRoleService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
	public UserDetailConditionMapper getUserDetailConditionMapper() {
		return userDetailConditionMapper;
	}

	public void setUserDetailConditionMapper(
			UserDetailConditionMapper userDetailConditionMapper) {
		this.userDetailConditionMapper = userDetailConditionMapper;
	}

	@Autowired
	public DivisionService getDivisionService() {
		return divisionService;
	}

	@Autowired
	public void setDivisionService(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@Autowired
	public UserDetailService getUserDetailService() {
		return userDetailService;
	}

	@Autowired
	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	@Autowired
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public EmailService getEmailService() {
		return emailService;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Autowired
	public DivisionRoleService getDivisionRoleService() {
		return divisionRoleService;
	}

	@Autowired
	public void setDivisionRoleService(DivisionRoleService divisionRoleService) {
		this.divisionRoleService = divisionRoleService;
	}

	@Autowired
	private UserInforService userInforService;

	@Autowired
	public UserInforService getUserInforService() {
		return userInforService;
	}

	@Autowired
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	
	@Autowired
	public void setUser2DivisionService(IUser2DivisionService user2DivisionService) {
		this.user2DivisionService = user2DivisionService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		ModelAndView mv = new ModelAndView("maintenance/user/editUser");
		UserImpl UserImpl = new UserImpl();
		UserImpl.setEditState("i");
		mv.addObject("user", UserImpl);
		return mv;
	}
	
	
	@RequestMapping("/toAddUser")
	public ModelAndView toAddUser(UserImpl UserImpl) throws PmException {
		ModelAndView mv = new ModelAndView("maintenance/user/addUser");
		UserImpl.setEditState("i");
		// 设置状态为初始化添加
		UserImpl.setStateInit("r");
		mv.addObject("user", UserImpl);
		return mv;
	}
	
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Json doAdd(UserImpl UserImpl, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(UserImpl.getLoginName())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.uidpwdempty", null, null));
			return j;
		} else if (TextUtils.getTrimmedLength(UserImpl.getLoginName()) < 3 || !TextUtils.isPrintableAsciiOnly(UserImpl.getLoginName().trim())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.invalid.loginname", null, null));
			return j;
		} else if (TextUtils.indexOf(UserImpl.getLoginName().trim(), ' ') != -1) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.invalid.loginname.whitechar", null, null));
			return j;
		} else if (TextUtils.isEmpty(UserImpl.getPassword())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.uidpwdempty", null, null));
			return j;
		} else if (TextUtils.getTrimmedLength(UserImpl.getPassword()) < 6 || TextUtils.getTrimmedLength(UserImpl.getPassword()) > 30) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.pwdlengthinvalid", null, null));
			return j;
		} else if (TextUtils.isEmpty(UserImpl.getUserProfile().getFullname())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.uidpwdempty", null, null));
			return j;
		}
		UserImpl.setUserId(sessionInfo.getUserId());
		try {
			UserImpl = this.userService.add(sessionInfo.getUserId(), UserImpl);
			j.setSuccess(true);
			j.setObj(UserImpl);
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
		ModelAndView mv = new ModelAndView("maintenance/user/editUser");
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("参数错误");
		}
		try {
			UserImpl UserImpl = this.userService.getWithProfile(sessionInfo.getUserId(), id.trim());
			if (UserImpl == null) {
				throw new PmException("用户不存在");
			}
			UserImpl.setEditState("u");
			mv.addObject("user", UserImpl);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return mv;
	}
	
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(UserImpl userImpl, HttpSession session) throws PmException {
		String stateInit = userImpl.getStateInit();
		// 如果是用户注册状态那么没有session可以正常使用  regist:rr
		String editState = userImpl.getEditState();
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(userImpl.getLoginName())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.uidpwdempty", null, null));
			return j;
		} else if (TextUtils.getTrimmedLength(userImpl.getLoginName()) < 3 || !TextUtils.isPrintableAsciiOnly(userImpl.getLoginName().trim())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.invalid.loginname", null, null));
			return j;
		} else if (TextUtils.indexOf(userImpl.getLoginName().trim(), ' ') != -1) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.invalid.loginname.whitechar", null, null));
			return j;
		}
		if (!"r".equals(stateInit)) {
			if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
				throw new PmException(PmException.CODE_NOSESSION);
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
			userImpl.setUserId(sessionInfo.getUserId());
			try {
				if (editState.equals("i")) {
					this.userService.add(sessionInfo.getUserId(), userImpl);
				} else if (editState.equals("u")) {
					if (TextUtils.isEmpty(userImpl.getId())) {
						j.setSuccess(false);
						j.setMsg("参数错误");
						return j;
					}
					this.userService.edit(sessionInfo.getUserId(), userImpl);
				}
				j.setObj(userImpl);
				j.setSuccess(true);
			} catch (PmException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
		} else {
			UserImpl userTemp = new UserImpl();
			if (editState.equals("i")) {
				// 0启用、1禁用、2注册、3驳回
				userImpl.setStatus("2");
				userImpl.setAddDate(new Date());
				userImpl.setModifyDate(new Date());
				// 姓
				String	lastName = userImpl.getLastName();
				// 名
				String	firstName = userImpl.getFirstName();
				String displayName = (lastName + firstName);
				userImpl.setDisplayName(displayName);
				userTemp = this.userService.add("", userImpl);
			}
			if (TextUtils.isEmpty(userImpl.getId())) {
				j.setSuccess(false);
				j.setMsg("参数错误");
				return j;
			}
			j.setObj(userTemp);
			j.setSuccess(true);
		}
		return j;
	}
	
	@RequestMapping("/toPassword")
	public ModelAndView toPassword(@RequestParam("id") String id, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/user/password");
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("参数错误");
		}
		if ("460f4f88-52c2-4d50-8275-0d0739e6237d".equalsIgnoreCase(id.trim())) {
			throw new PmException("内置用户不能编辑");
		}
		try {
			UserImpl UserImpl = this.userService.getWithProfile(sessionInfo.getUserId(), id.trim());
			if (UserImpl == null) {
				throw new PmException("用户不存在");
			}
			mv.addObject("user", UserImpl);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return mv;
	}
	
	@RequestMapping(value = "/doPassword", method = RequestMethod.POST)
	@ResponseBody
	public Json doPassword(UserImpl UserImpl, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(UserImpl.getId())) {
			j.setSuccess(false);
			j.setMsg("参数错误");
			return j;
		}
		if ("460f4f88-52c2-4d50-8275-0d0739e6237d".equalsIgnoreCase(UserImpl.getId())) {
			j.setSuccess(false);
			j.setMsg("内置用户不能编辑");
		}
		if (TextUtils.isEmpty(UserImpl.getPassword())) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.pwdempty", null, null));
			return j;
		} else if (TextUtils.getTrimmedLength(UserImpl.getPassword()) < 6 || TextUtils.getTrimmedLength(UserImpl.getPassword()) > 30) {
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("c_user.pwdlength", null, null));
			return j;
		}
		UserImpl.setUserId(sessionInfo.getUserId());
		try {
			this.userService.editPassword(sessionInfo.getUserId(), null, UserImpl);
			j.setSuccess(true);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping("/toEditRoles")
	public ModelAndView toEditRoles(UserImpl userImpl, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("maintenance/user/editRoles");
		String id = userImpl.getId();
		String divisionId = userImpl.getDivisionId();
		if (null != id) {
			if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
				throw new PmException(PmException.CODE_NOSESSION);
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
			if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
				throw new PmException("参数错误");
			}
			userImpl = null;
			try {
				userImpl = this.userService.getWithRoles(sessionInfo.getUserId(), id.trim());
			} catch (PmException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
			if (userImpl == null) {
				throw new PmException("用户不存在");
			}
			userImpl.setId(id);
			mv.addObject("user", userImpl);
			if (userImpl.getRoles() != null && !userImpl.getRoles().isEmpty()) {
				mv.addObject("roleList", JSONObject.toJSON(userImpl.getRoles()).toString());
			}
		}
		else if (null != divisionId) {
			mv.addObject("user", userImpl);
		}
		return mv;
	}
	
	@RequestMapping("/doSearchRoles")
	@ResponseBody
	public DataGrid<RoleImpl> doSearchRoles(UserImpl userImpl, HttpSession session) throws PmException {
		DataGrid<RoleImpl> result = new DataGrid<RoleImpl>();
		String id = userImpl.getId();
		String divisionId = userImpl.getDivisionId();
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		if (null != id && !"".equals(id)) {
			if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
				throw new PmException("参数错误");
			}
			try {
				userImpl = this.userService.getWithRoles(sessionInfo.getUserId(), id);
				if (userImpl == null) {
					throw new PmException("用户不存在");
				}
				if (userImpl.getRoles() != null && !userImpl.getRoles().isEmpty()) {
					//new add
					/*for(int i = 0; i < UserImpl.getRoles().size(); i++){
					System.out.println("++++");
					System.out.println(UserImpl.getRoles().get(i).getId());
				}*/
					result.setRows(userImpl.getRoles());
					result.setTotal(userImpl.getRoles().size());
				}
			} catch (PmException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
		}
		else if (null != divisionId) {
			try {
				userImpl = this.userService.getWithRolesDivision(sessionInfo.getUserId(), divisionId);
				if (userImpl.getRoles() != null && !userImpl.getRoles().isEmpty()) {
					//new add
					/*for(int i = 0; i < UserImpl.getRoles().size(); i++){
					System.out.println("++++");
					System.out.println(UserImpl.getRoles().get(i).getId());
				}*/
					result.setRows(userImpl.getRoles());
					result.setTotal(userImpl.getRoles().size());
				}
			} catch (PmException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
			
		}
		return result;
	}
	
	@RequestMapping("/toEditActions")
	public ModelAndView toEditActions(@RequestParam("userId") String userId, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/user/editActions");
		if (TextUtils.isEmpty(userId) || TextUtils.getTrimmedLength(userId) == 0) {
			throw new PmException("参数错误");
		}
		try {
			UserImpl userImpl = this.userService.get(sessionInfo.getUserId(), userId);
			if (userImpl == null) {
				throw new PmException("用户不存在");
			}
			mv.addObject("user", userImpl);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return mv;
	}
	
	@RequestMapping(value = "/doEditRoles", method = RequestMethod.POST)
	@ResponseBody
	public Json doEditRoles(UserImpl userImpl, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		String userId = userImpl.getId();
        String roleIds= userImpl.getRoleIds();
        String divisionId = userImpl.getDivisionId();
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		Json j = new Json();
		if (null != userId && !"".equals(userId)) {
			// validate
			if (TextUtils.isEmpty(userId) || TextUtils.getTrimmedLength(userId) == 0) {
				j.setSuccess(false);
				j.setMsg("参数错误");
				return j;
			}
			try {
				String[] roles = null;
				if (!TextUtils.isEmpty(roleIds) && TextUtils.getTrimmedLength(roleIds) > 0) {
					roles = roleIds.split(",");
					//new add2
					UserImpl userTemp = this.userService.getWithRoles(sessionInfo.getUserId(), userId);
					if (userTemp == null) {
						throw new PmException("用户不存在");
					}
					//new add
					History history1 = new History();
					history1.setUserIds(userId);
					History history2 = this.historyService.getMax(history1);
					int version = 0;
					if(history2!= null ){
						version = history2.getVersionNO();
						version++;
					}else{
						version =1;
					}
					
					
					if (userTemp.getRoles() != null && !userTemp.getRoles().isEmpty()) {
						//new add
						for(int i = 0; i < userTemp.getRoles().size(); i++){
							String rid =userTemp.getRoles().get(i).getId();
							History history = new History();
							history.setId(UUID.randomUUID().toString());
							history.setUserIds(userId);
							history.setType("r");
							history.setCurrentFlag("n");
							history.setPreCodeId(rid);
							history.setAddUser(sessionInfo.getUserId());
							history.setAddIp(sessionInfo.getIp());
							history.setAddDate(new Date());
							//version
							history.setVersionNO(version);
							this.historyService.insertForVersioin(history);
						}
					}
					//new add
					for(int i=0;i<roles.length;i++){
						History history = new History();
						history.setId(UUID.randomUUID().toString());
						history.setUserIds(userId);
						history.setType("r");
						history.setCurrentFlag("y");
						history.setCodeId(roles[i].split("\\.")[0]);
						history.setAddUser(sessionInfo.getUserId());
						history.setAddIp(sessionInfo.getIp());
						history.setAddDate(new Date());
						
						//version
						history.setVersionNO(version);
						this.historyService.insertForVersioin(history);
					}
					
					
					
				}
				this.userService.editRoles(sessionInfo.getUserId(), userId.trim(), roles);
				j.setSuccess(true);
			} catch (PmException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
			
		}
		else if (null != divisionId && !"".equals(divisionId)) {
			try {
				String[] roles = roleIds.split(",");
				this.userService.editRolesDivision(sessionInfo.getUserId(), divisionId.trim(), roles);
				j.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return j;
	}

	@RequestMapping("/toSearch")
	public ModelAndView toSearch(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/user/searchUserDetail");
		// 加载分类json
		JSONArray jsonArray = new JSONArray();
		List<UserInforImpl> listUserInfor = null;
		try {
			listUserInfor = this.userInforService.search(new UserInforImpl());
		} catch (PmException e) {
			e.printStackTrace();
		}
		jsonArray.add(listUserInfor);
		mv.addObject("jsonListUserInfor", jsonArray.toString());
		return mv;
	}
	
	@RequestMapping("/toSearchForApprove")
	public ModelAndView toSearchForApprove(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("maintenance/user/SearchForApprove");
		return mv;
	}
	
	@RequestMapping(value="/doSearchForApprove", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<UserImpl> doSearchForApprove(UserSearchForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<UserImpl> result = null;
		try {
			result = this.userService.list(sessionInfo.getUserId(), form);
			if (result == null) {
				result = new DataGrid<UserImpl>();
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	/*@RequestMapping(value="/doSearchForVersion", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<History> doSearchForVersion(History history, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<History> result = null;
		try {
			//result = this.historyService.listForVersion(sessionInfo.getUserId(), history);
			result = this.historyService.select(history);
			if (result == null) {
				result = new DataGrid<History>();
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}*/
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<UserImpl> doSearch(UserSearchForm form, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<UserImpl> result = null;
		try {
			result = this.userService.list(sessionInfo.getUserId(), form);
			if (result == null) {
				result = new DataGrid<UserImpl>();
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	@RequestMapping(value="/doSearchByDivisionId", method=RequestMethod.POST)
	@ResponseBody
	public List<UserImpl> doSearchByDivisionId(String divisionId, HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<UserImpl> result = null;
		try {
			result = this.userService.listByDivisionId(divisionId);
			if (result == null) {
				result = new ArrayList<UserImpl>();
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@RequestMapping("/doListPair")
	@ResponseBody
	public List<Pair<String, String>> doListPair(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		List<Pair<String, String>> list = null;
		try {
			List<UserImpl> users = this.userService.listAllAvailable(sessionInfo.getUserId(), null);
			
			if (users != null && !users.isEmpty()) {
				list = new ArrayList<Pair<String, String>>(users.size());
				for (UserImpl userImpl : users) {
					list.add(new Pair<String, String>(userImpl.getId(), userImpl.getDisplayName()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}
	
	/**
	 * 查询所有有效用户
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListPairEnable")
	@ResponseBody
	public List<Pair<String, String>> doListPairEnable(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		List<Pair<String, String>> list = null;
		try {
			List<UserImpl> users = this.userService.listAllEnable(sessionInfo.getUserId(), null);
			
			if (users != null && !users.isEmpty()) {
				list = new ArrayList<Pair<String, String>>(users.size());
				for (UserImpl userImpl : users) {
					list.add(new Pair<String, String>(userImpl.getId(), userImpl.getDisplayName()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}
	
    @RequestMapping("/doApproveForUserRegister")
    public ModelAndView doApproveForUserRegister(UserImpl userImpl,HttpSession session) throws PmException{
        SessionInfo sessionInfo =(SessionInfo)session.getAttribute(Constants.SESSION_INFO);
        try {
        	String loginName = userImpl.getLoginName();
            String userId = userImpl.getId();
            userImpl.setModifyUser(sessionInfo.getLoginName());
            userImpl.setModifyDate(new Date());
            userService.updateForApproveStatus(userImpl, session);

            this.userService.getByLoginName(userId, userImpl.getLoginName());
            /*    UserImpl dbuer = this.userService.getByLoginName(sessionInfo.getUserId(), UserImpl.getLoginName());
            if("0".equals(dbuer.getStatus())){
                String userId = dbuer.getId();
                String[] roles = new String[]{"9678860e-d0b3-4e53-8661-89f0f2adf42f"};
                this.userService.editRoles(sessionInfo.getUserId(),userId.trim(),roles);

                String departmentId = dbuer.getDepartmentId();
                String[] divisions = new String[]{departmentId};
                String[] leaders = null;
                String mainIndex="";
                this.user2DivisionService.edit(sessionInfo.getUserId(), userId.trim(), divisions, leaders,mainIndex);

            }*/
            String status = userImpl.getStatus();
            // 如果是转正审批那么发送入职确认邮件
            if ("4".equals(status)) {
                UserDetailImpl userDetail = new UserDetailImpl();
                userDetail.setLoginName(loginName);
                userDetail = userDetailService.get(userDetail);
                if (null != userDetail) {
                    String webContent = session.getServletContext().getRealPath("/upload");
                    String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateUserEntry.jsp");

                    // 替换用户信
                    UserInforImpl userInfor = new UserInforImpl();
                    Map<String,String> mapUserInfor = new HashMap<>();
                    List<UserInforImpl> listMapUserInfor = userInforService.search(userInfor);
                    for (int i = 0; i < listMapUserInfor.size(); i++) {
						UserInforImpl userInforInner = listMapUserInfor.get(i);
						String code = userInforInner.getCode();
						String name = userInforInner.getName();
						mapUserInfor.put(code, name);
						
					}
                    mapUserInfor.put("", "N/A");
                    mapUserInfor.put(null, "N/A");
                    
                    // 姓名
                    String displayName = (userDetail.getDisplayName() != null ? userDetail.getDisplayName() : "");
                    template = template.replaceAll("displayName", displayName);
                    
                    // 性别
                    String gender = (userDetail.getGender() != null ? userDetail.getGender() : "");
                    if ("f".equals(gender)) {
                        gender = "男";
                    }
                    else {
                        gender = "女";
                    }
                    template = template.replaceAll("gender", gender);
                    
                    String birthDate = "N/A";
                    
                    // 出生年月日
                    Date birthDateTemp = userDetail.getBirthDate();
                    if (null != birthDate) {
                        birthDate = new SimpleDateFormat("yyyy-MM-dd").format(birthDateTemp);
                    }
                    template = template.replaceAll("birthDate", birthDate);
                    
                    // 毕业学校
                    String schoolName = (userDetail.getSchoolName1() != null ? userDetail.getSchoolName1() : "");
                    template = template.replaceAll("schoolName", schoolName);

                    // 专业
                    String major = userDetail.getMajor1();
                    major = mapUserInfor.get(major);
                    template = template.replaceAll("major", major);
                    
                    // 学位
                    String educationalDegree = userDetail.getEducationalDegree1();
                    educationalDegree = mapUserInfor.get(educationalDegree);
                    template = template.replaceAll("educationalDegree", educationalDegree);
                    
                    // 英语等级
                    String englishProficiency = userDetail.getEnglishProficiency();
                    englishProficiency = mapUserInfor.get(englishProficiency);
                    template = template.replaceAll("englishProficiency", englishProficiency);
                    
                    // 其他证书
                    String skills = userDetail.getSkills1();
                    skills = (userDetail.getSkills1() != null ? userDetail.getSkills1() : "");
                    template = template.replaceAll("skills", skills);
                    
                    
                    //工作经验 暂无
                    Integer workingYear = (userDetail.getWorkingYear() != null ? userDetail.getWorkingYear() : 0);
                    template = template.replaceAll("workingYear", String.valueOf(workingYear));
                    
                    // 需求部门
                    String divisionId = userDetail.getDepartmentId();
                    divisionId = (divisionId != null ? divisionId : "");
                    String departmentNameExpected = "N/A";
                    if (null != divisionId && !"".equals(divisionId)) {
                    	DivisionImpl divisionTemp = new DivisionImpl();
                    	divisionTemp.setId(divisionId);
                    	divisionTemp = divisionService.get(divisionTemp);
                    	if (null != divisionTemp) {
							String divisionName = divisionTemp.getName();
							if (null != divisionName && !"".equals(displayName)) {
								departmentNameExpected = divisionName;
							}
						}
						
					}
                    template = template.replaceAll("departmentNameExpected", departmentNameExpected);
                    
                    // 应聘职位
                    String positionId = userDetail.getPositionId();
                    String targetPosition = mapUserInfor.get(positionId);
                    template = template.replaceAll("targetPosition", targetPosition);
                    
                    
                    // 预计入职时间
                    String entryDateExpected = "N/A";
                    Date entryDateExpectedTemp = userDetail.getEntryDateExpected();
                    
                    if (null != entryDateExpectedTemp) {
                    	entryDateExpected = new SimpleDateFormat("yyyy-MM-dd").format(entryDateExpectedTemp);
                    }
                    template = template.replaceAll("entryDateExpected", entryDateExpected);
                    
                    DecimalFormat   df   =new  DecimalFormat("#.00");  
                    // 转正前税前工资
                    double emolumentPreTaxPositiveBefore = (userDetail.getEmolumentPreTaxPositiveBefore() != null ? userDetail.getEmolumentPreTaxPositiveBefore() : 0);
                    String emolumentPreTaxPositiveBeforeStirng = String.valueOf(df.format(emolumentPreTaxPositiveBefore));
                    template = template.replaceAll("emolumentPreTaxPositiveBefore", emolumentPreTaxPositiveBeforeStirng);
                    // 转正前税后工资
                    double emolumentAfterTaxPositiveBefore = (userDetail.getEmolumentAfterTaxPositiveBefore() != null ? userDetail.getEmolumentAfterTaxPositiveBefore() : 0);
                    String emolumentAfterTaxPositiveBeforeStirng = String.valueOf(df.format(emolumentAfterTaxPositiveBefore));
                    template = template.replaceAll("emolumentAfterTaxPositiveBefore", emolumentAfterTaxPositiveBeforeStirng);
                    // 转正前税前保险公积金扣款
                    double withholdingPositiveBefore = (userDetail.getWithholdingPositiveBefore() != null ? userDetail.getWithholdingPositiveBefore() : 0);
                    String withholdingPositiveBeforeStirng = String.valueOf(df.format(withholdingPositiveBefore));
                    template = template.replaceAll("withholdingPositiveBefore", withholdingPositiveBeforeStirng);
                    // 转正前保险基数
                    double socialSecurityRangePositiveBefore = (userDetail.getSocialSecurityRangePositiveBefore() != null ? userDetail.getSocialSecurityRangePositiveBefore() : 0);
                    String socialSecurityRangePositiveBeforeStirng = String.valueOf(df.format(socialSecurityRangePositiveBefore));
                    template = template.replaceAll("socialSecurityRangePositiveBefore", socialSecurityRangePositiveBeforeStirng);
                    // 转正前公积金基数
                    double houseFundinRangePositiveBefore = (userDetail.getHouseFundinRangePositiveBefore() != null ? userDetail.getHouseFundinRangePositiveBefore() : 0);
                    String houseFundinRangePositiveBeforeStirng = String.valueOf(df.format(houseFundinRangePositiveBefore));
                    template = template.replaceAll("houseFundinRangePositiveBefore", houseFundinRangePositiveBeforeStirng);
                    // 转正后税前工资
                    double emolumentPreTax = (userDetail.getEmolumentPreTax() != null ? userDetail.getEmolumentPreTax() : 0);
                    String emolumentPreTaxStirng = String.valueOf(df.format(emolumentPreTax));
                    template = template.replaceAll("emolumentPreTax", emolumentPreTaxStirng);
                    // 转正后税后工资
                    double emolumentAfterTax = (userDetail.getEmolumentAfterTax() != null ? userDetail.getEmolumentAfterTax() : 0);
                    String emolumentAfterTaxStirng = String.valueOf(df.format(emolumentAfterTax));
                    template = template.replaceAll("emolumentAfterTax", emolumentAfterTaxStirng);
                    // 转正后税前保险公积金扣款
                    double withholding = (userDetail.getWithholding() != null ? userDetail.getWithholding() : 0);
                    String withholdingStirng = String.valueOf(df.format(withholding));
                    template = template.replaceAll("withholding", withholdingStirng);
                    
                    // 保险基数
                    double socialSecurityRange = (userDetail.getSocialSecurityRange() != null ? userDetail.getSocialSecurityRange() : 0);
                    String socialSecurityRangeStirng = String.valueOf(df.format(socialSecurityRange));
                    template = template.replaceAll("socialSecurityRange", socialSecurityRangeStirng);
                    // 公积金基数
                    double houseFundinRange = (userDetail.getHouseFundinRange() != null ? userDetail.getHouseFundinRange() : 0);
                    String houseFundinRangeStirng = String.valueOf(df.format(houseFundinRange));
                    template = template.replaceAll("houseFundinRange", houseFundinRangeStirng);
                    
                    // 转正月份 暂无
                    String positiveMonth = "N/A";
                    Date positiveDateTemp = userDetail.getPositiveDate();
                    if (null != positiveDateTemp) {
                    	positiveMonth = new SimpleDateFormat("yyyy-MM").format(positiveDateTemp);
                    }
                    template = template.replaceAll("positiveMonth", String.valueOf(positiveMonth));
                    
                    EmailImpl email = new EmailImpl();
                    // 取得职位，如果为行政主管，那么发送邮件给自己
                    // 取得行政部主管信息
    				//UserDetailImpl user = new UserDetailImpl();
    				/*// gwmc3代表职位为行政部主管
    				user.setPositionId("gwmc3");
    				user = (UserDetailImpl) userDetailMapper.get(user);*/
    				//user.setCode("1701001");
    				//user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
    				if (CommonUtil.getTrueSys()) {
    					email.setReceiver(getEmail());
    				} else {
    					email.setReceiver("neoyin@ManchuTimesFashion.com");
    				}
                    email.setTheme("入职申请/" + departmentNameExpected + "/" + targetPosition + "/" + displayName);
                    UserDetailImpl userDetailTemp = new UserDetailImpl();
                    userDetailTemp.setDivisionIdMain(divisionId);
                    userDetailTemp.setTagMapper("join");
                    // detail
                    List<UserDetailImpl> listUserDetail = userDetailService.select(userDetailTemp);
                    //userDetailTemp.setOrder(order);
                    String office_detail = "";
                    for (int j = 0; j < listUserDetail.size(); j++) {
                        String templateDetail = CommonUtil.readTextContent(webContent + "/tempEmail/templateUserEntryDetail.jsp");
                        // 替换用户信
                        UserDetailImpl userDetailImplTemp2 = listUserDetail.get(j);
                        String firstName = (userDetailImplTemp2.getFirstName() != null ? userDetailImplTemp2.getFirstName() : "N/A");
                        String lastName = (userDetailImplTemp2.getLastName() != null ? userDetailImplTemp2.getLastName() : "N/A");
                        String chineseName = (userDetailImplTemp2.getChineseName() != null ? userDetailImplTemp2.getChineseName() : "N/A");
                        String positionId2 = (userDetailImplTemp2.getPositionId() != null ? userDetailImplTemp2.getPositionId() : "N/A");
                        String nameImmediateSuperior = (userDetailImplTemp2.getImmediateSuperiorName() != null ? userDetailImplTemp2.getImmediateSuperiorName() : "N/A");
                        String position = "N/A";
                        try {
							position = mapUserInfor.get(positionId2);
						} catch (Exception e) {
							e.printStackTrace();
							position = "N/A";
						} 
                        String immediateSuperior = (userDetailImplTemp2.getImmediateSuperiorId() != null ? userDetailImplTemp2.getImmediateSuperiorId() : "");
                        UserDetailImpl userDetailTemp2 = new UserDetailImpl();
                        userDetailImplTemp2.setUserId(immediateSuperior);
                        userDetailImplTemp2 = userDetailService.get(userDetailTemp2);
                        if (null != userDetailImplTemp2) {
							String displayNameTemp = userDetailImplTemp2.getDisplayName();
							templateDetail = templateDetail.replaceAll("immediateSuperior", displayNameTemp);
						}
                        templateDetail = templateDetail.replaceAll("number", String.valueOf(j + 1));
                        templateDetail = templateDetail.replaceAll("firstName", firstName);
                        templateDetail = templateDetail.replaceAll("lastName", lastName);
                        templateDetail = templateDetail.replaceAll("chineseName", chineseName);
                        templateDetail = templateDetail.replaceAll("nameImmediateSuperior", nameImmediateSuperior);
                        try {
							templateDetail = templateDetail.replaceAll("position", position);
						} catch (Exception e) {
							e.printStackTrace();
							templateDetail = templateDetail.replaceAll("position", "N/A");
						}
                        office_detail += templateDetail;
                    }
                    // 替换标签<office_manager/>
                    template = template.replaceAll("<office_detail/>", office_detail);
                    email.setContent(template);
                    try {
                        if (!getTagSys()) {
                            emailService.sendMail(email);
                        }
                    } catch (EmailException e) {
                        e.printStackTrace();
                    }

                }
            }

        } catch (PmException e) {
            e.printStackTrace();
        }


        return this.toSearch(session);
    }
	
	/**
	 * 获取行政部采购人员信息列表
	 * @param session
	 * @return 行政部采购人员信息列表
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearchByCategoryId", method=RequestMethod.POST)
	@ResponseBody
	public List<UserImpl> doSearchByCategoryId(UserImpl userImpl, Integer categoryId) throws PmException {
		List<UserImpl> listUser = null;
		try {
			listUser = this.userService.listByCategoryId(userImpl, categoryId);
			
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listUser;
	}
	
	/**
	 * 获取行政部采购人员信息列表
	 * @param session
	 * @return 行政部采购人员信息列表
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearchAdminByCategoryId", method=RequestMethod.POST)
	@ResponseBody
	public List<UserImpl> doSearchAdminByCategoryId(UserImpl userImpl, Integer categoryId) throws PmException {
		List<UserImpl> listUser = null;
		try {
			listUser = this.userService.listAdminByCategoryId(userImpl, categoryId);
			
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listUser;
	}
	
	/**
	 * 获取签字人信息列表
	 * @param session
	 * @return 行政部签字人信息列表
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearchForSigners", method=RequestMethod.POST)
	@ResponseBody
	public List<UserImpl> doSearchForSigners(UserImpl userImpl) throws PmException {
		List<UserImpl> listUser = null;
		try {
			listUser = this.userService.listForSinger(null);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listUser;
	}
}
