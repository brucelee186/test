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
package com.mtf.framework.exception;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mtf.framework.util.Constants;

/**
 * 自定义异常
 * <p>继承自 {@link Exception}，增加自定义业务异常代码</p>
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class PmException extends Exception {
	
	private static final Logger logger = Logger.getLogger(PmException.class);
	
	public static final int		CODE_NOSESSION = -1;
	
	private static final long	serialVersionUID = 1L;
	private int 				code;
	private Object				obj;
	
	public PmException() {}
	
	/**
	 * 判断Session是否失效,如果失效,那么code状态存入-1
	 */
	public PmException(HttpSession session) throws PmException {
		if (session == null || session.getAttribute(Constants.SESSION_INFO) == null) {
			logger.error(PmException.CODE_NOSESSION);
			throw new PmException(PmException.CODE_NOSESSION);
		}
	}
	
	/**
	 * 实例化
	 * @param msg 异常描述信息
	 * @param code 异常代码
	 */
	public PmException(String msg, int code) {
		super(msg);
		logger.error(msg);
		this.code = code;
	}
	
	/**
	 * 实例化
	 * @param msg 异常描述信息
	 */
	public PmException(String msg) {
		super(msg);
		logger.error(msg);
	}
	
	/**
	 * 实例化
	 * @param msg 异常描述信息
	 */
	public PmException(int code) {
		this.code = code;
		logger.error(code);
	}
	
	/**
	 * 实例化
	 * @param msg 异常描述信息
	 * @param obj 对象信息
	 */
	public PmException(int code, Object obj) {
		super("" + code);
		this.code = code;
		this.obj  = obj;
	}
	
	/**
	 * 获取异常代码
	 * @return 异常代码
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * 设置异常代码
	 * @param code 异常代码
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * 获取对象信息
	 * @return 对象信息
	 */
	public Object getObj() {
		return obj;
	}
	
	/**
	 * 设置对象信息
	 * @param obj 对象信息
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
