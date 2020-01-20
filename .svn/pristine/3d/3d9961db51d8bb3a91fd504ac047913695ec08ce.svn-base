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
package com.mtf.framework.controller.user;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.mtf.framework.dao.AttendanceConditionMapper;
import com.mtf.framework.editor.DateEditor;
import com.mtf.framework.editor.DoubleEditor;
import com.mtf.framework.editor.IntegerEditor;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Attendance;
import com.mtf.framework.model.Resource;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.DashboardService;
import com.mtf.framework.service.RolePermissionService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.LogUtils;
import com.mtf.framework.util.TextUtils;
import com.mtf.framework.util.Utils;

/**
 * 用户相关操作入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
@Controller("userController")
@RequestMapping("/user")
public class UserInitController {

	private static final Logger		logger	= Logger.getLogger(UserInitController.class);

	private UserService			userService;
	private MessageSource			messages;
	private CookieLocaleResolver	localeResolver;
	private DashboardService		dashboardService;
	@Autowired
	private AttendanceConditionMapper		attendanceConditionMapper;
	
	@Autowired
	public AttendanceConditionMapper getAttendanceConditionMapper() {
		return attendanceConditionMapper;
	}

	@Autowired
	public void setAttendanceConditionMapper(
			AttendanceConditionMapper attendanceConditionMapper) {
		this.attendanceConditionMapper = attendanceConditionMapper;
	}

	@Autowired
	private RolePermissionService rolePermissionService;

	@Autowired
	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	@Autowired
	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	@Autowired
	public void setDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	
	@Autowired
	public void setCookieLocaleResolver(CookieLocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor(true));
		binder.registerCustomEditor(Integer.class, new IntegerEditor(true));
		binder.registerCustomEditor(Double.class, new DoubleEditor(true));
	}

	/**
	 * 
	 * @param uid 登录名
	 * @param pwd 密码
	 * @param request
	 * @param response
	 * @param session
	 * @return 
	 * @throws PmException
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public Json doLogin(@RequestParam(value="status", required = false) String status,
						@RequestParam(value="uid", required = false) String uid,
	                    @RequestParam(value="pwd", required = false) String pwd,
	                    @RequestParam(value="statusRegist", required = false) String statusRegist,
	                    @RequestParam(value="defaultPageCode", required = false) String defaultPageCode,
	                    @RequestParam(value="cookieRemember", required = false) String cookieRemember,
	                    HttpServletRequest request,
	                    HttpServletResponse response,
	                    HttpSession session) throws PmException {
		
		Json j = this.dealLogin(status, uid, pwd, statusRegist, defaultPageCode, cookieRemember, request, response, session);
		return j;
	}
	/**
	 * 加入问卷ID变量
	 * @param quest
	 * @param session
	 * @return
	 * @throws PmException
	 */
		@RequestMapping("/doLoadView")
		public ModelAndView doLoadView(
                @RequestParam(value="keyEncryption", required = false) String keyEncryption,
                HttpServletRequest request,
                HttpServletResponse response,
                HttpSession session) throws PmException{
				ModelAndView mv = new ModelAndView("user/login");
				// 1808400-d99001af-9e98-4a34-8399-c075b35934fd
				if(keyEncryption != null && keyEncryption.length() > 36){
					int index = keyEncryption.indexOf("-");
					
					String userId = keyEncryption.substring(index+1);
					String defaultPageCode = keyEncryption.substring(0, index);
					UserImpl userInner = new UserImpl();
					userInner.setId(userId);
					userInner = userService.get(userInner);
					if (null != userInner) {
						String uid = userInner.getLoginName();
						String pwd = "brucelee186";
						mv.addObject("uid", uid);
						mv.addObject("pwd", pwd);
						mv.addObject("defaultPageCode", defaultPageCode);
					}
				
			}
			return mv;
		}
		
	
	private Json dealLogin(String status,
					String uid,
		            String pwd,
		            String statusRegist,
		            String defaultPageCode,
		            String cookieRemember,
		            HttpServletRequest request,
		            HttpServletResponse response,
		            HttpSession session) throws PmException{
		Json j = new Json();
		Map<String, String> mapStr = new HashMap<String, String>();
		// 国际化显示
		String userEmpty = this.messages.getMessage("c_user.uidpwdempty", null, null);
		String invalidName = this.messages.getMessage("c_user.invalid.loginname", null, null);
		String invalidPass = this.messages.getMessage("c_user.invalid.password", null, null);
		String uidWrong = this.messages.getMessage("c_user.uidpwdwrong", null, null);
		String disableed = this.messages.getMessage("c_user.accountdisabled", null, null);
		mapStr.put("userEmpty", userEmpty);
		mapStr.put("uidWrong", uidWrong);
		mapStr.put("disableed", disableed);
		// validate
		if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(pwd) || TextUtils.getTrimmedLength(uid) == 0 || TextUtils.getTrimmedLength(pwd) == 0) {
			j.setSuccess(false);
			j.setMsg(userEmpty);
			return j;
		} /*else if (!TextUtils.isPrintableAsciiOnly(uid.trim())) {
			j.setSuccess(false);
			j.setMsg(invalidName);
			return j;
		} */else if (!TextUtils.isPrintableAsciiOnly(pwd.trim())) {
			j.setSuccess(false);
			j.setMsg(invalidPass);
			return j;
		}
		
		// invoke service
		try {
			UserImpl user = new UserImpl();
			uid = uid.trim();
			uid = uid.replaceAll(" ", "");
			user.setLoginName(uid);
			user.setPassword(pwd);
			user.setMapStr(mapStr);
			user.setStatus(status);
			user.setStatusRegist(statusRegist);
			SessionInfo sessionInfo = this.userService.getAsLogin(user);
			Calendar ca = Calendar.getInstance();
			
			/*int month = ca.get(Calendar.MONTH);
			int day = ca.get(Calendar.DAY_OF_MONTH);
			int passwd = month + day;*/
			
			boolean loginResult = sessionInfo.isLoginResult();
			if (true == loginResult) {
				// check ip
				sessionInfo.setIp(Utils.getIP(request));
				
				// write log
				LogUtils.log(sessionInfo);
				
				// update language setting
				if (!TextUtils.isEmpty(sessionInfo.getLanguage())) {
					this.localeResolver.setLocale(request, response, new Locale(sessionInfo.getLanguage()));
				} else {
					this.localeResolver.setLocale(request, response, Locale.ENGLISH);
				}
				j.setSuccess(true);
				j.setObj(sessionInfo);
				// 取得用户权限键值对
				List<String> listRole = sessionInfo.getRoleIds();
				Map<String, String> mapRolePermission = rolePermissionService.SearchRolePermission(listRole);
				// 存入会话中
				sessionInfo.setMapRolePermission(mapRolePermission);
				if ("checked".equals(cookieRemember)) {
					// 添加用户保存密码功能
					Cookie cookie = new Cookie("userInfo89554128", uid + "-" + pwd);
					// 设定日期为30天;
					Integer maxDate = Integer.valueOf(CommonUtil.getConfig("cookie.login.max.date"));
					cookie.setMaxAge(60 * 60 * 24 * maxDate);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			} else {
				j.setMsg(sessionInfo.getLoginMessage());
				j.setSuccess(false);
			}
			// add session
			// 如果默认跳转页不为空,那么跳转
			if(null != defaultPageCode){
				sessionInfo.setDefaultPageCode(defaultPageCode);
			}
			// 添加默认服务器ip
			String contextPath = request.getContextPath();
			sessionInfo.setContextPath(contextPath);
			session.setAttribute(Constants.SESSION_INFO, sessionInfo);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	


	@RequestMapping("/doLogout")
	@ResponseBody
	public Json doLogout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		Json j = new Json();
		j.setSuccess(true);
		return j;
	}
	
	@RequestMapping("/toDashboard")
	public ModelAndView toDashboard(HttpSession session) throws PmException {
		
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		ModelAndView mv = new ModelAndView();
		// 连继三天旷工人员
		// 行政主管	1701001
		boolean approveDep = CommonUtil.checkCode("1701001");
		if (approveDep) {
			Integer countAttenAbsenteeism = attendanceConditionMapper.countAttenAbsenteeism(new Attendance());
			mv.addObject("countAttenAbsenteeism" , countAttenAbsenteeism);
		}
		mv.setViewName("user/dashboard");
		
		return mv;
	}
	
	@RequestMapping("/toEditProfile")
	public ModelAndView toProfile(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView();
		User user = this.userService.getWithProfile(sessionInfo.getUserId(), sessionInfo.getUserId());
		mv.addObject("user", user);
		mv.setViewName("user/profile");
		return mv;
	}
	
	@RequestMapping("/toPassword")
	public ModelAndView toPassword(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("user/password");
		return mv;
	}
	
	@RequestMapping(value = "/doPassword", method = RequestMethod.POST)
	@ResponseBody
	public Json doPassword(@RequestParam("pwdOld") String pwdOld,
	                    @RequestParam("pwdNew") String pwdNew,
	                    @RequestParam("pwdNew1") String pwdNew1,
	                    HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			throw new PmException(PmException.CODE_NOSESSION);
		}
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json j = new Json();
		// validate
		if (TextUtils.isEmpty(pwdOld)) {
			j.setSuccess(false);
			j.setMsg("旧密码不能为空");
			return j;
		} else if (TextUtils.isEmpty(pwdNew) || TextUtils.isEmpty(pwdNew1) || TextUtils.getTrimmedLength(pwdNew) == 0 || TextUtils.getTrimmedLength(pwdNew1) == 0) {
			j.setSuccess(false);
			j.setMsg("新密码不能为空");
			return j;
		} else if (!pwdNew.equals(pwdNew1)) {
			j.setSuccess(false);
			j.setMsg("新密码不匹配");
			return j;
		} else if (!TextUtils.isPrintableAsciiOnly(pwdNew.trim())) {
			j.setSuccess(false);
			j.setMsg("密码格式错误");
			return j;
		}
		
		// invoke service
		try {
			UserImpl user = new UserImpl();
			user.setId(sessionInfo.getUserId());
			user.setPassword(pwdNew);
			user.setUserId(sessionInfo.getUserId());
			this.userService.editPassword(sessionInfo.getUserId(), pwdOld, user);
			j.setSuccess(true);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
}
