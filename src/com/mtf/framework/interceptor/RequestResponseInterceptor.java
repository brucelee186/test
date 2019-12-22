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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;

/**
 * 响应编码拦截器
 *
 * @author Wade.Zhu
 * @version 1.0	2014-04-15	Wade.Zhu		created.
 * @version <ver>
 */
public class RequestResponseInterceptor implements HandlerInterceptor {

	private static final Logger	logger	= Logger.getLogger(RequestResponseInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
		if (object instanceof BaseController) {
			BaseController bc = (BaseController) object;
			bc.removeRequest();
			bc.removeResponse();
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		if (object instanceof BaseController) {
			BaseController bc = (BaseController) object;
			bc.setRequest(request);
			bc.setResponse(response);
		}
		
		return true;
	}
}
