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
package com.mtf.framework.interceptor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.model.Resource;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.SysHistoryImpl;
import com.mtf.framework.service.ISecurityService;
import com.mtf.framework.service.ResourceService;
import com.mtf.framework.service.SysHistoryService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.UdpGetClientMacAddr;
import com.mtf.framework.util.Utils;

/**
 * 安全性检查拦截器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static final Logger	logger	= Logger.getLogger(SecurityInterceptor.class);
	private List<String>		noSessionUris;
	private List<String>		noSecurityUris;

	private ISecurityService	securityService;
	private MessageSource		messages;
	private SimpleDateFormat	dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//快捷方式
	private ResourceService		resourceService;
	
	@Autowired
	private SysHistoryService sysHistoryService;
	
	@Autowired
	public SysHistoryService getSysHistoryService() {
		return sysHistoryService;
	}
	
	@Autowired
	public void setSysHistoryService(SysHistoryService sysHistoryService) {
		this.sysHistoryService = sysHistoryService;
	}
	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	/**
	 * 设定无需登录即可使用的资源
	 * 
	 * @param noSessionUris 资源列表
	 */
	public void setNoSessionUris(List<String> noSessionUris) {
		this.noSessionUris = noSessionUris;
	}
	
	/**
	 * 设定无需权限即可使用的资源
	 * 
	 * @param noSecurityUris 资源列表
	 */
	public void setNoSecurityUris(List<String> noSecurityUris) {
		this.noSecurityUris = noSecurityUris;
	}

	@Autowired
	public void setSecurityService(ISecurityService securityService) {
		this.securityService = securityService;
	}
	
	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		response.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String uri = requestUri.substring(contextPath.length());
		logger.debug("preHandle uri: " + uri);

		// 不需要验证的请求
		if (this.noSessionUris != null && this.noSessionUris.contains(uri)) {
			logger.debug("Do NOT need check session, skip!");
			return true;
		}
		// 需要验证的请求
		else {
			// step 1 ： 验证session
			HttpSession session = request.getSession(false);
			if (session == null) {
				logger.debug("No session, refused!");
				request.getRequestDispatcher("/WEB-INF/jsp/error/nosession.jsp").forward(request, response);
				return false;
			}
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
			if (sessionInfo == null || sessionInfo.getUserId() == null) {
				logger.debug("Session invalid, refused!");
				request.getRequestDispatcher("/WEB-INF/jsp/error/nosession.jsp").forward(request, response);
				return false;
			}
			
			// step 2 : 无需权限
			if (this.noSecurityUris != null && this.noSecurityUris.contains(uri)) {
				logger.debug("Do NOT need check security, skip!");
				return true;
			}
			
			// step 3 : 验证超级用户sys
			if ("460f4f88-52c2-4d50-8275-0d0739e6237d".equalsIgnoreCase(sessionInfo.getUserId())) {
				return true;
			}
			
			// step 4 : 验证操作
			int passCode = this.securityService.getPassCode(uri, sessionInfo);
			//passCode = 0;
			logger.debug("Security check return code with : " + passCode);
			if (passCode == 0) {
				// 添加日志
				addHistory(request);
				logger.debug("Security check passed, continue!");
				return true;
			} else {
				String errorMsg = null;
				switch (passCode) {
					case 1:
						errorMsg = this.messages.getMessage("error.security.undefinedresource", null, Utils.getLocale(sessionInfo.getLanguage()));
						break;
					case 2:
						errorMsg = this.messages.getMessage("error.security.accessdenied", null, Utils.getLocale(sessionInfo.getLanguage()));
						break;
					case 3:
						errorMsg = this.messages.getMessage("error.security.unauthorized", null, Utils.getLocale(sessionInfo.getLanguage()));
						break;
					default:
						errorMsg = this.messages.getMessage("error.security.syserror", null, Utils.getLocale(sessionInfo.getLanguage()));
						break;
				}

			/*	request.setAttribute("uri", uri);
				request.setAttribute("errorCode", passCode);
				request.setAttribute("errorMsg", errorMsg);
				request.setAttribute("datetime", dateFormatter.format(new Date()));
				request.getRequestDispatcher("/WEB-INF/jsp/error/nopermission.jsp").forward(request, response);
				return false;*/
				
				if(1 == passCode){
					//添加resource
					Resource resource = new Resource();
					resource.setUri(uri);
					resource.setName("1自动添加:"+uri);
					resource.setDescription("1自动添加:"+uri);
					resource.setLevel(1);
					resource.setAccess("3");
					resource.setActionId("a7782534-ffa2-4658-8239-8ac41fc435a1");
					resourceService.add(sessionInfo.getUserId(), resource);
					// 添加日志
					addHistory(request);
				}
				return true;
			}
		}
	}
	
	private void addHistory(HttpServletRequest request) throws Exception {
		String requestUri = request.getRequestURI();
		HttpSession session = request.getSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		// 加入日志
		String displayName = sessionInfo.getDisplayName();
		String userId = sessionInfo.getUserId();
		String loginName = sessionInfo.getLoginName();
		SysHistoryImpl sysHistory = new SysHistoryImpl();
		CommonUtil.setCommonField(sysHistory, session);
		sysHistory.setDisplayName(displayName);
		sysHistory.setUserId(userId);
		sysHistory.setLoginName(loginName);
		sysHistory.setAtcion(requestUri);
		sysHistory.setType("s");
		//String macClient = this.getMacClient(request);
		//if(null != macClient){
		//	sysHistory.setAddMac(macClient);
		//}
		sysHistoryService.insert(sysHistory);
	}
	
	private String getMacClientV0(HttpServletRequest request){
		String clientMac = "";
		try {
			String sip = request.getHeader("x-forwarded-for");   
			if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
			    sip = request.getHeader("Proxy-Client-IP");   
			}   
			if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
			    sip = request.getHeader("WL-Proxy-Client-IP");   
			}   
			if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
			    sip = request.getRemoteAddr();   
			}   
			UdpGetClientMacAddr umac = new UdpGetClientMacAddr(sip);
			clientMac = umac.GetRemoteMacAddr();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientMac;
	}
	
	private String getMacClient(HttpServletRequest request) {
		String clientMac = "";
		String sip = "";
		try {
			sip = request.getHeader("x-forwarded-for");
			if (sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {
				sip = request.getHeader("proxy-Client-IP");
			}
			if (sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {
				sip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {
				sip = request.getRemoteAddr();
			}

			if (!"127.0.0.1".equals(sip)) // 本机过滤掉
			{
				Process process = Runtime.getRuntime().exec("nbtstat -a " + sip);
				InputStreamReader ir = new InputStreamReader(
						process.getInputStream());
				LineNumberReader input = new LineNumberReader(ir);
				String line;
				while ((line = input.readLine()) != null)
					if (line.indexOf("MAC Address") > 0) {
						clientMac = line.substring(line.indexOf("-") - 2);
					}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientMac;
	}
}
