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
package com.mtf.framework.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import com.alibaba.fastjson.JSONObject;

/**
 * 日志工具类
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class LogUtils {
	private static final Logger		logger	= Logger.getLogger(LogUtils.class);

	private LogUtils() {}
	
	public static void log(JoinPoint jp) {
		try {
			String clz = jp.getTarget().getClass().getSimpleName();
			String sign = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			String log = String.format("method=[%s.%s] args=[%s]", clz, sign, JSONObject.toJSONString(args));
			logger.warn(String.format(Constants.LOG_TEMPLATE, log));
		} catch (Exception e) {
		}
	}
	
	public static void log(Object o) {
		try {
			String log = String.format("method=login %s", JSONObject.toJSONString(o));
			logger.warn(String.format(Constants.LOG_TEMPLATE, log));
		}
		catch (Exception e) {
		}
	}
	
	/**
	 * 记录MTF ADD日志
	 * @param logger
	 * @param objects
	 */
	public static void logAdd(JoinPoint jp) {
		try {
			String clz = jp.getTarget().getClass().getSimpleName();
			String sign = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			String log = String.format("method=[%s.%s] args=[%s]", clz, sign, JSONObject.toJSONString(args));
			logger.warn(String.format(Constants.LOG_TEMPLATE, log));
		} catch (Exception e) {
			
		}
	}
	/**
	 * 记录MTF EDIT日志
	 * @param logger
	 * @param objects
	 */
	public static void logEdit(JoinPoint jp) {
		try {
			String clz = jp.getTarget().getClass().getSimpleName();
			String sign = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			String log = String.format("method=[%s.%s] args=[%s]", clz, sign, JSONObject.toJSONString(args));
			logger.warn(String.format(Constants.LOG_TEMPLATE, log));
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 记录MTF DELETE日志
	 * @param logger
	 * @param objects
	 */
	public static void logDelete(JoinPoint jp) {
		try {
			String clz = jp.getTarget().getClass().getSimpleName();
			String sign = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			String log = String.format("method=[%s.%s] args=[%s]", clz, sign, JSONObject.toJSONString(args));
			logger.warn(String.format(Constants.LOG_TEMPLATE, log));
		} catch (Exception e) {
			
		}
	}
}
